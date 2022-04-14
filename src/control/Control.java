// Jérémie Caron     itération 1
// Frédéric Choinière   itération 2
//Classe contrôleur qui initialise l'affichage du frame d'introduction

package control;

import java.util.Scanner;

import javax.swing.*;

import model.SimpleAudioPlayer;
import view.*;

public class Control {
    public static SimpleAudioPlayer audioPlayer;

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

            audioPlayer = new SimpleAudioPlayer();
            audioPlayer.play();

        }

        catch (Exception e) {
            e.printStackTrace();
        }
    }

}
