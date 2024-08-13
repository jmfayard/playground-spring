package dev.jmfayard.spring;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/policies")
@RestController
public class InsurancePolicyController {
    private InsurancePolicyService service;

    public InsurancePolicyController(InsurancePolicyService service) {
        this.service = service;
    }

    @GetMapping
    public List<InsurancePolicy> fetchAllPolicies() {
        return service.fetchAll();
    }

    @PostMapping
    public ResponseEntity<InsurancePolicy> createPolicy(
            HttpServletRequest request,
            @RequestBody InsurancePolicy policy
    ) throws URISyntaxException {
        var createdPolicy = service.createPolicy(policy);
        var uri = new URI(request.getRequestURI());
        return ResponseEntity.created(uri).body(createdPolicy);
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
    public ResponseEntity<String> deleteById(@PathVariable long id) {
        var deleted = service.deleteById(id);
        return ResponseEntity.accepted().body(deleted);
    }
}

