package model.jeu;

import javax.swing.JLabel;

import view.GUIMain;

public class Argent {

    public static int argent = 5000;

    static int emp1 = 0;
    static int emp2 = 0;
    static int emp3 = 0;
    public static int poi1 = 0; //rouge
    public static int poi2 = 0; ///betta
    public static int poi3 = 0; //tetra


    static String montant = "50 ₴";

    public static void paye(JLabel label, JLabel label2) {

        argent += emp1 + emp2 + emp3 + poi1 + poi2 + poi3;

        montant = Integer.toString(argent);

        label.setText(montant + " ₴");
        label2.setText(montant + " ₴");
    }


    
}
