package com.ensa.ebanking.Services;

import com.infobip.ApiClient;
import com.infobip.ApiException;
import com.infobip.api.SendSmsApi;
import com.infobip.model.SmsAdvancedTextualRequest;
import com.infobip.model.SmsDestination;
import com.infobip.model.SmsResponse;
import com.infobip.model.SmsTextualMessage;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class SmsService1 {

    private  final String BASE_URL = "https://yrm19p.api.infobip.com";
    private  final String API_KEY = "b90e45e6b1896eccab86334fa05adb5c-d3a134b5-447c-4dc8-9b9a-ea284ad2d1fa";

    private  final String SENDER = "+212628227877";

    public void sendSMS(String message,String recipient) {
        ApiClient client = initApiClient();

        SendSmsApi sendSmsApi = new SendSmsApi(client);

        SmsTextualMessage smsMessage = new SmsTextualMessage()
                .from(SENDER)
                .addDestinationsItem(new SmsDestination().to(recipient))
                .text(message);

        SmsAdvancedTextualRequest smsMessageRequest = new SmsAdvancedTextualRequest()
                .messages(Collections.singletonList(smsMessage));

        try {
            SmsResponse smsResponse = sendSmsApi.sendSmsMessage(smsMessageRequest);
            System.out.println("Response body: " + smsResponse);
        } catch (ApiException e) {
            System.out.println("HTTP status code: " + e.getCode());
            System.out.println("Response body: " + e.getResponseBody());
        }
    }

    private ApiClient initApiClient() {
        ApiClient client = new ApiClient();

        client.setApiKeyPrefix("App");
        client.setApiKey(API_KEY);
        client.setBasePath(BASE_URL);

        return client;
    }
}
