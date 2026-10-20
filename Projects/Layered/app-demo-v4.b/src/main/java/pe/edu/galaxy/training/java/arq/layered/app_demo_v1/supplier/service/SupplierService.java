package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.service;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.dto.SupplierResponseDto;

import java.util.List;

public interface SupplierService {
    List<SupplierResponseDto> getAll();
    SupplierResponseDto getById(Long id);
    Long save(SupplierRequestDto supplier);
    void update(Long id, SupplierRequestDto supplier);
    void delete (Long id);
}
