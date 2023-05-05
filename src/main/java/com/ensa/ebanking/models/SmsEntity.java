package com.ensa.ebanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "sms")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SmsEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String message;
    private String phoneNumber;
    private String otp;
    private Date otpExpiration;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="billaccountid")
    private BillAccountEntity billaccount;
    /////////////////////////////////////////
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
