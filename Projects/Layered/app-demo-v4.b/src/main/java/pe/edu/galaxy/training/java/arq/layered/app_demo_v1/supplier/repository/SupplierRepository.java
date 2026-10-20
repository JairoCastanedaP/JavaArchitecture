package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    SupplierEntity findByCompanyName(String companyName);

    }
