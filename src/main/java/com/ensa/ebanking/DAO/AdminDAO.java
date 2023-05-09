package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.AdminEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDAO extends JpaRepository<AdminEntity, Long> {

}
