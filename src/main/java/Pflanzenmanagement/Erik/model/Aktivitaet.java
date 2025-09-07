package Pflanzenmanagement.Erik.model;

import jakarta.persistence.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;

import Pflanzenmanagement.Erik.enums.AktivitaetsStatus;
import Pflanzenmanagement.Erik.enums.Aktivitaetsart;
import Pflanzenmanagement.Erik.event.AnbauEvent;

@Entity
public class Aktivitaet {

    //////////////////////
    /// Attribute
    //////////////////////

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Bezeichnung der Aktivität, z. B. "Bewässerung", "Ernte"
    private Aktivitaetsart aktivitaetsart;

    // Status der Aktivität (GEPLANT, AUSFUEHRUNG, ERLEDIGT)
    @Enumerated(EnumType.STRING)
    private AktivitaetsStatus status;

    // Zeitpunkt, wann die Aktivität begonnen wurde
    private LocalDateTime startzeit;

    // Zeitpunkt, wann die Aktivität beendet wurde
    private LocalDateTime endzeit;

    // Dauer der Aktivität (optional abgeleitet aus Start/Ende)
    private Duration dauer;

    //////////////////////
    /// Beziehungen
    //////////////////////

    // (Optional) Beziehung zu einem AnbauEvent oder Anbauort
    // z. B. "Diese Aktivität gehört zu einem bestimmten Anbauereignis"
    @ManyToOne
    private AnbauEvent anbauEvent;

    //////////////////////
    /// Konstruktoren
    //////////////////////

    public Aktivitaet() {
    }


    public Aktivitaet(Long id, Aktivitaetsart aktivitaetsart, AktivitaetsStatus status, LocalDateTime startzeit, LocalDateTime endzeit, Duration dauer, AnbauEvent anbauEvent) {
        this.id = id;
        this.aktivitaetsart = aktivitaetsart;
        this.status = status;
        this.startzeit = startzeit;
        this.endzeit = endzeit;
        this.dauer = dauer;
        this.anbauEvent = anbauEvent;
    }

    //////////////////////
    /// Getter / Setter
    //////////////////////


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Aktivitaetsart getAktivitaetsart() {
        return this.aktivitaetsart;
    }

    public void setAktivitaetsart(Aktivitaetsart aktivitaetsart) {
        this.aktivitaetsart = aktivitaetsart;
    }

    public AktivitaetsStatus getStatus() {
        return this.status;
    }

    public void setStatus(AktivitaetsStatus status) {
        this.status = status;
    }

    public LocalDateTime getStartzeit() {
        return this.startzeit;
    }

    public void setStartzeit(LocalDateTime startzeit) {
        this.startzeit = startzeit;
    }

    public LocalDateTime getEndzeit() {
        return this.endzeit;
    }

    public void setEndzeit(LocalDateTime endzeit) {
        this.endzeit = endzeit;
    }

    public Duration getDauer() {
        return this.dauer;
    }

    public void setDauer(Duration dauer) {
        this.dauer = dauer;
    }

    public AnbauEvent getAnbauEvent() {
        return this.anbauEvent;
    }

    public void setAnbauEvent(AnbauEvent anbauEvent) {
        this.anbauEvent = anbauEvent;
    }
   

    //////////////////////
    ///toString- Methode /
    //////////////////////


    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", aktivitaetsart='" + getAktivitaetsart() + "'" +
            ", status='" + getStatus() + "'" +
            ", startzeit='" + getStartzeit() + "'" +
            ", endzeit='" + getEndzeit() + "'" +
            ", dauer='" + getDauer() + "'" +
            ", anbauEvent='" + getAnbauEvent() + "'" +
            "}";
    }
  

}
