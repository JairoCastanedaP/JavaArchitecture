package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.entity.GenericEntity;

@ToString
@Getter
@Setter
@Entity(name = "Customer")
@Table(name = "customers")
public class CustomerEntity extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true)
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;

}
