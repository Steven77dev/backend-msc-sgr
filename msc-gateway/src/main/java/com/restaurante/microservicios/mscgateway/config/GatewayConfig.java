package com.restaurante.microservicios.mscgateway.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("swagger-personal", r -> r.path("/swagger/personal/**") // Ruta de Swagger para msc-personal
                        .filters(f -> f.rewritePath("/swagger/personal/(?<segment>.*)", "/${segment}") // Redirecciona la ruta de Swagger
                                .addResponseHeader("X-Frame-Options", "SAMEORIGIN") // Opcional: Agrega cabecera X-Frame-Options
                                .stripPrefix(2)) // Elimina el prefijo /swagger/personal
                        .uri("lb://msc-personal") // Nombre del servicio registrado en Eureka para msc-personal
                )
                .route("swagger-persona", r -> r.path("/swagger/persona/**") // Ruta de Swagger para msc-persona
                        .filters(f -> f.rewritePath("/swagger/persona/(?<segment>.*)", "/${segment}") // Redirecciona la ruta de Swagger
                                .addResponseHeader("X-Frame-Options", "SAMEORIGIN") // Opcional: Agrega cabecera X-Frame-Options
                                .stripPrefix(2)) // Elimina el prefijo /swagger/persona
                        .uri("lb://msc-persona") // Nombre del servicio registrado en Eureka para msc-persona
                )
                .build();
    }
}