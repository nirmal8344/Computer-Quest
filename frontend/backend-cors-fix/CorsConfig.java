// Drop this file into:
// src/main/java/com/computerquest/computer_quest_backend/config/CorsConfig.java
// (create the "config" package if it doesn't exist yet)
//
// This is additive only — it does not touch any existing controller, service,
// or entity. It simply enables CORS globally so every endpoint (including the
// ones missing @CrossOrigin today, like AuthController, ChapterController,
// GameController, MissionController, PlayerProgressController and
// QuestionController) can be called from the React dev server.
//
// Adjust allowedOrigins if your frontend runs on a different host/port than
// http://localhost:5173 (Vite's default).

package com.computerquest.computer_quest_backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig {

    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurer() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/api/**")
                        .allowedOrigins("http://localhost:5173")
                        .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                        .allowedHeaders("*");
            }
        };
    }
}
