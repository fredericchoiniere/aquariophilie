package model.chimie;

import model.environnement.*;
import view.GUIMain;
//import java.math.*;

public class CycleAzote implements Runnable{

    public float jourInitial = GUIMain.jours;
    public float jourFinal = jourInitial + 35;
    public float jours = 0;
    Eau eau = new Eau();
    
    //Temps tempsCycle = new Temps();

    public void cycleAmmoniaque(Eau eau) {
        eau.ammoniaque = (float)(-3.2*((jours/7)-1.25)*((jours/7)-1.25)+5);
    }

    @Override
    public void run() { // TODO: updater avec changement de jour
        while (true) {
            
            if((jours + jourInitial) < GUIMain.jours)
                jours++;
                
            try {
                if (jours >= 0 && jours < 18) {
                    //System.out.println("compote");
                    cycleAmmoniaque(eau);
                    System.out.println("Jour:" + jours);
                    System.out.println("Ammoniaque:" + eau.ammoniaque);
                    Thread.sleep(1000); // à enlever
                } else Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}