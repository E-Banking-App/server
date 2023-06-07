package com.ensa.ebanking.Auth;

import com.ensa.ebanking.Auth.AuthenticationRequest;
import com.ensa.ebanking.Auth.AuthenticationResponse;
import com.ensa.ebanking.Auth.AuthenticationService;
import com.ensa.ebanking.Auth.PasswordGenerator;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService service;
    private final UserService agentService;


    //    @PostMapping("/register")
//    public ResponseEntity<AuthenticationResponse> register(
//            @RequestBody RegisterRequest request
//            ){
//        return ResponseEntity.ok(service.register(request));
//    }
    @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register(
            @RequestBody PasswordGenerator.RegisterRequest request
            ){
        return ResponseEntity.ok(service.adminRegister(request));
    }
    @PostMapping("/authenticate")
    public ResponseEntity<AuthenticationResponse> authenticate(
            @RequestBody AuthenticationRequest request
    ){
        return ResponseEntity.ok(service.authenticate(request));
    }
    @PostMapping("/authenticate/agent")
    public ResponseEntity<AuthenticationResponse> authenticateAgent(
            @RequestBody AuthenticationRequest request
    ){

        //get the Agent from the DB
        AgentResponseDto agentResponse= agentService.findByUsername(request.getUsername());
        //affect the value to the response id and first Login
        AuthenticationResponse response = service.authenticate(request);
        response.setIsFirstLogin(agentResponse.getIsFirstLogin());
        response.setId(agentResponse.getId());

        return ResponseEntity.ok(response);
    }
}
