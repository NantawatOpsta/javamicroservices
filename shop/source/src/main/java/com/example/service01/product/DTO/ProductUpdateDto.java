package com.example.service01.product.DTO;

public record ProductUpdateDto (
        Integer id,
        String name,
        String description,
        Double price_usd,
        Integer stock
){
}
