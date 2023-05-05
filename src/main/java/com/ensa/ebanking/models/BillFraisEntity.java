package com.ensa.ebanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "billfrais")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillFraisEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Float amount;

    //private Integer billId;
    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="billid")
    private BillEntity bill;
    /////////////////////////////////////////
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}