package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.ClientBankAccountDAO;
import com.ensa.ebanking.Models.ClientBankAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClientBankAccountService {
    @Autowired
    private final ClientBankAccountDAO clientBankAccountDAO;
    public ClientBankAccountService(ClientBankAccountDAO clientBankAccountDAO) {
        this.clientBankAccountDAO = clientBankAccountDAO;
    }
    public ClientBankAccountEntity createClientBankAccount(ClientBankAccountEntity clientBankAccountEntity) { return clientBankAccountDAO.save(clientBankAccountEntity);}
}
