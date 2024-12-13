package com.example.gatewayservice;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator gatewayRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("client-service", r -> r.path("/clients/**")
                        .uri("http://localhost:8081/")) // Microservice Client

                .route("product-service", r -> r.path("/produits/**")
                        .uri("http://localhost:8082/")) // Microservice Produit

                .route("fournisseur-service", r -> r.path("/fournisseurs/**")
                        .uri("http://localhost:8083/")) // Microservice Fournisseur
                .build();
    }
}
