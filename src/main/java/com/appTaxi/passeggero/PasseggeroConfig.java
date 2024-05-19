package com.appTaxi.passeggero;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class PasseggeroConfig {
    @Bean
    CommandLineRunner commandLineRunnerTassista(PasseggeroRepository repository){
        return args -> {
            Passeggero samuele  = new Passeggero(
                    "samuele",
                    "costantini",
                    "samu@samu.it",
                    "12345S",
                    true
            );
            Passeggero hani  = new Passeggero(
                    "hani",
                    "belal",
                    "email@email.com",
                    "12345S",
                    true
            );

            repository.saveAll(
                    List.of(samuele, hani)
            );
        };
    }
}
