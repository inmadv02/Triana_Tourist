package com.salesianostriana.com.Triana_Tourist;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing

public class Triana_TouristApplication {

    public static void main(String[] args) {
        SpringApplication.run(Triana_TouristApplication.class, args);
    }

}
