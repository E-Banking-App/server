package com.ensa.ebanking.Models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "agence")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgenceEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String name;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="createdby")
    private AdminEntity admin;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "agence", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AgentEntity> agent;
    /////////////////////////////////////////

    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public AgenceEntity(String name, AdminEntity admin) {
        this.name = name;
        this.admin = admin;
    }
}
