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
        Product savedProduct = productRepository.save(product);
        return productMapper.toProductDto(savedProduct);
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

//    public ProductDto updateProduct(Integer id, ProductDto productDto) {
//        Product product = productMapper.toProduct(productDto);
//        Product updatedProduct = productRepository.update(id, product);
//        return productMapper.toProductDto(updatedProduct);
//    }
//
//    public void deleteProduct(Integer id) {
//        productRepository.delete(id);
//    }
}
