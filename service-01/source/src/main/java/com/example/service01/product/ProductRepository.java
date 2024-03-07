package com.example.service01.product;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    Product save(Product product);

    Product update(Integer id, Product product);

    void delete(Integer id);

}
