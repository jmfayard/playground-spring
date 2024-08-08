package dev.jmfayard.spring;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "policies", path = "policies")
public interface InsurancePolicyRepository extends PagingAndSortingRepository<InsurancePolicy, Long> {
    InsurancePolicy save(InsurancePolicy policy);

    void deleteById(Long id);

    InsurancePolicy findById(Long id);

}