package com.example.service01.product;

public record ProductDto(
        Integer id,
        String name,
        String description,
        Double price_usd,

        Integer stock
) {
}