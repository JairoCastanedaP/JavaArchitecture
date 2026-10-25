package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.service;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.service.GenericService;

public interface CustomerService
        extends GenericService<CustomerRequestDto, CustomerResponseDto, Long> {

}
