package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.DTO.Agence.AgenceRequestDto;
import com.ensa.ebanking.DTO.Agence.AgenceResponseDto;
import com.ensa.ebanking.DTO.Agent.AgentRequestDto;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgenceEntity;
import com.ensa.ebanking.Services.AgenceService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agency")
@CrossOrigin
@AllArgsConstructor
public class AgenceController {
    private final AgenceService agenceService;
    @PostMapping("")
    public AgenceResponseDto saveAgence(@RequestBody AgenceRequestDto agenceRequestDto){
        return agenceService.saveAgence(agenceRequestDto);
    }
    @GetMapping("")
    public List<AgenceResponseDto> getAgence(){
        return agenceService.findAllAgence();
    }
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteAgence(@PathVariable("id") Long id) {
        agenceService.deleteAgence(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
