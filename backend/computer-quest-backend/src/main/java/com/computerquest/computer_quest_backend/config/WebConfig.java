package com.computerquest.computer_quest_backend.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    // WebMvcConfigurer extensions can be placed here.
    // CORS configuration is centralized in CorsConfig.java.
}
