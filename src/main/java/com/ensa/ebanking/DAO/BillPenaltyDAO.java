package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.BillPenaltyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillPenaltyDAO extends JpaRepository<BillPenaltyEntity, Long> {
}
