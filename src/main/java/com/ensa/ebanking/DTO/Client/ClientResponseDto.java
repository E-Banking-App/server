package com.ensa.ebanking.DTO.Client;

import com.ensa.ebanking.Enums.Role;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ClientResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isFirstLogin;
    private String username;
    private String password;
    private Role role;
}
