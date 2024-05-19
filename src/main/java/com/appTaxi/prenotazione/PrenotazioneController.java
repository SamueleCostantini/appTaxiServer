package com.appTaxi.prenotazione;

import com.appTaxi.passeggero.Passeggero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

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
    @GetMapping(path = "tassista={idtassista}") //gestisce le richieste get dal client
    public List<Prenotazione> getPrenotazioneByTassista(@PathVariable("idtassista") Long idtassista) {
        return prenotazioneService.getPrenotazioneByTass(idtassista);

    }
    @CrossOrigin
    @PostMapping//gestisce le richieste post dal client
    public void registerNewPrenotazione(@RequestBody Prenotazione prenotazione){

        prenotazioneService.addNewPrenotazione(prenotazione);
    }

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