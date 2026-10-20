package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.service;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.SupplierResponseDto;

import java.util.List;

public interface SupplierService {
    List<SupplierResponseDto> getAll();
    SupplierResponseDto getById(Long id);
    Long save(SupplierRequestDto supplier);
    void update(Long id, SupplierRequestDto supplier);
    void delete (Long id);
}
