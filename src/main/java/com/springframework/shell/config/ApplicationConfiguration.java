package com.springframework.shell.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;

@Configuration
public class ApplicationConfiguration {

    @Bean
    public RestClient restClient(@Value("${review.service.url}") String endPointUrl){
        return RestClient
                .builder()
                .baseUrl(endPointUrl)
                .build();
    }
}
