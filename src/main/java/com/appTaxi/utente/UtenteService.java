package com.appTaxi.utente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> getUtente() {
        return utenteRepository.findAll();
    }

    public void addNewUtente(Utente utente) {

        Optional<Utente> utenteOptional = utenteRepository.findUtenteByEmail(utente.getEmail());

        if(utenteOptional.isPresent()){
            throw new IllegalStateException("Email in uso");
        }

        utenteRepository.save(utente);
    }
}
