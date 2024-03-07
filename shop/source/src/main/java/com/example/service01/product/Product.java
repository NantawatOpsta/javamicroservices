package com.example.service01.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;

import java.time.LocalDateTime;

@Entity
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private String description;
    private Double price_usd;
    private Double price_thb;
    private Double price_lak;
    private Integer Stock;
    private LocalDateTime createdAt;

    public Product() {
    }

    public Product(String name, String description, Double price_usd, Integer stock) {
        this.name = name;
        this.description = description;
        this.price_usd = price_usd;
        Stock = stock;
        this.createdAt = LocalDateTime.now();
    }

    @PrePersist
    public void calculatePrices() {
        this.price_thb = this.price_usd * 32.5;
        this.price_lak = this.price_usd * 8000;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice_usd() {
        return price_usd;
    }

    public void setPrice_usd(Double price_usd) {
        this.price_usd = price_usd;
    }

    public Double getPrice_thb() {
        return price_thb;
    }

    public void setPrice_thb(Double price_thb) {
        this.price_thb = price_thb;
    }

    public Double getPrice_lak() {
        return price_lak;
    }

    public void setPrice_lak(Double price_lak) {
        this.price_lak = price_lak;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer stock) {
        Stock = stock;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
