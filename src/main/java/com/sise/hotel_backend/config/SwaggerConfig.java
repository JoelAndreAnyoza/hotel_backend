package com.sise.hotel_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

@Configuration
public class SwaggerConfig {
    
    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
            .info(new Info()
            .title("API - Hotel Backend")
            .version("1.0")
            .description("Documentación de la API del Sistema de Gestión de Reserva de habitaciones de hotel"));
    }
}
