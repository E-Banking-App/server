package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.VirementDAO;
import com.ensa.ebanking.Models.VirementEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VirementService {
    @Autowired
    private final VirementDAO virementDAO;
    public VirementService(VirementDAO virementDAO) {
        this.virementDAO = virementDAO;
    }
    public VirementEntity addVirement(VirementEntity virementEntity) { return virementDAO.save(virementEntity);}
}
