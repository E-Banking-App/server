package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.FormDAO;
import com.ensa.ebanking.Models.FormEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormService {
    @Autowired
    private final FormDAO formDAO;
    public FormService(FormDAO formDAO) {
        this.formDAO = formDAO;
    }
    public FormEntity createForm(FormEntity formEntity) { return formDAO.save(formEntity);}
}
