// Frédéric Choinière   itération 1
// Classe qui contrôle le temps et le timer global

package model.environnement;

import java.util.*;

import model.jeu.Argent;
import view.GUIMain;

public class Temps {
    Timer journee;
    public final static int DUREE = 1500; // Durée d'une journée en millisecondes

    // Incrémente GUIMain.jours (timer global) au 5 secondes

    public Temps() {
        journee = new Timer();

        journee.scheduleAtFixedRate(new TimerTask() {

            @Override
            public void run() {
                GUIMain.jours++;
                Argent.paye(GUIMain.label_argent_aqua, GUIMain.label_argent_shop);
            }
        }, 0, DUREE);
    }
}
