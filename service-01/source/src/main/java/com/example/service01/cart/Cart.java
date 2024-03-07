package com.example.service01.cart;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Cart {
    @Id
    @GeneratedValue
    private Long id;
    private Long productId;
    private Integer quantity;
    public Cart() {
    }
    public Cart(Long productId, Integer quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
    public Long getId() {
        return id;
    }
    public Long getProductId() {
        return productId;
    }
    public Integer getQuantity() {
        return quantity;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setProductId(Long productId) {
        this.productId = productId;
    }
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
