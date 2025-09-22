package com.fil.springbasic.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.stereotype.Service;

@Service
public class EmailService implements NotificationService {

    @PostConstruct
    public void init(){
        System.out.println("Email Service Initialized");
    }

    @Override
    public boolean sendMessage(String emailId) {
        System.out.println("Email Sent");
        return true;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Email Service Destroyed");
    }
}
