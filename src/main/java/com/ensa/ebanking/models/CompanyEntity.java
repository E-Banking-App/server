package com.ensa.ebanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "company")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CompanyEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String image;
    private String name;

    //private Integer accountid;
    /////////////// Relation ////////////////
    @OneToOne
    @JoinColumn(name = "accountid")
    private CompanyBankAccountEntity companybankaccount;
    /////////////// //////// ////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CreditorEntity> creditor;
    /////////////////////////////////////////

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
