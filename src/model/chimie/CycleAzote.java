package model.chimie;
import view.GUIMain;

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
public class CycleAzote implements Runnable {

    public float jourInitial = GUIMain.jours;
    public float jourFinal = jourInitial + 35;
    public float jours = 0, tempAmmoniaque = 0, tempNitrites = 0;
    public Eau eau = GUIMain.eau;
    public byte cycle = eau.cycle;

    // Temps tempsCycle = new Temps();
    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public CycleAzote() {
        eau.cycle++;
        cycle++;
    }

    
    /** 
     * @param eau
     * Démarre un cycle d'ammoniaque en fonction du temps, suivant une courbe
     */
    public void cycleAmmoniaque(Eau eau) {
        eau.listeAmmoniaque.remove(tempAmmoniaque);
        if (jours != 18) {
            tempAmmoniaque = (float) (-3.2 * ((jours / 7) - 1.25) * ((jours / 7) - 1.25) + 5);
        } else {
            tempAmmoniaque = 0;
        }
        eau.addAmmoniaque(tempAmmoniaque, cycle);
    }
    
    /** 
     * Méthode run de la classe CycleAzote
     * Incrémente les jours et calcule le nouveau taux d'ammoniaque et de nitrites
    */
    
    public void cycleNitrites(Eau eau) {
        //if(tempNitrites!=0)
        eau.listeNitrites.remove(tempNitrites);
        if (jours > 14 && jours < 35) {
            tempNitrites = (float) (-3.56 * ((jours / 7) - 3.5) * ((jours / 7) - 3.5) + 8);
        } 
        else{
            tempNitrites = 0;
        }
        eau.addNitrites(tempNitrites, cycle);
        //eau.listeNitrites.add(tempNitrites);
    }

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

                if (jours >= 14 && jours <= 35) {
                    // System.out.println("compote");
                    //cycleNitrites(eau);
    
                    Thread.sleep(1000); // à enlever
                } else 
                  Thread.sleep(1000);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}