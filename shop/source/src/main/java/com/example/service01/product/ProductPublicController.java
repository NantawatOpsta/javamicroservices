package com.example.service01.product;

import com.example.service01.product.DTO.ProductDto;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class ProductPublicController {

    private final ProductService productService;

    private final RestTemplate restTemplate;

    public ProductPublicController(ProductService productService, RestTemplate restTemplate) {
        this.productService = productService;
        this.restTemplate = restTemplate;
    }

    @Cacheable(value = "partnerProduct", key = "#root.methodName")
    @GetMapping("/api/partner/products")
    public Object getPartnerProducts() {
        return restTemplate.getForObject("https://api.publicapis.org/entries", Object.class);
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
