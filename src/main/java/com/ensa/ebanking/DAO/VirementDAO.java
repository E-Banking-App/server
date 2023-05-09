package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.VirementEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VirementDAO extends JpaRepository<VirementEntity, Long> {
}
