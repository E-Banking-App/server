package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.AgentDAO;
import com.ensa.ebanking.Models.AgentEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgentService {
    @Autowired
    private final AgentDAO agentDTO;
    public AgentService(AgentDAO agentDTO) {
        this.agentDTO = agentDTO;
    }
    public AgentEntity addAgent(AgentEntity agentEntity) { return agentDTO.save(agentEntity);}
}
