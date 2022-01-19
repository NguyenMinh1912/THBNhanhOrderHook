package com.thbrabbitserver.thbrabbitmqserver.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.amqp.core.DirectExchange;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("nhanh");
    }


    @Bean
    public ObjectWriter objectWriter(){
        return new ObjectMapper().writer();
    }

}
