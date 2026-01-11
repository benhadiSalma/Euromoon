package model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
/**
 * Abstracte klasse die alle personeelsleden (Staff) van Euromoon vertegenwoordigt.
 * Naast de basisgegevens, beheert deze klasse ook de lijst met behaalde certificaten.
 * @author Selma Benhadi
 */
public abstract class Staff extends Persoon {
    private List<String> certificaten;

    public Staff (String naam, String voornaam, String rijksNummer, LocalDate geboortedatum){
        super(naam,voornaam,rijksNummer,geboortedatum);
        this.certificaten = new ArrayList<>();
    }

    public List<String> getCertificaten() {
        return certificaten;
    }
    /**
     * Voegt een nieuw behaald certificaat toe aan de lijst van dit personeelslid.
     * @param nieuwCertificaat De naam van het certificaat (bv. 'Veiligheid', 'EHBO').
     */
    public void voegCertificaat(String nieuwCertificaat){
        certificaten.add(nieuwCertificaat);
    }
}
