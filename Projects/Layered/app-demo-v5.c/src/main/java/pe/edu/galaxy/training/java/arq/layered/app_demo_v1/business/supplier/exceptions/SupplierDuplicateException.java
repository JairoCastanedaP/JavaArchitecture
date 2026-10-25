package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.supplier.exceptions;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.DuplicateException;

public class SupplierDuplicateException extends DuplicateException {
    public SupplierDuplicateException(String message) {
        super(message);
    }
}
