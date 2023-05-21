package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Auth.PasswordGenerator;
import com.ensa.ebanking.DTO.Agent.AgentRequestDto;
import com.ensa.ebanking.DTO.Agent.AgentResponseDto;
import com.ensa.ebanking.Services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("agent")
@CrossOrigin
@AllArgsConstructor
public class AgentController {
    private UserService agentService;

    @GetMapping("")
    public List<AgentResponseDto> getAgent(){
        return agentService.findAllAgent();
    }

    @PostMapping("")
    public AgentResponseDto saveAgent(@RequestParam("firstName") String firstName, @RequestParam("lastName") String lastName,
                                   @RequestParam("cin") String cin, @RequestParam("cinFront") MultipartFile cinFront,
                                   @RequestParam("cinBack") MultipartFile cinBack, @RequestParam("location") String location,
                                   @RequestParam("birthDate") LocalDate birthDate, @RequestParam("phoneNumber") String phoneNumber,
                                   @RequestParam("irc") String irc, @RequestParam("irc") String ice,
                                   @RequestParam("username") String username) {
        AgentRequestDto agentRequestDto = new AgentRequestDto();
        agentRequestDto.setFirstName(firstName);
        agentRequestDto.setLastName(lastName);
        agentRequestDto.setCin(cin);
        String cinLink = "CIN/" + cin + "/";
        agentRequestDto.setCinLink(cinLink);
        agentRequestDto.setLocation(location);
        agentRequestDto.setBirthDate(birthDate);
        agentRequestDto.setPhoneNumber(phoneNumber);
        agentRequestDto.setIrc(irc);
        agentRequestDto.setIce(ice);
        agentRequestDto.setUsername(username);
        PasswordGenerator passwordGenerator = new PasswordGenerator();
        String password = passwordGenerator.generateRandomPassword();
        agentRequestDto.setPassword(password);
        if (!cinFront.isEmpty() && !cinBack.isEmpty()) {
            try {
                String fileNameCinFront = cinFront.getOriginalFilename();
                String fileNameCinBack = cinBack.getOriginalFilename();
                byte[] bytesFront = cinFront.getBytes();
                byte[] bytesBack = cinBack.getBytes();
                Path fileStoragePath = Paths.get("CIN/" + cin).toAbsolutePath().normalize();
                Files.createDirectories(fileStoragePath);
                Files.write(Paths.get("CIN/" + cin + "/CinFront-" +  fileNameCinFront), bytesFront);
                Files.write(Paths.get("CIN/" + cin + "/CinBack-" +  fileNameCinBack), bytesBack);
                System.out.println("File uploaded successfully.");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("Error occurred during file upload.");
            }
        } else {
            System.out.println("Empty files provided.");
        }
        return agentService.saveAgent(agentRequestDto);
    }
}
