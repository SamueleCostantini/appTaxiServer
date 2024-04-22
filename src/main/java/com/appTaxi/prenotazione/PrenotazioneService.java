package com.appTaxi.prenotazione;


import com.appTaxi.passeggero.Passeggero;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class PrenotazioneService {

    private final PrenotazioneRepository prenotazioneRepository;

    @Autowired
    public PrenotazioneService(PrenotazioneRepository prenotazioneRepository) {
        this.prenotazioneRepository = prenotazioneRepository;
    }

    public List<Passeggero> getPasseggero() {
        return prenotazioneRepository.findAll();
    }

    public void addNewPasseggero(Passeggero passeggero) {

        Optional<Passeggero> passeggeroOptional = prenotazioneRepository.findPasseggeroByEmail(passeggero.getEmail());

        if(passeggeroOptional.isPresent()){
            throw new IllegalStateException("Email in uso");
        }

        prenotazioneRepository.save(passeggero);
    }

    public Passeggero loginPasseggero(String email, String password){
        Optional<Passeggero> passeggeroOptional = prenotazioneRepository.findPasseggeroByEmail(email);
        if(passeggeroOptional.isEmpty()){
            throw new IllegalStateException("Email non esistente");
        }

        if(!Objects.equals(passeggeroOptional.get().getPassword(), password)){
            throw new IllegalStateException("Password errata");
        }


        return passeggeroOptional.get();

    }

    public void deletePasseggero(Long IDPasseggero) {
        boolean esiste = prenotazioneRepository.existsById(IDPasseggero);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDPasseggero);
        }

        prenotazioneRepository.deleteById(IDPasseggero);
    }

    public void updatePasseggero(String email, String attributo, String valore) {
        Optional<Passeggero> passeggeroOptional = prenotazioneRepository.findPasseggeroByEmail(email);
        if(passeggeroOptional.isEmpty()){
            throw new IllegalStateException("Passeggero "+email+" non esiste ");
        }
        long IDPasseggero = passeggeroOptional.get().getIDPasseggero();
        Passeggero ut1 = new Passeggero();
        ut1 = prenotazioneRepository.getReferenceById(IDPasseggero);
        boolean esiste = true;
        switch(attributo){
            case "IDPasseggero":

                /*controlli se id inserito è valido*/
                try {
                    Double.parseDouble(valore);
                } catch (NumberFormatException e) {
                    throw new IllegalStateException("Id non valido");
                }
                esiste = prenotazioneRepository.existsById(Long.valueOf(valore));
                if(esiste){
                    throw new IllegalStateException("Questo id già esiste");
                }
                if(valore.isEmpty()){
                    throw new IllegalStateException("Id non valido");
                }
                /*fine controlli*/

                ut1.setIDPasseggero(Long.valueOf(valore));
                break;
            case "email":

                /*controlli se id inserito è valido*/
                Optional<Passeggero> passeggeroByEmail = prenotazioneRepository.findPasseggeroByEmail(valore);
                if(passeggeroByEmail.isPresent()){
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
            case "stato":

                /*implementare parametri password*/

                if(valore.isEmpty()){
                    throw new IllegalStateException("stato non valida");
                }
                ut1.setStato(valore);
                break;
        }
        prenotazioneRepository.save(ut1);
    }
}
