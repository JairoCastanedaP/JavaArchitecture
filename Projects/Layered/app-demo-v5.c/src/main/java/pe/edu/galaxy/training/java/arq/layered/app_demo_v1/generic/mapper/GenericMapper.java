package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.mapper;

import java.util.List;

public interface GenericMapper<ENT, REQ, RES> {

    RES toDto(ENT entity);
    ENT toEntity(REQ dto);
    List<RES> toDtoList(List<ENT> entities);
    List<ENT> toEntityList(List<REQ> dtos);
}