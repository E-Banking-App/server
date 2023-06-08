package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Models.ClientBankAccountEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Services.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("recharge")
public class RechargeController {

    @Autowired
    private ClientService clientService;

    @PostMapping("/internetsim")
    public ResponseEntity<String> recharge(@RequestBody Map<String, Object> request) {
        String email = (String) request.get("email");
        String password = (String) request.get("password");
        double amount = (double) request.get("amount");

        // Vérifier le mot de passe du client
        boolean passwordVerified = clientService.verifyPassword(email, password);
        if (!passwordVerified) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe incorrect");
        }

        // Vérifier le solde du client
        ClientEntity client = clientService.findByEmail(email);
        ClientBankAccountEntity clientBankAccount = client.getClientBankAccount();
        double clientBalance = clientBankAccount.getSolde();
        if (clientBalance < amount) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Solde insuffisant");
        }

        double newClientBalance = clientBalance - amount ;
        client.getClientBankAccount().setSolde(newClientBalance);
        clientService.saveClient(client);

        // Effectuer la recharge du numero  !!!!!!!! a ajouter
        // ...

        return ResponseEntity.ok("Recharge réussie");
    }

}