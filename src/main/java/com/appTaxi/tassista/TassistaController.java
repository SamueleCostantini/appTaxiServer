package com.appTaxi.tassista;

import com.appTaxi.tassista.Tassista;
import com.appTaxi.tassista.TassistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "utente/tassista") //indica la path della pagina
public class TassistaController {
    private final TassistaService utenteService;

    @Autowired
    public TassistaController(TassistaService utenteService) {
        this.utenteService = utenteService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Tassista> getTassista() {
        return utenteService.getTassista();

    }
    @CrossOrigin
    @PostMapping//gestisce le richieste post dal client
    public void registerNewTassista(@RequestBody Tassista utente){
        utenteService.addNewTassista(utente);
    }

    @DeleteMapping(path = "{IDTassista}")
    public void deleteStudent(@PathVariable("IDTassista") Long IDTassista){
        utenteService.deleteTassista(IDTassista);
    }

    @PutMapping(path = "{IDTassista}={attributo}={valore}")
    public void updateTassista(@PathVariable("IDTassista") Long IDTassista, @PathVariable("attributo") String attributo, @PathVariable("valore") String valore){
        utenteService.updateTassista(IDTassista, attributo, valore);
    }
}