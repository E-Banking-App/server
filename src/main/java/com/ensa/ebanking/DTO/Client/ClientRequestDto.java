package com.ensa.ebanking.DTO.Client;

import com.ensa.ebanking.Enums.Role;
import com.ensa.ebanking.Models.UserEntity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientRequestDto {
    private String firstName;
    private String lastName;
    private String email;
    private String username;
    private String password;
}
