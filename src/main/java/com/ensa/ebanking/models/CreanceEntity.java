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
    //private Integer creditorid;
    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="creditorid")
    private CreditorEntity creditor;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "creance", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name="creanceid")
    private List<BillAccountEntity> billaccount;
    /////////////////////////////////////////
    private Integer formId;
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
