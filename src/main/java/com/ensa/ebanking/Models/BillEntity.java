package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "bill")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)

    //numero de facture
    private String code;

    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private float amount;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="billaccountid")
    private BillAccountEntity billaccount;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "bill", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BillFraisEntity> billfrais;
    /////////////////////////////////////////
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();


    // added

    private String Creancier ;

    private String Creance ;
    // new added : au cas ou paiement par reference
    @ManyToOne
    @JoinColumn(name="reference")
    private UserBill userBill ;

    private int mois ;


}
