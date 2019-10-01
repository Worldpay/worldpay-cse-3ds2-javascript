package com.worldpay.poc.dragonspay.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class CORSFilter {

    @Bean
    public WebMvcConfigurer corsConfigurer() {

        return new WebMvcConfigurerAdapter() {

            @Override
            public void addCorsMappings(CorsRegistry registry) {

                registry.addMapping("/**")
                        .allowedOrigins("*")
                        .allowedMethods("*")
                        .allowedHeaders("*")
                        .exposedHeaders("X-PINGOTHER", "Content-Type", "X-Requested-With", "Accept", "Origin", "Access-Control-Request-Method", "Access-Control-Request-Headers", "Authorization", "Access-Control-Allow-Origin")
                        .allowCredentials(false).maxAge(3600);
            }

        };
    }
}