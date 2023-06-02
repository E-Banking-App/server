package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.DTO.Client.PaymentRequestDto;
import com.ensa.ebanking.Enums.Status;
import com.ensa.ebanking.Models.BillEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Services.BillService;
import com.ensa.ebanking.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PaymentController {

    @Autowired
    private ClientService clientService;

    @Autowired
    private BillService billService;

    @PostMapping("/paiementfacture")
    public ResponseEntity<String> performPayment(@RequestBody PaymentRequestDto paymentRequest) {
        try {
            // Get the client based on the provided email
            ClientEntity client = clientService.findByEmail(paymentRequest.getEmail());

            if (client == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect ou client introuvable.");
            }

            // Verify the client's password
            if (!client.getPassword().equals(paymentRequest.getPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect.");
            }

            // Check if the client's balance is sufficient
            if (client.getClientBankAccount().getSolde() < paymentRequest.getAmount()) {
                return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Solde insuffisant pour effectuer le paiement.");
            }

            // Perform the payment logic here

            // Deduct the amount from the client's balance
            double newBalance = client.getClientBankAccount().getSolde() - paymentRequest.getAmount();
            client.getClientBankAccount().setSolde(newBalance);

            // Save the updated client information
            clientService.saveClient(client);

            String  factureNumber = paymentRequest.getReferenceOrFactureNumber();
            BillEntity bill = billService.findByCode(factureNumber);
            bill.setStatus(Status.valueOf("PAID"));

            // Save the updated bill information
            billService.saveBill(bill);

            return ResponseEntity.ok("Paiement effectué avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors du paiement.");
        }
    }

}