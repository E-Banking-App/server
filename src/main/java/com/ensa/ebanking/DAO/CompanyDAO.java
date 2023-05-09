package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.CompanyEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyDAO extends JpaRepository<CompanyEntity, Long> {
}
