package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.repository;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.entity.CustomerEntity;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.repository.GenericRepository;

public interface CustomerRepository extends GenericRepository<CustomerEntity, Long> {

    CustomerEntity findByName(String name);

}
