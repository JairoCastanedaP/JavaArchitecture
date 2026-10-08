package co.edu.arq.layered.app_demo_v1.mapper;

import co.edu.arq.layered.app_demo_v1.dto.CustomerRequestDto;
import co.edu.arq.layered.app_demo_v1.dto.CustomerResponseDto;
import co.edu.arq.layered.app_demo_v1.entity.CustomerEntity;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapper {

    public CustomerEntity toEntity(CustomerRequestDto dto){
        CustomerEntity customerEntity= new CustomerEntity();
        customerEntity.setName(dto.name());
        customerEntity.setEmail(dto.email());
        customerEntity.setPhone(dto.phone());
        customerEntity.setAddress(dto.state());
        customerEntity.setState(dto.state());
        return customerEntity;
    }

    public CustomerResponseDto toResponseDto(CustomerEntity entity){
        return new CustomerResponseDto(
          entity.getId(),
          entity.getName(),
          entity.getEmail(),
          entity.getPhone(),
          entity.getAddress(),
          entity.getState()
        );
    }
}
