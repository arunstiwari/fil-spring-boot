package com.fil.springbasic.order.service;

import com.fil.springbasic.order.entity.Order;
import com.fil.springbasic.order.entity.Product;
import com.fil.springbasic.service.DatabaseService;
import com.fil.springbasic.service.OrderService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.math.BigDecimal;
import java.util.List;

@ActiveProfiles("qa")
@SpringBootTest
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
