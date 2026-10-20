package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.customer;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAll();
    CustomerResponseDto getById(Long id);
    Long save(CustomerRequestDto customer);
    void update(Long id, CustomerRequestDto customer);
    void delete (Long id);
}
