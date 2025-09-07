package Pflanzenmanagement.Erik.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Pflanzenmanagement.Erik.enums.Bodentyp;
import Pflanzenmanagement.Erik.model.Feld;

public interface FeldRepository extends JpaRepository<Feld, Long> {
    
    // Zusätzliche Methode laut Prüfungsbeschreibung:
    List<Feld> findByBodentyp(Bodentyp bodentyp);
    List<Feld> findAllByOrderByFlaecheHektar(); 

}