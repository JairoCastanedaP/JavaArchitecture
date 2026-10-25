package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.shared.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.DuplicateException;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.GenericException;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.exceptions.NotFoundException;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestControllerAdvice
public class GlobalException {
    // 1. Captura los errores de validación de @Valid / @NotNull / @Pattern
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        log.info("handleValidationExceptions...");
        Map<String, Object> response = new HashMap<>();
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Validation Failed");
        response.put("fields", errors);

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 2. Captura tus excepciones de negocio (ej. "Customer already exists" o "Not found")
    @ExceptionHandler(GenericException.class)
    public ResponseEntity<Map<String, Object>> handleBadRequest(GenericException ex) {
        log.info("handleBadRequest...");
        Map<String, Object> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.BAD_REQUEST.value());
        response.put("error", "Business Error");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // 3. Captura tus excepciones de negocio (ej. "Customer already exists")
    @ExceptionHandler(DuplicateException.class)
    public ResponseEntity<Map<String, Object>> handleCustomerException(DuplicateException ex) {
        log.info("handleCustomerException...");
        Map<String, Object> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.CONFLICT.value());
        response.put("error", "Business Error");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.CONFLICT);
    }

    // 4. Captura tus excepciones de negocio (ej. "Customer already exists")
    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<Map<String, Object>> handleCustomerException(NotFoundException ex) {
        log.info("handleCustomerException...");
        Map<String, Object> response = new HashMap<>();

        response.put("timestamp", LocalDateTime.now());
        response.put("status", HttpStatus.NOT_FOUND.value());
        response.put("error", "Business Error");
        response.put("message", ex.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

}
