package model;
/**
 * Een wagon object dat deel uitmaakt van een trein.
 * Elke wagon heeft een uniek ID en een specifiek klasses-type (Eerste of Tweede klasse).
 * @author Selma Benhadi
 */
public class Wagon {
    private int id;
    private KlasseType type;

    public Wagon(int id, KlasseType type){
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public KlasseType getType() {
        return type;
    }

    public int getZitplaatsen(){
        return this.type.getAantalZitplaatsen();
    }
}
