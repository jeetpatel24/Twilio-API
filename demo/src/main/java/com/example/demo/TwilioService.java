package com.example.demo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestBody;

@org.springframework.stereotype.Service
public class TwilioService {

    private final SmsSender smsSender;

    public TwilioService(@Qualifier("twilio") TwilioSmsSender smsSender) {
        this.smsSender = smsSender;
    }

    public void sendSms(@RequestBody SmsRequest smsRequest) {
        smsSender.sendSms(smsRequest);
    }
}
