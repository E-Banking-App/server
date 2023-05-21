package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "agent")
////lombok
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@DiscriminatorValue("AGENT")
//public class AgentEntity extends UserEntity implements Serializable {
//    @Id()
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Integer id;
////    @Column(nullable = false, unique = true)
////    private String email;
////    private String password;
//    private String firstName;
//    private String lastName;
//    private String cin;
//    private String cinLink;
//    private String location;
//    private LocalDate birthDate;
//    private String phoneNumber;
//    private String irc;
//    private String ice;
//    private Boolean isFirstLogin=true;
//    @Enumerated(EnumType.STRING)
//    private Role role = Role.AGENT;
//
//    //private Integer createdby;
//    /////////////// Relation ////////////////
//    @ManyToOne
//    @JoinColumn(name="createdby")
//    private AdminEntity admin;
//    /////////////////////////////////////////
//
//    //private Integer agenceid;
//    /////////////// Relation ////////////////
//    @ManyToOne
//    @JoinColumn(name="agenceid")
//    private AgenceEntity agence;
//    /////////////////////////////////////////
//
//    @Column(nullable = false)
//    private LocalDateTime updatedAt = LocalDateTime.now();
//    @Column(nullable = false)
//    private LocalDateTime createdAt = LocalDateTime.now();
//
//    public AgentEntity( String firstName, String lastName, String cin, String cinLink, String location, LocalDate birthDate, String phoneNumber, String irc, String ice, AdminEntity admin, AgenceEntity agence) {
//        this.firstName = firstName;
//        this.lastName = lastName;
//        this.cin = cin;
//        this.cinLink = cinLink;
//        this.location = location;
//        this.birthDate = birthDate;
//        this.phoneNumber = phoneNumber;
//        this.irc = irc;
//        this.ice = ice;
//        this.admin = admin;
//        this.agence = agence;
//    }
//}

@Table(name = "agent")
@Entity
@Data
public class AgentEntity extends UserEntity {
    private String firstName;
    private String lastName;
    private String cin;
    private String cinLink;
    private String location;
    private LocalDate birthDate;
    private String phoneNumber;
    private String irc;
    private String ice;
    private Boolean isFirstLogin=true;
    @Enumerated(EnumType.STRING)
    private Role role = Role.AGENT;

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="createdby")
    private AdminEntity admin;
    /////////////////////////////////////////

    /////////////// Relation ////////////////
    @ManyToOne
    @JoinColumn(name="agenceid")
    private AgenceEntity agence;

    public AgentEntity(String username, String password, String firstName, String lastName, String cin, String cinLink, String location, LocalDate birthDate, String phoneNumber, String irc, String ice, AdminEntity admin, AgenceEntity agence) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.cin = cin;
        this.cinLink = cinLink;
        this.location = location;
        this.birthDate = birthDate;
        this.phoneNumber = phoneNumber;
        this.irc = irc;
        this.ice = ice;
        this.admin = admin;
        this.agence = agence;
    }

    public AgentEntity() {

    }
}
