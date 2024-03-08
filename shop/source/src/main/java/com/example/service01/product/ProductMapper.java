package com.example.service01.product;

import com.example.service01.product.DTO.ProductDto;
import com.example.service01.product.DTO.ProductUpdateDto;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {

    public Product toProductUpdate(ProductUpdateDto productDto) {
        return new Product(
                productDto.name(),
                productDto.description(),
                productDto.price_usd(),
                productDto.stock()
        );
    }

    public ProductDto toProductDto(Product product) {
        return new ProductDto(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice_usd(),
                product.getPrice_thb(),
                product.getPrice_lak(),
                product.getStock()
        );
    }

}
