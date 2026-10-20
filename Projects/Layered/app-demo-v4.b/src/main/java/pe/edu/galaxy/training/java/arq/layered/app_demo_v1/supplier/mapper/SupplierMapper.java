package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.mapper;

import org.mapstruct.Mapper;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.entity.SupplierEntity;

@Mapper(componentModel = "spring")
public interface SupplierMapper {
    SupplierResponseDto toDto(SupplierEntity entity);
    SupplierEntity toEntity(SupplierRequestDto dto);
}
