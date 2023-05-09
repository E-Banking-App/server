package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.ClientDAO;
import com.ensa.ebanking.Models.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {
    @Autowired
    private final ClientDAO clientDAO;
    public ClientService(ClientDAO clientDAO) {
        this.clientDAO = clientDAO;
    }
    public ClientEntity addClient(ClientEntity clientEntity) { return clientDAO.save(clientEntity);}
}