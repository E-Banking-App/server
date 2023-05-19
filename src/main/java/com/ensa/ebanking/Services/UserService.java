package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.AdminDAO;
import com.ensa.ebanking.DAO.AgentDAO;
import com.ensa.ebanking.DAO.ClientDAO;
import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Models.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private final ClientDAO clientDTO;

    @Autowired
    private final AdminDAO adminDTO;

    @Autowired
    private final AgentDAO agentDTO;

    public UserService(ClientDAO clientDTO, AdminDAO adminDTO, AgentDAO agentDTO) {
        this.clientDTO = clientDTO;
        this.adminDTO = adminDTO;
        this.agentDTO = agentDTO;
    }

    public ClientEntity createClient(ClientEntity client) {
        return clientDTO.save(client);
    }

    public AdminEntity createAdmin(AdminEntity admin) {
        return adminDTO.save(admin);
    }
    public void deleteAdmin(Long id) {
        adminDTO.deleteById(id);
    }
    public List<AdminEntity> getAdmins() {
        List<AdminEntity> admins = adminDTO.findAll();
        return admins;
    }
    public AgentEntity createAgent(AgentEntity agent) {
        return agentDTO.save(agent);
    }
}