package com.example.service01.product;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @PostMapping("/api/products")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    @GetMapping("/api/products/{id}")
    public ProductDto getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

}
