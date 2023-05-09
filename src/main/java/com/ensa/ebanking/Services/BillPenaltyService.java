package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.BillPenaltyDAO;
import com.ensa.ebanking.Models.BillPenaltyEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillPenaltyService {
    @Autowired
    private final BillPenaltyDAO billPenaltyDAO;
    public BillPenaltyService(BillPenaltyDAO billPenaltyDAO) {
        this.billPenaltyDAO = billPenaltyDAO;
    }
    public BillPenaltyEntity addBillPenalty(BillPenaltyEntity billPenaltyEntity) { return billPenaltyDAO.save(billPenaltyEntity);}
}
