package Pflanzenmanagement.Erik.event;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import Pflanzenmanagement.Erik.model.Aktivitaet;
import Pflanzenmanagement.Erik.model.Anbauort;
import Pflanzenmanagement.Erik.model.Feld;
import Pflanzenmanagement.Erik.model.Pflanze;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class AnbauEvent {

    //////////////////////
    /// Beziehungen
    //////////////////////

    @ManyToOne
    private Feld feld;

    @ManyToOne
    private Pflanze pflanze;

    @OneToMany(mappedBy = "anbauEvent")
    private List<Aktivitaet> aktivitaet;

    //////////////////////
    /// Attribute
    //////////////////////
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate startdatum;
    private LocalDate enddatum;

    //////////////////////
    /// Konstruktor
    //////////////////////


    public AnbauEvent() {
    }


    public AnbauEvent(Feld feld, Pflanze pflanze, List<Aktivitaet> aktivitaet, Long id, LocalDate startdatum, LocalDate enddatum) {
        this.feld = feld;
        this.pflanze = pflanze;
        this.aktivitaet = aktivitaet;
        this.id = id;
        this.startdatum = startdatum;
        this.enddatum = enddatum;
    }
  

    
    //////////////////////
    /// Getter und setter
    //////////////////////


    public Feld getFeld() {
        return this.feld;
    }

    public void setFeld(Feld feld) {
        this.feld = feld;
    }

    public Pflanze getPflanze() {
        return this.pflanze;
    }

    public void setPflanze(Pflanze pflanze) {
        this.pflanze = pflanze;
    }

    public List<Aktivitaet> getAktivitaet() {
        return this.aktivitaet;
    }

    public void setAktivitaet(List<Aktivitaet> aktivitaet) {
        this.aktivitaet = aktivitaet;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDate getStartdatum() {
        return this.startdatum;
    }

    public void setStartdatum(LocalDate startdatum) {
        this.startdatum = startdatum;
    }

    public LocalDate getEnddatum() {
        return this.enddatum;
    }

    public void setEnddatum(LocalDate enddatum) {
        this.enddatum = enddatum;
    }


    //////////////////////
    /// toString-methode
    //////////////////////



    @Override
    public String toString() {
        return "{" +
            " feld='" + getFeld() + "'" +
            ", pflanze='" + getPflanze() + "'" +
            ", aktivitaet='" + getAktivitaet() + "'" +
            ", id='" + getId() + "'" +
            ", startdatum='" + getStartdatum() + "'" +
            ", enddatum='" + getEnddatum() + "'" +
            "}";
    }


  

}
