package com.ndroid.backend.config;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class CorsConfig {

    @Bean
    CorsConfigurationSource corsConfigurationSource(
            @Value("${app.cors.allowed-origins:http://localhost:3000}") String allowedOrigins,
            @Value("${app.frontend-url:http://localhost:3000}") String frontendUrl) {
        CorsConfiguration config = new CorsConfiguration();
        List<String> origins = new ArrayList<>(Arrays.stream((allowedOrigins == null ? "" : allowedOrigins).split(","))
                .map(String::trim)
                .filter(s -> !s.isEmpty())
                .toList());
        if (frontendUrl != null && !frontendUrl.isBlank() && origins.stream().noneMatch(frontendUrl::equalsIgnoreCase)) {
            origins.add(frontendUrl.trim());
        }

        config.setAllowedOrigins(origins);
        config.setAllowedMethods(List.of("GET", "POST", "PUT", "PATCH", "DELETE", "OPTIONS"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
