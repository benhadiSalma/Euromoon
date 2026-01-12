package model;
import java.time.LocalDateTime;
/**
 * Deze klasse vertegenwoordigt een specifieke reis tussen twee stations.
 * Een reis heeft een vaste vertrektijd, een prijs en een gekoppelde trein.
 * @author Selma Benhadi
 */
public class Reis {
    private String vertrekStation;
    private String aankomstStation;
    private LocalDateTime tijdstip;
    private Double ticketPrijs;
    private Trein reisTrein;

    public Reis(String vertrekStation, String aankomstStation, LocalDateTime tijdstip, Double ticketPrijs, Trein reisTrein) {
        this.vertrekStation = vertrekStation;
        this.aankomstStation = aankomstStation;
        this.tijdstip = tijdstip;
        this.ticketPrijs = ticketPrijs;
        this.reisTrein = reisTrein;
    }

    public String getVertrekStation() {
        return vertrekStation;
    }

    public String getAankomstStation() {
        return aankomstStation;
    }

    public LocalDateTime getTijdstip() {
        return tijdstip;
    }

    public Double getTicketPrijs() {
        return ticketPrijs;
    }

    public Trein getReisTrein() {
        return reisTrein;
    }
}
