package dev.jmfayard.spring;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper
public interface EntityMapper {

    @Mapping(target = "policy_id", source = "id")
    InsurancePolicyDTO policyToDTO(InsurancePolicy policy);

    @Mapping(target = "id", source = "policy_id")
    InsurancePolicy dtoToPolicy(InsurancePolicyDTO dto);
}
