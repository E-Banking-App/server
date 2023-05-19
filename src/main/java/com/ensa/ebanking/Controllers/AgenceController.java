package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgenceEntity;
import com.ensa.ebanking.Services.AgenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class AgenceController {
    @Autowired
    private final AgenceService agenceService;

    public AgenceController(AgenceService agenceService) {
        this.agenceService = agenceService;
    }

    @PostMapping("/agency")
    public void addAgency(@RequestBody AgenceEntity agency){
        agenceService.createAgence(agency);
    }
    @GetMapping("/agency")
    public ResponseEntity<List<AgenceEntity>> getAgencies(){
        return new ResponseEntity<>(agenceService.getAgencies(), HttpStatus.OK);
    }
    @DeleteMapping("/agency/{id}")
    public ResponseEntity<HttpStatus> deleteAgence(@PathVariable("id") Long id) {
        agenceService.deleteAgence(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
