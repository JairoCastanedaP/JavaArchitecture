package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.service.CustomerService;
import java.net.URI;
import java.util.List;
import java.util.Map;

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
    ResponseEntity<?> save(@RequestBody @Valid CustomerRequestDto customer) {
        log.info("Saving customer: {}", customer);
        Long id = this.customerService.save(customer);
        return ResponseEntity.created(URI.create("/api/v1/customers/" + id))
                .body(Map.of("Customer created with id", id));
    }

    @PutMapping("/{id}")
    ResponseEntity<?> update(
            @PathVariable("id") Long id,
            @RequestBody CustomerRequestDto customer) {
        log.info("Updating customer with id {}, customer: {}", id, customer);
        this.customerService.update(id, customer);
        return ResponseEntity.ok().build();
    }
    @DeleteMapping("/{id}")
    ResponseEntity<?> delete(
            @PathVariable("id") Long id) {
        log.info("Deleting customer with id {}", id);
        this.customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
