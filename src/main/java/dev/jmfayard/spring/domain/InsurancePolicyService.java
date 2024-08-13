package dev.jmfayard.spring.domain;

import dev.jmfayard.spring.data.InsurancePolicyRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Service
public class InsurancePolicyService {
    private final InsurancePolicyRepository repository;

    InsurancePolicyService(InsurancePolicyRepository repository) {
        this.repository = repository;
    }

    public List<InsurancePolicy> fetchAll(Pageable pageable) {
        return newArrayList(repository.findAll(pageable));
    }

    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return repository.save(policy);
    }

    public Optional<InsurancePolicy> fetchById(long id) {
        return repository.findById(id);
    }

    public Optional<InsurancePolicy> updatePolicy(long id, InsurancePolicy newPolicy) {
        if (newPolicy.getId() != id)
            throw new InvalidRequest("Mismatch between the policy_id in the path and in the body while updating the insurance policy");
        if (!repository.existsById(id)) {
            return Optional.empty();
        } else {
            return Optional.of(repository.save(newPolicy));
        }
    }

    public String deleteById(long id) {
        repository.deleteById(id);
        return "deleted";
    }
}
