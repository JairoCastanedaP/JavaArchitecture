package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto;

public record SupplierResponseDto(
        Long   id,
        String companyName,
        String documentNumber,
        String email,
        String address,
        String phone,
        String state
) {
}
