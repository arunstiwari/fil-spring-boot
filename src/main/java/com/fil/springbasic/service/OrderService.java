package com.fil.springbasic.service;

import com.fil.springbasic.order.entity.Order;
import com.fil.springbasic.order.entity.Product;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Configuration
@Service
public class OrderService {
//    @Autowired
    private PricingService pricingService;

    public OrderService(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PostConstruct
    public void postCreation(){
        System.out.println("OrderService Object has been created");
    }

    public Order createOrder(List<Product> products, String customerId) {
        BigDecimal totalAmount = pricingService.getTotalAmount(products);
        Order order = new Order(null, customerId, products, totalAmount);
        return order;
    }

    @Autowired
    public void setPricingService(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    @PreDestroy
    public void destroy(){
        System.out.println("Order Service Destroyed");
    }
}
