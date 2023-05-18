package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.BillDAO;
import com.ensa.ebanking.Models.BillEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {
    @Autowired
    private final BillDAO billDAO;

    public BillService(BillDAO billDAO) {
        this.billDAO = billDAO;
    }

    public BillEntity createBill(BillEntity billEntity) { return billDAO.save(billEntity);}
}