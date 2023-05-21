package com.ensa.ebanking.Config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    private final String clientUrl;

    public CrossOriginConfig(@Value("${client.url}") String clientUrl) {
        this.clientUrl = clientUrl;
    }

    public String getClientUrl() {
        return clientUrl;
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedOrigins(clientUrl);
    }
}