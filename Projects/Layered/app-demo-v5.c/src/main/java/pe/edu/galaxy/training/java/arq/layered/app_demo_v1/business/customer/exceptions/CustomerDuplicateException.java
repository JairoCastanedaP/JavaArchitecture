package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.customer.exceptions;


import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.DuplicateException;

public class CustomerDuplicateException extends DuplicateException {
    public CustomerDuplicateException(String message) {
        super(message);
    }
}
