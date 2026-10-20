package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.customer;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;
    private final CustomerMapper customerMapper;
    public CustomerServiceImpl(CustomerRepository customerRepository,
                               CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    @Override
    public List<CustomerResponseDto> getAll() {
        return this.customerRepository.findAll()
                .stream()
                .map(this.customerMapper::toDto)
                .toList();
    }

    @Override
    public CustomerResponseDto getById(Long id) {
        return this.customerRepository
                .findById(id)
                .map(this.customerMapper::toDto)
                .orElseThrow(() -> new CustomerException("Customer not found with id " + id));
    }

    @Override
    public Long save(CustomerRequestDto customer) {
        CustomerEntity existingCustomer = customerRepository.findByName(customer.name());
        if (existingCustomer != null) {
            throw new CustomerException("Customer already exists with name " + customer.name());
        }
        CustomerEntity customerEntity = this.customerMapper.toEntity(customer);
        customerEntity.setSwDelete("1");
        return customerRepository.save(customerEntity).getId();
    }

    @Override
    public void update(Long id, CustomerRequestDto customer) {
        CustomerEntity customerEntity= customerRepository.findById(id)
                .orElseThrow(() -> new CustomerException("Customer not found with id " + id));
        CustomerEntity existingCustomer = customerRepository.findByName(customer.name());
        if (existingCustomer != null && !existingCustomer.getId().equals(id)) {
            throw new CustomerException("Customer already exists with name " + customer.name());
        }
        customerEntity.setName(customer.name());
        customerEntity.setEmail(customer.email());
        customerEntity.setPhone(customer.phone());
        customerEntity.setAddress(customer.address());
        this.customerRepository.save(customerEntity);
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
