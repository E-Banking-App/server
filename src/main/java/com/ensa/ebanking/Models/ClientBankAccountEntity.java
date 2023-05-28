package com.ensa.ebanking.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "clientbankaccount")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientBankAccountEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer numero;
    @Column(nullable = false)
    private String ceiling;

    @Column(nullable = true)
    private Double solde;
    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "clientBankAccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VirementEntity> virement;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToOne(mappedBy = "clientBankAccount", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private ClientEntity client;
    /////////////// //////// ////////////////

    @Column(nullable = false)
    //@CreationTimestamp
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public ClientBankAccountEntity(Integer numero, String ceiling) {
        this.numero = numero;
        this.ceiling = ceiling;
    }
}
