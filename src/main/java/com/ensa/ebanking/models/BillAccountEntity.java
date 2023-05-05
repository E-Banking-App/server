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
@Table(name = "billaccount")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillAccountEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String code;
    private String name;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="creanceid")
    private CreanceEntity creance;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="creditorid")
    private CreditorEntity creditor;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "billaccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BillEntity> bill;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "billaccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BillPenaltyEntity> billpenalty;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "billaccount", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SmsEntity> sms;
    /////////////////////////////////////////
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
