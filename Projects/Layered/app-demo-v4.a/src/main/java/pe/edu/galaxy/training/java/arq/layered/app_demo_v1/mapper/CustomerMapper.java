package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.mapper;

import org.mapstruct.Mapper;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.entity.CustomerEntity;

@Mapper(componentModel = "spring")
public interface CustomerMapper {
    CustomerResponseDto toDto(CustomerEntity entity);
    CustomerEntity toEntity(CustomerRequestDto dto);
}
