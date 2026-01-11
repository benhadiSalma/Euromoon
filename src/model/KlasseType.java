package model;
/**
 * Definieert de verschillende klasses beschikbaar in een wagon (Eerste of Tweede klasse).
 * Bepaalt ook het aantal zitplaatsen per wagon.
 * @author Selma Benhadi
 */
public enum KlasseType {
    EERSTE_KLASSE(40),
    TWEEDE_KLASSE(100);

    private final int aantalZitplaatsen;

    KlasseType(int aantalZitplaatsen1){
        this.aantalZitplaatsen = aantalZitplaatsen1;
    }

    public int getAantalZitplaatsen() {
        return aantalZitplaatsen;
    }
}
