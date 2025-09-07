package Pflanzenmanagement.Erik.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

import Pflanzenmanagement.Erik.event.AnbauEvent;

@MappedSuperclass
public abstract class Anbauort {

    //////////////////////
    /// Attribute
    //////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double laengengrad;
    private double breitengrad;

   

    //////////////////////
    /// Konstruktoren
    //////////////////////

    public Anbauort() {}

    public Anbauort(double laengengrad, double breitengrad) {
        this.laengengrad = laengengrad;
        this.breitengrad = breitengrad;
    }

    //////////////////////
    /// Getter und Setter
    //////////////////////

    public Long getId() {
        return id;
    }

    public double getLaengengrad() {
        return laengengrad;
    }

    public double getBreitengrad() {
        return breitengrad;
    }

    public void setLaengengrad(double laengengrad) {
        this.laengengrad = laengengrad;
    }

    public void setBreitengrad(double breitengrad) {
        this.breitengrad = breitengrad;
    }

    //////////////////////
    /// toString-Methode
    //////////////////////

    @Override
    public String toString() {
        return "Anbauort{" +
                "id=" + id +
                ", laengengrad=" + laengengrad +
                ", breitengrad=" + breitengrad +
                '}';
    }

    //////////////////////
    /// equals & hashCode
    //////////////////////

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Anbauort)) return false;
        Anbauort that = (Anbauort) o;
        return Double.compare(laengengrad, that.laengengrad) == 0 &&
               Double.compare(breitengrad, that.breitengrad) == 0 &&
               Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, laengengrad, breitengrad);
    }
}
