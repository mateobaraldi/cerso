package com.example.studentsapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsConfig implements WebMvcConfigurer {
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/api/**")
                .allowedOrigins( "https://cerso-2.onrender.com/api/students", "http://127.0.0.1:5500")
                .allowedMethods("GET", "POST", "PUT", "DELETE");
    }
}
