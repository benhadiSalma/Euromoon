# Euromoon - Trein Ticket Systeem

## Projectomschrijving
Dit project is een Java Command Line Interface (CLI) applicatie ontwikkeld voor de fictieve treinmaatschappij **Euromoon**. De applicatie faciliteert het beheer van internationale treinreizen, passagiersregistratie en ticketverkoop met geautomatiseerde prijsberekening en capaciteitscontrole.

Dit project is uitgevoerd als *Proof of Concept* (PoC) voor het vak **Programming Advanced & Project Flow** aan de Erasmushogeschool Brussel.

## Functionaliteiten

### 1. Passagierbeheer & Registratie
* **Identificatie:** Registratie op basis van het Rijksregisternummer.
* **Validatie:** Gebruik van **Reguliere Expressies (Regex)** om het strikte formaat `xx.xx.xx-xxx.xx` te waarborgen.
* **Uniciteit:** Controle op dubbele registraties in het systeem.

### 2. Reisplanning & Treinbeheer
* **Reisbeheer:** Aanmaken van trajecten tussen Europese hoofdsteden met specifieke tijdstippen.
* **Vloot:** Koppeling van reizen aan treinen bestaande uit een locomotief en een variabel aantal wagons.
* **Capaciteit:** Automatische berekening van het maximaal aantal zitplaatsen.

### 3. Ticketverkoop (Core Logic)
* **Unieke Identificatie:** Elk ticket krijgt een universeel unieke code via de **Java UUID-standaard** (Universally Unique Identifier).
* **Prijsberekening:** Geautomatiseerde logica gebaseerd op:
    * **Leeftijd:** Kortingen voor kinderen (-25%) en senioren (-15%).
    * **Klasse:** Toeslag voor 1ste klasse (x1.5).
    * **Type:** Verdubbeling van de prijs voor heen-en-terug tickets (x2).
* **Volzet-beheer:** Automatische detectie van volle treinen met een suggestiesysteem voor alternatieve tijdstippen.

### 4. Boardinglijst & Rapportage
* **Export:** Genereren van een `.txt` bestand per reis met daarin de passagierslijst en het toegewezen boordpersoneel (Conductor & Stewards).
* **Logging:** Bijhouden van alle verkopen in een centraal logboekbestand (`Logboek.txt`).

## Planning en Methodologie
De ontwikkeling werd gestuurd door een **Product Backlog** (Excel), waarbij gewerkt werd met User Stories en Acceptance Criteria (AC). De voortgang is nauwkeurig opgevolgd om te voldoen aan de technische vereisten van de opdracht.

## Gebruik van AI-tools
Tijdens dit project werd AI (Gemini & ChatGPT) ingezet als **interactieve taalcoach** en ondersteunend hulpmiddel.
* **Taalondersteuning:** Verbetering van de Nederlandstalige formuleringen in de interface en de documentatie (User Stories).
* **Debugging:** Ondersteuning bij het oplossen van Scanner-gerelateerde problemen en complexe Regex-patronen.
* **Logische Structuur:** Hulp bij het automatiseren van de vloot-initialisatie (het automatisch opvullen van treinen met locomotieven, wagons en personeel) om een functionele testomgeving te creëren.
* **Documentatie:** Hulp bij het structureren van de README en Javadoc volgens de academische standaarden.
* *Noot: De volledige logica, architectuur en finale implementaties zijn handmatig uitgevoerd en gevalideerd door de student.*

## Bronvermelding (APA-stijl)

Erasmushogeschool Brussel. (2025). *Programming Advanced: Syllabus en cursusmateriaal*. Brussel: EhB.

Erasmushogeschool Brussel. (2025). *Project Flow: Agile & Scrum methodologie*. Brussel: EhB.

Oracle. (z.d.). *Pattern (Java Platform SE 8 )*. Geraadpleegd op 8 januari 2026, van https://docs.oracle.com/javase/8/docs/api/java/util/regex/Pattern.html

Oracle. (z.d.). *UUID (Java Platform SE 8 )*. Geraadpleegd op 8 januari 2026, van https://docs.oracle.com/javase/8/docs/api/java/util/UUID.html

## Auteur
**Selma Benhadi** Student Programming Advanced & Project Flow  
Erasmushogeschool Brussel (EhB)

