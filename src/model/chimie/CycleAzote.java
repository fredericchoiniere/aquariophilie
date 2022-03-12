package model.chimie;

import model.environnement.*;

import view.GUIMain;

public class CycleAzote implements Runnable {

    public float jourInitial = GUIMain.jours;
    public float jourFinal = jourInitial + 35;
    public float jours = 0, temp = 0;
    public Eau eau = GUIMain.eau;
    public byte cycle = eau.cycle;

    public CycleAzote() {
        eau.cycle++;
        cycle++;
    }

    
    /** 
     * @param eau
     * Démarre un cycle d'ammoniaque en fonction du temps, suivant une courbe
     */
    public void cycleAmmoniaque(Eau eau) {
        eau.listeAmmoniaque.remove(temp);
        if (jours != 18) {
            temp = (float) (-3.2 * ((jours / 7) - 1.25) * ((jours / 7) - 1.25) + 5);
        } else {
            temp = 0;
        }
        eau.addAmmoniaque(temp, cycle);
    }

    
    /** 
     * Méthode run de la classe CycleAzote
     * Incrémente les jours et calcule le nouveau taux d'ammoniaque et de nitrites
     */
    @Override
    public void run() { // TODO: updater avec changement de jour
        while (true) {

            if ((jours + jourInitial) < GUIMain.jours)
                jours++;

            try {
                if (jours >= 0 && jours <= 18) {
                    cycleAmmoniaque(eau);
                    Thread.sleep(1000);
                } else 
                    Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}