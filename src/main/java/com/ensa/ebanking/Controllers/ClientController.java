package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Auth.PasswordGenerator;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.DTO.Agent.ChangePasswordAgentDto;
import com.ensa.ebanking.DTO.Client.ClientRequestDto;
import com.ensa.ebanking.DTO.Client.ClientResponseDto;
import com.ensa.ebanking.DTO.Client.MobileChangePasswordRequestDto;
import com.ensa.ebanking.Models.ClientBankAccountEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Services.ClientBankAccountService;
import com.ensa.ebanking.Services.ClientService;
import com.ensa.ebanking.Services.UserService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Random;

@RestController
@RequestMapping("client")
@CrossOrigin("*")
@AllArgsConstructor
public class ClientController {
    private UserService clientService;
    private final ModelMapper modelMapper;
    private ClientBankAccountService clientBankAccountService;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    @Autowired
    private ClientService service ;

    @GetMapping("")
    public List<ClientResponseDto> getClient(){
        return clientService.findAllClient();
    }

    @PostMapping("")
    public ClientResponseDto saveClient(@RequestBody ClientRequestDto clientRequestDto){
        //generate the password
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generateRandomPassword();
        clientRequestDto.setPassword(password);

        //get the agent : create_id
        List<AgentResponseDto> agent = clientService.findByIdAgent(clientRequestDto.getCreatedBy_id());
        clientRequestDto.setCreatedBy_id(null);


        //Affect the Agent id to Client
        clientRequestDto.setCreatedBy(modelMapper.map(agent.get(0),ClientEntity.class));


        //create the Bank_Account
        Random random = new Random();
        ClientBankAccountEntity bank = new ClientBankAccountEntity(random.nextInt(99999) , clientRequestDto.getCeiling(), 500.0);
        ClientBankAccountEntity banka= clientBankAccountService.createClientBankAccount(bank);
        //affect the bank account to the client
        clientRequestDto.setClientBankAccount(clientBankAccountService.findById(banka.getId()).get());

        return clientService.saveClient(clientRequestDto);
    }


    @PostMapping("/ChangePassword")
    public ResponseEntity<String> changePassword(@RequestBody MobileChangePasswordRequestDto requestDto) {
        try {
            // Get the client based on the email : unique
            ClientEntity client = service.findByEmail(requestDto.getEmail());

            if (client == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client introuvable.");
            }

            // Verify the current password
//            if (!client.getPassword().equals(requestDto.getCurrentPassword())) {
    


    //@PostMapping("/ChangePassword")
//    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordRequestDto requestDto) {
//        try {
//            // Get the client based on the phone number
//            ClientEntity client = service.findByEmail(requestDto.getEmail());
//
//            if (client == null) {
//                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Client introuvable.");
//            }
//
//            // Verify the current password
//            /*if (!client.getPassword().equals(requestDto.getCurrentPassword())) {
//                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Mot de passe actuel incorrect.");
//            }

            // Update the password
//            client.setPassword(requestDto.getNewPassword());
            client.setPassword(passwordEncoder.encode(requestDto.getNewPassword()));
            client.setFirstLogin(false); //  mark the client as not first login after password change
            service.saveClient(client);

            return ResponseEntity.ok("Mot de passe changé avec succès.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Une erreur s'est produite lors du changement de mot de passe.");
        }
    }

  @PostMapping("/change_password")
    public ResponseEntity<String> changePassword(@RequestBody ChangePasswordAgentDto requestDto) {
        clientService.changePasswordClient( requestDto,requestDto.getNewPassword());
        return null;
    }

    @GetMapping("/clients/{email}/solde")
    public ResponseEntity<Double> getClientSolde(@PathVariable String email) {
        ClientEntity client = service.findByEmail(email);
        if (client != null) {
            double solde = client.getClientBankAccount().getSolde();
            return ResponseEntity.ok(solde);
        } else {
            return ResponseEntity.notFound().build();
        }


    }

}