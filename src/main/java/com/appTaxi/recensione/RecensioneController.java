package com.appTaxi.recensione;

import com.appTaxi.recensione.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "recensione") //indica la path della pagina
public class RecensioneController {
    private final RecensioneService recensioneService;

    @Autowired
    public RecensioneController(RecensioneService recensioneService) {
        this.recensioneService = recensioneService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Recensione> getRecensione() {
        return recensioneService.getRecensione();
    }
    @PostMapping//gestisce le richieste post dal client
    public void registerNewRecensione(@RequestBody Recensione recensione){
        recensioneService.addNewRecensione(recensione);
    }

    @DeleteMapping(path = "{IDRecensione}")
    public void deleteStudent(@PathVariable("IDRecensione") Long IDRecensione){
        recensioneService.deleteRecensione(IDRecensione);
    }

    @PutMapping(path = "{IDRecensione}={attributo}={valore}")
    public void updateRecensione(@PathVariable("IDRecensione") Long IDRecensione, @PathVariable("attributo") String attributo, @PathVariable("valore") String valore){
        recensioneService.updateRecensione(IDRecensione, attributo, valore);
    }
}