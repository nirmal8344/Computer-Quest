package com.computerquest.computer_quest_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class CorsConfig {

    @Value("${allowed.origins:http://localhost:5173,http://localhost:4173,http://localhost:3000}")
    private String allowedOrigins;

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                List<String> originsList = new ArrayList<>();
                // Local development origins
                originsList.add("http://localhost:*");
                originsList.add("http://127.0.0.1:*");

                if (allowedOrigins != null && !allowedOrigins.trim().isEmpty()) {
                    String[] origins = allowedOrigins.split(",");
                    for (String origin : origins) {
                        String trimmed = origin.trim();
                        if (!trimmed.isEmpty() && !originsList.contains(trimmed)) {
                            originsList.add(trimmed);
                        }
                    }
                }

                registry.addMapping("/**")
                        .allowedOriginPatterns(originsList.toArray(new String[0]))
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                        .allowedHeaders("*")
                        .allowCredentials(true);
            }
        };
    }
}
