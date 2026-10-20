package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.exceptions;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.GenericException;

public class CustomerException extends GenericException {
    public CustomerException(String message) {
        super(message);
    }
}
