package com.appTaxi.prenotazione;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table
public class Prenotazione {
    @Id
    @SequenceGenerator(
            name = "prenotazione_sequence",
            sequenceName = "prenotazione_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "prenotazioen_sequence"
    )
    private Long id;
    private LocalDateTime DataOra;
    private String stato;
    private Long idPasseggero;
    private Long idTassista;

    private String partenza;
    private String destinazione;
    private int km;
    private float costoXkm;
    private float costoTratta;
    public Prenotazione(Long id,
                        String stato,
                        Long idPasseggero,
                        Long idTassista,
                        String partenza,
                        String destinazione,
                        int km,
                        float costoXkm) {
        this.id = id;
        this.DataOra = LocalDateTime.now();
        System.out.println("ora: "+this.DataOra);
        this.stato = stato;
        this.idPasseggero = idPasseggero;
        this.idTassista = idTassista;
        this.partenza = partenza;
        this.destinazione = destinazione;
        this.km = km;
        this.costoXkm = costoXkm;
        this.costoTratta = km*costoXkm;

        }

    public Prenotazione() {
        this.DataOra = LocalDateTime.now();
        System.out.println("ora: "+this.DataOra);
    }
    public float getCostoTratta() {
        return costoTratta;
    }

    public void setCostoTratta(float costoTratta) {
        this.costoTratta = costoTratta;
    }
    public String getPartenza() {
        return partenza;
    }

    public String getDestinazione() {
        return destinazione;
    }

    public int getKm() {
        return km;
    }

    public float getCostoXkm() {
        return costoXkm;
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


    @Override
    public String toString() {
        return "Prenotazione{" +
                "id=" + id +
                ", DataOra=" + DataOra.toString() +
                ", stato='" + stato + '\'' +
                ", idPasseggero=" + idPasseggero +
                ", idTassista=" + idTassista +
                ", partenza='" + partenza + '\'' +
                ", destinazione='" + destinazione + '\'' +
                ", km=" + km +
                ", costoXkm=" + costoXkm +
                ", costoTratta=" + costoTratta +
                '}';
    }
}
