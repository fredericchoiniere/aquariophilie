// Frédéric Choinière, Justin Plouffe   itération 1
// Frédéric Choinière   itération 2
// Classe qui contrôle les cycles de l'azote

package model.chimie;

import view.GUIMain;

public class CycleAzote{

    public float jours = GUIMain.jours, jourInitial, compteurJoursCycle = 0, tempAmmoniaque = 0, tempNitrites = 0;
    public Eau eau = GUIMain.eau;

    public String actionEnCours = "Aucune action initiale";

   
    public CycleAzote(float jourInit){
        jourInitial = jourInit;
    }

    /* public void setCompteurJoursCycle(float compteurJours) {
        compteurJoursCycle = compteurJours;
    }

    public float getCompteurJoursCycle(){
        compteurJoursCycle =  jours - jourInitial;
        return compteurJoursCycle;
    } */

    /**
     * @param eau
     *            Démarre un cycle d'ammoniaque en fonction du temps, suivant une
     *            courbe
     */
    public void cycleAmmoniaque(Eau eau, float jours) {
        eau.listeAmmoniaque.remove(tempAmmoniaque);
        //System.out.println("jour cycle ammo: " + jours);

        if (jours <= 18) {
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
    public void cycleNitrites(Eau eau, float jours) {
        eau.listeNitrites.remove(tempNitrites);
        if (jours >= 14 && jours <= 35) {
            tempNitrites = (float) (-3.56 * ((jours / 7) - 3.5) * ((jours / 7) - 3.5) + 8);
            //System.out.println("tempnitrites: " + tempNitrites + " au jour " + jours);
        } else {
            tempNitrites = 0;
        }
        eau.addNitrites(tempNitrites);
    }

       
    public void cycler(Eau eau, float jours){


        if (jours >= jourInitial && jours <= (jourInitial + 18)) { // >= 0 <= 18 // TODO: checker la différence de jours pour les cycles
            //cycleAmmoniaque(getCompteurJoursCycle());
            actionEnCours = "Cycle ammoniaque";
            System.out.println("entré dans if ammo");
            
            //setCompteurJoursCycle(jours);
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