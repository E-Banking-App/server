package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.FormFieldDAO;
import com.ensa.ebanking.Models.FormFieldEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FormFieldService {
    @Autowired
    private final FormFieldDAO formFieldDTO;
    public FormFieldService(FormFieldDAO formFieldDTO) {
        this.formFieldDTO = formFieldDTO;
    }
    public FormFieldEntity createFormField(FormFieldEntity formFieldEntity) { return formFieldDTO.save(formFieldEntity);}
}
