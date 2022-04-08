package model.jeu;

/* create a class that can access Argent class*/
import model.jeu.Argent;
import model.poissons.PoissonBetta;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;

public class Magasin {

    public static void ajustement_argent(int prix) {
        Argent.argent -= prix;
    }

    public static void checkPoissonPrix(String type){
        switch (type) {
            case "rouge":
                ajustement_argent(PoissonRouge.prix);
                break;

            case "betta":
                ajustement_argent(PoissonBetta.prix);
                break;

            case "tetra":
                ajustement_argent(PoissonTetra.prix);
                break;
            default:
                break;
        }
    }

    public static void checkPlantePrix(String type){
        switch (type) {
            case "java":
                ajustement_argent(450);
                break;

            case "blue":
                ajustement_argent(200);
                break;

            case "scarlet":
                ajustement_argent(1000);
                break;
            default:
                break;
        }
    }

    public static boolean gotMoney(String type){
        switch (type) {
            case "rouge":
                if(Argent.argent >= PoissonRouge.prix) {
                    return true;
                }
                
            case "betta":
                if(Argent.argent >= PoissonBetta.prix){
                    return true;
                }
            case "tetra":
                if(Argent.argent >= PoissonTetra.prix){
                    return true;
                }
            case "java":
                if(Argent.argent >= PoissonBetta.prix){
                    return true;
                }
            case "blue":
                if(Argent.argent >= PoissonBetta.prix){
                    return true;
                }
            case "scarlet":
                if(Argent.argent >= PoissonBetta.prix){
                    return true;
                }
            default:
                return false;
        }
    }
}
