package dev.jmfayard.spring.core;

import dev.jmfayard.spring.domain.InsurancePolicy;
import dev.jmfayard.spring.api.InsurancePolicyDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EntityMapper {

    @Mapping(target = "policy_id", source = "id")
    InsurancePolicyDTO policyToDTO(InsurancePolicy policy);

    @Mapping(target = "id", source = "policy_id")
    InsurancePolicy dtoToPolicy(InsurancePolicyDTO dto);
}
