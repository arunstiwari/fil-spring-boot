package com.fil.springbasic.service;

import com.fil.springbasic.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    private BankAccountRepository bankAccountRepository;
    private NotificationService notificationService;


    public BankAccountService(BankAccountRepository bankAccountRepository, NotificationService notificationService) {
        this.bankAccountRepository = bankAccountRepository;
        this.notificationService = notificationService;
    }

    public double getBalance(String customerId){
        return this.bankAccountRepository.getBalance(customerId);
    }

    public boolean sendEmail(String emailId) {
        return this.notificationService.sendMessage(emailId) ;
    }
}
