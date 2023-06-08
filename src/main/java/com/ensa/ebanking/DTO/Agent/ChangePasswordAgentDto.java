package com.ensa.ebanking.DTO.Agent;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ChangePasswordAgentDto {
    private Long id;
    private String newPassword;
    private String confirmation;

}
