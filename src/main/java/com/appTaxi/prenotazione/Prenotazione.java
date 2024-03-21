package com.appTaxi.prenotazione;
import java.time.LocalDateTime;
public class Prenotazione {
    private Long id;
    private LocalDateTime DataOra;
    private String stato;
    private Long id_fruitore;
    private Long id_erogatore;
    private Long id_taxi;

    public Prenotazione(Long id,
                        LocalDateTime dataOra,
                        String stato,
                        Long id_fruitore,
                        Long id_erogatore,
                        Long id_taxi) {
        this.id = id;
        DataOra = dataOra;
        this.stato = stato;
        this.id_fruitore = id_fruitore;
        this.id_erogatore = id_erogatore;
        this.id_taxi = id_taxi;
    }

    public Prenotazione() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getDataOra() {
        return DataOra;
    }

    public void setDataOra(LocalDateTime dataOra) {
        DataOra = dataOra;
    }

    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    public Long getId_fruitore() {
        return id_fruitore;
    }

    public void setId_fruitore(Long id_fruitore) {
        this.id_fruitore = id_fruitore;
    }

    public Long getId_erogatore() {
        return id_erogatore;
    }

    public void setId_erogatore(Long id_erogatore) {
        this.id_erogatore = id_erogatore;
    }

    public Long getId_taxi() {
        return id_taxi;
    }

    public void setId_taxi(Long id_taxi) {
        this.id_taxi = id_taxi;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", DataOra=" + DataOra +
                ", stato='" + stato + '\'' +
                ", id_fruitore=" + id_fruitore +
                ", id_erogatore=" + id_erogatore +
                ", id_taxi=" + id_taxi +
                '}';
    }
}
