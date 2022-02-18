package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "com.example.backend")
@EnableJpaRepositories(basePackages = "com.example.backend.database")
@EntityScan(basePackages = "com.example.backend.database")
@ComponentScan(basePackages = "com.example.backend.web.MesRest")
@ImportResource("classpath*:Beans.xml")
public class Beginner {
    public static void main(String[] args){
        SpringApplication.run(Beginner.class, args);
    }
}
