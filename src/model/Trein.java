package model;
import java.util.ArrayList;
import java.util.List;
/**
 * De Trein klasse beheert de samenstelling van een trein.
 * Het bevat een locomotief en een lijst van wagons, en zorgt ervoor
 * dat de regels van de locomotief (maximaal aantal wagons) gerespecteerd worden.
 * @author Selma Benhadi
 */
public class Trein {
    private String naam;
    private LocomotiefModel locomotief;
    private List<Wagon> wagons;

    public Trein(String naam, LocomotiefModel deLoco){
        this.naam = naam;
        this.locomotief = deLoco;
        this.wagons = new ArrayList<>();
    }

    public String getNaam() {
        return naam;
    }

    public LocomotiefModel getLocomotiefModel() {
        return locomotief;
    }

    public List<Wagon> getAantalWagons() {
        return wagons;
    }

    /**
     * Voegt een nieuwe wagon toe aan de trein als de capaciteit het toelaat.
     * Controleert eerst of het huidige aantal wagons kleiner is dan het maximum
     * dat de locomotief kan trekken.
     * * @param nieuwWagon De wagon die toegevoegd moet worden aan de lijst.
     */
    public void voegWagonToe(Wagon hetWagon){
        int max = this.locomotief.getMaxWagons();

        if(this.wagons.size() < this.locomotief.getMaxWagons()){
            this.wagons.add(hetWagon);
            System.out.println("Wagon toegevoegd aan de trein " + this.naam);
        }
        else{
            System.out.println("de trein is compleet ! De locomotief kan niet meer trekken.");
        }
    }
}
