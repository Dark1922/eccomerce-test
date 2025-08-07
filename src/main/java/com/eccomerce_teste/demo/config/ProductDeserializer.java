package com.eccomerce_teste.demo.config;

import com.eccomerce_teste.demo.model.Product;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.kafka.common.serialization.Deserializer;

import java.io.IOException;
import java.util.Map;

public class ProductDeserializer implements Deserializer<Product> {
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {}

    @Override
    public Product deserialize(String topic, byte[] data) {
        try {
            return objectMapper.readValue(data, Product.class);
        } catch (IOException e) {
            throw new RuntimeException("Error deserializing Product", e);
        }
    }

    @Override
    public void close() {}
}