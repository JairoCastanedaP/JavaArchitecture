package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.service;

import java.util.List;

public interface GenericService<REQ,RES, ID> {
    List<RES> findAll();
    RES findById(ID id);
    ID save(REQ req);
    void update(ID id, REQ req);
    void delete(ID id);
}
