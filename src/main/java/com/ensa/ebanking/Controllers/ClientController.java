package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Auth.PasswordGenerator;
import com.ensa.ebanking.DTO.Client.ChangePasswordRequestDto;
import com.ensa.ebanking.DTO.Client.ClientRequestDto;
import com.ensa.ebanking.DTO.Client.ClientResponseDto;
import com.ensa.ebanking.Helpers.BankAccountNumberGenerator;
import com.ensa.ebanking.Models.ClientBankAccountEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Models.UserEntity;
import com.ensa.ebanking.Services.ClientService;
import com.ensa.ebanking.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("client")
@CrossOrigin
@AllArgsConstructor
public class ClientController {
    private UserService clientService;

    @Autowired
    private ClientService service ;

    @GetMapping("")
    public List<ClientResponseDto> getClient(){
        return clientService.findAllClient();
    }

    @PostMapping("")
    public ClientResponseDto saveClient(@RequestBody ClientRequestDto clientRequestDto){
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generateRandomPassword();
        BankAccountNumberGenerator bankAccountNumberGenerator = new BankAccountNumberGenerator();
        Integer number = bankAccountNumberGenerator.generateRandomBankAccountNumber();
        ClientBankAccountEntity clientBankAccount = new ClientBankAccountEntity(number, clientRequestDto.getCeiling());
        clientRequestDto.setPassword(password);
        UserEntity loggedInUser = (UserEntity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        System.out.println("loogedInUser"+ loggedInUser);

//        ClientEntity client = new ClientEntity(clientRequestDto.getUsername(),clientRequestDto.getPassword(), clientRequestDto.getFirstName(), clientRequestDto.getLastName(), clientRequestDto.getEmail(), clientBankAccount);
//        return clientService.saveClient(client);
        return clientService.saveClient(clientRequestDto);
    }
    @PostMapping("/ChangePassword")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequestDto requestDto) {
        try {
            // Get the client based on the phone number
            ClientEntity client = service.findByEmail(requestDto.getEmail());

            if (client == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client introuvable.");
            }

            // Verify the current password
            if (!client.getPassword().equals(requestDto.getCurrentPassword())) {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe actuel incorrect.");
            }

            // Update the password
            client.setPassword(requestDto.getNewPassword());
            client.setFirstLogin(false); // Assuming you want to mark the client as not first login after password change
            service.saveClient(client);

            return ResponseEntity.ok("Mot de passe changé avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors du changement de mot de passe.");
        }
}}
