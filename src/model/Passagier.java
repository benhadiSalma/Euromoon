package model;

import java.time.LocalDate;
/**
 * Vertegenwoordigt een klant van de spoorwegmaatschappij.
 * Een passagier kan tickets kopen en reizen maken.
 * @author Selma Benhadi
 */
public class Passagier extends Persoon {
    public Passagier(String naam, String voornaam, String rijksNummer, LocalDate geboortedatum){
        super(naam,voornaam,rijksNummer,geboortedatum);
    }
}
