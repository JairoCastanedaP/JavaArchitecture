package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.entity.CustomerEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.entity.SupplierEntity;

public interface SupplierRepository extends JpaRepository<SupplierEntity, Long> {

    SupplierEntity findByCompanyName(String companyName);

    }
