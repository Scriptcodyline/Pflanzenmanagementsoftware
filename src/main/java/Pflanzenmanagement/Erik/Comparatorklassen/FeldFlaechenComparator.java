package Pflanzenmanagement.Erik.Comparatorklassen;

import java.util.Comparator;

import Pflanzenmanagement.Erik.model.Feld;

public class FeldFlaechenComparator implements Comparator<Feld> {
    @Override
    public int compare(Feld f1, Feld f2) {
        if (f1 == null && f2 == null) return 0;
        if (f1 == null) return 1;
        if (f2 == null) return -1;

        int flaecheCmp = Double.compare(f1.getFlaecheHektar(), f2.getFlaecheHektar());
        if (flaecheCmp != 0) return flaecheCmp;

        return Double.compare(f1.getgetEnfernungVomHofInKm(), f2.getgetEnfernungVomHofInKm());
    }
}