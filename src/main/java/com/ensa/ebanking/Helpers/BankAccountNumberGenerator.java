package com.ensa.ebanking.Helpers;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.SecureRandom;

public class BankAccountNumberGenerator {
    private static final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static Integer generateRandomBankAccountNumber() {
        SecureRandom secureRandom = new SecureRandom();
        String number = "";

        for (int i = 0; i < 10; i++) {
            int randomIndex = secureRandom.nextInt(VALID_CHARACTERS.length());
            char randomChar = VALID_CHARACTERS.charAt(randomIndex);
            number += randomChar;
        }

        return Integer.parseInt(number);
    }

}
