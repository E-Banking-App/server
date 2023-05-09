package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.ClientEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientDAO extends JpaRepository<ClientEntity, Long> {
}
