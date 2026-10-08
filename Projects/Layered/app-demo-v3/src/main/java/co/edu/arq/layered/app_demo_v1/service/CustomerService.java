package co.edu.arq.layered.app_demo_v1.service;

import co.edu.arq.layered.app_demo_v1.dto.CustomerRequestDto;
import co.edu.arq.layered.app_demo_v1.dto.CustomerResponseDto;

import java.util.List;

public interface CustomerService {
    List<CustomerResponseDto> getAll();
    CustomerResponseDto getById(Long id);
    CustomerResponseDto save(CustomerRequestDto customer);
    CustomerResponseDto update(Long id, CustomerRequestDto customer);
    void delete (Long id);
}