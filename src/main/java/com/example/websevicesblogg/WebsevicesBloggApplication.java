package com.example.websevicesblogg;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.authentication.configuration.EnableGlobalAuthentication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class WebsevicesBloggApplication {

    public static void main(String[] args) {
        SpringApplication.run(WebsevicesBloggApplication.class, args);
        System.out.println("Tweet tweet");}

}
