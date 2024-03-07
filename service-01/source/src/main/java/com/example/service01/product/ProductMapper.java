package com.example.service01.product;

import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductMapper {

    public Product toProduct(ProductDto productDto) {
        return new Product(
                productDto.name(),
                productDto.description(),
                productDto.price(),
                0
        );
    }

    public ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice()
        );
    }

}