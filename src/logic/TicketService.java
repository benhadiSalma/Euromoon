package logic;

import model.*;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

/**
 * Service klasse voor het beheren van ticketverkoop.
 * @author Selma Benhadi
 */
public class TicketService {
    private List<Ticket> verkochteTickets;

    public TicketService() {
        this.verkochteTickets = new ArrayList<>();
    }

    public void koopTicket(Reis r, Passagier p, KlasseType klasse, TicketType type) {
        int aantalVerkocht = 0;
        for (Ticket t : verkochteTickets) {
            if (t.getReis().equals(r)) {
                aantalVerkocht++;
            }
        }

        int maxCapaciteit = r.getReisTrein().getCapaciteit();

        if (aantalVerkocht < maxCapaciteit) {
            double finalePrijs = berekenPrijs(p, r, klasse, type);

            String ticketId = "TICKET-" + (verkochteTickets.size() + 1);
            Ticket nieuwTicket = new Ticket(p, r, ticketId, finalePrijs);
            verkochteTickets.add(nieuwTicket);

            System.out.println("Ticket verkocht! ID: " + ticketId + " - Prijs: €" + String.format("%.2f", finalePrijs));

            try (FileWriter writer = new FileWriter("Logboek.txt", true)) { // TRUE = Ajoute à la suite
                writer.write("Achat: " + ticketId + " | " + p.getNaam() + " | " + r.getAankomstStation() + " | Prijs: " + finalePrijs + "\n");
            } catch (IOException e) {
                System.out.println("Fout bij opslaan in logboek.");
            }

        } else {
            System.out.println("VOLZET! Geen plaats meer op deze trein.");
        }
    }

    private double berekenPrijs(Passagier p, Reis r, KlasseType k, TicketType t) {
        double basisPrijs = r.getTicketPrijs();

        int leeftijd = Period.between(p.getGeboortedatum(), LocalDate.now()).getYears();

        System.out.println("   [Info] Leeftijd passagier: " + leeftijd + " jaar");

        if (leeftijd < 12) {
            System.out.println("   --> Korting Kind toegepast (-25%)");
            basisPrijs = basisPrijs * 0.75;
        } else if (leeftijd >= 65) {
            System.out.println("   --> Korting Senior toegepast (-15%)");
            basisPrijs = basisPrijs * 0.85;
        }

        if (k == KlasseType.EERSTE_KLASSE) {
            basisPrijs = basisPrijs * 1.5;
        }

        if (t == TicketType.HEEN_TERUG) {
            basisPrijs = basisPrijs * 2;
        }

        return basisPrijs;
    }

    public List<Ticket> getVerkochteTickets() {
        return verkochteTickets;
    }

    public void printBoardingLijst(Reis r) {
        String veiligeTijd = r.getTijdstip().toString().replace(":", "-");
        String bestandsNaam = r.getVertrekStation() + "_" + r.getAankomstStation() + "_" + veiligeTijd + ".txt";

        System.out.println("⏳ Bezig met genereren van boardinglijst...");
        try (FileWriter writer = new FileWriter(bestandsNaam)) {
            writer.write("=========================================\n");
            writer.write("              BOARDINGLIJST              \n");
            writer.write("=========================================\n");
            writer.write("Reis: " + r.getVertrekStation() + " -> " + r.getAankomstStation() + "\n");
            writer.write("Vertrek: " + r.getTijdstip() + "\n");
            writer.write("Trein: " + r.getReisTrein().getNaam() + "\n");
            writer.write("-----------------------------------------\n");

            int count = 0;
            for (Ticket t : verkochteTickets) {
                if (t.getReis().equals(r)) {
                    writer.write("Passagier #" + (count + 1) + "\n");
                    writer.write(" - Naam: " + t.getPassagier().getNaam() + " " + t.getPassagier().getVoornaam() + "\n");
                    writer.write(" - RRN: " + t.getPassagier().getRijksNummer() + "\n");
                    writer.write(" - Ticket ID: " + t.getTicketId() + "\n");
                    writer.write("-----------------------------------------\n");
                    count++;
                }
            }

            if (count == 0) writer.write("Geen passagiers voor deze reis.\n");
            writer.write("Totaal passagiers: " + count + "\n");

            System.out.println("SUCCES! Bestand aangemaakt: " + bestandsNaam);

        } catch (IOException e) {
            System.out.println("Fout bij het maken van bestand: " + e.getMessage());
        }
    }
}