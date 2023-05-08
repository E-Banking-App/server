package com.ensa.ebanking.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Entity
@Table(name = "form")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String types;
    private String names;
    private String placeholders;

    /////////////// Relation ////////////////
    @OneToOne(mappedBy = "form", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private CreanceEntity creance;
    /////////////// //////// ////////////////

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
