package com.fil.springbasic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbasicApplication {

    public static void main(String[] args) {
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        BankAccountService bankAccountService = context.getBean(BankAccountService.class);
//        System.out.println(bankAccountService.getBalance("12345"));
        SpringApplication.run(SpringbasicApplication.class, args);
    }

}
