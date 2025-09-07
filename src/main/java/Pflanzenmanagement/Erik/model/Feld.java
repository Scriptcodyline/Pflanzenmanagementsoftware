package Pflanzenmanagement.Erik.model;

import java.util.List;

import Pflanzenmanagement.Erik.enums.Bodentyp;
import Pflanzenmanagement.Erik.event.AnbauEvent;
import jakarta.persistence.*;


@Entity
public class Feld extends Anbauort implements Comparable<Feld> {

    //////////////////////
    /// Attribute
    //////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double flaecheHektar;
    private double getEnfernungVomHofInKm;

    @Enumerated(EnumType.STRING)
    private Bodentyp bodentyp;

    private String beschreibung;

    @OneToMany
    private List<AnbauEvent> anbauevent;


    //////////////////////
    /// Konstruktoren
    //////////////////////

    public Feld() {}

    public Feld(double laengengrad, double breitengrad, double flaecheHektar, double getEnfernungVomHofInKm,
                Bodentyp bodentyp, String beschreibung) {
        super(laengengrad, breitengrad);
        this.flaecheHektar = flaecheHektar;
        this.getEnfernungVomHofInKm = getEnfernungVomHofInKm;
        this.bodentyp = bodentyp;
        this.beschreibung = beschreibung;
    }

    //////////////////////
    /// Getter und Setter
    //////////////////////

    public double getFlaecheHektar() {
        return flaecheHektar;
    }

    public void setFlaecheHektar(double flaecheHektar) {
        this.flaecheHektar = flaecheHektar;
    }

    public double getgetEnfernungVomHofInKm() {
        return getEnfernungVomHofInKm;
    }

    public void setgetEnfernungVomHofInKm(double getEnfernungVomHofInKm) {
        this.getEnfernungVomHofInKm = getEnfernungVomHofInKm;
    }

    public Bodentyp getBodentyp() {
        return bodentyp;
    }

    public void setBodentyp(Bodentyp bodentyp) {
        this.bodentyp = bodentyp;
    }

    public String getBeschreibung() {
        return beschreibung;
    }

    public void setBeschreibung(String beschreibung) {
        this.beschreibung = beschreibung;
    }

    //////////////////////
    /// toString-Methode
    //////////////////////

    @Override
    public String toString() {
        return "Feld{" +
                "flaecheHektar=" + flaecheHektar +
                ", getEnfernungVomHofInKm=" + getEnfernungVomHofInKm +
                ", bodentyp=" + bodentyp +
                ", beschreibung='" + beschreibung + '\'' +
                "} " + super.toString();
    }

    //////////////////////
    /// Vergleichsmethode
    //////////////////////

    @Override
    public int compareTo(Feld other) {
        int flaecheCmp = Double.compare(this.flaecheHektar, other.flaecheHektar);
        return (flaecheCmp != 0) ? flaecheCmp : Double.compare(this.getEnfernungVomHofInKm, other.getEnfernungVomHofInKm);
    }
}
