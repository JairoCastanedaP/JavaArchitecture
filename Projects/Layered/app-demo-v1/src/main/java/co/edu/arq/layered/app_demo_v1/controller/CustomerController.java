package co.edu.arq.layered.app_demo_v1.controller;

import co.edu.arq.layered.app_demo_v1.entity.CustomerEntity;
import co.edu.arq.layered.app_demo_v1.repository.CustomerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;
@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerRepository customerRepository;

    public CustomerController(CustomerRepository customerRepository){
        this.customerRepository= customerRepository;
    }
    @GetMapping
    ResponseEntity<List<CustomerEntity>> getAllCustomers(){
        List<CustomerEntity> customers = this.customerRepository.findAll();

        if(customers.isEmpty()){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(customers);
        }
    }

    @PostMapping
    ResponseEntity<CustomerEntity> save(@RequestBody CustomerEntity customer) {
        log.info("Saving customer: {}", customer);
        CustomerEntity savedCustomer = this.customerRepository.save(customer);
        return ResponseEntity.created(URI.create("/api/v1/customers/" + savedCustomer.getId()))
                .body(savedCustomer);
    }

    @PutMapping("/{id}")
    ResponseEntity<CustomerEntity> update(
            @PathVariable("id") Long id,
            @RequestBody CustomerEntity customer) {
        log.info("Saving id {}, customer: {}", id,customer);
        CustomerEntity customerEntity= customerRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Customer not found with id " + id));
        customerEntity.setName(customer.getName());
        customerEntity.setEmail(customer.getEmail());
        customerEntity.setPhone(customer.getPhone());
        customerEntity.setAddress(customer.getAddress());

        CustomerEntity updatedCustomer = this.customerRepository.save(customerEntity);
        return ResponseEntity.ok()
                .body(updatedCustomer);
    }
}
