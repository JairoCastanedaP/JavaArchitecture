package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.service;

import java.util.List;

public interface GenericService<T, R, ID> {
    List<R> findAll();
    R findById(ID id);
    ID save(T entity);
    void update(ID id, T entity);
    void delete(ID id);
}
