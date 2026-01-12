package model;

import java.util.ArrayList;
import java.util.List;

/**
 * De Trein klasse beheert de samenstelling van een trein.
 * Het bevat een locomotief en een lijst van wagons.
 * @author Selma Benhadi
 */
public class Trein {
    private String naam;
    private Locomotief locomotief;
    private List<Wagon> wagons;

    public Trein(String naam, Locomotief deLoco){
        this.naam = naam;
        this.locomotief = deLoco;
        this.wagons = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public Locomotief getLocomotief() {
        return locomotief;
    }

    public List<Wagon> getWagons() {
        return wagons;
    }
    /**
     * Voegt een nieuwe wagon toe aan de trein als de capaciteit het toelaat.
     * Controleert eerst of het huidige aantal wagons kleiner is dan het maximum
     * dat de locomotief kan trekken.
     * * @param nieuwWagon De wagon die toegevoegd moet worden aan de lijst.
     */
    public void voegWagonToe(Wagon hetWagon){
        if(this.wagons.size() < this.locomotief.getWagon()){
            this.wagons.add(hetWagon);
        }
    }
    public int getCapaciteit(){
        return this.locomotief.getWagon() * this.locomotief.getPlaats();
    }
}
