package dev.jmfayard.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/policies")
@RestController
public class InsurancePolicyController {
    private InsurancePolicyService service;

    @Autowired
    public InsurancePolicyController(InsurancePolicyService service) {
        this.service = service;
    }

    @GetMapping
    public List<InsurancePolicy> fetchAllPolicies() {
        return service.fetchAll();
    }

    @PostMapping
    public InsurancePolicy createPolicy(@RequestBody InsurancePolicy policy) {
        return service.createPolicy(policy);
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

