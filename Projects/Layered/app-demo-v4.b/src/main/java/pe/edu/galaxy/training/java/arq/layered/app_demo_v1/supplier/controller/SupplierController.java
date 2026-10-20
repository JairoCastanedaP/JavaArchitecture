package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.service.SupplierService;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/v1/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @GetMapping
    ResponseEntity<List<SupplierResponseDto>> getAllSuppliers() {
        List<SupplierResponseDto> suppliers = this.supplierService.getAll();
        if(suppliers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(suppliers);
    }
    @PostMapping
    ResponseEntity<?> save(@RequestBody @Valid SupplierRequestDto supplier) {
        log.info("Saving supplier: {}", supplier);
        Long id = this.supplierService.save(supplier);
        return ResponseEntity.created(URI.create("/api/v1/suppliers/" + id))
                .body(Map.of("Supplier created with id", id));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @RequestBody SupplierRequestDto supplier) {
        log.info("Updating supplier with id {}, supplier: {}", id, supplier);
        this.supplierService.update(id, supplier);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(
            @PathVariable("id") Long id) {
        log.info("Deleting supplier with id {}", id);
        this.supplierService.delete(id);
        return ResponseEntity.ok().build();
    }
}
