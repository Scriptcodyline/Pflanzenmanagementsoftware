package Pflanzenmanagement.Erik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Pflanzenmanagement.Erik.event.AnbauEvent;

public interface AnbauEventRepository extends JpaRepository<AnbauEvent, Long> {
    // Kann für generische Abfragen genutzt werden, wenn du keine konkrete Subklasse brauchst
}

