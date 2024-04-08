package com.appTaxi.prenotazione;
import java.time.LocalDateTime;
public class Prenotazione {
    private Long id;
    private LocalDateTime DataOra;
    private String stato;
    private Long idPasseggero;
    private Long idTassista;
    private String id_taxi;

    public Prenotazione(Long id,
                        LocalDateTime dataOra,
                        String stato,
                        Long idPasseggero,
                        Long idTassista,
                        String id_taxi) {
        this.id = id;
        DataOra = dataOra;
        this.stato = stato;
        this.idPasseggero = idPasseggero;
        this.idTassista = idTassista;
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

    public Long getIdPasseggero() {
        return idPasseggero;
    }

    public void setIdPasseggero(Long idPasseggero) {
        this.idPasseggero = idPasseggero;
    }

    public Long getIdTassista() {
        return idTassista;
    }

    public void setIdTassista(Long idTassista) {
        this.idTassista = idTassista;
    }

    public String getId_taxi() {
        return id_taxi;
    }

    public void setId_taxi(String id_taxi) {
        this.id_taxi = id_taxi;
    }

    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", DataOra=" + DataOra +
                ", stato='" + stato + '\'' +
                ", idPasseggero=" + idPasseggero +
                ", idTassista=" + idTassista +
                ", id_taxi=" + id_taxi +
                '}';
    }
}
