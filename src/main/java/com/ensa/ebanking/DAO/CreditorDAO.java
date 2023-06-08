package com.ensa.ebanking.DAO;

import com.ensa.ebanking.DTO.creditor.CreditorResponseDto;
import com.ensa.ebanking.Enums.Category;
import com.ensa.ebanking.Models.CreditorEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CreditorDAO extends JpaRepository<CreditorEntity, Long> {
    //public List<CreditorResponseDto> findll
    List<CreditorEntity> findByCategory(Category category);
}
