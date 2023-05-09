package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.BillFraisDAO;
import com.ensa.ebanking.Models.BillFraisEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillFraisService {
    @Autowired
    private final BillFraisDAO billFraisDAO;
    public BillFraisService(BillFraisDAO billFraisDAO) {
        this.billFraisDAO = billFraisDAO;
    }
    public BillFraisEntity addBillFrais(BillFraisEntity billFraisEntity) { return billFraisDAO.save(billFraisEntity);}
}
