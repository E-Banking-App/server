package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.DTO.creditor.CreditorResponseDto;
import com.ensa.ebanking.Enums.Category;
import com.ensa.ebanking.Models.CreanceEntity;
import com.ensa.ebanking.Models.CreditorEntity;
import com.ensa.ebanking.Services.CreditorService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("creditor")
@CrossOrigin
@AllArgsConstructor
public class CreditorController {
    private final CreditorService creditorService;
//    @GetMapping("")
//    public List<CreditorResponseDto> getClient(){
//        return creditorService.findAll();
//    }

    @GetMapping("")
    public ResponseEntity<List<CreditorEntity>> getClientb(){
        return ResponseEntity.ok(creditorService.findAllB());
    }

    @GetMapping("/facture")
    public ResponseEntity<List<CreditorEntity>> findByCategoryFacture(Category category){
        return ResponseEntity.ok(creditorService.findByCategory(Category.FACTURE));
    }
    @GetMapping("/donation")
    public ResponseEntity<List<CreditorEntity>> findByCategoryDonation(Category category){
        return ResponseEntity.ok(creditorService.findByCategory(Category.DONATION));
    }
    @GetMapping("/recharge")
    public ResponseEntity<List<CreditorEntity>> findByCategoryRecharge(Category category){
        return ResponseEntity.ok(creditorService.findByCategory(Category.RECHARGE));
    }

}
