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
                    "Mario",
                    "Rossi",
                    "mario@gmail.com",
                    "12345678",
                    true
            );
            Passeggero hani  = new Passeggero(
                    "Giovanni",
                    "Verdi",
                    "giovanni@gmail.com",
                    "12345678",
                    true
            );

            repository.saveAll(
                    List.of(samuele, hani)
            );
        };
    }
}
