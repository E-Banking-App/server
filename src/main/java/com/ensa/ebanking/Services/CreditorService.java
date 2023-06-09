package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.CreditorDAO;
import com.ensa.ebanking.DTO.Agent.AgentRequestDto;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.DTO.Client.ClientResponseDto;
import com.ensa.ebanking.DTO.creditor.CreditorResponseDto;
import com.ensa.ebanking.Enums.Category;
import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Models.CreditorEntity;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class CreditorService {
    @Autowired
    private final CreditorDAO creditorDAO;
    private final ModelMapper modelMapper;

    public CreditorEntity createCreditor(CreditorEntity creditorEntity) {
        return creditorDAO.save(creditorEntity);
    }

    public List<CreditorResponseDto> findAll(){
        return creditorDAO.findAll()
                .stream()
                .map(el->modelMapper.map(el,CreditorResponseDto.class))
                .collect(Collectors.toList());
    }
    public List<CreditorEntity> findAllB(){
        return creditorDAO.findAll();
    }
    public List<CreditorEntity> findByCategory(Category category){
        return creditorDAO.findByCategory(category);
    }


//    public CreditorEntity createCreditor(CreditorEntity creditorEntity) {
//        return creditorDAO.save(creditorEntity);
//    }

    public CreditorEntity findByName(String name ){
        return creditorDAO.findByName(name);

    }

    public CreditorEntity save(CreditorEntity creancier) {
        return creditorDAO.save(creancier);

    }
}
