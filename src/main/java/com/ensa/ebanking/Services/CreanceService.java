package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.CreanceDAO;
import com.ensa.ebanking.Models.CreanceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreanceService {
    @Autowired
    private final CreanceDAO creanceDAO;
    public CreanceService(CreanceDAO creanceDAO) {
        this.creanceDAO = creanceDAO;
    }
    public CreanceEntity createCreance(CreanceEntity creanceEntity) { return creanceDAO.save(creanceEntity);}


}
