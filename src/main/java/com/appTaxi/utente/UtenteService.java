package com.appTaxi.utente;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteService {

    private final UtenteRepository utenteRepository;

    @Autowired
    public UtenteService(UtenteRepository utenteRepository) {
        this.utenteRepository = utenteRepository;
    }

    public List<Utente> getUtente() {
        return utenteRepository.findAll();
    }

    public void addNewUtente(Utente utente) {

        Optional<Utente> utenteOptional = utenteRepository.findUtenteByEmail(utente.getEmail());

        if(utenteOptional.isPresent()){
            throw new IllegalStateException("Email in uso");
        }

        utenteRepository.save(utente);
    }

    public void deleteUtente(Long IDUtente) {
        boolean esiste = utenteRepository.existsById(IDUtente);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDUtente);
        }

        utenteRepository.deleteById(IDUtente);
    }

    public void updateUtente(Long IDUtente, String attributo, String valore) {
        boolean esiste = utenteRepository.existsById(IDUtente);
        if(!esiste){
            throw new IllegalStateException("Utente "+IDUtente+" non esiste ");
        }
        Optional<Utente> utente = utenteRepository.findById(IDUtente);
        Utente ut1 = new Utente();
        ut1 = utenteRepository.getReferenceById(IDUtente);
        switch(attributo){
            case "IDUtente":

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

                ut1.setIDUtente(Long.valueOf(valore));
                break;
            case "email":

                /*controlli se id inserito è valido*/
                Optional<Utente> utenteByEmail = utenteRepository.findUtenteByEmail(valore);
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
