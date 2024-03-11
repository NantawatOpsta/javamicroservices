package com.example.service01.usecase;

public class Exchange {

    public double calculatePriceBaht(double price_usd) {
        return price_usd * 32.5;
    }

    public double calculatePriceLak(double price_usd) {
        return price_usd * 8000;
    }

}
