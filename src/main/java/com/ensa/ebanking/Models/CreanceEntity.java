package com.ensa.ebanking.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "creance")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CreanceEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true)
    private String code;
    private String name;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="creditorid")
    private CreditorEntity creditor;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "creance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BillAccountEntity> billaccount;
    /////////////////////////////////////////

    //private Integer formId;
    /////////////// Relation ////////////////
    @OneToOne
    @JoinColumn(name = "formId")
    private FormEntity form;
    /////////////// //////// ////////////////
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public CreanceEntity(String code, String name, CreditorEntity creditor, FormEntity form) {
        this.code = code;
        this.name = name;
        this.creditor = creditor;
        this.form = form;
    }
}
