package com.fil.springbasic.service;

import com.fil.springbasic.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankAccountService {
    private BankAccountRepository bankAccountRepository;


    public BankAccountService(BankAccountRepository bankAccountRepository) {
        this.bankAccountRepository = bankAccountRepository;
    }

    public double getBalance(String customerId){
        return this.bankAccountRepository.getBalance(customerId);
    }
}
