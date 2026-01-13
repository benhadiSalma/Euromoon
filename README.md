# Project Euromoon – Treinmaatschappij Applicatie

## Projectomschrijving
Dit project is een Java Command Line Interface (CLI) applicatie ontwikkeld
voor de fictieve treinmaatschappij **Euromoon**.  
De applicatie laat toe om passagiers te registreren, internationale treinreizen
aan te maken en tickets te verkopen met automatische prijsberekening en
capaciteitscontrole.

Het project werd uitgewerkt als proof of concept binnen het vak  
**Programming Advanced & Project Flow** aan de Erasmushogeschool Brussel.

---

## Functionaliteiten
- **Passagierbeheer**  
  Registratie van passagiers met controle op een uniek rijksregisternummer.

- **Reisplanning**  
  Aanmaken van reizen tussen Europese hoofdsteden, gekoppeld aan specifieke
  treinen (locomotieven en wagons).

- **Treinbeheer**  
  Beheer van treinsamenstellingen met locomotieven en wagons, rekening houdend
  met maximale capaciteit.

- **Ticketverkoop**  
  Verkoop van tickets in eerste en tweede klasse met automatische kortingen:
  - Kinderen jonger dan 12 jaar: -25%
  - Senioren vanaf 65 jaar: -15%

- **Boardinglijst**  
  Genereren van een tekstbestand per reis met:
  - alle passagiers met een geldig ticket
  - het vaste boordpersoneel (conducteur en stewards) van de trein

- **Zoekfunctionaliteit**  
  Opzoeken van tickets via een unieke ticket-ID.

---

## Planning en planmatig werken
De planning van dit project werd opgevolgd aan de hand van een product backlog
in Excel (**ProductBacklog.xlsx**).  
In deze backlog werden de user stories, taken en voortgang per functionaliteit
gestructureerd bijgehouden.

Alle essentiële functionaliteiten uit de opdracht werden geïmplementeerd
volgens deze planning.

---

## Gebruik van AI-tools
Tijdens de ontwikkeling van dit project werd gebruik gemaakt van AI-tools
als **ondersteunend hulpmiddel**.

**Gemini (Google AI)** werd gebruikt voor:
- Ondersteuning bij het structureren van de code
  (scheiding tussen de packages `model` en `logic`).
- Hulp bij debugging van invoerproblemen met de Java `Scanner`.
- Verbetering en verduidelijking van Javadoc-documentatie.
- Taalondersteuning (spelling, formulering en vertaling van technische termen).

**ChatGPT (OpenAI)** werd gebruikt in een latere fase van het project voor:
- Relecture en inhoudelijke versterking van bestaande code.
- Controleren van de samenhang met de user stories en beoordelingscriteria.
- Verbeteren van documentatie en README-structuur.

Alle door AI gegenereerde suggesties werden kritisch nagelezen, aangepast
en gevalideerd door de student.  
De uiteindelijke code, ontwerpkeuzes en implementaties zijn volledig eigen werk.

---

## Gebruikte bronnen
- Cursusmateriaal **Programming Advanced & Project Flow**  
  (Erasmushogeschool Brussel).
- Java Oracle Documentation:
  - `java.time.LocalDate`
  - `java.time.LocalDateTime`
  - `java.time.Period`
- Eigen code-archief uit eerdere labo’s en opdrachten van dit academiejaar.

---

## Auteur
**Selma Benhadi**  
Student Programming Advanced & Project Flow  
Erasmushogeschool Brussel (EhB)

