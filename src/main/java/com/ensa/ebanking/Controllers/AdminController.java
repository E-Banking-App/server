package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Auth.PasswordGenerator;
import com.ensa.ebanking.DTO.Admin.AdminRequestDto;
import com.ensa.ebanking.DTO.Admin.AdminResponseDto;
import com.ensa.ebanking.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("admin")
@CrossOrigin
@AllArgsConstructor
public class AdminController {
    private final UserService adminService;
    @GetMapping("")
    public List<AdminResponseDto> getAdmin(){
        return adminService.findAllAdmin();
    }
    @PostMapping("")
    public AdminResponseDto saveAdmin(@RequestBody AdminRequestDto adminRequestDto){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generateRandomPassword();
        adminRequestDto.setPassword(password);
        return adminService.saveAdmin(adminRequestDto);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteAdmin(@PathVariable("id") Long id) {
        adminService.deleteAdmin(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
