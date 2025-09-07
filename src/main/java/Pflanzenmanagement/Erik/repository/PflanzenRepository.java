package Pflanzenmanagement.Erik.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import Pflanzenmanagement.Erik.model.Pflanze;

public interface PflanzenRepository extends JpaRepository<Pflanze, Long> {
    // Keine zusätzlichen Methoden laut Aufgabenstellung nötig
}