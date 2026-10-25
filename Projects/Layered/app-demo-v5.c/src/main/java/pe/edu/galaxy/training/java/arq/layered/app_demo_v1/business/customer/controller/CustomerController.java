package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.controller;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller.GenericController;

public interface CustomerController
        extends GenericController<CustomerRequestDto, CustomerResponseDto, Long> {
}
