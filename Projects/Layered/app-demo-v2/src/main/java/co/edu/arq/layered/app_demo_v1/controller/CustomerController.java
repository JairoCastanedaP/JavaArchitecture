package co.edu.arq.layered.app_demo_v1.controller;

import co.edu.arq.layered.app_demo_v1.entity.CustomerEntity;
import co.edu.arq.layered.app_demo_v1.repository.CustomerRepository;
import co.edu.arq.layered.app_demo_v1.service.CustomerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;


@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<List<CustomerEntity>> getAllCustomers() {
        List<CustomerEntity> customers = this.customerService.getAll();
        if(customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
    @PostMapping
    ResponseEntity<CustomerEntity> save(@RequestBody CustomerEntity customer) {
        log.info("Saving customer: {}", customer);
        CustomerEntity savedCustomer = this.customerService.save(customer);
        return ResponseEntity.created(URI.create("/api/v1/customers/" + savedCustomer.getId()))
                .body(savedCustomer);
    }

    @PutMapping("/{id}")
    ResponseEntity<CustomerEntity> update(
            @PathVariable("id") Long id,
            @RequestBody CustomerEntity customer) {
        log.info("Updating customer with id {}, customer: {}", id, customer);
        CustomerEntity updatedCustomer = this.customerService.update(id, customer);
        return ResponseEntity.ok()
                .body(updatedCustomer);
    }

}