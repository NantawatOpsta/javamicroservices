package com.example.service01.product;

import com.example.service01.product.DTO.ProductDto;
import com.example.service01.product.DTO.ProductUpdateDto;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductPrivateController {

    private final ProductService productService;

    public ProductPrivateController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/api/products")
    public ProductDto createProduct(@RequestBody ProductUpdateDto productUpdateDto) {
        return productService.createProduct(productUpdateDto);
    }
}
