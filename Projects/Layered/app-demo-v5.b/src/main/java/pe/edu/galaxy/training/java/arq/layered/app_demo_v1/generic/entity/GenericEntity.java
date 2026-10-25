package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@ToString
@Getter
@Setter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class) // Permite la captura automática de fechas y usuarios
public class GenericEntity {

    @Column(name = "state", nullable = false, length = 20)
    private String state = "Activo";

    // --- ESTADO Y BORRADO LÓGICO ---
    @Column(name = "sw_delete", nullable = false, length = 1)
    private String swDelete = "1";

    // --- AUDITORÍA DE TIEMPO Y USUARIO (Automáticos con Spring Auditing) ---
    @CreatedDate
    @Column(name = "created_date", updatable = false)
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name = "created_by", updatable = false, length = 50)
    private String createdBy;

    @LastModifiedDate
    @Column(name = "updated_date")
    private LocalDateTime updatedDate;

    @LastModifiedBy
    @Column(name = "updated_by", length = 50)
    private String updatedBy;

    // --- AUDITORÍA DE RED Y CONTEXTO (Se setean vía Interceptor/Filtro o manualmente) ---
    @Column(name = "client_ip", length = 45) // Longitud 45 soporta IPv6 perfectamente
    private String clientIp;

    @Column(name = "client_host", length = 100)
    private String clientHost;

    @Column(name = "session_id", length = 100)
    private String sessionId;
}
