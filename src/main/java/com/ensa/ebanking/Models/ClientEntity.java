package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Role;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.time.LocalDateTime;

//@Entity
//@Table(name = "client")
////lombok
//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//public class ClientEntity implements Serializable {
//    @Id
////    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @GeneratedValue(strategy = GenerationType.TABLE)
//    private Integer id;
////    @Column(unique = true,nullable = false)
////    private String phoneNumber;
////    private String password;
//    private String firstName;
//    private String lastName;
//    private String email;
//    private Boolean isFirstLogin = true;
//    @Enumerated(EnumType.STRING)
//    private Role role = Role.CLIENT;
//
//    //private Integer createdBy;
//    /////////////// GFK ////////////////
//    /////////////// /// ////////////////
//    @ManyToOne
//    @JoinColumn(name = "createdby")
//    private UserEntity createdBy;
//    /////////////// /// ////////////////
//    /////////////// /// ////////////////
//
//    //private Integer accountid;
//    /////////////// Relation ////////////////
//    @OneToOne
//    @JoinColumn(name = "accountid")
//    private ClientBankAccountEntity clientbankaccount;
//    /////////////// //////// ////////////////
//    @Column(nullable = false)
//    private LocalDateTime updatedAt = LocalDateTime.now();
//    @Column(nullable = false)
//    private LocalDateTime createdAt = LocalDateTime.now();
//}
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "client")
@Entity
public class ClientEntity extends UserEntity {
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isFirstLogin = true;
    @Enumerated(EnumType.STRING)
    private Role role = Role.CLIENT;

    /////////////// GFK ////////////////
    /////////////// /// ////////////////
    @ManyToOne
    @JoinColumn(name = "createdBy")
    private UserEntity createdBy;
    /////////////// /// ////////////////
    /////////////// /// ////////////////

    /////////////// Relation ////////////////
    @OneToOne
    @JoinColumn(name = "accountId")
    private ClientBankAccountEntity clientBankAccount;

    private boolean FirstLogin= true  ;

    public ClientEntity(String username, String password, String firstName, String lastName, String email, UserEntity createdBy, ClientBankAccountEntity clientBankAccount) {
        super(username, password);
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.createdBy = createdBy;
        this.clientBankAccount = clientBankAccount;
    }

}