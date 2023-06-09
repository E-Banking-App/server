package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Enums.Status;
import com.ensa.ebanking.Models.BillEntity;
import com.ensa.ebanking.Models.UserBill;
import com.ensa.ebanking.Services.BillService;
import com.ensa.ebanking.Services.UserBillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("modepaiement")
public class BillController {

    private final BillService billService;

    private final UserBillService userBillService;

    @Autowired
    public BillController(BillService billService, UserBillService userBillService ) {
        this.billService = billService;
        this.userBillService=userBillService;
    }

    @GetMapping("/facturesimpayees")
    public ResponseEntity<List<Map<String, Object>>> getUnpaidInvoices(
            @RequestParam("creancier") String creancier,
            @RequestParam("creance") String creance,
            @RequestParam("referenceId") String referenceId
    ) {
        try {
            UserBill userBill = userBillService.findById(referenceId);

            if (userBill == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
            }

            List<BillEntity> unpaidBills = billService.findByCreancierAndCreanceAndUserBillAndStatus(
                    creancier, creance, userBill, Status.PENDING);

            List<Map<String, Object>> unpaidInvoices = new ArrayList<>();

            for (BillEntity bill : unpaidBills) {
                Map<String, Object> invoice = new HashMap<>();
                invoice.put("numero", bill.getCode());
                invoice.put("mois", bill.getName());
                invoice.put("montant", bill.getAmount());
                unpaidInvoices.add(invoice);
            }

            return ResponseEntity.ok(unpaidInvoices);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/montantfacture")
    public ResponseEntity<Double> getBillAmount(
            @RequestParam("creancier") String creancier,
            @RequestParam("creance") String creance,
            @RequestParam("factureNumber") String factureNumber) {
        try {
            Double billAmount;

            if (creancier.equals("Lydec")) {
                billAmount = 150.0;
            } else {
                billAmount = (double) billService.getBillAmount(creancier, creance, factureNumber);
            }

            return ResponseEntity.ok(billAmount);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

}