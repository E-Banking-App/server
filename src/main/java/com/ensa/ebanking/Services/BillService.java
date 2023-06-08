package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.BillDAO;
import com.ensa.ebanking.DAO.UserBillDAO;
import com.ensa.ebanking.Enums.Status;
import com.ensa.ebanking.Models.BillEntity;
import com.ensa.ebanking.Models.UserBill;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BillService {
    @Autowired
    private final BillDAO billDAO;
    private final UserBillDAO userBillDAO;

    @Autowired
    public BillService(BillDAO billDAO, UserBillDAO userBillDAO) {
        this.billDAO = billDAO;
        this.userBillDAO = userBillDAO;
    }

    public BillEntity findByCreancierAndCreanceAndCode(String creancier, String creance, String code) {
        return billDAO.findByCreancierAndCreanceAndCode(creancier, creance, code);
    }

    public float getBillAmount(String creancier, String creance, String factureNumber) {
        BillEntity bill = findByCreancierAndCreanceAndCode(creancier, creance, factureNumber);
        if (bill != null) {
            return bill.getAmount();
        }
        return -1.0f;
    }




    public List<BillEntity> findByCreancierAndCreanceAndUserBillAndStatus(
            String creancier, String creance, UserBill userBill, Status status) {
        return billDAO.findByCreancierAndCreanceAndUserBillAndStatus(creancier, creance, userBill, status);
    }

    public BillEntity findByCode(String factureNumber) {
        return billDAO.findByCode(factureNumber);
    }

    public BillEntity saveBill(BillEntity bill) {
        return billDAO.save(bill);
    }

}