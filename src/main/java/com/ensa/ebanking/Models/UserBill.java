package com.ensa.ebanking.Models;

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