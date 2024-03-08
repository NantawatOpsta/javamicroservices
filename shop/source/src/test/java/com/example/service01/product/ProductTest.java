package com.example.service01.product;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@DataJpaTest
class ProductTest {

    @Autowired
    private ProductRepository productRepository;

    @Test
    void testCreateProduct() {
        Product product = new Product("product1", "description1", 100.0, 10);
        productRepository.save(product);
        assertNotNull(product.getId());
        assertNotNull(product.getCreatedAt());
        assertNotNull(product.getUpdatedAt());
    }
}