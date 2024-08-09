package dev.jmfayard.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static org.hibernate.validator.internal.util.CollectionHelper.newArrayList;

@Service
public class InsurancePolicyService {
    private final InsurancePolicyRepository repository;

    @Autowired
    InsurancePolicyService(InsurancePolicyRepository repository) {
        this.repository = repository;
    }

    public List<InsurancePolicy> fetchAll() {
        return newArrayList(repository.findAll());
    }

    public InsurancePolicy createPolicy(InsurancePolicy policy) {
        return repository.save(policy);
    }

    public Optional<InsurancePolicy> fetchById(long id) {
        return repository.findById(id);
    }

    public Optional<InsurancePolicy> updatePolicy(long id, InsurancePolicy newPolicy) {
        if (newPolicy.getId() != id)
            throw new InvalidRequest("Mismatch between the id in the path and in the body while updating the insurance policy");
        if (!repository.existsById(id)) {
            return Optional.empty();
        } else {
            return Optional.of(repository.save(newPolicy));
        }
    }

    public String deleteById(long id) {
        return null;
    }
}
