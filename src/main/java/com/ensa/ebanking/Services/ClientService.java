package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.ClientDAO;
import com.ensa.ebanking.Models.ClientEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientService {

    @Autowired
    ClientDAO clientDAO;

    public ClientEntity saveClient(ClientEntity client) {
        return clientDAO.save(client);
    }

    public ClientEntity findByEmail(String email) {
        return clientDAO.findByEmail(email);
    }
}
