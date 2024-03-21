package com.appTaxi.user;


import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> getUser() {



        return List.of(
                new Utente(
                        1L,
                        "samuele",
                        "costantini",
                        "email@email.com",
                        "12345S",
                        true
                )
        );
    }

}
