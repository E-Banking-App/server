package com.ensa.ebanking.DTO.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequestDto {
    private String email;
    private String password;
    private String creancier;
    private String creance;
    private double amount;
    private String referenceOrFactureNumber;
}