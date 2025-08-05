package com.eccomerce_teste.demo.config;

import com.eccomerce_teste.demo.model.Product;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Serializer;

import java.util.Map;

public class ProductSerializer implements Serializer<Product> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public byte[] serialize(String topic, Product product) {
        try {
            return objectMapper.writeValueAsBytes(product);
        } catch (JsonProcessingException e) {
            throw new RuntimeException("Error serializing Product", e);
        }
    }

    @Override
    public void close() {}
}