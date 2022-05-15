// Itération 1: Frédéric Choinière, Justin Plouffe
// Itération 2: Frédéric Choinière

// Classe qui contrôle les cycles de l'azote

package model.chimie;

import view.GUIMain;

public class CycleAzote {

    public float jours = GUIMain.jours, jourInitial, joursCalcul = 0, compteurJoursCycle = 0, tempAmmoniaque = 0,
            tempNitrites = 0;

    public Eau eau = GUIMain.eau;

    public String actionEnCours = "Aucune action initiale";

    /**
     * @param float
     *              // TODO: ça fait quoi?
     */
    public CycleAzote(float jourInit) {
        jourInitial = jourInit;
    }

    /**
     * Incrémente le nombre de jours
     */
    public void incrJoursCalcul() {
        joursCalcul++;
    }

    /**
     * @param eau
     * @param jours
     *              Démarre un cycle d'ammoniaque en fonction du temps, suivant une
     *              courbe
     */
    public void cycleAmmoniaque(Eau eau, float jours) {
        eau.listeAmmoniaque.remove(tempAmmoniaque);
        if (jours >= jourInitial && jours <= (jourInitial + 18)) {
            tempAmmoniaque = (float) (-3.2 * ((joursCalcul / 7) - 1.25) * ((joursCalcul / 7) - 1.25) + 5);
            if (tempAmmoniaque <= 0) {
                tempAmmoniaque = 0;
            }
        } else {
            tempAmmoniaque = 0;
        }
        eau.addAmmoniaque(tempAmmoniaque);
    }

    /**
     * @param eau
     * @param float
     *              Méthode run de la classe CycleAzote
     *              Incrémente les jours et calcule le nouveau taux d'ammoniaque et
     *              de
     *              nitrites
     */
    public void cycleNitrites(Eau eau, float jours) {
        eau.listeNitrites.remove(tempNitrites);
        if (jours >= (jourInitial + 14) && jours <= (jourInitial + 35)) {
            tempNitrites = (float) (-3.56 * ((joursCalcul / 7) - 3.5) * ((joursCalcul / 7) - 3.5) + 8);
            if (tempNitrites <= 0) {
                tempNitrites = 0;
            }
        } else {
            tempNitrites = 0;
        }
        eau.addNitrites(tempNitrites);
    }

    /**
     * @param jours
     *              Cycle l'aquarium
     */
    public void cycler(float jours) {

        if (jours >= jourInitial && jours <= (jourInitial + 18)) {
            actionEnCours = "Cycle ammoniaque";
            cycleAmmoniaque(eau, jours);
        }
        if (jours >= (jourInitial + 14) && jours <= (jourInitial + 35)) {
            actionEnCours = "Cycle nitrites";
            cycleNitrites(eau, jours);
        }
    }
}
