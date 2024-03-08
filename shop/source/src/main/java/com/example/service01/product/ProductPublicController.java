package com.example.service01.product;

import com.example.service01.product.DTO.ProductDto;
import com.example.service01.product.DTO.ProductUpdateDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductPublicController {

    private final ProductService productService;

    public ProductPublicController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/api/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    @GetMapping("/api/products/{id}")
    public ProductDto getProduct(@PathVariable Integer id) {
        return productService.getProduct(id);
    }

}
