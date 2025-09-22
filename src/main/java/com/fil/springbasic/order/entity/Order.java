package com.fil.springbasic.order.entity;


import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

//Create an `Order` model class with properties: `id`, `customerId`, `products` (List), `totalAmount`
public class Order {
    private Long id;
    private String customerId;
    private List<Product> products = new ArrayList<>();
    private BigDecimal totalAmount = new BigDecimal(0.0);

    public Order(Long id, String customerId, List<Product> products, BigDecimal totalAmount) {
        this.id = id;
        this.customerId = customerId;
        this.products = products;
        this.totalAmount = totalAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public BigDecimal getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(BigDecimal totalAmount) {
        this.totalAmount = totalAmount;
    }
}
