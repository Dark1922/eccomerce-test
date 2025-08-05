package service;

import com.eccomerce_teste.demo.model.Product;
import com.eccomerce_teste.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private KafkaTemplate<String, Product> kafkaTemplate;

    @Cacheable("products")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        Product savedProduct = productRepository.save(product);
        sendProductEvent(savedProduct);
        return savedProduct;
    }

    private void sendProductEvent(Product product) {
        kafkaTemplate.send("product-topic", product);
    }
}