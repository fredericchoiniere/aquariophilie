// Frédéric Choinière   itération 1
// Frédéric Choinière, Jérémie Caron   itération 2
// Classe qui contrôle le temps et le timer global

package model.environnement;

import java.util.*;

import model.jeu.Argent;
import view.GUIMain;

public class Temps {
    static Timer journee;
    public static int DUREE = 1500; // Durée d'une journée en millisecondes

    // Incrémente GUIMain.jours (timer global) au DUREE secondes 

    public Temps() {
        reprendre();
    }

    public static void pause(){
        journee.cancel();
    }

    public static void reprendre(){
        journee = new Timer();
        journee.scheduleAtFixedRate(new TimerTask() {
            @Override
                public void run() {
                    GUIMain.jours++;
                    Argent.paye(GUIMain.label_argent_aqua, GUIMain.label_argent_shop);
                    //System.out.println(GUIMain.aqua1+" "+GUIMain.aqua2+" "+GUIMain.aqua3+" "+GUIMain.aqua4+" "+GUIMain.aqua5+" "+GUIMain.aqua6);
                }
        }, 0, DUREE);
    }

}
