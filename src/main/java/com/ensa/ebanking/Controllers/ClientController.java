package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.DTO.Client.ClientRequestDto;
import com.ensa.ebanking.DTO.Client.ClientResponseDto;
import com.ensa.ebanking.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("clients")
@AllArgsConstructor
public class ClientController {
    private UserService clientService;

    @GetMapping("")
    public List<ClientResponseDto> getClient(){
        return clientService.findAllClient();
    }

    @PostMapping("")
    public ClientResponseDto saveClient(@RequestBody ClientRequestDto clientRequestDto){
        return clientService.saveClient(clientRequestDto);
    }
}
