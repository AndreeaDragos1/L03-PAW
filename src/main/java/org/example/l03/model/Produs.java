package org.example.l03.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


@Entity
public class Produs {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nume;
    private Double pret;
    private String descriere;

    public Produs() {}

    public Produs(String nume, Double pret, String descriere) {
        this.nume = nume;
        this.pret = pret;
        this.descriere = descriere;
    }

    // Getteri și setteri
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNume() { return nume; }
    public void setNume(String nume) { this.nume = nume; }
    public Double getPret() { return pret; }
    public void setPret(Double pret) { this.pret = pret; }
    public String getDescriere() { return descriere; }
    public void setDescriere(String descriere) { this.descriere = descriere; }
}