package com.octavioi.config;

import com.octavioi.parts.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {


    @Bean
    public Coder2 coder() {
        return new Coder2(desktop());
    } 

    @Bean
    public Coder2 coder2(@Autowired Computer com) { // This will automatically autowire any Computer Objects available
        return new Coder2(com);
    } 

    @Bean(name = "d1") 
    @Scope(value = "prototype")
    @Primary
    public Desktop desktop() {
        return new Desktop();
    }

    @Bean 
    public Laptop laptop() {
        return new Laptop();
    }




    
    
}
