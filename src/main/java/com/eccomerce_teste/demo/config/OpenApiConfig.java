package com.eccomerce_teste.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("E-commerce API")
                        .version("1.0.0")
                        .description("Documentação da API do sistema de E-commerce"))
                .addServersItem(new Server()
                        .url("http://localhost:8080")
                        .description("Servidor local"))
                .addServersItem(new Server()
                        .url("https://api.seudominio.com")
                        .description("Servidor de produção"));
    }
}