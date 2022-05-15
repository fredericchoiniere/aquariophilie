// Itération 1: Jérémie Caron
// Itération 2: Frédéric Choinière
// Itération 3: Jérémie Caron

//Classe contrôleur qui initialise l'affichage du frame d'introduction

package control;

import javax.swing.*;
import model.GestionException;
import model.Radio;
import view.*;

public class Control {
    public static Radio audioPlayer;

    /**
     * @param args
     *             permet d'initialiser le frame Introduction
     */
    public static void main(String[] args) {
        
        // appel du frame intro
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                GUIIntro.guiIntroFrame();
            }
        });

        // création de la radio, et mise en pause de celle-ci
        try {
            audioPlayer = new Radio();
            audioPlayer.play();
            audioPlayer.pause();
        }

        catch (Exception e) {
            GestionException.GestionExceptionRadio();
        }
    }

}

// Слава Україні!