package com.ensa.ebanking.DTO.Agent;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentResponseDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String cin;
    private String cinLink;
    private String location;
    private Boolean isFirstLogin;
    private LocalDate birthDate;
    private String phoneNumber;
    private String irc;
    private String ice;
    private String username;
    private String password;
}
