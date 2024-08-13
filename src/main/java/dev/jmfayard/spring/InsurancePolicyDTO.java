package dev.jmfayard.spring;

import java.time.Instant;

public record InsurancePolicyDTO(
    long policy_id,
    String name,
    InsurancePolicy.Status status,
    Instant startDate,
    Instant endDate,
    Instant createdAt,
    Instant updatedAt
) {

}

