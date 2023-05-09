package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.BillEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BillDAO extends JpaRepository<BillEntity, Long> {
}
