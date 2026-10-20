package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.customer;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto toDto(CustomerEntity entity);
    CustomerEntity toEntity(CustomerRequestDto dto);
}
