package model.jeu;

import javax.swing.JLabel;

public class Argent {

    public static int argent = 1000;

    public static int emp = 0;

    public static int poi1 = 0; //rouge
    public static int poi2 = 0; ///betta
    public static int poi3 = 0; //tetra


    static String montant = "50 ₴";

    public static void paye(JLabel label, JLabel label2) {

        argent += emp + poi1 + poi2 + poi3;

        montant = Integer.toString(argent);

        label.setText(montant + " ₴");
        label2.setText(montant + " ₴");
    }


    
}
