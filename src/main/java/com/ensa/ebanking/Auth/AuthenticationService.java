package com.ensa.ebanking.Auth;


import com.ensa.ebanking.DAO.AdminDAO;
import com.ensa.ebanking.DAO.AgentDAO;
import com.ensa.ebanking.DAO.ClientDAO;
import com.ensa.ebanking.DAO.UserRepository;
import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final PasswordEncoder passwordEncoder;
    private final UserRepository repository;
    private final AdminDAO Adminrepository;
    private final AgentDAO agentrepository;
    private final ClientDAO clientrepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse adminRegister(PasswordGenerator.RegisterRequest request){
        AdminEntity user =new AdminEntity(request.getUsername(),passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse agentRegister(PasswordGenerator.RegisterRequest request){
        AgentEntity user =new AgentEntity(request.getUsername(),passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
    public AuthenticationResponse clientRegister(PasswordGenerator.RegisterRequest request){
        ClientEntity user =new ClientEntity(request.getUsername(),passwordEncoder.encode(request.getPassword()));
        repository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }



//    public AuthenticationResponse register(RegisterRequest request) {
//        var user = UserEntity.builder()
//                .username(request.getUsername())
//                .password(passwordEncoder.encode(request.getPassword()))
//                .build();
//        repository.save(user);
//        var jwtToken = jwtService.generateToken(user);
//        return AuthenticationResponse.builder()
//                .token(jwtToken)
//                .build();
//    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getUsername(),
                        request.getPassword()
                )
        );
        var user = repository.findByUsername(request.getUsername())
                .orElseThrow();

        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .token(jwtToken)
                .build();
    }
}
