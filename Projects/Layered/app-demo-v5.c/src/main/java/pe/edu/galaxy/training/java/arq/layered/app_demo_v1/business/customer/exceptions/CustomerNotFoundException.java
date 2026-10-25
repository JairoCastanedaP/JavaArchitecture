package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.exceptions;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.NotFoundException;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
