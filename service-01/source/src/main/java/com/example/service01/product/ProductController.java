package com.example.service01.product;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.List;

@RestController
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public List<ProductDto> getProducts() {
        return productService.getProducts();
    }

    public ProductDto createProduct(ProductDto productDto) {
        return productService.createProduct(productDto);
    }

    public ProductDto getProduct(Integer id) {
        return productService.getProduct(id);
    }

    public ProductDto updateProduct(Integer id, ProductDto productDto) {
        return productService.updateProduct(id, productDto);
    }

    public void deleteProduct(Integer id) {
        productService.deleteProduct(id);
    }
}
