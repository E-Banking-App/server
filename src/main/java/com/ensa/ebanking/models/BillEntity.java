package com.ensa.ebanking.models;

import com.ensa.ebanking.enums.Status;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
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
    private Integer id;
    @Column(unique = true)
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private Status status;
    private Float amount;

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
}
