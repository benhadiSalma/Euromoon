package logic;

import model.Passagier;

import java.util.ArrayList;
import java.util.List;
/**
 * Service klasse voor het beheren van de passagierslijst.
 * Zorgt ervoor dat elke passagier uniek is op basis van het rijksregisternummer.
 * @author Selma Benhadi
 */
public class PassagierService {
    private List<Passagier> passsagiersLijst;

    public PassagierService(){
        this.passsagiersLijst = new ArrayList<>();
    }
    /**
     * Voegt een nieuwe passagier toe aan de lijst.
     * Controleert eerst of het rijksregisternummer al bestaat om dubbele items te voorkomen.
     * @param nieuwPassagier De passagier die toegevoegd moet worden.
     */
    public void voegPassagierToe(Passagier nieuwPassagier){
        boolean bestaat = false;

        for(Passagier passagier : passsagiersLijst){
            if(passagier.getRijksNummer().equals(nieuwPassagier.getRijksNummer())){
                bestaat = true;
                break;
            }
        }

        if(!bestaat){
            passsagiersLijst.add(nieuwPassagier);
            System.out.println("Passagier toegevoegd: " + nieuwPassagier.getNaam() + " " + nieuwPassagier.getVoornaam());
        }
        else{
            System.out.println("fout : Deze passagier bestaat al!!");
        }
    }

    public List<Passagier> getPassagiersLijst() {
        return passsagiersLijst;
    }
}
