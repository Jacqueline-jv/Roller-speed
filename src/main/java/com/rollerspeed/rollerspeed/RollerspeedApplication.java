package com.rollerspeed.rollerspeed;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RollerspeedApplication {

    public static void main(String[] args) {
        SpringApplication.run(RollerspeedApplication.class, args);
        System.out.println("🚀 Aplicación RollerSpeed iniciada en http://localhost:8080/");
    }
}
