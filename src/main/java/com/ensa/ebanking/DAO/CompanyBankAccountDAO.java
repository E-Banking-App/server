package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.CompanyBankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyBankAccountDAO extends JpaRepository<CompanyBankAccountEntity, Long> {
}
