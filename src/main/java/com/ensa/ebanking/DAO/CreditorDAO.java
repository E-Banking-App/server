package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.CreditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CreditorDAO extends JpaRepository<CreditorEntity, Long> {


    CreditorEntity findByName(String name);
}
