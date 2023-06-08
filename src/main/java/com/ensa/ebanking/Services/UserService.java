package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.AdminDAO;
import com.ensa.ebanking.DAO.AgentDAO;
import com.ensa.ebanking.DAO.ClientDAO;
import com.ensa.ebanking.DTO.Admin.AdminRequestDto;
import com.ensa.ebanking.DTO.Admin.AdminResponseDto;
import com.ensa.ebanking.DTO.Agent.AgentRequestDto;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.DTO.Agent.ChangePasswordAgentDto;
import com.ensa.ebanking.DTO.Client.ClientRequestDto;
import com.ensa.ebanking.DTO.Client.ClientResponseDto;
import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Models.ClientEntity;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
//@RequiredArgsConstructor
@AllArgsConstructor
public class UserService {

    private final ClientDAO clientDTO;

    private final AdminDAO adminDTO;

    private final AgentDAO agentDTO;

    private final ModelMapper modelMapper;
    private PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //------------------------ Client ------------------------//
    public ClientResponseDto saveClient(ClientRequestDto clientRequestDto){
        ClientEntity clientEntity=modelMapper.map(clientRequestDto,ClientEntity.class);
        ClientEntity saved=clientDTO.save(clientEntity);
        return modelMapper.map(saved,ClientResponseDto.class);
    }
    public List<ClientResponseDto> findAllClient(){
        return clientDTO.findAll()
                .stream()
                .map(el->modelMapper.map(el,ClientResponseDto.class))
                .toList();
    }
    public List<ClientResponseDto> findByIdClient(Long id){
        return clientDTO.findById(id)
                .stream()
                .map(el->modelMapper.map(el,ClientResponseDto.class))
                .toList();
    }
    public ClientResponseDto findByUsernameClient(String username){
        ClientEntity agent=clientDTO.findByUsername(username);
        return modelMapper.map(agent,ClientResponseDto.class)  ;
    }

    public ResponseEntity<String> changePasswordClient(ChangePasswordAgentDto requestDto,String password) {
        if (password == null) {
            // Return a bad request response if the password is null
            return ResponseEntity.badRequest().body("Password cannot be null");
        }
        ClientEntity agent=clientDTO.findById(requestDto.getId()).orElseThrow(() -> new RuntimeException("Agent not found"));
        agent.setPassword(passwordEncoder.encode(password));
        agent.setIsFirstLogin(false);
        clientDTO.save(agent);
        return null;
    }



    //------------------------ Agent ------------------------//
    public AgentResponseDto saveAgent(AgentRequestDto agentRequestDto){
        AgentEntity agentEntity=modelMapper.map(agentRequestDto,AgentEntity.class);
        AgentEntity saved=agentDTO.save(agentEntity);
        return modelMapper.map(saved,AgentResponseDto.class);
    }

    public List<AgentResponseDto> findAllAgent(){
        return agentDTO.findAll()
                .stream()
                .map(el->modelMapper.map(el,AgentResponseDto.class))
                .collect(Collectors.toList());
    }
    public List<AgentResponseDto> findByIdAgent(Long id) {
        return agentDTO.findById(id).stream()
                .map(el->modelMapper.map(el,AgentResponseDto.class))
                .collect(Collectors.toList());
    }
    public AgentResponseDto findByUsernameAgent(String username){
        AgentEntity agent=agentDTO.findByUsername(username);
        return modelMapper.map(agent,AgentResponseDto.class)  ;
    }
    public ResponseEntity<String> changePasswordAgent(ChangePasswordAgentDto requestDto,String password) {
        if (password == null) {
            // Return a bad request response if the password is null
            return ResponseEntity.badRequest().body("Password cannot be null");
        }
        AgentEntity  agent=agentDTO.findById(requestDto.getId()).orElseThrow(() -> new RuntimeException("Agent not found"));
        agent.setPassword(passwordEncoder.encode(password));
        agent.setIsFirstLogin(false);
        agentDTO.save(agent);
        return null;
    }

    //------------------------ Admin ------------------------//
    public AdminResponseDto saveAdmin(AdminRequestDto adminRequestDto){
        AdminEntity adminEntity=modelMapper.map(adminRequestDto,AdminEntity.class);
        AdminEntity saved=adminDTO.save(adminEntity);
        return modelMapper.map(saved,AdminResponseDto.class);
    }
    public List<AdminResponseDto> findAllAdmin(){
        return adminDTO.findAll()
                .stream()
                .map(el->modelMapper.map(el,AdminResponseDto.class))
                .collect(Collectors.toList());
    }


    ////////////////////////////////////////////////////////////////////////////////////////////:
    public ClientEntity createClient(ClientEntity client) {
        return clientDTO.save(client);
    }

    public AdminEntity createAdmin(AdminEntity admin) {
        return adminDTO.save(admin);
    }
    public AgentEntity createAgent(AgentEntity agent) {
        return agentDTO.save(agent);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////:

    public void deleteAdmin(Long id) {
        adminDTO.deleteById(id);
    }
    public List<AdminEntity> getAdmins() {
        List<AdminEntity> admins = adminDTO.findAll();
        return admins;
    }

}