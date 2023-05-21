package com.ensa.ebanking.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "form")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "form", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<FormFieldEntity> formFields;
    /////////////// Relation ////////////////
    @OneToOne(mappedBy = "form", cascade = CascadeType.ALL,fetch = FetchType.LAZY )
    private CreanceEntity creance;
    /////////////// //////// ////////////////

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public FormEntity(List<FormFieldEntity> formFields) {
        this.formFields = formFields;
    }
}
