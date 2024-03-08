package com.example.service01.product.DTO;

import java.time.LocalDateTime;

public record ProductDto(
        Integer id,
        String name,
        String description,
        Double price_usd,
        Double price_thb,
        Double price_lak,
        Integer stock,
        LocalDateTime createdAt,
        LocalDateTime updatedAt

) {
}