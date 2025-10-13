package com.fil.springbasic.service;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service
@Qualifier("notificationService")
public class NotificationService  {

    @PostConstruct
    public void init(){
        System.out.println("Email Service Initialized");
    }

    public boolean sendMessage(String emailId) {
        System.out.println("Email Sent");
        return true;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Email Service Destroyed");
    }
}
