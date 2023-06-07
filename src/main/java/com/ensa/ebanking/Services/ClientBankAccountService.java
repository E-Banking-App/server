package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.ClientBankAccountDAO;
import com.ensa.ebanking.Models.ClientBankAccountEntity;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClientBankAccountService {
    @Autowired
    private final ClientBankAccountDAO clientBankAccountDAO;

    public ClientBankAccountEntity createClientBankAccount(ClientBankAccountEntity clientBankAccountEntity) {
        return clientBankAccountDAO.save(clientBankAccountEntity);
    }
}
