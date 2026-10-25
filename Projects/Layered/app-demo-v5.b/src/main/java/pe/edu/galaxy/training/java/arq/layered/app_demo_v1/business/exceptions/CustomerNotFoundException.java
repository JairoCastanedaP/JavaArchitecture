package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.exceptions;

public class CustomerNotFoundException extends NotFoundException {
    public CustomerNotFoundException(String message) {
        super(message);
    }
}
