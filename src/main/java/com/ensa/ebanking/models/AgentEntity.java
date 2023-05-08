package com.ensa.ebanking.models;

import com.ensa.ebanking.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "agent")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AgentEntity implements Serializable {
    @Id()
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(nullable = false, unique = true)
    private String email;
    private String password;
    private String firstName;
    private String lastName;
    private String cin;
    private String cinLink;
    private String location;
    private Date birthDate;
    private String phoneNumber;
    private String irc;
    private String ice;
    private Boolean isFirstLogin=true;
    @Enumerated(EnumType.STRING)
    private Role role = Role.AGENT;
    private Integer createdBy;
    private Integer agenceId;
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
