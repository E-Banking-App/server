package com.ensa.ebanking.Controllers;

import com.ensa.ebanking.Services.SoapClient;
import com.ensa.ebanking.solde.ConsultationSoldeRequest;
import com.ensa.ebanking.solde.ConsultationSoldeResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SoldeController {


//    @Autowired
//    private SoapClient client ;
//    @PostMapping("/getLoanSolde")
//    @ResponseBody
//    public ConsultationSoldeResponse invokeSoapClientToGetLoanStatus(@RequestBody ConsultationSoldeRequest request) {
////        ConsultationSoldeRequest consultationSoldeRequest = new ConsultationSoldeRequest(request.getFistName());
//        System.out.println("request"+request);
//        return client.getLoanSolde(request);
//    }

//    @PostMapping("/getsolde")
//    @ResponseBody
//    public Double invokeSoapClientToGetLoanStatus(@RequestBody ConsultationSoldeRequest request) {
//        System.out.println("request"+request);
//        return 0.0;
////        return client.getLoanSolde(request);
//    }
}
