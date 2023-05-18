package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.CompanyDAO;
import com.ensa.ebanking.Models.CompanyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyService {
    @Autowired
    private final CompanyDAO companyDAO;
    public CompanyService(CompanyDAO companyDAO) {
        this.companyDAO = companyDAO;
    }
    public CompanyEntity createCompany(CompanyEntity companyEntity) { return companyDAO.save(companyEntity);}
}