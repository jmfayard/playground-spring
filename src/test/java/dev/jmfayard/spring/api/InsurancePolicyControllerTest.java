package dev.jmfayard.spring.api;

import dev.jmfayard.spring.IntegrationTest;
import dev.jmfayard.spring.domain.InsurancePolicy;
import dev.jmfayard.spring.domain.InsurancePolicyService;
import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.when;

class InsurancePolicyControllerTest extends IntegrationTest {

    @MockBean
    InsurancePolicyService service;

    @Test
    void should_return_all_policies() {
        List<InsurancePolicy> policies = List.of(InsurancePolicy("Habitation", InsurancePolicy.Status.ACTIVE));
        when(service.fetchAll(any())).thenReturn(policies);

        RestAssured.given().port(port).when()
                .get("/policies")
                .then()
                .assertThat()
                .statusCode(200)
                .body("[0].name", equalTo("Habitation"));

    }


    @Test
    void should_create_policy() {
        when(service.createPolicy(any())).thenReturn(InsurancePolicy("Habitation", InsurancePolicy.Status.ACTIVE));
        RestAssured.given().port(port)
                .header("Content-Type", "application/json")
                .body(somePolicy())
                .when()
                .post("/policies")
                .then()
                .assertThat()
                .statusCode(201)
                .body("name", equalTo("Habitation"));
    }

    @Test
    void should_fetchById_found() {
        List<InsurancePolicy> policies = List.of(InsurancePolicy("Habitation", InsurancePolicy.Status.ACTIVE));
        when(service.fetchById(1L)).thenReturn(Optional.of(somePolicy()));

        RestAssured.given().port(port).when()
                .get("/policies/1?page=2&size=3")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Habitation"));
    }

    @Test
    void should_fetchById_notFound() {
        when(service.fetchById(1L)).thenReturn(Optional.empty());

        RestAssured.given().port(port).when()
                .get("/policies/{policy_id}", 1)
                .then()
                .assertThat()
                .statusCode(404);
    }

    @Test
    void should_delete() {
        when(service.deleteById(1L)).thenReturn("");

        RestAssured.given().port(port)
                .header("Content-Type", "application/json")
                .when()
                .delete("/policies/1")
                .then()
                .assertThat()
                .statusCode(202)
                .body(equalTo(""));
    }


    @Test
    void should_update() {
        when(service.updatePolicy(anyLong(), any())).thenReturn(Optional.of(somePolicy()));

        RestAssured.given()
                .header("Content-Type", "application/json")
                .body(somePolicy())
                .port(port).when()
                .put("/policies/1")
                .then()
                .assertThat()
                .statusCode(200)
                .body("name", equalTo("Habitation"));
    }

    static InsurancePolicy InsurancePolicy(String name, InsurancePolicy.Status status) {
        InsurancePolicy policy = new InsurancePolicy();
        policy.setName(name);
        policy.setStatus(status);
        return policy;
    }

    static InsurancePolicy somePolicy() {
        return InsurancePolicy("Habitation", InsurancePolicy.Status.ACTIVE);
    }

}