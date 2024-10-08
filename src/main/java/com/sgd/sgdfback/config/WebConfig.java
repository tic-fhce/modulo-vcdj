package com.sgd.sgdfback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**")
                // .allowedOrigins("http://192.168.0.10:5173")
                .allowedOrigins("http://localhost:5173")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                //.allowedHeaders("Authorization")
                .allowedHeaders("*")
                .allowCredentials(true);
    }
    //.allowedHeaders("Content-Type", "Authorization")
}