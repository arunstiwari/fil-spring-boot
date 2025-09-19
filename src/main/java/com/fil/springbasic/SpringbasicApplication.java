package com.fil.springbasic;

import com.fil.springbasic.service.BankAccountService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication
public class SpringbasicApplication {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
//        System.out.println(bankAccountService.getBalance("12345"));
        SpringApplication.run(SpringbasicApplication.class, args);
    }

}
