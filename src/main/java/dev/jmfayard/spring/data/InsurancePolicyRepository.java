package dev.jmfayard.spring.data;

import dev.jmfayard.spring.domain.InsurancePolicy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

}