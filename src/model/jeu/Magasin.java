//Jérémie Caron     itération 2

package model.jeu;

/* create a class that can access Argent class*/

import model.plantes.BlueBlue;
import model.plantes.JavaFern;
import model.plantes.ScarletRot;
import model.poissons.PoissonBetta;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;

public class Magasin {

    /**
     * @param prix
     *             méthode qui permet de mettre à jour le montant d'argent
     */
    public static void ajustement_argent(int prix) {
        Argent.argent -= prix;
    }

    /**
     * @param type
     *             méthode qui permet de voir lle bon prix pour le bon item
     */
    public static void checkPoissonPrix(String type) {
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

    /**
     * @param type
     *             méthode qui permet de voir lle bon prix pour le bon item
     */
    public static void checkPlantePrix(String type) {
        switch (type) {
            case "java":
                ajustement_argent(JavaFern.prix);
                break;

            case "blue":
                ajustement_argent(BlueBlue.prix);
                break;

            case "scarlet":
                ajustement_argent(ScarletRot.prix);
                break;
            default:
                break;
        }
    }

    /**
     * @param type
     * @return boolean
     *         méthode qui permet de voir si on a asser d'argent
     */
    public static boolean gotMoney(String type) {
        switch (type) {
            case "rouge":
                if (Argent.argent >= PoissonRouge.prix) {
                    return true;
                }
            case "betta":
                if (Argent.argent >= PoissonBetta.prix) {
                    return true;
                }
            case "tetra":
                // System.out.println(Argent.argent);
                if (Argent.argent >= PoissonTetra.prix) {
                    return true;
                }
            case "java":
                if (Argent.argent >= JavaFern.prix) {
                    return true;
                }
            case "blue":
                if (Argent.argent >= BlueBlue.prix) {
                    return true;
                }
            case "scarlet":
                if (Argent.argent >= ScarletRot.prix) {
                    return true;
                }
            default:
                return false;
        }
    }
}
