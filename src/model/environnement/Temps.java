// Frédéric Choinière   itération 1
// Frédéric Choinière, Jérémie Caron   itération 2
// Classe qui contrôle le temps et le timer global

package model.environnement;

import java.util.*;

import model.chimie.Eau;
import model.jeu.Argent;
import view.GUIMain;

public class Temps {
    static Timer journee;
    public static int DUREE = 1500; // Durée d'une journée en millisecondes
    public static boolean isPaused = true;

    // Incrémente GUIMain.jours (timer global) au DUREE secondes 

    public static void pause(){
        journee.cancel();
        isPaused = true;
    }

    public static void jourAJour(int jour){
        GUIMain.label_jours.setText("J" + Integer.toString(jour));
    }

    public static void reprendre(){
        journee = new Timer();
        isPaused = false;
        journee.scheduleAtFixedRate(new TimerTask() {
            @Override
                public void run() {
                    GUIMain.jours++;
                    jourAJour((int) GUIMain.jours);
                    Argent.paye(GUIMain.label_argent_aqua, GUIMain.label_argent_shop);
                    Eau.setScoreEau();
                }
        }, 0, DUREE);
    }

}
