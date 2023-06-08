package com.ensa.ebanking.DTO.creditor;

import com.ensa.ebanking.Enums.Category;
import com.ensa.ebanking.Models.BillAccountEntity;
import com.ensa.ebanking.Models.CompanyEntity;
import com.ensa.ebanking.Models.CreanceEntity;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CreditorRequestDto {
    private Long id;
    private String code;
    private String name;
    @Enumerated(EnumType.STRING)
    private Category category;
//    private CompanyEntity company;
//    private List<CreanceEntity> creance;
//    private List<BillAccountEntity> billaccount;

}
