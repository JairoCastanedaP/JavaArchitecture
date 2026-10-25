package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.exceptions;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.NotFoundException;

public class SupplierNotFoundException extends NotFoundException {
    public SupplierNotFoundException(String message) {
        super(message);
    }
}
