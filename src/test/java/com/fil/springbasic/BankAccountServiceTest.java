package com.fil.springbasic;

import com.fil.springbasic.repository.BankAccountRepository;
import com.fil.springbasic.service.BankAccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class BankAccountServiceTest {

    @Autowired
    private BankAccountService bankAccountService;

    @Test
    void getBalanceTest(){
//        BankAccountRepository bankAccountRepository = new BankAccountRepository();
//        BankAccountService bankAccountService = new BankAccountService(bankAccountRepository);
        assertEquals(0.0, bankAccountService.getBalance("12345"));
    }

}
//https://github.com/arunstiwari/fil-spring-boot