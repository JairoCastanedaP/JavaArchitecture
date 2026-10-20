package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.mapper;

import java.util.List;

public interface GenericMapper<E, REQ, RES> {

    RES toDto(E entity);

    E toEntity(REQ dto);

    List<RES> toDtoList(List<E> entities);

    List<E> toEntityList(List<REQ> dtos);
}