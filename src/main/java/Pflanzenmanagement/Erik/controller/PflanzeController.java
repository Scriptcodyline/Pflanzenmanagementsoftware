package Pflanzenmanagement.Erik.controller;


import Pflanzenmanagement.Erik.model.Pflanze;
import Pflanzenmanagement.Erik.repository.PflanzenRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pflanzen")
public class PflanzeController {

    @Autowired
    private PflanzenRepository pflanzenRepository;

    // Alle Pflanzen abrufen
    @GetMapping
    public List<Pflanze> getAllPflanzen() {
        return pflanzenRepository.findAll();
    }

    // Einzelne Pflanze per ID abrufen
    @GetMapping("/{id}")
    public Optional<Pflanze> getPflanzeById(@PathVariable Long id) {
        return pflanzenRepository.findById(id);
    }

    // Neue Pflanze hinzufügen
    @PostMapping
    public Pflanze createPflanze(@RequestBody Pflanze pflanze) {
        return pflanzenRepository.save(pflanze);
    }

    // Pflanze aktualisieren
    @PutMapping("/{id}")
    public Pflanze updatePflanze(@PathVariable Long id, @RequestBody Pflanze neueDaten) {
        return pflanzenRepository.findById(id).map(pflanze -> {
            pflanze.setName(neueDaten.getName());
            return pflanzenRepository.save(pflanze);
        }).orElseGet(() -> {
            neueDaten.setId(id);
            return pflanzenRepository.save(neueDaten);
        });
    }

    // Pflanze löschen
    @DeleteMapping("/{id}")
    public void deletePflanze(@PathVariable Long id) {
        pflanzenRepository.deleteById(id);
    }
}
