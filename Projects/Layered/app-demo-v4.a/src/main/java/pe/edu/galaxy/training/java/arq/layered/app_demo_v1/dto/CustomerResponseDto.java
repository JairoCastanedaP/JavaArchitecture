package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.dto;

public record CustomerResponseDto(
        Long   id,
        String name,
        String email,
        String address,
        String phone,
        String state
) {
}
