package co.edu.arq.layered.app_demo_v1.repository;

import co.edu.arq.layered.app_demo_v1.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

///
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

}
