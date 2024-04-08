package com.appTaxi.passeggero;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PasseggeroService {

    private final PasseggeroRepository passeggeroRepository;

    @Autowired
    public PasseggeroService(PasseggeroRepository passeggeroRepository) {
        this.passeggeroRepository = passeggeroRepository;
    }

    public List<Passeggero> getPasseggero() {
        return passeggeroRepository.findAll();
    }

    public void addNewPasseggero(Passeggero passeggero) {

        Optional<Passeggero> passeggeroOptional = passeggeroRepository.findPasseggeroByEmail(passeggero.getEmail());

        if(passeggeroOptional.isPresent()){
            throw new IllegalStateException("Email in uso");
        }

        passeggeroRepository.save(passeggero);
    }

    public void deletePasseggero(Long IDPasseggero) {
        boolean esiste = passeggeroRepository.existsById(IDPasseggero);

        if(!esiste){
            throw new IllegalStateException("Id non esistente: "+ IDPasseggero);
        }

        passeggeroRepository.deleteById(IDPasseggero);
    }

    public void updatePasseggero(Long IDPasseggero, String attributo, String valore) {
        boolean esiste = passeggeroRepository.existsById(IDPasseggero);
        if(!esiste){
            throw new IllegalStateException("Passeggero "+IDPasseggero+" non esiste ");
        }
        Optional<Passeggero> passeggero = passeggeroRepository.findById(IDPasseggero);
        Passeggero ut1 = new Passeggero();
        ut1 = passeggeroRepository.getReferenceById(IDPasseggero);
        switch(attributo){
            case "IDPasseggero":

                /*controlli se id inserito è valido*/
                try {
                    Double.parseDouble(valore);
                } catch (NumberFormatException e) {
                    throw new IllegalStateException("Id non valido");
                }
                esiste = passeggeroRepository.existsById(Long.valueOf(valore));
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
                Optional<Passeggero> passeggeroByEmail = passeggeroRepository.findPasseggeroByEmail(valore);
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
        }
        passeggeroRepository.save(ut1);
    }
}
