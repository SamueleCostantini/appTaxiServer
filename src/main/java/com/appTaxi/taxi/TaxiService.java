package com.appTaxi.taxi;


import com.appTaxi.taxi.Taxi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaxiService {

    private final TaxiRepository taxiRepository;

    @Autowired
    public TaxiService(TaxiRepository taxiRepository) {
        this.taxiRepository = taxiRepository;
    }

    public List<Taxi> getTaxi() {
        return taxiRepository.findAll();
    }

    public void addNewTaxi(Taxi taxi) {

        Optional<Taxi> taxiOptional = taxiRepository.findTaxiByTarga(taxi.getTarga());

        if(taxiOptional.isPresent()){
            throw new IllegalStateException("targa in uso");
        }

        taxiRepository.save(taxi);
    }

    public void deleteTaxi(Long IDTaxi) {
        boolean esiste = taxiRepository.existsById(IDTaxi);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDTaxi);
        }

        taxiRepository.deleteById(IDTaxi);
    }

    public void updateTaxi(Long IDTaxi, String attributo, String valore) {
        boolean esiste = taxiRepository.existsById(IDTaxi);
        if(!esiste){
            throw new IllegalStateException("Taxi "+IDTaxi+" non esiste ");
        }
        Optional<Taxi> taxi = taxiRepository.findById(IDTaxi);
        Taxi tx1 = new Taxi();
        tx1 = taxiRepository.getReferenceById(IDTaxi);
        switch(attributo){
            case "IDTaxi":

                /*controlli se id inserito è valido*/
                try {
                    Double.parseDouble(valore);
                } catch (NumberFormatException e) {
                    throw new IllegalStateException("Id non valido");
                }
                esiste = taxiRepository.existsById(Long.valueOf(valore));
                if(esiste){
                    throw new IllegalStateException("Questo id già esiste");
                }
                if(valore.isEmpty()){
                    throw new IllegalStateException("Id non valido");
                }
                /*fine controlli*/

                tx1.setIDTaxi(Long.valueOf(valore));
                break;
            case "targa":

                /*controlli se id inserito è valido*/
                Optional<Taxi> taxiByTarga= taxiRepository.findTaxiByTarga(valore);
                if(taxiByTarga.isPresent()){
                    throw new IllegalStateException("Questa email già esiste");
                }
                if(valore.isEmpty()){
                    throw new IllegalStateException("Email non valida");
                }
                /*fine controlli*/

                tx1.setTarga(valore);
                System.out.println("nuova targa : "+valore);
                break;
           
        }
        taxiRepository.save(tx1);
    }


}
