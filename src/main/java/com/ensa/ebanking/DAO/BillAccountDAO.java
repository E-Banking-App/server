package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.BillAccountEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillAccountDAO extends JpaRepository<BillAccountEntity, Long> {
}
