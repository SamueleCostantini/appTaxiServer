package com.appTaxi.tassista;

import jakarta.persistence.*;


/*
* Classe user
*
* */
//per abbinare l'entita al database
@Entity
@Table
public class Tassista {
    @Id
    @SequenceGenerator(
            name = "utente_sequence",
            sequenceName = "utente_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "utente_sequence"
    )
    private Long IDTassista; //id user globale
    private String name;
    private String surname;
    private String email;
    private String password; //da cripltare con hash, utilizzare spring security
    private boolean role; //ruolo del utente, 0 per fruitore (cliente), 1 per erogatore(tassista)

    private double lat;
    private double lng;
    public double getLat() {
        return lat;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLng() {
        return lng;
    }

    public void setLng(double lng) {
        this.lng = lng;
    }
    private String targa;
    public Tassista() {
        this.lat = 0.0;
        this.lng = 0.0;
    }

    public Tassista(Long IDTassista,
                  String name,
                  String surname,
                  String email,
                  String password,
                  boolean role, String targa) {
        this.IDTassista = IDTassista;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.targa = targa;
    }

    public Tassista(String name,
                  String surname,
                  String email,
                  String password,
                  boolean role, String targa) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.targa = targa;
    }

    public Long getIDTassista() {
        return IDTassista;
    }
    public void setIDTassista(Long iIDTassista) {
        this.IDTassista = IDTassista;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getSurname() {
        return surname;
    }
    public void setSurname(String surname) {
        this.surname = surname;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public boolean isRole() {
        return role;
    }
    public void setRole(boolean role) {
        this.role = role;
    }

    public String getTarga() {
        return targa;
    }

    public void setTarga(String targa) {
        this.targa = targa;
    }

    @Override
    public String toString() {
        return "Tassista{" +
                "IDTassista=" + IDTassista +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                ", lat=" + lat +
                ", lng=" + lng +
                ", targa='" + targa + '\'' +
                '}';
    }
}
