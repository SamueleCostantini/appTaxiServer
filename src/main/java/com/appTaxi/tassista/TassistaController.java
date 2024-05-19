package com.appTaxi.tassista;

import com.appTaxi.passeggero.Passeggero;
import com.appTaxi.tassista.Tassista;
import com.appTaxi.tassista.TassistaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "utente/tassista") //indica la path della pagina
public class TassistaController {
    private final TassistaService tassistaService;

    @Autowired
    public TassistaController(TassistaService utenteService) {
        this.tassistaService = utenteService;
    }
    @CrossOrigin
    @GetMapping(path="{idtassista}")
    public Optional<Tassista> getTassistaById(@PathVariable("idtassista") Long id){
        Optional<Tassista> tassista = tassistaService.getTassistaById(id);
        System.out.println(tassista.toString());
        return tassista;
    }
    @GetMapping //gestisce le richieste get dal client
    public List<Tassista> getTassista() {
        return tassistaService.getTassista();

    }
    @CrossOrigin
    @PostMapping(path="login")//gestisce le richieste get dal client
    public Tassista loginTassista(@RequestBody Tassista tassista) {

        return tassistaService.loginPasseggero(tassista.getEmail(), tassista.getPassword());

    }
    @CrossOrigin
    @PostMapping//gestisce le richieste post dal client
    public void registerNewTassista(@RequestBody Tassista utente){
        tassistaService.addNewTassista(utente);
    }

    @DeleteMapping(path = "{IDTassista}")
    public void deleteStudent(@PathVariable("IDTassista") Long IDTassista){
        tassistaService.deleteTassista(IDTassista);
    }
    @CrossOrigin
    @PutMapping(path = "{IDTassista}={attributo}={valore}")
    public void updateTassista(@PathVariable("IDTassista") Long IDTassista, @PathVariable("attributo") String attributo, @PathVariable("valore") String valore){
        tassistaService.updateTassista(IDTassista, attributo, valore);
    }
}