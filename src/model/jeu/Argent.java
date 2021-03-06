// Itération 1: Jérémie Caron
// Itération 2: Jérémie Caron
// Itération 3: Jérémie Caron

// Classe qui gère le nombre d'argent que nous possédons

package model.jeu;

import javax.swing.JLabel;

public class Argent {

    // attributs de la classe
    public static int argent = 500;
    public static int emp1 = 0;
    public static int emp2 = 0;
    public static int emp3 = 0;
    public static int poi1 = 1; // rouge
    public static int poi2 = 0; // betta
    public static int poi3 = 0; // tetra
    public static int poi4 = 0; // neo

    public static String montant = argent + "";

    public static boolean normal = true;

    /**
     * @param label
     * @param label2
     *               méthode qui permet de mettre à jour le montant d'argent
     */
    public static void paye(JLabel label, JLabel label2) {
        if (normal) {
            argent += emp1 + emp2 + emp3 + poi1 + poi2 + poi3 + poi4;
            montant = Integer.toString(argent);
            label.setText(montant + "฿");
            label2.setText(montant + "฿");
        } else {
            label.setText("∞");
            label2.setText("∞");
        }
    }
}

// Слава Україні!