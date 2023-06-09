package com.ensa.ebanking;

import com.ensa.ebanking.Enums.Category;
import com.ensa.ebanking.Models.*;
import com.ensa.ebanking.Services.*;
import com.ensa.ebanking.solde.ConsultationSoldeRequest;
import com.ensa.ebanking.solde.ConsultationSoldeResponse;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Arrays;

//@CrossOrigin(origins = "*")
@SpringBootApplication
public class EBankingApplication {
	PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(EBankingApplication.class, args);
	}

	@Bean
	CommandLineRunner run(AgenceService agenceService, UserService userService, ClientBankAccountService clientBankAccountService, CompanyBankAccountService companyBankAccountService, CompanyService companyService, CreditorService creditorService, FormService formService, CreanceService creanceService, BillService billService, BillAccountService billAccountService, BillPenaltyService billPenaltyService, BillFraisService billFraisService, FormFieldService formFieldService) {
		return args -> {
			// Add Default Admin On Initialization
			this.passwordEncoder = new BCryptPasswordEncoder();//to encrypte the password
			AdminEntity admin = new AdminEntity("admin@ensa.ma",  passwordEncoder.encode("password"), "first name", "last name", "0600000000");
			userService.createAdmin(admin);
			// Add Default Agencies On Initialization
			AgenceEntity agence1 = new AgenceEntity("agence 1", admin);
			AgenceEntity agence2 = new AgenceEntity("agence 2", admin);
			agenceService.createAgence(agence1);
			agenceService.createAgence(agence2);
			// Add Default Agents On Initialization

			AgentEntity agent1 = new AgentEntity("agent1@ensa.ma", passwordEncoder.encode("password"), "first name", "last name", "EE000000", "/cin/EE000000", "location", LocalDate.now(), "0600000000", "irc", "ice", admin, agence1);
			AgentEntity agent2 = new AgentEntity("agent2@ensa.ma", "password", "first name", "last name", "EE000001", "/cin/EE000001", "location", LocalDate.now(), "0600000001", "irc", "ice", admin, agence2);
			userService.createAgent(agent1);
			userService.createAgent(agent2);
			// Add Client Bank Account On Initialization
			ClientBankAccountEntity clientBankAccount1 = new ClientBankAccountEntity(30445, "20000");
			ClientBankAccountEntity clientBankAccount2 = new ClientBankAccountEntity(30446, "5000");
			clientBankAccountService.createClientBankAccount(clientBankAccount1);
			clientBankAccountService.createClientBankAccount(clientBankAccount2);
			// Add Client On Initialization
			ClientEntity client1 = new ClientEntity("0628523329", passwordEncoder.encode("password"), "first Name", "last Name", "client@ensa.ma", agent1, clientBankAccount1);
			ClientEntity client2 = new ClientEntity("0609454357", passwordEncoder.encode("password"), "first Name", "last Name", "client2@ensa.ma", admin, clientBankAccount2);
			userService.createClient(client1);
			userService.createClient(client2);
			// Add Company Bank Account On Initialization
			CompanyBankAccountEntity companyBankAccount = new CompanyBankAccountEntity(32435);
			companyBankAccountService.createCompanyBankAccount(companyBankAccount);
			// Add Company On Initialization
			// Hehe
			CompanyEntity company = new CompanyEntity("https://www.iam.ma/ImagesMarocTelecom/Phototh%C3%A8que/Images-grandes/maroc-telecom-bleu-fr-grande.jpg", "Maroc Telecom", companyBankAccount);
			companyService.createCompany(company);
			// Add Creditors On Initialization
			CreditorEntity creditor1 = new CreditorEntity("23434", "IAM Recharges", Category.RECHARGE, company);
			CreditorEntity creditor2 = new CreditorEntity("23435", "IAM Factures", Category.FACTURE, company);
			CreditorEntity creditor3 = new CreditorEntity("23436", "ALCS", Category.DONATION, company);
			creditorService.createCreditor(creditor1);
			creditorService.createCreditor(creditor2);
			creditorService.createCreditor(creditor3);
			// Add Forms On Initialization
			FormEntity form1 = new FormEntity();
			FormEntity form2 = new FormEntity();
			formService.createForm(form1);
			formService.createForm(form2);
			// Add FormFields On Initialization
			FormFieldEntity formField1 = new FormFieldEntity("code", "Enter Code", "number", form1);
			FormFieldEntity formField2 = new FormFieldEntity("phoneNumber", "Enter Phone Number", "text", form2);
			FormFieldEntity formField3 = new FormFieldEntity("name", "Enter Your Full Name", "text", form1);
			formFieldService.createFormField(formField1);
			formFieldService.createFormField(formField2);
			formFieldService.createFormField(formField3);
			// Add Creances On Initialization
			CreanceEntity creance1 = new CreanceEntity("34542", "Téléphonie et Internet SIM", creditor1, form1);
			CreanceEntity creance2 = new CreanceEntity("43894", "Produit Internet SIM", creditor2, form2);
			CreanceEntity creance3 = new CreanceEntity("43895", "Produit Fix SIM", creditor2, form2);
			CreanceEntity creance4 = new CreanceEntity("43896", "Produit Mobile SIM", creditor2, form2);
			CreanceEntity creance5 = new CreanceEntity("43834", "Donation ALCS", creditor3, form2);
			creanceService.createCreance(creance1);
			creanceService.createCreance(creance2);
			creanceService.createCreance(creance3);
			creanceService.createCreance(creance4);
			creanceService.createCreance(creance5);
		};
	}

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}

}
