package com.appTaxi.taxi;

import jakarta.persistence.*;

import java.util.Arrays;
@Entity
@Table
public class Taxi {

    @Id
    @SequenceGenerator(
            name = "taxi_sequence",
            sequenceName = "taxi_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "taxi_sequence"
    )
    private Long idTaxi;
    private String targa;
    public Taxi(Long idTaxi, String targa) {
        this.idTaxi = idTaxi;
        this.targa = targa;
    }

    public Taxi() {
    }

    public Long getIdTaxi() {
        return idTaxi;
    }

    public void setIdTaxi(Long idTaxi) {
        this.idTaxi = idTaxi;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public String toString() {
        return "Taxi{" +
                "idTaxi=" + idTaxi +
                ", targa=" + targa +
                '}';
    }
}
