package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.UserBillDAO;
import com.ensa.ebanking.Models.UserBill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserBillService {

    private final UserBillDAO userBillDAO;

    @Autowired
    public UserBillService(UserBillDAO userBillDAO) {
        this.userBillDAO = userBillDAO;
    }



    public UserBill findById(String referenceId) {
        Optional<UserBill> userBillOptional = userBillDAO.findById(referenceId);
        return userBillOptional.orElse(null);
    }
}
