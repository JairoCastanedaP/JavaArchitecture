package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.repository;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.entity.SupplierEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.repository.GenericRepository;

public interface SupplierRepository extends GenericRepository<SupplierEntity, Long> {

    SupplierEntity findByCompanyName(String companyName);

}
