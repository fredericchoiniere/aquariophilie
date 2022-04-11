//Jérémie Caron     itération 2

package model.jeu;

import javax.swing.JLabel;

public class Argent {

    // attributs de la classe
    public static int argent = 10000;

    public static int emp1 = 0;
    public static int emp2 = 0;
    public static int emp3 = 0;

    public static int poi1 = 0; // rouge
    public static int poi2 = 0; // betta
    public static int poi3 = 0; // tetra

    public static String montant = argent + "";

    /**
     * @param label
     * @param label2
     *               méthode qui permet de mettre à jour le montant d'argent
     */
    public static void paye(JLabel label, JLabel label2) {
        argent += emp1 + emp2 + emp3 + poi1 + poi2 + poi3;
        montant = Integer.toString(argent);
        label.setText(montant + "₴");
        label2.setText(montant + "₴");
    }
}
