package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface GenericRepository <T,ID> extends JpaRepository<T,ID> {
 // Aquí puedes agregar métodos genéricos adicionales si es necesario
}
