package model.chimie;

import model.environnement.*;
import view.GUIMain;
//import java.math.*;

public class CycleAzote implements Runnable {

    public float jourInitial = GUIMain.jours;
    public float jourFinal = jourInitial + 35;
    public float jours = 0, tempAmmoniaque = 0, tempNitrites = 0;
    public Eau eau = GUIMain.eau;
    public byte cycle = eau.cycle;

    // Temps tempsCycle = new Temps();

    public CycleAzote() {

        eau.cycle++;
        cycle++;
        //eau.listeAmmoniaque.addLast((float)0);
    }

    public void cycleAmmoniaque(Eau eau) {
        if(tempAmmoniaque!=0)
            eau.listeAmmoniaque.remove(tempAmmoniaque);
        if (jours != 18) {
            tempAmmoniaque = (float) (-3.2 * ((jours / 7) - 1.25) * ((jours / 7) - 1.25) + 5);
        } else {
            tempAmmoniaque = 0;
        }
        eau.addAmmoniaque(tempAmmoniaque, cycle);
    }

    public void cycleNitrites(Eau eau) {
        if(tempNitrites!=0)
            eau.listeNitrites.remove(tempNitrites);
        if (jours >= 14 && jours <= 35) {
            tempNitrites = (float) (-3.56 * ((jours / 7) - 3.5) * ((jours / 7) - 3.5) + 8);
        } else {
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
                    // System.out.println("compote");
                    cycleAmmoniaque(eau);

                    Thread.sleep(1000); // à enlever
                } else 
                    Thread.sleep(1000);

                if (jours >= 14 && jours <= 35) {
                    // System.out.println("compote");
                    cycleNitrites(eau);
    
                    Thread.sleep(1000); // à enlever
                } else 
                  Thread.sleep(1000);
                
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}