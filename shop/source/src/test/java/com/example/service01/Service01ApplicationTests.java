package com.example.service01;

import com.example.service01.product.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.time.LocalDateTime;

class Service01ApplicationTests {

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
		ProductDto productDto = new ProductDto(1, "Product 1", "Description 1", 10.0, 325.0, 80000.0 , 1);
		Product product = new Product("Product 1", "Description 1", 10.0, 100);
		product.setCreatedAt(LocalDateTime.now());
		Mockito.when(productMapper.toProduct(productDto)).thenReturn(product);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Mockito.when(productMapper.toProductDto(product)).thenReturn(productDto);

		// Act
		ProductDto result = productService.createProduct(productDto);

		// Assert
		Assertions.assertEquals(productDto, result);
	}

	@Test
	public void should_calculate_price_baht_correctly() {
		double price_usd = 10.0;
		double expectedPriceBaht = 325.0;

		double result = productService.calculatePriceBaht(price_usd);

		Assertions.assertEquals(expectedPriceBaht, result);
	}

	@Test
	public void should_calculate_price_lak_correctly() {
		double price_usd = 10.0;
		double expectedPriceLak = 80000.0;

		double result = productService.calculatePriceLak(price_usd);

		Assertions.assertEquals(expectedPriceLak, result);
	}

}
