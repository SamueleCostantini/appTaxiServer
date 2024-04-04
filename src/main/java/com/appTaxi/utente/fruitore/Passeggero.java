package com.appTaxi.utente.fruitore;

import com.appTaxi.utente.Utente;

public class Passeggero extends Utente {
    public Passeggero() {
    }

    public Passeggero(Long IDUtente, String name, String surname, String email, String password, boolean role) {
        super(IDUtente, name, surname, email, password, role);
    }

    public Passeggero(String name, String surname, String email, String password, boolean role) {
        super(name, surname, email, password, role);
    }
}
