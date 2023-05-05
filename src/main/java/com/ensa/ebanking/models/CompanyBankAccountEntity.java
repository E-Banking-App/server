package com.ensa.ebanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
    private Integer id;
    private String numero;
    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "companybankaccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name="bankAccountId")
    private List<VirementEntity> virement;
    /////////////////////////////////////////
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
