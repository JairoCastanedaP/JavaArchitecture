package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.supplier.dto;

import jakarta.validation.constraints.*;

public record SupplierRequestDto(

        @NotNull(message = "Company name is required")
        @Size(min = 2, max = 100, message = "Company name must be between {min} and {max} characters")
        String companyName,

        @NotNull(message = "Document Number is required")
        @Pattern(
                regexp = "^[0-9]{11}$",
                message = "Document Number must be exactly 11 digits"
        )
        String documentNumber,

        @NotNull(message = "Email is required")
        @Email(message = "Email should be valid")
        String email,

        @NotNull(message = "Address is required")
        @Size(min = 5, max = 150, message = "Address must be between {min} and {max} characters")
        String address,

        @NotNull(message = "Phone is required")
        @Pattern(
                regexp = "^\\+?[0-9\\s-]{7,15}$",
                message = "Phone must be a valid number (e.g., +51 999999999 or 01 4444444)"
        )
        String phone
) {
}
