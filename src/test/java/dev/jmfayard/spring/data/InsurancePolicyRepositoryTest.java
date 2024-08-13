package dev.jmfayard.spring.data;

import dev.jmfayard.spring.IntegrationTest;
import dev.jmfayard.spring.domain.InsurancePolicy;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.TransactionSystemException;

import java.time.Instant;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

class InsurancePolicyRepositoryTest extends IntegrationTest {

    @Autowired
    InsurancePolicyRepository repository;

    @Test
    void should_insert_valid_policy() {
        InsurancePolicy policy = new InsurancePolicy();
        policy.setName("Be Healthy");
        policy.setStatus(InsurancePolicy.Status.ACTIVE);
        policy.setStartDate(Instant.now());
        policy.setEndDate(Instant.now());
        repository.save(policy);
    }

    @Test
    void should_validate_annotated_fields() {
        InsurancePolicy policy = new InsurancePolicy();
        policy.setName("");
        policy.setStatus(null);
        String error = assertThrows(TransactionSystemException.class, () -> repository.save(policy)).getRootCause().getMessage();
        assertThat(error).contains("propertyPath=name", "propertyPath=status", "NotBlank", "NotNull");

    }

}