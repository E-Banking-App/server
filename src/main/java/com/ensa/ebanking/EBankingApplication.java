package com.ensa.ebanking;

import com.ensa.ebanking.Models.AdminEntity;
import com.ensa.ebanking.Models.AgenceEntity;
import com.ensa.ebanking.Models.AgentEntity;
import com.ensa.ebanking.Services.AdminService;
import com.ensa.ebanking.Services.AgenceService;
import com.ensa.ebanking.Services.AgentService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class EBankingApplication {

	public static void main(String[] args) {
		SpringApplication.run(EBankingApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AdminService adminService, AgenceService agenceService, AgentService agentService) {
		return args -> {
			// Add Default Admin On Initialization
			AdminEntity admin = new AdminEntity("admin@ensa.ma", "password", "first name", "last name", "0600000000");
			adminService.addAdmin(admin);
			// Add Default Agencies On Initialization
			AgenceEntity agence1 = new AgenceEntity("agence 1", admin);
			AgenceEntity agence2 = new AgenceEntity("agence 2", admin);
			agenceService.addAgence(agence1);
			agenceService.addAgence(agence2);
			// Add Default Agents On Initialization
			AgentEntity agent1 = new AgentEntity("agent1@ensa.ma", "password", "first name", "last name", "EE000000", "/cin/EE000000", "location", LocalDate.now(), "0600000000", "irc", "ice", admin, agence1);
			AgentEntity agent2 = new AgentEntity("agent2@ensa.ma", "password", "first name", "last name", "EE000001", "/cin/EE000001", "location", LocalDate.now(), "0600000001", "irc", "ice", admin, agence2);
			agentService.addAgent(agent1);
			agentService.addAgent(agent2);
			// Add Client On Initialization

		};
	}

}
