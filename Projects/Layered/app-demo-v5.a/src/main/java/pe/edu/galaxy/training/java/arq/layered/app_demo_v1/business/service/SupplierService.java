package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.service;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.service.GenericService;

public interface SupplierService
        extends GenericService<SupplierRequestDto, SupplierResponseDto, Long> {
    SupplierResponseDto findByDocumentNumber(String documentNumber);

}
