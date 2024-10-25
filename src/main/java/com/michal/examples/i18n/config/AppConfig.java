package com.michal.examples.i18n.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.module.paramnames.ParameterNamesModule;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;


/**
 * @author Michal Remis
 */
@Configuration
public class AppConfig {

    @Bean
    public RestClient restTemplate(RestTemplateBuilder builder) {
        return RestClient.create(builder.build());
    }

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper()
                .registerModule(new ParameterNamesModule());
    }
}
