package model;

import java.time.LocalDate;
/**
 * Vertegenwoordigt een steward op de trein.
 * Verantwoordelijk voor de service aan boord en de veiligheid van passagiers.
 * @author Selma Benhadi
 */
public class Steward extends Staff {
    public Steward(String naam, String voornaam, String rijksNummer, LocalDate geboortedatum){
        super(naam,voornaam,rijksNummer,geboortedatum);
    }
}
