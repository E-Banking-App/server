package com.ensa.ebanking.Auth;

import java.security.SecureRandom;

public class PasswordGenerator {

    private static final String VALID_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    public static String generateRandomPassword() {
        SecureRandom secureRandom = new SecureRandom();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            int randomIndex = secureRandom.nextInt(VALID_CHARACTERS.length());
            char randomChar = VALID_CHARACTERS.charAt(randomIndex);
            sb.append(randomChar);
        }

        return sb.toString();
    }

}