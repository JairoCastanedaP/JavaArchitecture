package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.entity.GenericEntity;

@ToString
@Getter
@Setter
@Entity(name = "Supplier")
@Table(name = "suppliers")
public class SupplierEntity  extends GenericEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "supplier_id")
    private Long id;

    @Column(name = "company_name", nullable = false, unique = true)
    private String companyName;

    @Column(name = "document_number", nullable = false, unique = true, length = 11)
    private String documentNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "phone")
    private String phone;

    @Column(name = "address")
    private String address;
}
