package Pflanzenmanagement.Erik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Pflanzenmanagement.Erik.model.Gewaechshaus;

public interface GewaechshausRepository extends JpaRepository<Gewaechshaus, Long> {
    // Keine zusätzlichen Methoden laut Aufgabenstellung nötig
}