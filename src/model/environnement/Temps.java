// Frédéric Choinière   itération 1
// Frédéric Choinière, Jérémie Caron   itération 2
// Jérémie Caron    itération 3
// Classe qui contrôle le temps et le timer global

package model.environnement;

import java.util.*;
import model.MethodeGUIMain;
import model.jeu.Argent;
import model.jeu.Magasin;
import view.GUIMain;

public class Temps {
    static Timer journee, cooldown;
    public static int DUREE = 1500; // Durée d'une journée en millisecondes
    public static int tempsActuel = (int) System.currentTimeMillis(), tempsPause = 0, tempsReprise = 0;
    public static boolean isPaused = true, beenPaused = false;;
    static short i = 0;

    // Incrémente GUIMain.jours (timer global) au DUREE secondes

    /**
     * @param jour
     *             Affiche le jour actuel
     */
    public static void jourAJour(int jour) {
        GUIMain.label_jours.setText(Integer.toString(jour));
    }

    public static void checkCooldown() {
        cooldown = new Timer();
        cooldown.schedule(new TimerTask() {
            @Override
            public void run() {
                if (!isPaused) {

                    tempsActuel = (int) System.currentTimeMillis();

                    MethodeGUIMain.live = tempsActuel - (tempsReprise - tempsPause);
                    
                    if (MethodeGUIMain.cooldownC()) {
                        GUIMain.setCooldownVisibleC();
                    } else {
                        GUIMain.setCooldownInvisibleC();
                    }

                    if (MethodeGUIMain.cooldownP()) {
                        GUIMain.setCooldownVisibleP();
                    } else {
                        GUIMain.setCooldownInvisibleP();
                    }
                } else { // permet de ne pas utiliser 23% du processeur si le temps est en pause
                    try {
                        Thread.sleep(Temps.DUREE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        }, 0, 500); // vérifie à chaque seconde
    }

    /**
     * Pause le défilement du temps
     */
    public static void pause() {
        journee.cancel();
        isPaused = true;
        beenPaused = true;
        tempsPause = (int) System.currentTimeMillis();
    }

    /**
     * Reprend le défilement du temps
     */
    public static void reprendre() {
        journee = new Timer();
        isPaused = false;
        if (beenPaused) {
            tempsReprise = (int) System.currentTimeMillis();
            beenPaused = false;
        }
        journee.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                GUIMain.jours++;
                jourAJour((int) GUIMain.jours);
                Argent.paye(GUIMain.label_argent_aqua, GUIMain.label_argent_shop);
                GUIMain.eau.getScoreEau();
                // MethodeGUIMain.checkCooldown();

                if (i > 5) {
                    i = 0;
                    Magasin.resetPrice();
                    Magasin.rabais((short) Magasin.generatingNumber());
                } else {
                    i++;
                }

                // Eau.setScoreEau();
            }
        }, 0, DUREE);
    }

}
