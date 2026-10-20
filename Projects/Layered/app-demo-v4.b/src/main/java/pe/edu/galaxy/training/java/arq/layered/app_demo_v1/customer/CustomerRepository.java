package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.customer;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

    // JPQL Query
    /*
    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    CustomerEntity findByName(@Param("name") String name);
    */
    CustomerEntity findByName(String name);

    }
