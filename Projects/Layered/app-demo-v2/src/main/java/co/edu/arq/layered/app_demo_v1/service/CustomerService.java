package co.edu.arq.layered.app_demo_v1.service;

import co.edu.arq.layered.app_demo_v1.entity.CustomerEntity;

import java.util.List;

public interface CustomerService {
    List<CustomerEntity> getAll();
    CustomerEntity getById(Long id);
    CustomerEntity save(CustomerEntity customer);
    CustomerEntity update(Long id, CustomerEntity customer);
}