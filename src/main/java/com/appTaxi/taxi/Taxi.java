package com.appTaxi.taxi;

import jakarta.persistence.*;

import java.util.Arrays;
@Entity
@Table
public class Taxi {

    @Id

    private String targa;
    public Taxi(String targa) {

        this.targa = targa;
    }

    public Taxi() {
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
                "targa=" + targa +
                '}';
    }


}
