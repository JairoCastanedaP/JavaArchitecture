package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.service.CustomerService;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller.GenericControllerImpl;
import java.net.URI;
import java.util.List;
import java.util.Map;
import static pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.shared.constants.APIEndPoints.API_CUSTOMER;

@Slf4j
@RestController
@RequestMapping(API_CUSTOMER)
public class CustomerControllerImpl
        extends GenericControllerImpl
        implements CustomerController{

    private final CustomerService customerService;

    public CustomerControllerImpl(CustomerService customerService) {
        this.customerService = customerService;
    }

    public ResponseEntity<List<CustomerResponseDto>> findAll() {
        List<CustomerResponseDto> customers = this.customerService.findAll();
        if(customers.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(customers);
    }
    public ResponseEntity<Map<String, Object>> save(CustomerRequestDto customer) {
        log.info("Saving customer: {}", customer);
        Long id = this.customerService.save(customer);
        /*
        return ResponseEntity.created(URI.create("/api/v1/customers/" + id))
                .body(Map.of("Customer created with id", id));

         */
        return super.returnSave(API_CUSTOMER, "Customer created with id",id);
    }

    @Override
    public ResponseEntity<Void> update(Long id, CustomerRequestDto customerRequestDto) {
            log.info("Updating customer with id {}, customer: {}", id, customerRequestDto);
            this.customerService.update(id, customerRequestDto);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<Void> delete(
            Long id) {
        log.info("Deleting customer with id {}", id);
        this.customerService.delete(id);
        return ResponseEntity.ok().build();
    }
}
