package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller;

import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

public interface GenericController<REQ,RES, ID> {
    @GetMapping
    ResponseEntity<List<RES>> findAll();
    @PostMapping
    ResponseEntity<Map<String, Object>> save(@RequestBody @Valid REQ req);
    @PutMapping("/{id}")
    ResponseEntity<Void> update(@PathVariable("id") ID id,@RequestBody REQ req);
    @DeleteMapping("/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") ID id);
}
