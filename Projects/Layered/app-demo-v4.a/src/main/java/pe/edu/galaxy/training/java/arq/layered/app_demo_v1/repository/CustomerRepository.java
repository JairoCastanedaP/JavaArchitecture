package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.entity.CustomerEntity;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // JPQL Query
    /*
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    CustomerEntity findByName(@Param("name") String name);
    */
    CustomerEntity findByName(String name);

    }
