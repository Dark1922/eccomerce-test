package com.eccomerce_teste.demo;


import com.eccomerce_teste.demo.model.Product;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.eccomerce_teste.demo.service.ProductService;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(properties = {
        "spring.data.redis.repositories.enabled=false",
        "spring.redis.enabled=false",
        "spring.cache.type=none"
})
@ActiveProfiles("test")
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