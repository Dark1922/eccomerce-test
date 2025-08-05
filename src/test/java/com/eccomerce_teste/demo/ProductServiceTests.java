package com.eccomerce_teste.demo;


import com.eccomerce_teste.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import service.ProductService;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ProductServiceTests {

    @Autowired
    private ProductService productService;

    @Test
    public void testCreateProduct() {
        Product product = new Product();
        product.setName("Test Product");
        product.setPrice(10.0);

        Product savedProduct = productService.createProduct(product);
        assertNotNull(savedProduct.getId());
    }
}