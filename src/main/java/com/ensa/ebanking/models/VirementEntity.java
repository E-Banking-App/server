package com.ensa.ebanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "virement")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class VirementEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;

    //private Integer bankAccountId;
    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="bankAccountId")
    private CompanyBankAccountEntity companybankaccount;
    /////////////////////////////////////////

    //private Integer clientAccountId;
    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="clientAccountId")
    private ClientBankAccountEntity clientbankaccount;
    /////////////////////////////////////////

    private Float amountSent;
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
