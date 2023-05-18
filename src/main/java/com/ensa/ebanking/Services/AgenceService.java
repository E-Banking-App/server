package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.AgenceDAO;
import com.ensa.ebanking.Models.AgenceEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgenceService {
    @Autowired
    private final AgenceDAO agenceDTO;
    public AgenceService(AgenceDAO agenceDTO) {
        this.agenceDTO = agenceDTO;
    }
    public AgenceEntity createAgence(AgenceEntity agenceEntity) { return agenceDTO.save(agenceEntity);}
}
