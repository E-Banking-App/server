package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Enums.Category;
import com.ensa.ebanking.Models.CreanceEntity;
import com.ensa.ebanking.Models.CreditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreanceDAO extends JpaRepository<CreanceEntity, Long> {
     //findById(Long id);

}
