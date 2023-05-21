package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.DTO.Agent.AgentRequestDto;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("agents")
@AllArgsConstructor
public class AgentController {
    private UserService agentService;
    @GetMapping("")
    public List<AgentResponseDto> getAgent(){
        return agentService.findAllAgent();
    }
    @PostMapping("")
    public AgentResponseDto saveAgent(@RequestBody AgentRequestDto agentRequestDto){
        return agentService.saveAgent(agentRequestDto);
    }
}
