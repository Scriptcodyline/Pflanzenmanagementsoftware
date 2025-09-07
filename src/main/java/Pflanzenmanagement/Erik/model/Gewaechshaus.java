package Pflanzenmanagement.Erik.model;

import jakarta.persistence.*;

@Entity
public class Gewaechshaus extends Anbauort {

    //////////////////////
    /// Attribute
    //////////////////////
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private double flaecheQm;
    private int etagen;
    private int mitarbeiter;

    //////////////////////
    /// Konstruktoren
    //////////////////////

    public Gewaechshaus() {}

    public Gewaechshaus(double laengengrad, double breitengrad, double flaecheQm, int etagen, int mitarbeiter) {
        super(laengengrad, breitengrad);
        this.flaecheQm = flaecheQm;
        this.etagen = etagen;
        this.mitarbeiter = mitarbeiter;
    }

    //////////////////////
    /// Getter und Setter
    //////////////////////

    public double getFlaecheQm() {
        return flaecheQm;
    }

    public void setFlaecheQm(double flaecheQm) {
        this.flaecheQm = flaecheQm;
    }

    public int getEtagen() {
        return etagen;
    }

    public void setEtagen(int etagen) {
        this.etagen = etagen;
    }

    public int getMitarbeiter() {
        return mitarbeiter;
    }

    public void setMitarbeiter(int mitarbeiter) {
        this.mitarbeiter = mitarbeiter;
    }

    //////////////////////
    /// toString-Methode
    //////////////////////

    @Override
    public String toString() {
        return "Gewaechshaus{" +
                "flaecheQm=" + flaecheQm +
                ", etagen=" + etagen +
                ", mitarbeiter=" + mitarbeiter +
                "} " + super.toString();
    }
}
