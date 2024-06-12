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

    public List<Prenotazione> getPrenotazione() {
        return prenotazioneRepository.findAll();
    }
    public List<Prenotazione> getPrenotazioneByPass(Long idPasseggero){
        List<Prenotazione> PrenotazioniPass = prenotazioneRepository.findPrenotazioneByIdPasseggero(idPasseggero);
        return PrenotazioniPass;
    }
    public Prenotazione getPrenotazioneById(Long idPrenotazione){
        Optional<Prenotazione> prenotazione = prenotazioneRepository.findById(idPrenotazione);
        return prenotazione.get();
    }
    public List<Prenotazione> getPrenotazioneByTass(Long idTassista){
        List<Prenotazione> PrenotazioniTass = prenotazioneRepository.findPrenotazioneByIdTassista(idTassista);
        return PrenotazioniTass;
    }
    public void addNewPrenotazione(Prenotazione prenotazione) {

        prenotazioneRepository.save(prenotazione);
    }

    public void deletePrenotazione(Long IDPrenotazione) {
        boolean esiste = prenotazioneRepository.existsById(IDPrenotazione);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDPrenotazione);
        }

        prenotazioneRepository.deleteById(IDPrenotazione);
    }

    public void updatePrenotazione(Long id, String attributo, String valore) {
        Optional<Prenotazione> passeggeroOptional = prenotazioneRepository.findById(id);
        if(passeggeroOptional.isEmpty()){
            throw new IllegalStateException("Prenotazione non esiste ");
        }
        long IDPrenotazione = passeggeroOptional.get().getId();
        Prenotazione ut1 = new Prenotazione();
        ut1 = prenotazioneRepository.getReferenceById(IDPrenotazione);
        boolean esiste = true;
        switch(attributo){
            case "id":

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

                ut1.setId(Long.valueOf(valore));
                break;
            case "":

                /*controlli se id inserito è valido
                Optional<Passeggero> passeggeroByEmail = prenotazioneRepository.findById();
                if(passeggeroByEmail.isPresent()){
                    throw new IllegalStateException("Questa email già esiste");
                }
                if(valore.isEmpty()){
                    throw new IllegalStateException("Email non valida");
                }
                /*fine controlli

                ut1.setEmail(valore);
                System.out.println("nuova email : "+valore);*/
                break;
            case "name":
//                if(valore.isEmpty()){
//                    throw new IllegalStateException("Email non valida");
//                }
//                ut1.setName(valore);
                break;
            case "surname":
//                if(valore.isEmpty()){
//                    throw new IllegalStateException("cognome non valida");
//                }
//                ut1.setSurname(valore);
                break;
            case "password":

//                /*implementare parametri password*/
//
//                if(valore.isEmpty()){
//                    throw new IllegalStateException("password non valida");
//                }
//                ut1.setPassword(valore);
                break;
            case "stato":

                /*implementare parametri password*/

                if(valore.isEmpty()){
                    throw new IllegalStateException("stato non valido");
                }
                ut1.setStato(valore);
                break;
        }
        prenotazioneRepository.save(ut1);
    }
}
