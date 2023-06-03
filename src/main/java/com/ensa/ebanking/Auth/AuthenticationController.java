package com.ensa.ebanking.Auth;

import com.ensa.ebanking.Auth.AuthenticationRequest;
import com.ensa.ebanking.Auth.AuthenticationResponse;
import com.ensa.ebanking.Auth.AuthenticationService;
import com.ensa.ebanking.Auth.PasswordGenerator;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin
public class AuthenticationController {
    private final AuthenticationService service;
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
        return ResponseEntity.ok(service.authenticate(request));
    }
}
