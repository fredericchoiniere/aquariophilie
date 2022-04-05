package model.jeu;

/* create a class that can access Argent class*/
import model.jeu.Argent;

public class Magasin {

    public static void ajustement_argent(int prix) {
        Argent.argent -= prix;
    }

    public static void checkPoissonPrix(String type){
        switch (type) {
            case "rouge":
                ajustement_argent(50);
                break;

            case "betta":
                ajustement_argent(200);
                break;

            case "tetra":
                ajustement_argent(500);
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
                if(Argent.argent >= 50){
                    return true;
                }
                
            case "betta":
                if(Argent.argent >= 200){
                    return true;
                }
            case "tetra":
                if(Argent.argent >= 500){
                    return true;
                }
            case "java":
                if(Argent.argent >= 450){
                    return true;
                }
            case "blue":
                if(Argent.argent >= 200){
                    return true;
                }
            case "scarlet":
                if(Argent.argent >= 1000){
                    return true;
                }
            default:
                return false;
        }
    }
}
