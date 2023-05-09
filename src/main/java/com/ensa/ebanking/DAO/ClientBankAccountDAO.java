package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.ClientBankAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientBankAccountDAO extends JpaRepository<ClientBankAccountEntity, Long> {
}
