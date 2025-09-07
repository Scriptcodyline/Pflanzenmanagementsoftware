package Pflanzenmanagement.Erik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Pflanzenmanagement.Erik.model.Aktivitaet;

public interface AktivitaetRepository extends JpaRepository<Aktivitaet, Long> {
    // Kann für generische Abfragen genutzt werden, wenn du keine konkrete Subklasse brauchst
}
