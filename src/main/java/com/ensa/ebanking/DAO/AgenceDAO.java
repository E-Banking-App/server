package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.AgenceEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgenceDAO extends JpaRepository<AgenceEntity, Long> {
}
