package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.CreanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreanceDAO extends JpaRepository<CreanceEntity, Long> {
}
