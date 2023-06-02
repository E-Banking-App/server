package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Enums.Status;
import com.ensa.ebanking.Models.BillEntity;
import com.ensa.ebanking.Models.UserBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BillDAO extends JpaRepository<BillEntity, Long> {
    List<BillEntity> findByCreancierAndCreanceAndUserBillAndStatus(String creancier, String creance, UserBill userBill, Status status);

    BillEntity findByCreancierAndCreanceAndCode(String creancier, String creance, String billCode);

    BillEntity findByCode(String  factureNumber);

    BillEntity save(BillEntity bill);


}