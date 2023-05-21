package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.AgenceDAO;
import com.ensa.ebanking.DTO.Agence.AgenceRequestDto;
import com.ensa.ebanking.DTO.Agence.AgenceResponseDto;
import com.ensa.ebanking.DTO.Client.ClientRequestDto;
import com.ensa.ebanking.DTO.Client.ClientResponseDto;
import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgenceEntity;
import com.ensa.ebanking.Models.ClientEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class AgenceService {
    @Autowired
    private final AgenceDAO agenceDTO;
    private ModelMapper modelMapper;
    public AgenceResponseDto saveAgence(AgenceRequestDto agenceRequestDto){
        AgenceEntity clientEntity=modelMapper.map(agenceRequestDto,AgenceEntity.class);
        AgenceEntity saved=agenceDTO.save(clientEntity);
        return modelMapper.map(saved, AgenceResponseDto.class);
    }
    public List<AgenceResponseDto> findAllAgence(){
        return agenceDTO.findAll()
                .stream()
                .map(el->modelMapper.map(el,AgenceResponseDto.class))
                .collect(Collectors.toList());
    }


    public void deleteAgence(Long id) {
        agenceDTO.deleteById(id);
    }

    public AgenceEntity createAgence(AgenceEntity agenceEntity) {
        return agenceDTO.save(agenceEntity);
    }
}
