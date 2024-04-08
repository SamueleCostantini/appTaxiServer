package com.appTaxi.tassista;


import com.appTaxi.tassista.Tassista;
import com.appTaxi.tassista.TassistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TassistaService {

    private final com.appTaxi.tassista.TassistaRepository utenteRepository;

    @Autowired
    public TassistaService(TassistaRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<com.appTaxi.tassista.Tassista> getTassista() {
        return utenteRepository.findAll();
    }

    public void addNewTassista(com.appTaxi.tassista.Tassista utente) {

        Optional<com.appTaxi.tassista.Tassista> utenteOptional = utenteRepository.findTassistaByEmail(utente.getEmail());

        if(utenteOptional.isPresent()){
            throw new IllegalStateException("Email in uso");
        }

        utenteRepository.save(utente);
    }

    public void deleteTassista(Long IDTassista) {
        boolean esiste = utenteRepository.existsById(IDTassista);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDTassista);
        }

        utenteRepository.deleteById(IDTassista);
    }

    public void updateTassista(Long IDTassista, String attributo, String valore) {
        boolean esiste = utenteRepository.existsById(IDTassista);
        if(!esiste){
            throw new IllegalStateException("Tassista "+IDTassista+" non esiste ");
        }
        Optional<com.appTaxi.tassista.Tassista> utente = utenteRepository.findById(IDTassista);
        com.appTaxi.tassista.Tassista ut1 = new com.appTaxi.tassista.Tassista();
        ut1 = utenteRepository.getReferenceById(IDTassista);
        switch(attributo){
            case "IDTassista":

                /*controlli se id inserito è valido*/
                try {
                    Double.parseDouble(valore);
                } catch (NumberFormatException e) {
                    throw new IllegalStateException("Id non valido");
                }
                esiste = utenteRepository.existsById(Long.valueOf(valore));
                if(esiste){
                    throw new IllegalStateException("Questo id già esiste");
                }
                if(valore.isEmpty()){
                    throw new IllegalStateException("Id non valido");
                }
                /*fine controlli*/

                ut1.setIDTassista(Long.valueOf(valore));
                break;
            case "email":

                /*controlli se id inserito è valido*/
                Optional<Tassista> utenteByEmail = utenteRepository.findTassistaByEmail(valore);
                if(utenteByEmail.isPresent()){
                    throw new IllegalStateException("Questa email già esiste");
                }
                if(valore.isEmpty()){
                    throw new IllegalStateException("Email non valida");
                }
                /*fine controlli*/

                ut1.setEmail(valore);
                System.out.println("nuova email : "+valore);
                break;
            case "name":
                if(valore.isEmpty()){
                    throw new IllegalStateException("Email non valida");
                }
                ut1.setName(valore);
                break;
            case "surname":
                if(valore.isEmpty()){
                    throw new IllegalStateException("cognome non valida");
                }
                ut1.setSurname(valore);
                break;
            case "password":

                /*implementare parametri password*/

                if(valore.isEmpty()){
                    throw new IllegalStateException("password non valida");
                }
                ut1.setPassword(valore);
                break;
        }
        utenteRepository.save(ut1);
    }
}
