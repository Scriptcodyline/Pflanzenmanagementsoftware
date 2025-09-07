package Pflanzenmanagement.Erik;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import Pflanzenmanagement.Erik.Comparatorklassen.FeldFlaechenComparator;
import Pflanzenmanagement.Erik.enums.Aktivitaetsart;
import Pflanzenmanagement.Erik.enums.Bodentyp;
import Pflanzenmanagement.Erik.event.AnbauEvent;
import Pflanzenmanagement.Erik.model.*;
import Pflanzenmanagement.Erik.repository.*;
import jakarta.transaction.Transactional;

@SpringBootApplication
public class PflanzenmanagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(PflanzenmanagementApplication.class, args);
    }

    // --------------------------------------------------
    // Runner 1: Pflanzen-, Feld-, Gewächshaus-, AnbauEvent-bezogene Initialisierung
    // --------------------------------------------------

    @Component
    @Order(1)
    class AnbauRunner implements CommandLineRunner {

        private final PflanzenRepository pflanzeRepo;
        private final FeldRepository feldRepo;
        private final AnbauEventRepository anbauEventRepo;
        private final AktivitaetRepository aktivitaetRepo;
        private final GewaechshausRepository gewaechshausrepo;

        public AnbauRunner(
                PflanzenRepository pflanzeRepo,
                FeldRepository feldRepo,
                AnbauEventRepository anbauEventRepo,
                AktivitaetRepository aktivitaetRepo,
                GewaechshausRepository gewaechshausrepo
        ) {
            this.pflanzeRepo = pflanzeRepo;
            this.feldRepo = feldRepo;
            this.anbauEventRepo = anbauEventRepo;
            this.aktivitaetRepo = aktivitaetRepo;
            this.gewaechshausrepo = gewaechshausrepo;
        }

        @Override
        @Transactional
        public void run(String... args) {
            System.out.println("--------------------------------------------------");
            System.out.println("Starte Dateninitialisierung (AnbauRunner)...");
            System.out.println("--------------------------------------------------");
            System.out.println();

            // 1. Pflanze
            Pflanze pflanze = new Pflanze();
            pflanze.setName("Weizen");
            System.out.println("[Pflanze erstellt] " + pflanze);
            System.out.println();

            // 2. Feld
            Feld feld = new Feld();
            feld.setFlaecheHektar(2.5);
            feld.setgetEnfernungVomHofInKm(1.2);
            feld.setBodentyp(Bodentyp.LEHM);
            feld.setBeschreibung("Südliches Feld");
            System.out.println("[Feld erstellt] " + feld);
            System.out.println();
			

            // 3. Gewächshaus
            Gewaechshaus gewaechshaus = new Gewaechshaus();
            gewaechshaus.setLaengengrad(10.5);
            gewaechshaus.setBreitengrad(50.3);
            gewaechshaus.setFlaecheQm(1200.0);
            gewaechshaus.setEtagen(2);
            gewaechshaus.setMitarbeiter(5);
            System.out.println("[Gewächshaus erstellt] " + gewaechshaus);
            System.out.println();

            // 4. Aktivität
            Aktivitaet aktivitaet = new Aktivitaet();
            aktivitaet.setAktivitaetsart(Aktivitaetsart.BEWAESSERUNG);
            aktivitaet.setStartzeit(LocalDateTime.now());
            System.out.println("[Aktivität erstellt] " + aktivitaet);
            System.out.println();

            // 5. AnbauEvent
            AnbauEvent anbauEvent = new AnbauEvent();
            anbauEvent.setFeld(feld); // alternativ: anbauEvent.setAnbauort(gewaechshaus);
            anbauEvent.setPflanze(pflanze);
            anbauEvent.setAktivitaet(List.of(aktivitaet));
            anbauEvent.setStartdatum(LocalDate.now().minusDays(7));
            anbauEvent.setEnddatum(LocalDate.now());
            System.out.println("[AnbauEvent erstellt] " + anbauEvent);
            System.out.println();

            // 6. Speichern
            pflanzeRepo.save(pflanze);
            feldRepo.save(feld);
            gewaechshausrepo.save(gewaechshaus);
            aktivitaetRepo.save(aktivitaet);
            anbauEventRepo.save(anbauEvent);

            // 7. Ausgabe
            System.out.println("--------------------------------------------------");
            System.out.println("Alle Pflanzen:");
            pflanzeRepo.findAll().forEach(System.out::println);
            System.out.println();

            System.out.println("--------------------------------------------------");
            System.out.println("Alle AnbauEvents:");
            anbauEventRepo.findAll().forEach(ae -> {
                System.out.println(ae);
                System.out.println("  → Aktivitäten: " + ae.getAktivitaet());
                System.out.println();
            });

            System.out.println("--------------------------------------------------");
            System.out.println("Alle gespeicherten Anbauorte (Felder und Gewächshäuser):");
            feldRepo.findAll().forEach(System.out::println);
            gewaechshausrepo.findAll().forEach(System.out::println);
            System.out.println();


            // Mehrere Felder mit Konstruktor erzeugen
            Feld feld1 = new Feld(10.1, 50.1, 1.5, 2.0, Bodentyp.LEHM, "Feld Nord");
            Feld feld2 = new Feld(10.2, 50.2, 3.0, 1.5, Bodentyp.SAND, "Feld Süd");
            Feld feld3 = new Feld(10.3, 50.3, 2.0, 3.5, Bodentyp.SCHWARZERDE, "Feld Ost");

            // In Konsole ausgeben
            System.out.println("[Feld1 erstellt] " + feld1);
            System.out.println("[Feld2 erstellt] " + feld2);
            System.out.println("[Feld3 erstellt] " + feld3);
            System.out.println();

            // Speichern
            feldRepo.save(feld1);
            feldRepo.save(feld2);
            feldRepo.save(feld3);
        
            List<Feld> felder = new ArrayList<>();
            feldRepo.findAll().forEach(felder::add);

            System.out.println("--------------------------------------------------");
            System.out.println("Felder unsortiert nach Fläche und Entfernung:");
            felder.forEach(System.out::println);
            // Sortieren nach Fläche, dann Entfernung
            Collections.sort(felder, new FeldFlaechenComparator());
            System.out.println("--------------------------------------------------");

            System.out.println("--------------------------------------------------");
            System.out.println("Felder sortiert nach Fläche:");
            felder.forEach(System.out::println);


            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------");
            System.out.println("Dateninitialisierung abgeschlossen.");
            System.out.println("--------------------------------------------------");
            System.out.println();

        // Felder mit dem Bodentyp Schwarzerde ausgeben. 
        System.out.println("\n▶︎ Feld vom Bodentyp Schwarzerde:");
        feldRepo.findByBodentyp(Bodentyp.SCHWARZERDE)
        .forEach(f -> System.out.println("Feld ID: " + f.getId() + ", Beschreibung: " + f.getBeschreibung() + ", Bodentyp: " + f.getBodentyp()));

        System.out.println("");

        }
    }
}
