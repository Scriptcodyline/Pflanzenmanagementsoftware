package Pflanzenmanagement.Erik.runner;

import Pflanzenmanagement.Erik.Comparatorklassen.FeldFlaechenComparator;
import Pflanzenmanagement.Erik.model.Feld;
import Pflanzenmanagement.Erik.repository.FeldRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Order(2)
public class Start_runner implements CommandLineRunner {

    @Autowired
    private FeldRepository feldRepository;

    @Override
    public void run(String... args) throws Exception {
        List<Feld> felder = feldRepository.findAll();
        felder.sort(new FeldFlaechenComparator());
        felder.forEach(System.out::println);
    }
}
