package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.AgentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgentDAO extends JpaRepository<AgentEntity, Long>  {
}
