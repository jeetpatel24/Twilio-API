package com.example.demo;

import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/sms")
public class TwilioController {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwilioController.class);

    private final TwilioService twilioService;

    public TwilioController(TwilioService twilioService) {
        this.twilioService = twilioService;
    }

    @PostMapping
    public void sendSms(@RequestBody SmsRequest smsRequest) {
        LOGGER.info("phone number = " + smsRequest.getPhoneNumber());
        twilioService.sendSms(smsRequest);
    }
}
