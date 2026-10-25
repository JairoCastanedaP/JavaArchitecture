package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.controller;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierRequestDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto.SupplierResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.controller.GenericController;

import static pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.controller.APIEndPoints.API_SUPPLIER_DOCUMENT_NUMBER;

public interface SupplierController
        extends GenericController<SupplierRequestDto, SupplierResponseDto,Long> {

    @GetMapping(API_SUPPLIER_DOCUMENT_NUMBER)
    ResponseEntity<SupplierResponseDto> findByDocumentNumber(
            @NotNull(message = "Document Number is required") @Pattern(
            regexp = "^[0-9]{11}$",
            message = "Document Number must be exactly 11 digits")
            @PathVariable("documentNumber") String documentNumber);
}
