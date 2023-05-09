package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "billpenalty")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class BillPenaltyEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Float amount;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="billaccountid")
    private BillAccountEntity billaccount;
    /////////////////////////////////////////

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
