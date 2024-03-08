package com.example.service01.product.DTO;

public record ProductDto(
        Integer id,
        String name,
        String description,
        Double price_usd,
        Double price_thb,
        Double price_lak,
        Integer stock
) {
}