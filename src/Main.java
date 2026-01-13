import logic.PassagierService;
import logic.TicketService;
import model.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;
/**
 * Hoofdklasse van de Euromoon applicatie.
 * Deze klasse bevat het hoofdmenu van de applicatie en laat de gebruiker toe
 * om passagiers te registreren, reizen aan te maken, tickets te verkopen
 * en boardinglijsten af te drukken.
 * De Main klasse stuurt de applicatie aan, maar bevat geen businesslogica.
 * @author Selma Benhadi
 */

public class Main {

    public static void main(String[] args) {

        TicketService ticketService = new TicketService();
        PassagierService passagierService = new PassagierService();
        Scanner scanner = new Scanner(System.in);

        Locomotief loco1 = new Locomotief("Loco-373-A", LocomotiefModel.CLASS_373);
        Trein trein1 = new Trein("Brussel-London", loco1);
        for (int i = 1; i <= 12; i++) trein1.voegWagonToe(new Wagon(i, KlasseType.TWEEDE_KLASSE));

        Locomotief loco2 = new Locomotief("Loco-374-S", LocomotiefModel.CLASS_374);
        Trein trein2 = new Trein("Brussel-Amsterdam", loco2);
        for (int i = 1; i <= 14; i++) {
            if (i <= 2) trein2.voegWagonToe(new Wagon(i, KlasseType.EERSTE_KLASSE));
            else trein2.voegWagonToe(new Wagon(i, KlasseType.TWEEDE_KLASSE));
        }

        Locomotief loco3 = new Locomotief("Loco-Class-100-S", LocomotiefModel.CLASS_100);
        Trein trein3 = new Trein("Brussel-Parijs", loco3);
        for (int i = 1; i <= 6; i++) trein3.voegWagonToe(new Wagon(i, KlasseType.TWEEDE_KLASSE));

        Locomotief loco4 = new Locomotief("Loco-Hyperloop-A", LocomotiefModel.HYPERLOOP);
        Trein trein4 = new Trein("Brussel-Berlijn", loco4);
        for (int i = 1; i <= 50; i++) {
            if (i <= 6) trein4.voegWagonToe(new Wagon(i, KlasseType.EERSTE_KLASSE));
            else trein4.voegWagonToe(new Wagon(i, KlasseType.TWEEDE_KLASSE));
        }

        List<Trein> treinenVloot = new ArrayList<>();
        treinenVloot.add(trein1);
        treinenVloot.add(trein2);
        treinenVloot.add(trein3);
        treinenVloot.add(trein4);

        List<Reis> reizen = new ArrayList<>();
        reizen.add(new Reis("Brussel", "Parijs", LocalDateTime.of(2025, 5, 20, 8, 0), 80.0, trein3));
        reizen.add(new Reis("Brussel", "Parijs", LocalDateTime.of(2025, 5, 20, 10, 0), 85.0, trein3));
        reizen.add(new Reis("Brussel", "Berlijn", LocalDateTime.of(2025, 5, 20, 14, 30), 120.0, trein4));
        reizen.add(new Reis("Brussel", "Amsterdam", LocalDateTime.of(2025, 5, 20, 11, 15), 45.0, trein2));
        reizen.add(new Reis("Brussel", "Londen", LocalDateTime.of(2025, 5, 21, 9, 30), 60.0, trein1));

        Reis testReis = reizen.get(0);
        Passagier ghost = new Passagier("Ghost", "Tester", "00.00.00-000.00", LocalDate.of(1990,1,1));

        int capaciteit = testReis.getReisTrein().getCapaciteit();
        for(int k = 0; k < capaciteit; k++){
            String fakeId = java.util.UUID.randomUUID().toString();
            Ticket t = new Ticket(ghost, testReis, fakeId, 0.0);

            ticketService.getVerkochteTickets().add(t);
        }

        List<Staff> personeel = new ArrayList<>();

        Steward steward1 = new Steward("Asushi", "Lina", "95.03.12-111.22", LocalDate.of(1995, 3, 12));
        steward1.voegCertificaat("EHBO");

        Steward steward2 = new Steward("Hurani", "Marwan", "92.11.08-333.44", LocalDate.of(1992, 11, 8));
        steward2.voegCertificaat("Brandveiligheid");

        Steward steward3 = new Steward("Bensahour", "Sara", "98.07.21-555.66", LocalDate.of(1998, 7, 21));
        steward3.voegCertificaat("Evacuatieprocedures");

        Conductor conductor = new Conductor("Aaiachi", "Farid", "85.01.30-777.88", LocalDate.of(1985, 1, 30));
        conductor.voegCertificaat("Treinbesturing");

        personeel.add(steward1);
        personeel.add(steward2);
        personeel.add(steward3);
        personeel.add(conductor);

        trein1.voegPersoneelToe(steward1);
        trein1.voegPersoneelToe(steward2);
        trein1.voegPersoneelToe(steward3);
        trein1.voegPersoneelToe(conductor);

        trein2.voegPersoneelToe(steward1);
        trein2.voegPersoneelToe(steward2);
        trein2.voegPersoneelToe(steward3);
        trein2.voegPersoneelToe(conductor);

        trein3.voegPersoneelToe(steward1);
        trein3.voegPersoneelToe(steward2);
        trein3.voegPersoneelToe(steward3);
        trein3.voegPersoneelToe(conductor);


        System.out.println("======== WELKOM BIJ EUROMOON ==========");

        while (true) {
            System.out.println("\n*** MENU SELECTEER JOUW KEUZE ***");
            System.out.println("1. Ticket kopen");
            System.out.println("2. Bekijk reizen");
            System.out.println("3. Bekijk het logboek (Historiek)");
            System.out.println("4. Zoek een ticket");
            System.out.println("5. Bekijk Boardinglijst ");
            System.out.println("6. Maak een nieuwe reis aan");
            System.out.println("7. Zoek personeel");
            System.out.println("0. Sessie stoppen");

            System.out.print("Uw keuze : ");
            if (scanner.hasNextInt()) {
                int keuze = scanner.nextInt();
                scanner.nextLine();

                switch (keuze) {
                    case 1:
                        System.out.println("---Reserveer ticket hier---");
                        System.out.println("Kies de reis nummer 1-" + reizen.size());
                        if (scanner.hasNextInt()) {
                            int reisIndex = scanner.nextInt() - 1;
                            scanner.nextLine();

                            if (reisIndex < 0 || reisIndex >= reizen.size()) {
                                System.out.println("Ongeldig nummer");
                                break;
                            }
                            Reis gekozenReis = reizen.get(reisIndex);
                            long sold = ticketService.getVerkochteTickets().stream().filter(t -> t.getReis().equals(gekozenReis)).count();

                            if (sold >= gekozenReis.getReisTrein().getCapaciteit()) {
                                System.out.println("Deze trein is volzet.");

                                System.out.println("=== Alternatieve Reizen ===");
                                boolean found = false;

                                for (Reis r : reizen) {
                                    if (r.getVertrekStation().equalsIgnoreCase(gekozenReis.getVertrekStation()) &&
                                            r.getAankomstStation().equalsIgnoreCase(gekozenReis.getAankomstStation()) &&
                                            r.getTijdstip().isAfter(gekozenReis.getTijdstip())) {
                                        System.out.println("Alternative : " + r.getTijdstip() + " met " + r.getReisTrein().getNaam());
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Geen alternative gevonden");
                                }
                                break;
                            }
                            System.out.println("Aantal personen?");
                            int aantal = scanner.nextInt();
                            scanner.nextLine();

                            for (int i = 0; i < aantal; i++) {
                                System.out.println("\n--- PASSAGIER " + (i + 1) + " ---");
                                String rrn = "";
                                Passagier passagierVoorTicket = null;

                                while (true) {
                                    System.out.print("Rijksregisternummer (xx.xx.xx-xxx.xx): ");
                                    rrn = scanner.nextLine();

                                    if (!rrn.matches("[0-9]{2}\\.[0-9]{2}\\.[0-9]{2}-[0-9]{3}\\.[0-9]{2}")) {
                                        System.out.println("Fout formaat!");
                                        continue;
                                    }

                                    boolean heeftAlTicket = false;
                                    for (Ticket t : ticketService.getVerkochteTickets()) {
                                        if (t.getReis().equals(gekozenReis) && t.getPassagier().getRijksNummer().equals(rrn)) {
                                            heeftAlTicket = true;
                                            break;
                                        }
                                    }

                                    if (heeftAlTicket) {
                                        System.out.println("Fout: Deze passagier heeft al een ticket voor deze rit!");
                                        continue;
                                    }
                                    break;
                                }

                                for (Passagier p : passagierService.getPassagiersLijst()) {
                                    if (p.getRijksNummer().equals(rrn)) {
                                        passagierVoorTicket = p;
                                        System.out.println("👋 Welkom terug, " + p.getVoornaam() + " " + p.getNaam());
                                        break;
                                    }
                                }

                                if (passagierVoorTicket == null) {
                                    System.out.println("🆕 Nieuwe passagier! Vul de gegevens in.");
                                    String naam, voornaam;
                                    do {
                                        System.out.print("Naam: ");
                                        naam = scanner.nextLine();
                                    } while (!naam.matches("[a-zA-Z -]+"));

                                    do {
                                        System.out.print("Voornaam: ");
                                        voornaam = scanner.nextLine();
                                    } while (!voornaam.matches("[a-zA-Z -]+"));

                                    System.out.print("Geboortedatum (YYYY-MM-DD): ");
                                    LocalDate gebDatum = LocalDate.of(2000, 1, 1);
                                    try {
                                        gebDatum = LocalDate.parse(scanner.nextLine());
                                    } catch (Exception e) {
                                    }

                                    passagierVoorTicket = new Passagier(naam, voornaam, rrn, gebDatum);
                                    passagierService.voegPassagierToe(passagierVoorTicket);
                                }

                                int klasseKeuze = 0;
                                while (klasseKeuze != 1 && klasseKeuze != 2) {
                                    System.out.print("Klasse? (1 = Eerste, 2 = Tweede): ");
                                    if (scanner.hasNextInt()) klasseKeuze = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                KlasseType gekozenKlasse = (klasseKeuze == 1) ? KlasseType.EERSTE_KLASSE : KlasseType.TWEEDE_KLASSE;

                                int typeKeuze = 0;
                                while (typeKeuze != 1 && typeKeuze != 2) {
                                    System.out.print("Type? (1 = Enkel, 2 = Heen-Terug): ");
                                    if (scanner.hasNextInt()) typeKeuze = scanner.nextInt();
                                    scanner.nextLine();
                                }
                                TicketType gekozenType = (typeKeuze == 2) ? TicketType.HEEN_TERUG : TicketType.ENKEL;

                                ticketService.koopTicket(gekozenReis, passagierVoorTicket, gekozenKlasse, gekozenType);
                            }
                             System.out.println("Tickets aangemaakt!");
                            }

                        else {
                            System.out.println("Ongeldige invoer");
                            scanner.nextLine();
                        }
                        break;

                            case 2:
                                System.out.println("--- OVERZICHT VAN REIZEN ----");
                                for (int i = 0; i < reizen.size(); i++) {
                                    Reis r = reizen.get(i);
                                    System.out.println((i + 1) + ". " + r.getVertrekStation() + " --> " + r.getAankomstStation());
                                    System.out.println("   Tijd: " + r.getTijdstip() + " | Prijs: " + r.getTicketPrijs());
                                    System.out.println("------------------------------------------------");
                                }
                                break;

                            case 3:
                                System.out.println("****** LOGBOEK (HISTORIEK VAN BESTAND) ******");
                                try {
                                    java.io.File hist = new java.io.File("Logboek.txt");
                                    Scanner his = new Scanner(hist);

                                    if (!his.hasNextLine()) {
                                        System.out.println("Het logboek bestand is leeg.");
                                    }

                                    while (his.hasNextLine()) {
                                        String ligne = his.nextLine();
                                        System.out.println(" " + ligne);
                                    }
                                    his.close();
                                } catch (Exception e) {
                                    System.out.println("Nog geen logboek bestand gevonden. Koop eerst een ticket!");
                                }
                                break;

                            case 4:
                                System.out.println("------- ZOEK EEN TICKET -------");
                                System.out.print("Geef ID: ");
                                String zoekId = scanner.nextLine();
                                boolean gevonden = false;
                                for (Ticket ticket : ticketService.getVerkochteTickets()) {
                                    if (ticket.getTicketId().equalsIgnoreCase(zoekId)) {
                                        System.out.println("*** TICKET GEVONDEN ***");
                                        System.out.println("ID: " + ticket.getTicketId() + " - " + ticket.getPassagier().getNaam() + " - " + ticket.getPassagier().getVoornaam() + " - " +  ticket.getPrijs());
                                        gevonden = true;
                                        break;
                                    }
                                }
                                if (!gevonden) System.out.println("Geen ticket gevonden met ID : " + zoekId);
                                break;

                            case 5:
                                System.out.println("------- BOARDINGLIJST AFDRUKKEN ------");
                                System.out.println("Selecteer de reis (Nummer): ");
                                for (int i = 0; i < reizen.size(); i++) {
                                    System.out.println((i + 1) + ". " + reizen.get(i).getVertrekStation() + " --> " + reizen.get(i).getAankomstStation());
                                }
                                System.out.print("Maak keuze : ");
                                if (scanner.hasNextInt()) {
                                    int printIndex = scanner.nextInt() - 1;
                                    scanner.nextLine();
                                    if (printIndex >= 0 && printIndex < reizen.size()) {
                                        ticketService.printBoardingLijst(reizen.get(printIndex));
                                    } else {
                                        System.out.println("Ongeldig nummer.");
                                    }
                                } else {
                                    scanner.nextLine();
                                }
                                break;

                            case 6:
                                System.out.println("\n--- NIEUWE REIS AANMAKEN ---");
                                System.out.print("Vertrekstation: ");
                                String vertrek = scanner.nextLine();
                                System.out.print("Aankomststation: ");
                                String aankomst = scanner.nextLine();
                                System.out.print("Prijs: ");
                                double prijs = scanner.nextDouble();
                                scanner.nextLine();
                                System.out.print("Datum (bv. 2025-10-20T14:30): ");
                                String datumReis = scanner.nextLine();
                                LocalDateTime vertrekTijd = null;
                                try {
                                    vertrekTijd = LocalDateTime.parse(datumReis);
                                } catch (Exception e) {
                                    vertrekTijd = LocalDateTime.now();
                                }
                                System.out.println("Kies een trein:");
                                for (int i = 0; i < treinenVloot.size(); i++)
                                    System.out.println((i + 1) + ". " + treinenVloot.get(i).getNaam());

                                int treinKeuze = scanner.nextInt() - 1;
                                scanner.nextLine();
                                if (treinKeuze >= 0 && treinKeuze < treinenVloot.size()) {
                                    reizen.add(new Reis(vertrek, aankomst, vertrekTijd, prijs, treinenVloot.get(treinKeuze)));
                                    System.out.println("Reis toegevoegd!");
                                }
                                break;
                            case 7:
                                System.out.println("------- ZOEK PERSONEEL -------");
                                System.out.print("Geef de naam van het personeelslid: ");
                                String zoekNaam = scanner.nextLine();

                                boolean gevondenStaff = false;

                                for (Trein t : treinenVloot) {
                                    for (Staff s : t.getBoordPersoneel()) {
                                        if (s.getNaam().equalsIgnoreCase(zoekNaam)) {
                                            gevondenStaff = true;

                                            System.out.println("Personeelslid gevonden");
                                            System.out.println("Naam: " + s.getNaam() + " " + s.getVoornaam());
                                            System.out.println("Functie: " + s.getClass().getSimpleName());
                                            System.out.println("Trein: " + t.getNaam());

                                            if (s.getCertificaten().isEmpty()) {
                                                System.out.println("Geen certificaten geregistreerd.");
                                            } else {
                                                System.out.println("Certificaten:");
                                                for (String cert : s.getCertificaten()) {
                                                    System.out.println(" - " + cert);
                                                }
                                            }
                                            break;
                                        }
                                    }
                                }

                                if (!gevondenStaff) {
                                    System.out.println("Geen personeelslid gevonden.");
                                }
                                break;


                            case 0:
                                System.out.println("Bedankt voor het gebruik van EUROMOON. Tot ziens!");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Ongeldige keuze.");
                        }
                } else{
                    System.out.println("Ongeldige invoer, voer een cijfer in.");
                    scanner.nextLine();
                }
            }
        }
    }