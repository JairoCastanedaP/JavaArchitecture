package co.edu.arq.layered.app_demo_v1.controller;

import co.edu.arq.layered.app_demo_v1.dto.CustomerRequestDto;
import co.edu.arq.layered.app_demo_v1.dto.CustomerResponseDto;
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
    ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        List<CustomerResponseDto> customers = this.customerService.getAll();
        if(customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
    @PostMapping
    ResponseEntity<CustomerResponseDto> save(@RequestBody CustomerRequestDto customer) {
        log.info("Saving customer: {}", customer);
        CustomerResponseDto savedCustomer = this.customerService.save(customer);
        return ResponseEntity.created(URI.create("/api/v1/customers/" + savedCustomer.id()))
                .body(savedCustomer);
    }

    @PutMapping("/{id}")
    ResponseEntity<CustomerResponseDto> update(
            @PathVariable("id") Long id,
            @RequestBody CustomerRequestDto customer) {
        log.info("Updating customer with id {}, customer: {}", id, customer);
        CustomerResponseDto updatedCustomer = this.customerService.update(id, customer);

        return ResponseEntity.ok(updatedCustomer);
    }

}