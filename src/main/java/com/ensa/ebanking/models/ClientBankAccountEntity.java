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
@Table(name = "clientbankaccount")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientBankAccountEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer numero;
    @Column(nullable = false)
    private String ceiling;
    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "clientbankaccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<VirementEntity> virement;
    /////////////////////////////////////////
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
