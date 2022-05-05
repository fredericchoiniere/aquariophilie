//Jérémie Caron     itération 2
// Jérémie Caron    itération 3

package model.jeu;

import java.util.Random;

/* create a class that can access Argent class*/

import model.plantes.BlueBlue;
import model.plantes.Erdtree;
import model.plantes.JavaFern;
import model.plantes.ScarletRot;
import model.poissons.PoissonBetta;
import model.poissons.PoissonNeo;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;
import view.tabs.PanelShop;

public class Magasin {

    static int emp = 0;
    static Random random = new Random();

    final static int prix_rouge = PoissonRouge.prix;
    final static int prix_betta = PoissonBetta.prix;
    final static int prix_tetra = PoissonTetra.prix;
    final static int prix_neo = PoissonNeo.prix;
    final static int prix_blue = BlueBlue.prix;
    final static int prix_java = JavaFern.prix;
    final static int prix_scarlet = ScarletRot.prix;
    final static int prix_erdtree = Erdtree.prix;

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

    public static void updateToolTip(){
        PanelShop.poisson_rouge.setToolTipText("Prix: " + PoissonRouge.prix + "฿");
        PanelShop.poisson_betta.setToolTipText("Prix: " + PoissonBetta.prix + "฿");
        PanelShop.poisson_tetra.setToolTipText("Prix: " + PoissonTetra.prix + "฿");
        PanelShop.poisson_neo.setToolTipText("Prix: " + PoissonNeo.prix + "฿");
        PanelShop.planteBlue.setToolTipText("Prix: " + BlueBlue.prix + "฿");
        PanelShop.planteFern.setToolTipText("Prix: " + JavaFern.prix + "฿");
        PanelShop.planteScarlet.setToolTipText("Prix: " + ScarletRot.prix + "฿");
        PanelShop.planteErdtree.setToolTipText("Prix: " + Erdtree.prix + "฿");
    }

    public static void rabais(short emp) {
        switch (emp) {
            case 1:
                PoissonRouge.prix = PoissonRouge.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(135, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(235, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(335, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(35, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(135, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(235, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(335, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            case 2:
                PoissonBetta.prix = PoissonBetta.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(235, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(335, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(35, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(135, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(235, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(335, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            case 3:
                PoissonTetra.prix = PoissonTetra.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(135, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(335, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(35, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(135, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(235, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(335, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            case 4:
                PoissonNeo.prix = PoissonNeo.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(135, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(235, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(35, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(135, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(235, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(335, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            case 5:
                JavaFern.prix = JavaFern.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(135, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(235, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(335, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(35, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(235, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(335, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            case 6:
                BlueBlue.prix = BlueBlue.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(135, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(235, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(335, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(135, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(235, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(335, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            case 7:
                ScarletRot.prix = ScarletRot.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(135, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(235, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(335, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(35, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(135, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(335, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            case 8:
                Erdtree.prix = Erdtree.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBounds(135, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBounds(235, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBounds(335, 214, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBounds(35, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBounds(135, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBounds(235, 384, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBounds(150, 550, PanelShop.shop_dimension.width, PanelShop.shop_dimension.height);
                break;
            default:
                break;
        }
    }


    public static void resetPrice(){
        PoissonBetta.prix = prix_betta;
        PoissonRouge.prix = prix_rouge;
        PoissonTetra.prix = prix_tetra;
        PoissonNeo.prix = prix_neo;
        JavaFern.prix = prix_java;
        BlueBlue.prix = prix_blue;
        ScarletRot.prix = prix_scarlet;
        Erdtree.prix = prix_erdtree;
    }
}
