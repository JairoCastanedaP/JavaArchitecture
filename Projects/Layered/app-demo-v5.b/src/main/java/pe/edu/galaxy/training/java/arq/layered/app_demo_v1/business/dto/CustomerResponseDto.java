package pe.edu.galaxy.training.java.arq.layered.app_demo_v1.business.dto;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import pe.edu.galaxy.training.java.arq.layered.app_demo_v1.generic.dto.GenericResponseDto;

@Getter
@Setter
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
public class CustomerResponseDto extends GenericResponseDto<Long, String> {

    private String name;
    private String email;
    private String address;
    private String phone;
}
