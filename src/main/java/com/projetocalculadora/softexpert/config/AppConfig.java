package com.projetocalculadora.softexpert.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.projetocalculadora.softexpert.domain.RetornoCalculo;

@Configuration
public class AppConfig {


    @Bean
    public RetornoCalculo retornoCalculo() {
        return new RetornoCalculo();
    }
}
