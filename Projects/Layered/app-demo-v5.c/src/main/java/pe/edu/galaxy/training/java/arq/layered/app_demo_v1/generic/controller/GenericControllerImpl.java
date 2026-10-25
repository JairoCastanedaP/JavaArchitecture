package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller;

import org.springframework.http.ResponseEntity;

import java.net.URI;
import java.util.Map;

public abstract class GenericControllerImpl {
    //TODO: Implement common controller methods here, if needed in the future
    protected ResponseEntity<Map<String, Object>> returnSave( String path,String msg, Long id) {
        return ResponseEntity.created(URI.create(path + id))
                .body(Map.of(msg, id));
    }

}
