package model;

import java.time.LocalDate;
/**
 * Vertegenwoordigt een treinbestuurder.
 * Deze persoon is verantwoordelijk voor het besturen van de locomotief.
 * Vereist specifieke rijbewijzen en veiligheidscertificaten.
 * @author Selma Benhadi
 */
public class Conductor extends Staff {
    public Conductor(String naam, String voornaam, String rijksNummer, LocalDate geboortedatum){
        super(naam,voornaam,rijksNummer,geboortedatum);
    }
}
