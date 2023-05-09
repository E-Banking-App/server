package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.AdminDAO;
import com.ensa.ebanking.Models.AdminEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminService {
    @Autowired
    private final AdminDAO adminDTO;
    public AdminService(AdminDAO adminDTO) {
        this.adminDTO = adminDTO;
    }
    public AdminEntity addAdmin(AdminEntity adminEntity) { return adminDTO.save(adminEntity);}
}
