package com.ensa.ebanking.Services;

import com.ensa.ebanking.DAO.SmsDAO;
import com.ensa.ebanking.Models.SmsEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SmsService {
    @Autowired
    private final SmsDAO smsDAO;
    public SmsService(SmsDAO smsDAO) {
        this.smsDAO = smsDAO;
    }
    public SmsEntity createSms(SmsEntity smsEntity) { return smsDAO.save(smsEntity);}
}
