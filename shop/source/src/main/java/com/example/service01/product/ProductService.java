package com.example.service01.product;

import com.example.service01.product.DTO.ProductDto;
import com.example.service01.product.DTO.ProductUpdateDto;
import com.example.service01.usecase.Exchange;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    public ProductService(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public ProductDto createProduct(ProductUpdateDto productUpdateDto) {
        Product product = productMapper.toProductUpdate(productUpdateDto);

        double price_usd = product.getPrice_usd();
        var exchange = new Exchange();
        product.setPrice_thb(exchange.calculatePriceBaht(price_usd));
        product.setPrice_lak(exchange.calculatePriceLak(price_usd));

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

}
