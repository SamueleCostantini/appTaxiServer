package com.appTaxi.passeggero;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "utente/passeggero") //indica la path della pagina
public class PasseggeroController {
    private final PasseggeroService passeggeroService;

    @Autowired
    public PasseggeroController(PasseggeroService passeggeroService) {
        this.passeggeroService = passeggeroService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Passeggero> getPasseggero() {
        return passeggeroService.getPasseggero();

    }
    @CrossOrigin
    @PostMapping(path="login")//gestisce le richieste get dal client
    public Passeggero loginPasseggero(@RequestBody Passeggero passeggero) {

        return passeggeroService.loginPasseggero(passeggero.getEmail(), passeggero.getPassword());

    }
    @CrossOrigin
    @PostMapping//gestisce le richieste post dal client
    public void registerNewPasseggero(@RequestBody Passeggero passeggero){
        passeggeroService.addNewPasseggero(passeggero);
    }

    @DeleteMapping(path = "{IDPasseggero}")
    public void deleteStudent(@PathVariable("IDPasseggero") Long IDPasseggero){
        passeggeroService.deletePasseggero(IDPasseggero);
    }
    @CrossOrigin
    @PutMapping(path = "{IDPasseggero}={attributo}={valore}")
    public void updatePasseggero(@PathVariable("IDPasseggero") Long id, @PathVariable("attributo") String attributo, @PathVariable("valore") String valore){
        passeggeroService.updatePasseggero(id, attributo, valore);
    }
}