package service;

import com.eccomerce_teste.demo.model.Product;
import com.eccomerce_teste.demo.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        // Aqui você pode adicionar regras de negócio antes de salvar
        return productRepository.save(product);
    }
}