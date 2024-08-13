package dev.jmfayard.spring;

import org.springframework.data.jpa.repository.JpaRepository;

interface InsurancePolicyRepository extends JpaRepository<InsurancePolicy, Long> {

}