package model;
/**
 * Vertegenwoordigt de fysieke locomotief die de trein trekt.
 * De eigenschappen (zoals maximum wagons) worden bepaald door het LocomotiefModel.
 * @author Selma Benhadi
 */
public class Locomotief {
    private String naam;
    private LocomotiefModel type;
    private final int plaats = 80;

    public Locomotief(String deNaam, LocomotiefModel modelLoco){
        this.naam = deNaam;
        this.type = modelLoco;
    }

    public String getNaam() {
        return naam;
    }

    public LocomotiefModel getModel() {
        return type;
    }

    public int getPlaats() {
        return plaats;
    }

    public int getWagon(){
        return this.type.getMaxWagons();
    }
}
