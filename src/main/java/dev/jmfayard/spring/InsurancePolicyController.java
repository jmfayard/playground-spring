package dev.jmfayard.spring;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RequestMapping("/policies")
@RestController
@AllArgsConstructor
public class InsurancePolicyController {
    private InsurancePolicyService service;

    @GetMapping
    public List<InsurancePolicy> fetchAllPolicies() {
        return service.fetchAll();
    }

    @PostMapping
    public InsurancePolicy createPolicy() {
        return service.createPolicy();
    }

    @GetMapping("/{id}")
    public InsurancePolicy fetchPolicyById(@PathVariable long id) {
        return service.fetchById(id).orElseThrow(RessourceNotFound::new);
    }

    @PutMapping("/{id}")
    public InsurancePolicy updatePolicy(@PathVariable long id, @RequestBody InsurancePolicy body) {
        return service.updatePolicy(id, body).orElseThrow(RessourceNotFound::new);
    }

    @DeleteMapping("/{id}")
    public String deleteById(@PathVariable long id) {
        return service.deleteById(id);
    }

}

@Service
@AllArgsConstructor
class InsurancePolicyService {

    public List<InsurancePolicy> fetchAll() {
        return new ArrayList<>();
    }

    public InsurancePolicy createPolicy() {
        return new InsurancePolicy();
    }

    public Optional<InsurancePolicy> fetchById(long id) {
        return Optional.empty();
    }

    public Optional<InsurancePolicy> updatePolicy(long id, InsurancePolicy body) {
        return null;
    }

    public String deleteById(long id) {
        return null;
    }
}