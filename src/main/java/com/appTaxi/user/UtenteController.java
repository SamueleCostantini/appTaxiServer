package com.appTaxi.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "api/v1/user") //indica la path della pagina
public class UtenteController {
    private final UtenteService utenteService;

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Utente> getUser() {
        return utenteService.getUser();

    }
    @PostMapping//gestisce le richieste post dal client
    public void registerNewUtente(@RequestBody Utente utente){
        utenteService.addNewUtente(utente);
    }
}