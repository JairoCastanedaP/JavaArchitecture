package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.service;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.service.GenericService;

public interface CustomerService
        extends GenericService<CustomerRequestDto, CustomerResponseDto, Long> {

}
