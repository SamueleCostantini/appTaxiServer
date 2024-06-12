package com.appTaxi.prenotazione;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "prenotazione") //indica la path della pagina
public class PrenotazioneController {
    private final PrenotazioneService prenotazioneService;

    @Autowired
    public PrenotazioneController(PrenotazioneService prenotazioneService) {
        this.prenotazioneService = prenotazioneService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Prenotazione> getPrenotazione() {
        return prenotazioneService.getPrenotazione();

    }
    @GetMapping(path = "{idpasseggero}") //gestisce le richieste get dal client
    public List<Prenotazione> getPrenotazione(@PathVariable("idpasseggero") Long idPasseggero) {
        return prenotazioneService.getPrenotazioneByPass(idPasseggero);

    }

    @GetMapping(path = "id/{idprenotazione}") //gestisce le richieste get dal client
    public Prenotazione getPrenotazioneById(@PathVariable("idprenotazione") Long idPrenotazione) {
        return prenotazioneService.getPrenotazioneById(idPrenotazione);

    }

    @GetMapping(path = "tassista={idtassista}") //gestisce le richieste get dal client
    public List<Prenotazione> getPrenotazioneByTassista(@PathVariable("idtassista") Long idtassista) {
        return prenotazioneService.getPrenotazioneByTass(idtassista);

    }
    @CrossOrigin
    @PostMapping//gestisce le richieste post dal client
    public void registerNewPrenotazione(@RequestBody Prenotazione prenotazione){

        prenotazioneService.addNewPrenotazione(prenotazione);
    }
    @CrossOrigin
    @DeleteMapping(path = "{IDPrenotazione}")
    public void deletePrenotazione(@PathVariable("IDPrenotazione") Long IDPrenotazione){
        prenotazioneService.deletePrenotazione(IDPrenotazione);
    }
    @CrossOrigin
    @PutMapping(path = "{IDPrenotazione}={attributo}={valore}")
    public void updatePrenotazione(@PathVariable("IDPrenotazione") Long id, @PathVariable("attributo") String attributo, @PathVariable("valore") String valore){
        prenotazioneService.updatePrenotazione(id, attributo, valore);
    }
}