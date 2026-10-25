package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.entity.CustomerEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.mapper.GenericMapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper
        extends GenericMapper<CustomerEntity, CustomerRequestDto, CustomerResponseDto> {
    @Override
    @Mapping(target = "audit", source = "entity")
    CustomerResponseDto toDto(CustomerEntity entity);
}
