package co.edu.arq.layered.app_demo_v1.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public record CustomerResponseDto(
     Long id,
     String name,
     String email,
     String phone,
     String address,
     String state
){}
