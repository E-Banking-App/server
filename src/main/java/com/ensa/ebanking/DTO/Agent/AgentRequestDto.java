package com.ensa.ebanking.DTO.Agent;

import lombok.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class AgentRequestDto {
    private String firstName;
    private String lastName;
    private String cin;
    private String cinLink;
    private String location;
    private LocalDate birthDate;
    private String phoneNumber;
    private String irc;
    private String ice;
    private String username;
    private String password;
}
