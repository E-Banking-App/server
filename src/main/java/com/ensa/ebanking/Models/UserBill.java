package com.ensa.ebanking.Models;

import com.ensa.ebanking.Enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//lombok
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserBill {

    @Id()
    private String reference ;



}
