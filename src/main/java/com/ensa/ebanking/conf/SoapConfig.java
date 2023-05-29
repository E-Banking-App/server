package com.ensa.ebanking.conf;

import com.ensa.ebanking.solde.ConsultationSoldeRequest;
import com.ensa.ebanking.solde.ConsultationSoldeResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapConfig {


    @Bean
    public Jaxb2Marshaller marshaller() {
        Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.ensa.ebanking.solde");
        return marshaller;
    }



}
