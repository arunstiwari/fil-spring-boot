package com.fil.springbasic.order.service;

import com.fil.springbasic.order.entity.Order;
import com.fil.springbasic.order.entity.Product;
import com.fil.springbasic.repository.BankAccountRepository;
import com.fil.springbasic.repository.EmployeeRepository;
import com.fil.springbasic.service.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

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
public class OrderProcessingServiceTest {

    @Autowired
    private OrderService orderService;

    @Autowired
    private DatabaseService databaseService;
    @Test
    void placeOrderTest(){

        long id = 1;
        String customerId = "cust-1";
        List<Product> products = List.of(
                new Product("1", "TV", new BigDecimal(200.25), "Electronics"),
                new Product("2", "Laptop", new BigDecimal(100.25), "Electronics")
        );
        System.out.println("OrderService hashcode: "+orderService.hashCode());
        Order createdOrder =  orderService.createOrder(products, "cust-1");

        Assertions.assertEquals(new BigDecimal(200.25).add(new BigDecimal(100.25)) , createdOrder.getTotalAmount());
        System.out.println(databaseService.getName());
    }

    @Test
    void placeOrderTest1(){

        long id = 1;
        String customerId = "cust-1";
        List<Product> products = List.of(
                new Product("1", "TV", new BigDecimal(200.25), "Electronics"),
                new Product("2", "Laptop", new BigDecimal(100.25), "Electronics")
        );
        System.out.println("OrderService hashcode: "+orderService.hashCode());
        Order createdOrder =  orderService.createOrder(products, "cust-1");

        Assertions.assertEquals(new BigDecimal(200.25).add(new BigDecimal(100.25)) , createdOrder.getTotalAmount());
    }
}
