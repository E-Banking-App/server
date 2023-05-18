package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.BillAccountDAO;
import com.ensa.ebanking.Models.BillAccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillAccountService {
    @Autowired
    private final BillAccountDAO billAccountDAO;
    public BillAccountService(BillAccountDAO billAccountDAO) {
        this.billAccountDAO = billAccountDAO;
    }
    public BillAccountEntity createBillAccount(BillAccountEntity billAccountEntity) { return billAccountDAO.save(billAccountEntity);}
}
