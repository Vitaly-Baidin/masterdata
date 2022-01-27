package ru.vitaly.baidin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {
    public static void main(String[] args) {
        // Dependency Injection
        SpringApplication.run(Application.class, args);
    }
}
