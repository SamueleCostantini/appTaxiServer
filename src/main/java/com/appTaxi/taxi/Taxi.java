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
    private Long IDTaxi;
    private String targa;
    public Taxi(Long IDTaxi, String targa) {
        this.IDTaxi = IDTaxi;
        this.targa = targa;
    }

    public Taxi() {
    }

    public Long getIDTaxi() {
        return IDTaxi;
    }

    public void setIDTaxi(Long IDTaxi) {
        this.IDTaxi = IDTaxi;
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
                "IDTaxi=" + IDTaxi +
                ", targa=" + targa +
                '}';
    }


}
