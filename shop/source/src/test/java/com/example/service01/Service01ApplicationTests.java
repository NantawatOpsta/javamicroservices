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
	public void testCreateProduct() {
		ProductDto productDto = new ProductDto(1, "Product 1", "Description 1", 10.0, 100);
		Product product = new Product("Product 1", "Description 1", 10.0, 100);
		product.setCreatedAt(LocalDateTime.now());
		Mockito.when(productMapper.toProduct(productDto)).thenReturn(product);
		Mockito.when(productRepository.save(product)).thenReturn(product);
		Mockito.when(productMapper.toProductDto(product)).thenReturn(productDto);

		ProductDto result = productService.createProduct(productDto);
		Assertions.assertEquals(productDto, result);
	}

}
