package com.ensa.ebanking.DAO;

import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Models.UserBill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserBillDAO extends JpaRepository<UserBill, String> {
    Optional<UserBill> findById(String referenceId);

}
