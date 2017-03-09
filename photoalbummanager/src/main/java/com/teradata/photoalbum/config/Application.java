package com.teradata.photoalbum.config;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication
@ComponentScan(basePackages = {"com.teradata.photoalbum.controller","com.teradata.photoalbum.model","com.teradata.photoalbum.utils","com.teradata.photoalbum.dao","com.teradata.photoalbum.config","com.teradata.photoalbum.service"})
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
