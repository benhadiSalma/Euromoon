package model;

import java.time.LocalDate;
/**
 * Abstracte basisklasse voor alle personen in het systeem (Passagiers en Personeel).
 * Bevat gemeenschappelijke persoonsgegevens zoals naam, voornaam en rijksregisternummer.
 * @author Selma Benhadi
 */
public abstract class Persoon {
    private String naam;
    private String voornaam;
    private String rijksNummer;
    private LocalDate geboortedatum;

    public Persoon(String deNaam, String deVoornaam, String deRijksNummer, LocalDate deGeboortedatum){
        this.naam = deNaam;
        this.voornaam = deVoornaam;
        this.rijksNummer = deRijksNummer;
        this.geboortedatum = deGeboortedatum;
    }

    public String getNaam() {
        return naam;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getRijksNummer() {
        return rijksNummer;
    }

    public LocalDate getGeboortedatum() {
        return geboortedatum;
    }
}
