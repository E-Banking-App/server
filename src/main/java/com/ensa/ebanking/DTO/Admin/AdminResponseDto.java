package com.ensa.ebanking.DTO.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
}
