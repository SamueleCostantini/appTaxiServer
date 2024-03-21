package com.appTaxi.user;

import jakarta.persistence.*;


/*
* Classe user
*
* */
//per abbinare l'entita al database
@Entity
@Table
public class Utente {
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
    private Long id; //id user globale
    private String name;
    private String surname;
    private String email;
    private String password; //da cripltare con hash, utilizzare spring security
    private boolean role; //ruolo del utente, 0 per fruitore (cliente), 1 per erogatore(tassista)

    public Utente() {
    }

    public Utente(Long id,
                  String name,
                  String surname,
                  String email,
                  String password,
                  boolean role) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Utente(String name,
                  String surname,
                  String email,
                  String password,
                  boolean role) {

        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
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
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", role=" + role +
                '}';
    }
}
