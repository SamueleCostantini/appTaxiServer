package com.appTaxi.tassista;

import com.appTaxi.passeggero.Passeggero;
import com.appTaxi.passeggero.PasseggeroRepository;
import com.appTaxi.tassista.Tassista;
import com.appTaxi.tassista.TassistaRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TassistaConfig {
    @Bean
    CommandLineRunner commandLineRunner(TassistaRepository repository){
        return args -> {
            Tassista samuele  = new Tassista(
                    "Samuele",
                    "Costantini",
                    "samutaxi@gmail.com",
                    "12345678",
                    true,
                    "AA222AA"
            );
            Tassista hani  = new Tassista(
                    "Hani",
                    "Belal",
                    "hanitaxi@gmail.com",
                    "12345678",
                    true,
                    "AB232BA"
            );

            repository.saveAll(
                    List.of(samuele, hani)
            );
        };
    }
}
