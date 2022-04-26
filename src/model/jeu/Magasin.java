//Jérémie Caron     itération 2

package model.jeu;

import java.awt.Color;
import java.util.Random;

/* create a class that can access Argent class*/

import model.plantes.BlueBlue;
import model.plantes.Erdtree;
import model.plantes.JavaFern;
import model.plantes.ScarletRot;
import model.poissons.Poisson;
import model.poissons.PoissonBetta;
import model.poissons.PoissonNeo;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;
import view.tabs.PanelShop;

public class Magasin {

    static int emp = 0;
    static Random random = new Random();

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
            case "neo":
                ajustement_argent(PoissonNeo.prix);
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

            case "erdtree":
                ajustement_argent(Erdtree.prix);
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
            case "neo":
                if (Argent.argent >= PoissonNeo.prix) {
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
            case "erdtree":
                if (Argent.argent >= Erdtree.prix) {
                    return true;
                }
            default:
                return false;
        }
    }

    public static int generatingNumber() {
        return emp = random.nextInt(8) + 1;
    }

    public static void rabais(short emp) {
        switch (emp) {
            case 1:
                PoissonRouge.prix = PoissonRouge.prix / 2;
                PanelShop.poisson_rouge.setBackground(Color.GRAY);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));
                break;
            case 2:
                PoissonBetta.prix = PoissonBetta.prix / 2;
                PanelShop.poisson_betta.setBackground(Color.GRAY);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));
                break;
            case 3:
                PoissonTetra.prix = PoissonTetra.prix / 2;
                PanelShop.poisson_tetra.setBackground(Color.GRAY);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));
                break;
            case 4:
                PoissonNeo.prix = PoissonNeo.prix / 2;
                PanelShop.poisson_neo.setBackground(Color.GRAY);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));
                break;
            case 5:
                JavaFern.prix = JavaFern.prix / 2;
                PanelShop.planteFern.setBackground(Color.GRAY);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));
                break;
            case 6:
                BlueBlue.prix = BlueBlue.prix / 2;
                PanelShop.planteBlue.setBackground(Color.GRAY);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));
                break;
            case 7:
                ScarletRot.prix = ScarletRot.prix / 2;
                PanelShop.planteScarlet.setBackground(Color.GRAY);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));
                break;
            case 8:
                Erdtree.prix = Erdtree.prix / 2;
                PanelShop.planteErdtree.setBackground(Color.GRAY);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                break;
            default:
                break;
        }
    }

}
