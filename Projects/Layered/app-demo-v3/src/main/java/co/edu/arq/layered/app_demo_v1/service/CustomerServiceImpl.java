package co.edu.arq.layered.app_demo_v1.service;

import co.edu.arq.layered.app_demo_v1.dto.CustomerRequestDto;
import co.edu.arq.layered.app_demo_v1.dto.CustomerResponseDto;
import co.edu.arq.layered.app_demo_v1.entity.CustomerEntity;
import co.edu.arq.layered.app_demo_v1.exceptions.CustomerException;
import co.edu.arq.layered.app_demo_v1.mapper.CustomerMapper;
import co.edu.arq.layered.app_demo_v1.repository.CustomerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;

    public CustomerServiceImpl(CustomerRepository customerRepository, CustomerMapper customerMapper){
        this.customerRepository = customerRepository;
        this.customerMapper= customerMapper;
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        //return this.customerRepository.findAll();
        return this.customerRepository.findAll()
                .stream()
                .map(this.customerMapper::toResponseDto)//explicación
                .toList();
    }

    @Override
    public CustomerResponseDto getById(Long id) {
        return this.customerRepository
                .findById(id)
                .map(this.customerMapper::toResponseDto)
                .orElseThrow(() -> new CustomerException("Customer not found with id " + id));
    }

    @Override
    public CustomerResponseDto save(CustomerRequestDto customerDto){
        //return customerRepository.save(customer);
        CustomerEntity existingCustomer = customerRepository.findByName(customerDto.name());
        if (existingCustomer != null) {
            throw new CustomerException("Customer already exists with name " + customerDto.name());
        }
        CustomerEntity customerEntity=  customerMapper.toEntity(customerDto);
        customerEntity.setSwDelete("1");
        CustomerEntity saveCustomer = customerRepository.save(customerEntity);

        return customerMapper.toResponseDto(saveCustomer);
    }

    @Override
    public CustomerResponseDto update(Long id, CustomerRequestDto customerDto) {
        CustomerEntity customerEntity= customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer not found with id " + id));
        customerEntity.setName(customerDto.name());
        customerEntity.setEmail(customerDto.email());
        customerEntity.setPhone(customerDto.phone());
        customerEntity.setAddress(customerDto.address());
        customerEntity.setAddress(customerDto.state());

        CustomerEntity updatedCustomer = customerRepository.save(customerEntity);

        return customerMapper.toResponseDto(updatedCustomer);
    }
    @Override
    public void delete(Long id) {

        CustomerEntity customerEntity= customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer not found with id " + id));
        // Physical delete
        //this.customerRepository.delete(customerEntity);
        customerEntity.setSwDelete("0");
        this.customerRepository.save(customerEntity);
    }
}