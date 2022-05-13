// Frédéric Choinière, Justin Plouffe   itération 1
// Frédéric Choinière   itération 2
// Classe qui contrôle les cycles de l'azote

package model.chimie;

import view.GUIMain;

public class CycleAzote{

    public float jours = GUIMain.jours, jourInitial, joursCalcul = 0, compteurJoursCycle = 0, tempAmmoniaque = 0, tempNitrites = 0;
    public Eau eau = GUIMain.eau;

    public String actionEnCours = "Aucune action initiale";

   
    public CycleAzote(float jourInit){
        jourInitial = jourInit;
    }

    public void incrJoursCalcul() {
        joursCalcul++;
    }

    /**
     * @param eau
     *            Démarre un cycle d'ammoniaque en fonction du temps, suivant une
     *            courbe
     */
    public void cycleAmmoniaque(Eau eau, float jours) {
        eau.listeAmmoniaque.remove(tempAmmoniaque);
        //System.out.println("jour cycle ammo: " + jours);

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
     *            Méthode run de la classe CycleAzote
     *            Incrémente les jours et calcule le nouveau taux d'ammoniaque et de
     *            nitrites
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
     */
    public void cycler(float jours){

        

        if (jours >= jourInitial && jours <= (jourInitial + 18)) { // >= 0 <= 18
            //cycleAmmoniaque(getCompteurJoursCycle());
            actionEnCours = "Cycle ammoniaque";
            //System.out.println("entré dans if ammo");
            
            
            cycleAmmoniaque(eau, jours);
        }
        if (jours >= (jourInitial + 14) && jours <= (jourInitial + 35)) { // >= 14 <= 35
            //cycleNitrites(getCompteurJoursCycle());
            //System.out.println("Entré dans nitrites jour: " + getCompteurJours());
            actionEnCours = "Cycle nitrites";


            cycleNitrites(eau, jours);

            
        }

    }

    /** 
     * Méthode run de la classe CycleAzote
     */
    /* @Override
    public void run() {
            jours = GUIMain.jours;
            jourInitial = jours;
        while (true) {

            // fix les jours des cycles criss
            jours = GUIMain.jours;
            compteurJours = jours - jourInitial;
            Eau.setCompteurJoursCycle(compteurJours);

            try {
                if (jours >= jourInitial && jours <= (jourInitial + 18)) { // >= 0 <= 18
                    cycleAmmoniaque(eau, getCompteurJours());
                    actionEnCours = "Cycle ammoniaque";
                }
                if (jours >= (jourInitial + 14) && jours <= (jourInitial + 35)) { // >= 14 <= 35
                    cycleNitrites(eau, getCompteurJours());
                    //System.out.println("Entré dans nitrites jour: " + getCompteurJours());
                    actionEnCours = "Cycle nitrites";
                }
                GUIMain.actionEnCours = actionEnCours;
                jours++;
                Thread.sleep(Temps.DUREE);

            } catch (Exception e) {
                System.out.println("Erreur dans le run() de CycleAzote.java");
                e.printStackTrace();
            }
        }
    } */
}