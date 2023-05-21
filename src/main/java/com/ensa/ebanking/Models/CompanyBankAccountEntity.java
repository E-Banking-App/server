package com.ensa.ebanking.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "companybankaccount")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyBankAccountEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "companyBankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VirementEntity> virement;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToOne(mappedBy = "companyBankAccount", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private CompanyEntity company;
    /////////////// //////// ////////////////

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public CompanyBankAccountEntity(Integer numero) {
        this.numero = numero;
    }
}
