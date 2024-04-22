package com.appTaxi.prenotazione;

import com.appTaxi.passeggero.Passeggero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "prenotazione") //indica la path della pagina
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;

    @Auto
    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Passeggero> getPasseggero() {
        return prenotazioneService.getPasseggero();

    }
    @CrossOrigin
    @PostMapping(path="login")//gestisce le richieste get dal client
    public Passeggero loginPasseggero(@RequestBody Passeggero passeggero) {

        return prenotazioneService.loginPasseggero(passeggero.getEmail(), passeggero.getPassword());

    }
    @CrossOrigin
    @PostMapping//gestisce le richieste post dal client
    public void registerNewPasseggero(@RequestBody Passeggero passeggero){
        prenotazioneService.addNewPasseggero(passeggero);
    }

    @DeleteMapping(path = "{IDPasseggero}")
    public void deleteStudent(@PathVariable("IDPasseggero") Long IDPasseggero){
        prenotazioneService.deletePasseggero(IDPasseggero);
    }
    @CrossOrigin
    @PutMapping(path = "{IDPasseggero}={attributo}={valore}")
    public void updatePasseggero(@PathVariable("IDPasseggero") String email, @PathVariable("attributo") String attributo, @PathVariable("valore") String valore){
        prenotazioneService.updatePasseggero(email, attributo, valore);
    }
}