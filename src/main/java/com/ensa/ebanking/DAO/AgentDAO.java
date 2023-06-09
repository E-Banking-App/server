package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AgentDAO extends JpaRepository<AgentEntity, Long>  {
    AgentEntity findByUsername(String username);

    Optional<AgentEntity> findById(Long id);

}
