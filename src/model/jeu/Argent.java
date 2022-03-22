package model.jeu;

import javax.swing.JLabel;

public class Argent {

    static int argent = 50;

    static int emp1 = 10;
    static int emp2 = 0;
    static int emp3 = 0;
    static int poi1 = 0;
    static int poi2 = 0;
    static int poi3 = 0;
    static int poi4 = 0;
    static int poi5 = 0;
    static int poi6 = 0;

    static String montant = "50 ₴";

    public static void paye(JLabel label, JLabel label2) {

        argent += emp1 + emp2 + emp3 + poi1 + poi2 + poi3 + poi4 + poi5 + poi6;

        montant = Integer.toString(argent);
        
        label.setText(montant + " ₴");
        label2.setText(montant + " ₴");
    }

}
