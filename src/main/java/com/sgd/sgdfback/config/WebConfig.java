package com.sgd.sgdfback.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(@SuppressWarnings("null") CorsRegistry registry) {
        registry.addMapping("/**")
                //.allowedOrigins("http://localhost:5173")
                .allowedOrigins("*")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS", "PATCH")
                //.allowedHeaders("Authorization")
                .allowedHeaders("*")
                .allowCredentials(false);
    }
    //.allowedHeaders("Content-Type", "Authorization")
}