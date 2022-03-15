//Jérémie Caron     itération 1
//Classe contrôleur qui initialise l'affichage du frame d'introduction


package control;

import javax.swing.*;
import view.*;

public class Control {

    
    /** 
     * @param args
     * permet d'initialiser le frame Introduction
     */
    public static void main(String[] args) {

        GUIIntro guiIntro = new GUIIntro();

        // attributs du Frame intro
        guiIntro.setSize(500, 400);
        guiIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiIntro.setResizable(false);
        guiIntro.setLocationRelativeTo(null);
        guiIntro.setVisible(true);

    }

}
