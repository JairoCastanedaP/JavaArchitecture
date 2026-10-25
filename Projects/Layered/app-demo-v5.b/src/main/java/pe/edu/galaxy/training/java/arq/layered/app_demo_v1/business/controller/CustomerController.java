package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.controller;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.CustomerRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.CustomerResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller.GenericController;

public interface CustomerController
        extends GenericController<CustomerRequestDto, CustomerResponseDto, Long> {
}
