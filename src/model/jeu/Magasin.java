//Jérémie Caron     itération 2
// Jérémie Caron    itération 3

package model.jeu;

import java.awt.Color;
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

    public final static int prix_rouge = PoissonRouge.prix;
    public final static int prix_betta = PoissonBetta.prix;
    public final static int prix_tetra = PoissonTetra.prix;
    public final static int prix_neo = PoissonNeo.prix;
    public final static int prix_blue = BlueBlue.prix;
    public final static int prix_java = JavaFern.prix;
    public final static int prix_scarlet = ScarletRot.prix;
    public final static int prix_erdtree = Erdtree.prix;

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

    
    /** 
     * @return int
     */
    public static int generatingNumber() {
        return emp = random.nextInt(8) + 1;
    }

    public static void updateToolTip() {
        PanelShop.poisson_rouge.setToolTipText("Prix: " + PoissonRouge.prix + "฿");
        PanelShop.poisson_betta.setToolTipText("Prix: " + PoissonBetta.prix + "฿");
        PanelShop.poisson_tetra.setToolTipText("Prix: " + PoissonTetra.prix + "฿");
        PanelShop.poisson_neo.setToolTipText("Prix: " + PoissonNeo.prix + "฿");
        PanelShop.planteBlue.setToolTipText("Prix: " + BlueBlue.prix + "฿");
        PanelShop.planteFern.setToolTipText("Prix: " + JavaFern.prix + "฿");
        PanelShop.planteScarlet.setToolTipText("Prix: " + ScarletRot.prix + "฿");
        PanelShop.planteErdtree.setToolTipText("Prix: " + Erdtree.prix + "฿");
        PanelShop.message.setVisible(false);
    }

    
    /** 
     * @param emp
     */
    public static void rabais(short emp) {
        switch (emp) {
            case 1:
                PoissonRouge.prix = PoissonRouge.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(82, 171, 198));
                PanelShop.poisson_betta.setBounds(155, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBounds(273, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBounds(390, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBounds(35, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBounds(155, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBounds(273, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBounds(390, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));

                PanelShop.rabais_rouge.setVisible(true);
                PanelShop.rabais_betta.setVisible(false);
                PanelShop.rabais_tetra.setVisible(false);
                PanelShop.rabais_neo.setVisible(false);
                PanelShop.rabais_blue.setVisible(false);
                PanelShop.rabais_fern.setVisible(false);
                PanelShop.rabais_scarlet.setVisible(false);
                PanelShop.rabais_erdtree.setVisible(false);
                break;
            case 2:
                PoissonBetta.prix = PoissonBetta.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_betta.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(82, 171, 198));
                PanelShop.poisson_tetra.setBounds(273, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBounds(390, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBounds(35, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBounds(155, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBounds(273, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBounds(390, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));

                PanelShop.rabais_rouge.setVisible(false);
                PanelShop.rabais_betta.setVisible(true);
                PanelShop.rabais_tetra.setVisible(false);
                PanelShop.rabais_neo.setVisible(false);
                PanelShop.rabais_blue.setVisible(false);
                PanelShop.rabais_fern.setVisible(false);
                PanelShop.rabais_scarlet.setVisible(false);
                PanelShop.rabais_erdtree.setVisible(false);
                break;
            case 3:
                PoissonTetra.prix = PoissonTetra.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_betta.setBounds(155, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(82, 171, 198));
                PanelShop.poisson_neo.setBounds(390, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBounds(35, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBounds(155, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBounds(273, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBounds(390, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));

                PanelShop.rabais_rouge.setVisible(false);
                PanelShop.rabais_betta.setVisible(false);
                PanelShop.rabais_tetra.setVisible(true);
                PanelShop.rabais_neo.setVisible(false);
                PanelShop.rabais_blue.setVisible(false);
                PanelShop.rabais_fern.setVisible(false);
                PanelShop.rabais_scarlet.setVisible(false);
                PanelShop.rabais_erdtree.setVisible(false);
                break;
            case 4:
                PoissonNeo.prix = PoissonNeo.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_betta.setBounds(155, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBounds(273, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(82, 171, 198));
                PanelShop.planteBlue.setBounds(35, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBounds(155, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBounds(273, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBounds(390, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));

                PanelShop.rabais_rouge.setVisible(false);
                PanelShop.rabais_betta.setVisible(false);
                PanelShop.rabais_tetra.setVisible(false);
                PanelShop.rabais_neo.setVisible(true);
                PanelShop.rabais_blue.setVisible(false);
                PanelShop.rabais_fern.setVisible(false);
                PanelShop.rabais_scarlet.setVisible(false);
                PanelShop.rabais_erdtree.setVisible(false);
                break;
            case 5:
                JavaFern.prix = JavaFern.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_betta.setBounds(155, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBounds(273, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBounds(390, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBounds(35, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(82, 171, 198));
                PanelShop.planteScarlet.setBounds(273, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBounds(390, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));

                PanelShop.rabais_rouge.setVisible(false);
                PanelShop.rabais_betta.setVisible(false);
                PanelShop.rabais_tetra.setVisible(false);
                PanelShop.rabais_neo.setVisible(false);
                PanelShop.rabais_blue.setVisible(false);
                PanelShop.rabais_fern.setVisible(true);
                PanelShop.rabais_scarlet.setVisible(false);
                PanelShop.rabais_erdtree.setVisible(false);
                break;
            case 6:
                BlueBlue.prix = BlueBlue.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_betta.setBounds(155, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBounds(273, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBounds(390, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(82, 171, 198));
                PanelShop.planteFern.setBounds(155, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBounds(273, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBounds(390, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));

                PanelShop.rabais_rouge.setVisible(false);
                PanelShop.rabais_betta.setVisible(false);
                PanelShop.rabais_tetra.setVisible(false);
                PanelShop.rabais_neo.setVisible(false);
                PanelShop.rabais_blue.setVisible(true);
                PanelShop.rabais_fern.setVisible(false);
                PanelShop.rabais_scarlet.setVisible(false);
                PanelShop.rabais_erdtree.setVisible(false);
                break;
            case 7:
                ScarletRot.prix = ScarletRot.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_betta.setBounds(155, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBounds(273, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBounds(390, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBounds(35, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBounds(155, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(82, 171, 198));
                PanelShop.planteErdtree.setBounds(390, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(53, 109, 127));

                PanelShop.rabais_rouge.setVisible(false);
                PanelShop.rabais_betta.setVisible(false);
                PanelShop.rabais_tetra.setVisible(false);
                PanelShop.rabais_neo.setVisible(false);
                PanelShop.rabais_blue.setVisible(false);
                PanelShop.rabais_fern.setVisible(false);
                PanelShop.rabais_scarlet.setVisible(true);
                PanelShop.rabais_erdtree.setVisible(false);
                break;
            case 8:
                Erdtree.prix = Erdtree.prix / 2;
                updateToolTip();
                PanelShop.poisson_rouge.setBounds(35, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_rouge.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_betta.setBounds(155, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_betta.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_tetra.setBounds(273, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_tetra.setBackground(new Color(53, 109, 127));
                PanelShop.poisson_neo.setBounds(390, 209, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.poisson_neo.setBackground(new Color(53, 109, 127));
                PanelShop.planteBlue.setBounds(35, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteBlue.setBackground(new Color(53, 109, 127));
                PanelShop.planteFern.setBounds(155, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteFern.setBackground(new Color(53, 109, 127));
                PanelShop.planteScarlet.setBounds(273, 379, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteScarlet.setBackground(new Color(53, 109, 127));
                PanelShop.planteErdtree.setBounds(648, 362, PanelShop.shop_dimension.width,
                        PanelShop.shop_dimension.height);
                PanelShop.planteErdtree.setBackground(new Color(82, 171, 198));

                PanelShop.rabais_rouge.setVisible(false);
                PanelShop.rabais_betta.setVisible(false);
                PanelShop.rabais_tetra.setVisible(false);
                PanelShop.rabais_neo.setVisible(false);
                PanelShop.rabais_blue.setVisible(false);
                PanelShop.rabais_fern.setVisible(false);
                PanelShop.rabais_scarlet.setVisible(false);
                PanelShop.rabais_erdtree.setVisible(true);
                break;
            default:
                break;
        }
    }

    public static void resetPrice() {
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

// Слава Україні!