package com.appTaxi.tassista;


import com.appTaxi.passeggero.Passeggero;
import com.appTaxi.tassista.Tassista;
import com.appTaxi.tassista.TassistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class TassistaService {

    private final com.appTaxi.tassista.TassistaRepository tassistaRepository;

    @Autowired
    public TassistaService(TassistaRepository utenteRepository) {
        this.tassistaRepository = utenteRepository;
    }

    public List<com.appTaxi.tassista.Tassista> getTassista() {
        return tassistaRepository.findAll();
    }
    public Optional<Tassista> getTassistaById(Long id){
        boolean exist = tassistaRepository.existsById(id);
        if(!exist){
            throw new IllegalStateException("Tassista non esiste");
        }
        Optional<Tassista> tassista = tassistaRepository.findById(id);
        return tassista;
    }
    public void addNewTassista(com.appTaxi.tassista.Tassista utente) {

        Optional<com.appTaxi.tassista.Tassista> utenteOptional = tassistaRepository.findTassistaByEmail(utente.getEmail());

        if(utenteOptional.isPresent()){
            throw new IllegalStateException("Email in uso");
        }

        tassistaRepository.save(utente);
    }

    public void deleteTassista(Long IDTassista) {
        boolean esiste = tassistaRepository.existsById(IDTassista);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDTassista);
        }

        tassistaRepository.deleteById(IDTassista);
    }

    public void updateTassista(Long IDTassista, String attributo, String valore) {
        boolean esiste = tassistaRepository.existsById(IDTassista);
        if(!esiste){
            throw new IllegalStateException("Tassista "+IDTassista+" non esiste ");
        }
        Optional<com.appTaxi.tassista.Tassista> utente = tassistaRepository.findById(IDTassista);
        com.appTaxi.tassista.Tassista ut1 = new com.appTaxi.tassista.Tassista();
        ut1 = tassistaRepository.getReferenceById(IDTassista);
        switch(attributo){
            case "IDTassista":

                /*controlli se id inserito è valido*/
                try {
                    Double.parseDouble(valore);
                } catch (NumberFormatException e) {
                    throw new IllegalStateException("Id non valido");
                }
                esiste = tassistaRepository.existsById(Long.valueOf(valore));
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
                Optional<Tassista> utenteByEmail = tassistaRepository.findTassistaByEmail(valore);
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
            case "lat":

                /*implementare parametri password*/

                if(valore.isEmpty()){
                    throw new IllegalStateException("stato non valida");
                }
                ut1.setLat(Double.parseDouble(valore));
                break;
            case "lng":

                /*implementare parametri password*/

                if(valore.isEmpty()){
                    throw new IllegalStateException("stato non valida");
                }
                ut1.setLng(Double.parseDouble(valore));
                break;
        }
        tassistaRepository.save(ut1);
    }
    public Tassista loginPasseggero(String email, String password){
        Optional<Tassista> tassistaOptional = tassistaRepository.findTassistaByEmail(email);
        if(tassistaOptional.isEmpty()){
            throw new IllegalStateException("Email non esistente");
        }

        if(!Objects.equals(tassistaOptional.get().getPassword(), password)){
            throw new IllegalStateException("Password errata");
        }


        return tassistaOptional.get();

    }
}
