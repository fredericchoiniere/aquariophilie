// Jérémie Caron     itération 1
// Frédéric Choinière   itération 2
// Jérémie Caron    itération 3
//Classe contrôleur qui initialise l'affichage du frame d'introduction

package control;

import javax.swing.*;

import model.Radio;
import view.*;

public class Control {
    public static Radio audioPlayer;

    /**
     * @param args
     *             permet d'initialiser le frame Introduction
     */
    public static void main(String[] args) {

        GUIIntro guiIntro = new GUIIntro();
        ImageIcon img = new ImageIcon("res/background/icone_aquariophilie.png");

        // attributs du Frame intro
        guiIntro.setSize(500, 400);
        guiIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiIntro.setResizable(false);
        guiIntro.setIconImage(img.getImage());
        guiIntro.setLocationRelativeTo(null);
        guiIntro.setVisible(true);

        try {

            audioPlayer = new Radio();
            audioPlayer.play();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
