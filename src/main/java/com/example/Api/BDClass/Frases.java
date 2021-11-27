package com.example.Api.BDClass;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="frases")
public class Frases {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="frase")
    private String frase;

    public Frases() {}

    public Frases(int id, String email, String frase) {
        this.id = id;
        this.frase = frase;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrase() {
        return frase;
    }

    public void setFrase(String frase) {
        this.frase = frase;
    }
    @Override
    public String toString() {
        return "Frase [id=" + id + ", Frase=" + frase + "]";
    }
}
