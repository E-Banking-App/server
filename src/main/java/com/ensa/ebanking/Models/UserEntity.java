package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "user")
//@Inheritance(strategy = InheritanceType.JOINED)
////@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
////@DiscriminatorColumn(name = "user_type")
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
////@MappedSuperclass
//public class UserEntity {
//
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer id;
//
//    @Column(name = "username", unique = true, nullable = false)
//    private String username;
//
//    @Column(name = "password", nullable = false)
//    private String password;
//
//    @Enumerated(EnumType.STRING)
//    private Role role;
//
//    @OneToOne(mappedBy = "user")
//    private ProfileEntity profile;
//
////    @OneToOne
////    private AgentEntity agent;
////
////    @OneToOne
////    private AdminEntity admin;
////
////    @OneToOne
////    private ClientEntity client;
//
//}

@Table(name = "user")
@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public abstract class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true, nullable = false)
    private String username;
    @Column(nullable = false)
    private String password;
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    public UserEntity(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public UserEntity() {

    }
}