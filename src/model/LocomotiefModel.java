package model;
/**
 * Enumeratie van de verschillende types locomotieven (zoals Class 373, 374).
 * Elk model heeft een vast maximum aantal wagons dat het kan trekken.
 * @author Selma Benhadi
 */
public enum LocomotiefModel {
    CLASS_373(12),
    CLASS_374(14),
    CLASS_100(6),
    HYPERLOOP(50);

    private final int maxWagons;

    LocomotiefModel(int maxWagons){
        this.maxWagons = maxWagons;
    }

    public int getMaxWagons() {
        return maxWagons;
    }
}
