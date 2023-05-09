package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.CompanyBankAccountDAO;
import com.ensa.ebanking.Models.CompanyBankAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CompanyBankAccountService {
    @Autowired
    private final CompanyBankAccountDAO companyBankAccountDAO;
    public CompanyBankAccountService(CompanyBankAccountDAO companyBankAccountDAO) {
        this.companyBankAccountDAO = companyBankAccountDAO;
    }
    public CompanyBankAccountEntity addCompanyBankAccount(CompanyBankAccountEntity companyBankAccountEntity) { return companyBankAccountDAO.save(companyBankAccountEntity);}
}