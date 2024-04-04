package com.appTaxi.recensione;


import com.appTaxi.recensione.Recensione;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecensioneService {

    private final RecensioneRepository recensioneRepository;

    @Autowired
    public RecensioneService(RecensioneRepository recensioneRepository) {
        this.recensioneRepository = recensioneRepository;
    }

    public List<Recensione> getRecensione() {
        return recensioneRepository.findAll();
    }

    public void addNewRecensione(Recensione recensione) {

        Optional<Recensione> recensioneOptional = recensioneRepository.findRecensioneByTarga(recensione.getTarga());

        if(recensioneOptional.isPresent()){
            throw new IllegalStateException("targa in uso");
        }

        recensioneRepository.save(recensione);
    }

    public void deleteRecensione(Long IDRecensione) {
        boolean esiste = recensioneRepository.existsById(IDRecensione);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDRecensione);
        }

        recensioneRepository.deleteById(IDRecensione);
    }

    public void updateRecensione(Long IDRecensione, String attributo, String valore) {
        boolean esiste = recensioneRepository.existsById(IDRecensione);
        if(!esiste){
            throw new IllegalStateException("Recensione "+IDRecensione+" non esiste ");
        }
        /* da finire */

    }


}
