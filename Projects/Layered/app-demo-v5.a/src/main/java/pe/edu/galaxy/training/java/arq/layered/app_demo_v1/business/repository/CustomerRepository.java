package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.repository;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.entity.CustomerEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.repository.GenericRepository;

public interface CustomerRepository extends GenericRepository<CustomerEntity, Long> {

    CustomerEntity findByName(String name);

}
