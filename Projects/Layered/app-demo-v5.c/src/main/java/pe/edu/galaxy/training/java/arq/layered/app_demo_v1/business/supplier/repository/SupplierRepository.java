package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.repository;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.entity.SupplierEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.repository.GenericRepository;

import java.util.Optional;

public interface SupplierRepository extends GenericRepository<SupplierEntity, Long> {

    SupplierEntity findByCompanyName(String companyName);

    Optional<SupplierEntity> findByDocumentNumber(@NotNull(message = "Document Number is required") @Pattern(
                regexp = "^[0-9]{11}$",
                message = "Document Number must be exactly 11 digits"
        ) String documentNumber);
}
