package com.eccomerce_teste.demo.config;

import com.eccomerce_teste.demo.model.Product;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class ProductConsumer {

    @KafkaListener(topics = "product-topic", groupId = "produto-group")
    public void listen(Product product) {
        // Lógica para processar o produto recebido
        System.out.println("Produto recebido: " + product.getName());
    }
}