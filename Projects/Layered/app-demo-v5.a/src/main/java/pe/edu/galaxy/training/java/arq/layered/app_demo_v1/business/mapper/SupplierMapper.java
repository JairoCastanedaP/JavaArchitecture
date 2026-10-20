package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.entity.SupplierEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.mapper.GenericMapper;

@Mapper(componentModel = "spring")
public interface SupplierMapper
        extends GenericMapper<SupplierEntity, SupplierRequestDto, SupplierResponseDto> {

    @Override
    @Mapping(target = "audit", source = "entity")
    SupplierResponseDto toDto(SupplierEntity entity);
}
