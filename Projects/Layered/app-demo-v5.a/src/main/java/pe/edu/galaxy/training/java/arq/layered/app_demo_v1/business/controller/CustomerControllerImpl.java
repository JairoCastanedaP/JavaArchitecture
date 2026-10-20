package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.service.CustomerService;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller.GenericController;

import java.net.URI;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("api/v1/customers")
public class CustomerControllerImpl extends GenericController {

    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    ResponseEntity<List<CustomerResponseDto>> getAllCustomers() {
        List<CustomerResponseDto> customers = this.customerService.findAll();
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
