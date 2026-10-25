package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.exceptions;


public class CustomerDuplicateException extends DuplicateException {
    public CustomerDuplicateException(String message) {
        super(message);
    }
}
