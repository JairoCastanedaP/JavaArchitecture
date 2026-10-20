package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.dto;

import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class GenericResponseDto<ID, S> {
    protected ID id;
    protected S state;
    protected AuditResponseDto audit;
}