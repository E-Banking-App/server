package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.FormEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormDAO extends JpaRepository<FormEntity, Long> {
}
