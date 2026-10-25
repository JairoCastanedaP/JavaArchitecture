package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.dto;

import java.time.LocalDateTime;

public record AuditResponseDto(
        Long id,
        String state,
        String swDelete,
        LocalDateTime createdDate,
        String createdBy,
        LocalDateTime updatedDate,
        String updatedBy,
        String clientIp,
        String clientHost,
        String sessionId
) {
}