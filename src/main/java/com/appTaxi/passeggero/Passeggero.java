package com.appTaxi.passeggero;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

/*
* Classe user
*
* */
//per abbinare l'entita al database
@Entity
@Table
public class Passeggero {
    @Id
    @SequenceGenerator(
            name = "passeggero_sequence",
            sequenceName = "passeggero_sequence",
            allocationSize = 1
    )
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "passeggero_sequence"
    )
    private Long IDPasseggero; //id user globale
    private String name;
    private String surname;
    @Email(message = "Email non valida")
    private String email;
    @Size(min = 8, message = "Password deve avere almeno 8 caratteri")
    private String password; //da criptare con hash, utilizzare spring security
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



    public String getStato() {
        return stato;
    }

    public void setStato(String stato) {
        this.stato = stato;
    }

    private String stato;
    private boolean role; //ruolo del passeggero, 0 per fruitore (cliente), 1 per erogatore(tassista)

    public Passeggero() {
        this.stato = "Libero";
        this.lat = 0.0;
        this.lng = 0.0;
    }

    public Passeggero(Long IDPasseggero,
                  String name,
                  String surname,
                  String email,
                  String password,
                  boolean role) {
        this.IDPasseggero = IDPasseggero;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.stato = "Libero";
    }

    public Passeggero(String name,
                  String surname,
                  String email,
                  String password,
                  boolean role) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
        this.stato = "Libero";

    }

    public Long getIDPasseggero() {
        return IDPasseggero;
    }
    public void setIDPasseggero(Long iIDPasseggero) {
        this.IDPasseggero = IDPasseggero;
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

    @Override
    public String toString() {
        return "Passeggero{" +
                "IDPasseggero=" + IDPasseggero +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", lat=" + lat +
                ", lng=" + lng +
                ", stato='" + stato + '\'' +
                ", role=" + role +
                '}';
    }
}
