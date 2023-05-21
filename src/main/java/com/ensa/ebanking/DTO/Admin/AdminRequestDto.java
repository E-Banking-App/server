package com.ensa.ebanking.DTO.Admin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequestDto {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String username;
    private String password;
}
