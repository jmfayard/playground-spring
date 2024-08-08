package dev.jmfayard.spring;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class HealthControllerTest extends IntegrationTest {

    @Test
    void isServerRunningEndpoint() {
        String actual = restTemplate.getForObject(endPoint("health"), String.class);
        assertThat(actual).isEqualTo("Hello, World!");
    }
}