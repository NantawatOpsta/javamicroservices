package com.example.service01.usecase;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ExchangeTest {

    @Test
    void testCalculatePriceBaht() {
        // Arrange
        double price_usd = 10.0;
        Exchange exchange = new Exchange();

        // Act
        double result = exchange.calculatePriceBaht(price_usd);

        // Assert
        assertEquals(325.0, result);
    }

    @Test
    void testCalculatePriceLak() {
        // Arrange
        double price_usd = 10.0;
        Exchange exchange = new Exchange();

        // Act
        double result = exchange.calculatePriceLak(price_usd);

        // Assert
        assertEquals(80000.0, result);
    }
}