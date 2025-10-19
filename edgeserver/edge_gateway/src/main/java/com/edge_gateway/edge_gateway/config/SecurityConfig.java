package com.edge_gateway.edge_gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;

@Configuration
@EnableWebFluxSecurity

public class SecurityConfig {
    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http) {
        http
            // 1. Deshabilitamos CSRF porque no estamos usando cookies, sino tokens/headers.
            .csrf(csrf -> csrf.disable())

            // 2. Definimos las reglas de autorización
            .authorizeExchange(exchange -> exchange
                // PERMITIMOS el tráfico hacia Eureka para que los servicios se puedan registrar
                .pathMatchers("/eureka/**").permitAll()
                // CUALQUIER OTRA petición debe estar autenticada
                .anyExchange().authenticated()
            )

            // 3. Habilitamos la autenticación básica (HTTP Basic)
            .httpBasic(Customizer.withDefaults());

        return http.build();
    }
}
