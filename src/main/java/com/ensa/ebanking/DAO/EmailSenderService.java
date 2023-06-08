package com.ensa.ebanking.DAO;

public interface EmailSenderService {
    void sendEmail(String to,String subject,String message);
}
