package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.FormFieldEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FormFieldDAO extends JpaRepository<FormFieldEntity, Long> {
}
