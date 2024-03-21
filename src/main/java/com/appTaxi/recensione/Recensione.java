package com.appTaxi.recensione;

import javax.swing.*;
import java.awt.*;

public class Recensione {
    private Long id;
    private Long id_prenotazione;
    private TextArea testo;

    private Short valutazione;

    public Recensione(Long id,
                      Long id_prenotazione,
                      TextArea testo,
                      Short valutazione) {
        this.id = id;
        this.id_prenotazione = id_prenotazione;
        this.testo = testo;
        this.valutazione = valutazione;
    }

    public Recensione() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId_prenotazione() {
        return id_prenotazione;
    }

    public void setId_prenotazione(Long id_prenotazione) {
        this.id_prenotazione = id_prenotazione;
    }

    public TextArea getTesto() {
        return testo;
    }

    public void setTesto(TextArea testo) {
        this.testo = testo;
    }

    public Short getValutazione() {
        return valutazione;
    }

    public void setValutazione(Short valutazione) {
        this.valutazione = valutazione;
    }

    @Override
    public String toString() {
        return "Recensione{" +
                "id=" + id +
                ", id_prenotazione=" + id_prenotazione +
                ", testo=" + testo +
                ", valutazione=" + valutazione +
                '}';
    }
}
