package co.edu.arq.layered.app_demo_v1.service;

import co.edu.arq.layered.app_demo_v1.entity.CustomerEntity;
import co.edu.arq.layered.app_demo_v1.repository.CustomerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public List<CustomerEntity> getAll() {
        return this.customerRepository.findAll();
    }

    @Override
    public CustomerEntity getById(Long id) {
        return this.customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
    }

    @Override
    public CustomerEntity save(CustomerEntity customer) {
        return customerRepository.save(customer);
    }

    @Override
    public CustomerEntity update(Long id, CustomerEntity customer) {
        CustomerEntity customerEntity= customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setAddress(customer.getAddress());
        return this.customerRepository.save(customerEntity);
    }
}