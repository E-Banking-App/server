package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AdminController {
    @Autowired
    private final UserService adminService;
    public AdminController(UserService adminService) {
        this.adminService = adminService;
    }
    @PostMapping("/admin")
    public void addAdmin(@RequestBody AdminEntity admin){
        adminService.createAdmin(admin);
    }
    @GetMapping("/admin")
    public ResponseEntity<List<AdminEntity>> getAdmins(){
        return new ResponseEntity<>(adminService.getAdmins(), HttpStatus.OK);
    }
    @DeleteMapping("/admin/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
