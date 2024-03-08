package com.example.service01.product;

import com.example.service01.product.DTO.ProductDto;
import com.example.service01.product.DTO.ProductUpdateDto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

class ProductServiceTest {

    @Mock
    private ProductMapper productMapper;

    @Mock
    private ProductRepository productRepository;

    @InjectMocks
    private ProductService productService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testProduct() {
        // Arrange
        ProductUpdateDto productUpdateDto = new ProductUpdateDto(1, "Product 1", "Description 1", 10.0, 10);
        ProductDto productDto = new ProductDto(
                1,
                "Product 1",
                "Description 1",
                10.0,
                325.0,
                80000.0,
                10,
                LocalDateTime.now(),
                LocalDateTime.now()
        );
        Product product = new Product("Product 1", "Description 1", 10.0, 100);
        product.setCreatedAt(LocalDateTime.now());
        Mockito.when(productMapper.toProductUpdate(productUpdateDto)).thenReturn(product);
        Mockito.when(productRepository.save(product)).thenReturn(product);
        Mockito.when(productMapper.toProductDto(product)).thenReturn(productDto);

        // Act
        ProductDto result = productService.createProduct(productUpdateDto);

        // Assert
        Assertions.assertEquals(productUpdateDto.name(), result.name());
        Assertions.assertEquals(productUpdateDto.description(), result.description());
        Assertions.assertEquals(productUpdateDto.price_usd(), result.price_usd());
        Assertions.assertEquals(productUpdateDto.stock(), result.stock());
    }
    @Test
    public void should_calculate_price_baht_correctly() {
        // Arrange
        double price_usd = 10.0;
        double expectedPriceBaht = 325.0;

        // Act
        double result = productService.calculatePriceBaht(price_usd);

        // Assert
        Assertions.assertEquals(expectedPriceBaht, result);
    }

    @Test
    public void should_calculate_price_lak_correctly() {
        // Arrange
        double price_usd = 10.0;
        double expectedPriceLak = 80000.0;

        // Act
        double result = productService.calculatePriceLak(price_usd);

        // Assert
        Assertions.assertEquals(expectedPriceLak, result);
    }

}