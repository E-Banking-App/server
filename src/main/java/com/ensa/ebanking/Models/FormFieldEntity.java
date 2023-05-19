package com.ensa.ebanking.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "formfield")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class FormFieldEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String placeholder;
    private String type;
    @ManyToOne
    @JoinColumn(name="formId")
    private FormEntity form;
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public FormFieldEntity(String name, String placeholder, String type, FormEntity form) {
        this.name = name;
        this.placeholder = placeholder;
        this.type = type;
        this.form = form;
    }
}