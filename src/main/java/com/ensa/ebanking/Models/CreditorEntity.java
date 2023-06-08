package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Category;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "creditor")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreditorEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="campanyid")
    private CompanyEntity company;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "creditor", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<CreanceEntity> creance;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "creditor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<BillAccountEntity> billaccount;
    /////////////////////////////////////////

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public CreditorEntity(String code, String name, Category category, CompanyEntity company) {
        this.code = code;
        this.name = name;
        this.category = category;
        this.company = company;
    }
}
