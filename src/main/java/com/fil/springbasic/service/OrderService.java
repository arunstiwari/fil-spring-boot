package com.fil.springbasic.service;

import com.fil.springbasic.order.entity.Order;
import com.fil.springbasic.order.entity.Product;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class OrderService {
    private PricingService pricingService;

    public OrderService(PricingService pricingService) {
        this.pricingService = pricingService;
    }

    public Order createOrder(List<Product> products, String customerId) {
        BigDecimal totalAmount = pricingService.getTotalAmount(products);
        Order order = new Order(null, customerId, products, totalAmount);
        return order;
    }
}
