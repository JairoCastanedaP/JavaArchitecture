package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.controller.impl;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.controller.SupplierController;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.service.SupplierService;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller.GenericControllerImpl;
import java.net.URI;
import java.util.List;
import java.util.Map;

import static pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.shared.constants.APIEndPoints.API_SUPPLIER;

@Slf4j
@RestController
@RequestMapping(API_SUPPLIER)
public class SupplierControllerImpl
        extends GenericControllerImpl
implements SupplierController {
    private final SupplierService supplierService;

    public SupplierControllerImpl(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @Override
    public ResponseEntity<List<SupplierResponseDto>> findAll() {
        List<SupplierResponseDto> suppliers = this.supplierService.findAll();
        if(suppliers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(suppliers);
    }

    @Override
    public ResponseEntity<Map<String, Object>> save(SupplierRequestDto supplierRequestDto) {
        log.info("Saving supplier: {}", supplierRequestDto);
        Long id = this.supplierService.save(supplierRequestDto);
        return ResponseEntity.created(URI.create("/api/v1/suppliers/" + id))
                .body(Map.of("Supplier created with id", id));
    }

    @Override
    public ResponseEntity<Void> update(Long id, SupplierRequestDto supplierRequestDto) {
        log.info("Updating supplier with id {}, supplier: {}", id, supplierRequestDto);
        this.supplierService.update(id, supplierRequestDto);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<Void> delete(Long id) {
        log.info("Deleting supplier with id: {}", id);
        this.supplierService.delete(id);
        return ResponseEntity.ok().build();
    }

    @Override
    public ResponseEntity<SupplierResponseDto> findByDocumentNumber(String documentNumber) {
        SupplierResponseDto supplier = this.supplierService.findByDocumentNumber(documentNumber);
        return ResponseEntity.ok(supplier);
    }
}
