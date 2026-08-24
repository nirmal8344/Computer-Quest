package com.computerquest.computer_quest_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Value("${allowed.origins:*}")
    private String allowedOrigins = "*";

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        String[] origins = (allowedOrigins != null && !allowedOrigins.trim().isEmpty())
                ? allowedOrigins.split(",")
                : new String[]{"*"};

        registry.addMapping("/**")
                .allowedOriginPatterns(origins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                .allowedHeaders("*")
                .allowCredentials(false)
                .maxAge(3600);
    }
}
