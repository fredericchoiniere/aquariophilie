// Frédéric Choinière, Justin Plouffe   itération 1
// Classe qui contrôle les cycles de l'azote

package model.chimie;

import model.environnement.Temps;
import view.GUIMain;

public class CycleAzote implements Runnable {

    public float jourInitial = GUIMain.jours;
    public float jourFinal = jourInitial + 35;
    public float jours = 0, tempAmmoniaque = 0, tempNitrites = 0;
    public Eau eau = GUIMain.eau;

    public String actionEnCours = "Aucune action initiale";

    /**
     * @param eau
     *            Démarre un cycle d'ammoniaque en fonction du temps, suivant une
     *            courbe
     */
    public void cycleAmmoniaque(Eau eau) {
        eau.listeAmmoniaque.remove(tempAmmoniaque);
        if (jours != 18) {
            tempAmmoniaque = (float) (-3.2 * ((jours / 7) - 1.25) * ((jours / 7) - 1.25) + 5);
        } else {
            tempAmmoniaque = 0;
        }
        eau.addAmmoniaque(tempAmmoniaque);
    }

    /**
     * @param eau
     *            Méthode run de la classe CycleAzote
     *            Incrémente les jours et calcule le nouveau taux d'ammoniaque et de
     *            nitrites
     */
    public void cycleNitrites(Eau eau) {
        eau.listeNitrites.remove(tempNitrites);
        if (jours > 14 && jours < 35) {
            tempNitrites = (float) (-3.56 * ((jours / 7) - 3.5) * ((jours / 7) - 3.5) + 8);
        } else {
            tempNitrites = 0;
        }
        eau.addNitrites(tempNitrites);
    }

    @Override
    public void run() {
        while (true) {

            if ((jours + jourInitial) < GUIMain.jours)
                jours++;

            try {
                if (jours >= 0 && jours <= 18) {
                    cycleAmmoniaque(eau);
                    actionEnCours = "Cycle ammoniaque";
                    System.out.println("Action en cours: " + actionEnCours + " dans thread " + Thread.currentThread().getName());
                }
                if (jours >= 14 && jours <= 35) {
                    cycleNitrites(eau);
                    actionEnCours = "Cycle nitrites";
                    System.out.println("Action en cours: " + actionEnCours + " dans thread " + Thread.currentThread().getName());
                }
                GUIMain.actionEnCours = actionEnCours;
                Thread.sleep(Temps.DUREE);

            } catch (Exception e) {
                System.out.println("Erreur dans le run() de CycleAzote.java");
                e.printStackTrace();
            }
        }
    }
}