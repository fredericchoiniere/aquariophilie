// Frédéric Choinière   itération 1
// Frédéric Choinière, Jérémie Caron   itération 2
// Jérémie Caron    itération 3
// Classe qui contrôle le temps et le timer global

package model.environnement;

import java.util.*;

import model.jeu.Argent;
import model.jeu.Magasin;
import view.GUIMain;

public class Temps {
    static Timer journee;
    public static int DUREE = 1500; // Durée d'une journée en millisecondes
    public static boolean isPaused = true;
    static short i = 0;

    // Incrémente GUIMain.jours (timer global) au DUREE secondes 

    /**
     *      Pause le défilement du temps
     */
    public static void pause(){
        journee.cancel();
        isPaused = true;
    }

    
    /** 
     * @param jour
     *      Affiche le jour actuel
     */
    public static void jourAJour(int jour){
        GUIMain.label_jours.setText(Integer.toString(jour));
    }

    /**
     *      Reprend le défilement du temps
     */
    public static void reprendre(){
        journee = new Timer();
        isPaused = false;
        journee.scheduleAtFixedRate(new TimerTask() {
            @Override
                public void run() {
                    GUIMain.jours++;
                    jourAJour((int) GUIMain.jours);
                    Argent.paye(GUIMain.label_argent_aqua, GUIMain.label_argent_shop);
                    GUIMain.eau.getScoreEau();

                    if(i > 5){
                        i = 0;
                        Magasin.resetPrice();
                        Magasin.rabais((short) Magasin.generatingNumber());
                    } else {
                        i++;
                    }
                    
                    //Eau.setScoreEau();
                }
        }, 0, DUREE);
    }

}
