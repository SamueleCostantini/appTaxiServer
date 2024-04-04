package com.appTaxi.taxi;

import com.appTaxi.taxi.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
*  risorse per api
* */
//controlla l'interazione con il web client
@RestController
@RequestMapping(path = "taxi") //indica la path della pagina
public class TaxiController {
    private final TaxiService taxiService;

    @Autowired
    public TaxiController(TaxiService taxiService) {
        this.taxiService = taxiService;
    }

    @GetMapping //gestisce le richieste get dal client
    public List<Taxi> getTaxi() {
        return taxiService.getTaxi();
    }
    @PostMapping//gestisce le richieste post dal client
    public void registerNewTaxi(@RequestBody Taxi taxi){
        taxiService.addNewTaxi(taxi);
    }

    @DeleteMapping(path = "{IDTaxi}")
    public void deleteStudent(@PathVariable("IDTaxi") Long IDTaxi){
        taxiService.deleteTaxi(IDTaxi);
    }

    @PutMapping(path = "{IDTaxi}={attributo}={valore}")
    public void updateTaxi(@PathVariable("IDTaxi") Long IDTaxi, @PathVariable("attributo") String attributo, @PathVariable("valore") String valore){
        taxiService.updateTaxi(IDTaxi, attributo, valore);
    }
}