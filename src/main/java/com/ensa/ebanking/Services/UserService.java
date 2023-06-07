package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.AdminDAO;
import com.ensa.ebanking.DAO.AgentDAO;
import com.ensa.ebanking.DAO.ClientDAO;
import com.ensa.ebanking.DTO.Admin.AdminRequestDto;
import com.ensa.ebanking.DTO.Admin.AdminResponseDto;
import com.ensa.ebanking.DTO.Agent.AgentRequestDto;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.DTO.Client.ClientRequestDto;
import com.ensa.ebanking.DTO.Client.ClientResponseDto;
import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.Models.UserEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserService {

    @Autowired
    private final ClientDAO clientDTO;

    @Autowired
    private final AdminDAO adminDTO;

    @Autowired
    private final AgentDAO agentDTO;

    private ModelMapper modelMapper;
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
                .collect(Collectors.toList());
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
//    public List<AgentResponseDto> findByUsername(String username){
//        return agentDTO.findByUsername(username)
//                .stream()
//                .map(el->modelMapper.map(el,AgentResponseDto.class))
//                .collect(Collectors.toList());
//    }
    public AgentResponseDto findByUsername(String username){
        AgentEntity agent=agentDTO.findByUsername(username);
        return modelMapper.map(agent,AgentResponseDto.class);
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