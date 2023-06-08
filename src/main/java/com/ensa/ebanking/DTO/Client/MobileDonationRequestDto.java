package com.ensa.ebanking.DTO.Client;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class MobileDonationRequestDto {

    private String email;

    private String creancier;

    private double amount;
}




