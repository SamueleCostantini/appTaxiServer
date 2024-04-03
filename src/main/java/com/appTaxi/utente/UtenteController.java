package com.appTaxi.utente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "api/v1/utente") //indica la path della pagina
public class UtenteController {
    private final UtenteService utenteService;

    @Autowired
    public UtenteController(UtenteService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Utente> getUtente() {
        return utenteService.getUtente();

    }
    @PostMapping//gestisce le richieste post dal client
    public void registerNewUtente(@RequestBody Utente utente){
        utenteService.addNewUtente(utente);
    }

    @DeleteMapping(path = "delete/{IDUtente}")
    public void deleteStudent(@PathVariable("IDUtente") Long IDUtente){
        utenteService.deleteUtente(IDUtente);
    }
}