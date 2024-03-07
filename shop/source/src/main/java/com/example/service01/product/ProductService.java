package com.example.service01.product;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto createProduct(ProductDto productDto) {
        Product product = productMapper.toProduct(productDto);

        double price_usd = product.getPrice_usd();
        product.setPrice_thb(calculatePriceBaht(price_usd));
        product.setPrice_lak(calculatePriceLak(price_usd));

        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDto(savedProduct);
    }

    public double calculatePriceBaht(double price_usd) {
        return price_usd * 32.5;
    }

    public double calculatePriceLak(double price_usd) {
        return price_usd * 8000;
    }

    public ProductDto getProduct(Integer id) {
        Product product = productRepository.findById(id).orElse(new Product());
        return productMapper.toProductDto(product);
    }

    public List<ProductDto> getProducts() {
        List<Product> products = productRepository.findAll();
        return products.stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

}
