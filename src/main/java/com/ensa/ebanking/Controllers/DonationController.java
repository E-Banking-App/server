package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.DTO.Client.MobileDonationRequestDto;
import com.ensa.ebanking.DTO.Client.PaymentRequestDto;
import com.ensa.ebanking.Enums.Status;
import com.ensa.ebanking.Models.BillEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Models.CreditorEntity;
import com.ensa.ebanking.Services.BillService;
import com.ensa.ebanking.Services.ClientService;
import com.ensa.ebanking.Services.CreditorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("donation")
public class DonationController {

    @Autowired
    private ClientService clientService;



    @Autowired
    private CreditorService creditorService;
    @PostMapping("/mobile")
    public ResponseEntity<String> performPayment(@RequestBody MobileDonationRequestDto paymentRequest) {
        try {
            // Get the client based on the provided email
            ClientEntity client = clientService.findByEmail(paymentRequest.getEmail());

            if (client == null) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect ou client introuvable.");
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






            CreditorEntity creancier  = creditorService.findByName(paymentRequest.getCreancier());
            double soldeCreancier = (creancier.getCompany().getCompanyBankAccount().getSolde())+(paymentRequest.getAmount());
            creancier.getCompany().getCompanyBankAccount().setSolde(soldeCreancier);
            creditorService.save(creancier);

            return ResponseEntity.ok("Donation effectué avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors de la donation");
        }
    }

}
