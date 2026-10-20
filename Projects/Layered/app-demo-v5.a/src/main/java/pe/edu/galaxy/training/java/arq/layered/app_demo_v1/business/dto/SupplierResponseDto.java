package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto;

import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.dto.AuditResponseDto;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.dto.GenericResponseDto;

public class SupplierResponseDto extends GenericResponseDto<Long, String> {
    private String companyName;
    private String documentNumber;
    private String email;
    private String address;
    private String phone;

    public SupplierResponseDto(Long aLong, String state, AuditResponseDto audit) {
        super(aLong, state, audit);
    }
}
