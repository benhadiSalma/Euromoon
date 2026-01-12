package model;
/**
 * Deze klasse vertegenwoordigt een ticket voor een specifieke reis binnen het Euromoon-systeem.
 * Het koppelt een passagier aan een reis en bevat de prijs en unieke ticket-ID.
 * @author Benhadi Salma
 */
public class Ticket {
    private Passagier passagier;
    private Reis reis;
    private String ticketId;
    private double prijs;

    public Ticket(Passagier passagier, Reis reis, String ticketId, double prijs){
        this.passagier = passagier;
        this.reis = reis;
        this.ticketId = ticketId;
        this.prijs = prijs;
    }

    public Passagier getPassagier() {
        return passagier;
    }

    public Reis getReis() {
        return reis;
    }

    public String getTicketId() {
        return ticketId;
    }

    public double getPrijs() {
        return prijs;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public void setPrijs(double prijs) {
        this.prijs = prijs;
    }
}
