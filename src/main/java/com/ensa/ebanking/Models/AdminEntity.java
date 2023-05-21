package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
//
//@Entity
//@Table(name = "admin")
////lombok
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
////@DiscriminatorValue("ADMIN")
//public class AdminEntity extends ProfileEntity  implements Serializable {
//    @Id()
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
////    @GeneratedValue(strategy = GenerationType.SEQUENCE)
//    private Integer id;
//    @Column(nullable = false)
//    private String email;
//    @Column(nullable = false)
//    private String password;
//    private String firstName;
//    private String lastName;
//    private String phoneNumber;
//    @Enumerated(EnumType.STRING)
//    private Role role = Role.ADMIN;
//
//    /////////////// Relation ////////////////
//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<AgenceEntity> agencies;
//    /////////////////////////////////////////
//
//    /////////////// Relation ////////////////
//    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
//    private List<AgentEntity> agents;
//    /////////////////////////////////////////
//
//
//    @Column(nullable = false)
//    private LocalDateTime updatedAt = LocalDateTime.now();
//    @Column(nullable = false)
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//}

@Table(name = "admin")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminEntity extends UserEntity {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    @Enumerated(EnumType.STRING)
    private Role role = Role.ADMIN;

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AgenceEntity> agencies;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @OneToMany(mappedBy = "admin", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<AgentEntity> agents;

    public AdminEntity(String username, String password, String firstName, String lastName, String phoneNumber) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }


}