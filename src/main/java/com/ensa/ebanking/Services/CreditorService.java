package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.CreditorDAO;
import com.ensa.ebanking.Models.CreditorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreditorService {
    @Autowired
    private final CreditorDAO creditorDAO;
    public CreditorService(CreditorDAO creditorDAO) {
        this.creditorDAO = creditorDAO;
    }

    public CreditorEntity createCreditor(CreditorEntity creditorEntity) { return creditorDAO.save(creditorEntity);}

    public CreditorEntity findByName(String name ){
        return creditorDAO.findByName(name);

    }

    public CreditorEntity save(CreditorEntity creancier) {
        return creditorDAO.save(creancier);

    }
}
