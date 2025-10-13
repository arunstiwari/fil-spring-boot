package com.fil.springbasic;

import com.fil.springbasic.repository.BankAccountRepository;
import com.fil.springbasic.repository.EmployeeRepository;
import com.fil.springbasic.service.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest(classes = {
        BankAccountService.class,
        BankAccountRepository.class,
        NotificationService.class,
        PricingService.class,
        OrderService.class,
        DatabaseService.class,
        EmployeeRepository.class
})
@EnableAutoConfiguration(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
public class BankAccountServiceTest {

    @Autowired
    private BankAccountService bankAccountService;

    @Test
    void getBalanceTest(){
//        BankAccountRepository bankAccountRepository = new BankAccountRepository();
//        BankAccountService bankAccountService = new BankAccountService(bankAccountRepository);
        assertEquals(0.0, bankAccountService.getBalance("12345"));
    }

    @Test
    void sendEmailNotificationToUser(){
//        BankAccountRepository bankAccountRepository = new BankAccountRepository();
//        BankAccountService bankAccountService = new BankAccountService(bankAccountRepository);
        assertEquals(true, bankAccountService.sendEmail("test@xyz"));
    }

}
//https://github.com/arunstiwari/fil-spring-boot