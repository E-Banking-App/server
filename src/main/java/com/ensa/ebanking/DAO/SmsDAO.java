package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.SmsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SmsDAO extends JpaRepository<SmsEntity, Long> {
}
