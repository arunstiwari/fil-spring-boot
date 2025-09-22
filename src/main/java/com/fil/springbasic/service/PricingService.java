package com.fil.springbasic.service;

import com.fil.springbasic.order.entity.Product;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
public class PricingService {
    public BigDecimal getTotalAmount(List<Product> products) {
        BigDecimal totalAmount = BigDecimal.ZERO;
        for(Product product : products){
            totalAmount = totalAmount.add(product.getPrice());
        }
        return totalAmount;
    }
}
