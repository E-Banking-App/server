package com.ensa.ebanking.Models;

public class EmailMessage {
    private String to;
    private String subject;
    private String message;

    public EmailMessage() {
    }

    public EmailMessage(String to,String subject,String message){
        this.setTo(to);
        this.setSubject(subject);
        this.setMessage(message);
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
