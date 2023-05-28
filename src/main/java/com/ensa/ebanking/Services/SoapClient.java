package com.ensa.ebanking.Services;
import com.ensa.ebanking.DAO.ClientBankAccountDAO;
import com.ensa.ebanking.DAO.ClientDAO;
import com.ensa.ebanking.Models.ClientBankAccountEntity;
import com.ensa.ebanking.Models.ClientEntity;
import com.ensa.ebanking.solde.ConsultationSoldeRequest;
import com.ensa.ebanking.solde.ConsultationSoldeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;
@Service
public class SoapClient {


    private  ClientBankAccountDAO clientBankAccountDAO;
    private ClientDAO clientDAO;

    @Autowired
    private Jaxb2Marshaller marshaller;


    private WebServiceTemplate template;


    @Autowired
    public SoapClient(ClientDAO clientDAO, ClientBankAccountDAO clientBankAccountDAO) {
        this.clientDAO = clientDAO;
        this.clientBankAccountDAO = clientBankAccountDAO;
    }

    /* public ConsultationSoldeResponse getLoanSolde(ConsultationSoldeRequest request) {
        template = new WebServiceTemplate(marshaller);
        ConsultationSoldeResponse response = (ConsultationSoldeResponse) template.marshalSendAndReceive("http://localhost:8082/ws", request);
        return response;
    }*/


    public ConsultationSoldeResponse getLoanSolde(ConsultationSoldeRequest request) {
        System.out.println("request2"+ request);
        // Appel du Web service externe pour récupérer la réponse
        template = new WebServiceTemplate(marshaller);
        ConsultationSoldeResponse response = (ConsultationSoldeResponse) template.marshalSendAndReceive("http://localhost:8082/ws", request);

        // Récupération du client en fonction du firstName depuis le DAO du client
        ClientEntity client = clientDAO.findByFirstName(request.getFistName());

        if (client != null && client.getClientBankAccount() != null) {
            // Récupération du solde du compte bancaire du client
            double balance = client.getClientBankAccount().getSolde();
            response.setBalance(balance);
        } else {
            // Gérer le cas où aucun client ou compte bancaire n'est trouvé
            response.setBalance(0.0);
        }

        return response;
    }

}