package com.appTaxi.user;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class StudentCongif {
    CommandLineRunner commandLineRunner(UtenteRepository repository){
        return args -> {
            Utente samuele  = new Utente(
                    1L,
                    "samuele",
                    "costantini",
                    "email@email.com",
                    "12345S",
                    true
            );
            Utente hani  = new Utente(
                    1L,
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
