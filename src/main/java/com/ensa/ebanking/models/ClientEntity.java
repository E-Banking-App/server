package com.ensa.ebanking.models;

import com.ensa.ebanking.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "client")
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClientEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(unique = true,nullable = false)
    private String phoneNumber;
    private String password;
    private String firstName;
    private String lastName;
    private String email;
    private Boolean isFirstLogin = true;
    @Enumerated(EnumType.STRING)
    private Role role = Role.CLIENT;
    private Integer createdBy;

    private Integer accountId;
    //@OneToMany(mappedBy = "client_bank_account", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    //@JoinColumn(name="client_id")
    //private List<ClientBankAccountEntity> accountId;


    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();
    @Column(nullable = false)
    private LocalDateTime createdAt = LocalDateTime.now();
}
