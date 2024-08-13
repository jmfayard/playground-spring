package dev.jmfayard.spring.api;

import dev.jmfayard.spring.core.EntityMapper;
import dev.jmfayard.spring.domain.InsurancePolicy;
import dev.jmfayard.spring.domain.InsurancePolicyService;
import dev.jmfayard.spring.domain.RessourceNotFound;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

@RequestMapping("/policies")
@RestController
public class InsurancePolicyController {
    private InsurancePolicyService service;
    private EntityMapper mapper;

    public InsurancePolicyController(InsurancePolicyService service, EntityMapper mapper) {
        this.service = service;
        this.mapper = mapper;
    }

    @GetMapping
    public List<InsurancePolicyDTO> fetchAllPolicies(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "size", required = false) Integer size,
            @RequestParam(value = "sort", required = false) String sort
    ) {
        var request = PageRequest.of(page == null ? 0 : page, size == null ? 20 : size, Sort.by(sort == null ? "id" : sort));
        List<InsurancePolicy> result = service.fetchAll(request);

        return result.stream().map(mapper::policyToDTO).toList();
    }

    @PostMapping
    public ResponseEntity<InsurancePolicyDTO> createPolicy(
            HttpServletRequest request,
            @RequestBody InsurancePolicy policy
    ) throws URISyntaxException {
        var createdPolicy = mapper.policyToDTO(service.createPolicy(policy));
        var uri = new URI(request.getRequestURI());
        return ResponseEntity.created(uri).body(createdPolicy);
    }

    @GetMapping("/{policy_id}")
    public InsurancePolicyDTO fetchPolicyById(@PathVariable long policy_id) {

        return service.fetchById(policy_id)
                .map(policy -> mapper.policyToDTO(policy))
                .orElseThrow(RessourceNotFound::new);
    }

    @PutMapping("/{policy_id}")
    public InsurancePolicyDTO updatePolicy(@PathVariable long policy_id, @RequestBody InsurancePolicy body) {
        var result = service.updatePolicy(policy_id, body)
                .map(policy -> mapper.policyToDTO(policy));
        return result.orElseThrow(RessourceNotFound::new);
    }

    @DeleteMapping("/{policy_id}")
    public ResponseEntity<String> deleteById(@PathVariable long policy_id) {
        var deleted = service.deleteById(policy_id);
        return ResponseEntity.accepted().body(deleted);
    }
}

