package co.edu.arq.layered.app_demo_v1.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record CustomerRequestDto (
    Long id,

    @NotNull(message = "Name is required")
    @Size(min = 2, max = 100, message = "Name must be between {min} and {max} characters")
    String name,

    @NotNull(message = "Email is required")
    @Email(message = "Email should be valid")
    String email,

    @NotNull(message = "Phone is required")
    @Pattern(
            regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$",
            message = "Phone must be a valid international number starting with '+' (e.g., +51 999999999)"
    )
    String phone,

    @NotNull(message = "Address is required")
    @Size(min = 2, max = 100, message = "Address must be between {min} and {max} characters")
    String address,

    String state
){}
