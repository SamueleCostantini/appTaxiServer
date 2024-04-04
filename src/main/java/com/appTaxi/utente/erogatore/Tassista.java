package com.appTaxi.utente.erogatore;

import com.appTaxi.utente.Utente;

public class Tassista extends Utente {
    public Tassista() {
    }

    public Tassista(Long IDUtente, String name, String surname, String email, String password, boolean role) {
        super(IDUtente, name, surname, email, password, role);
    }

    public Tassista(String name, String surname, String email, String password, boolean role) {
        super(name, surname, email, password, role);
    }
}
