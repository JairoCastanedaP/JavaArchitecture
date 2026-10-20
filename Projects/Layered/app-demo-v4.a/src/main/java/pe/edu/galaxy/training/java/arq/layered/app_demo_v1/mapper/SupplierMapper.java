package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.mapper;

import org.mapstruct.Mapper;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.entity.SupplierEntity;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierResponseDto toDto(SupplierEntity entity);
    SupplierEntity toEntity(SupplierRequestDto dto);
}
