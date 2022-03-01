package model.chimie;
import model.environnement.*;
import view.GUIMain;

public class CycleAzote {

    public float jourInitial = GUIMain.jours;
    public float jourFinal = GUIMain.jours + 35; 
    Temps tempsCycle = new Temps();

    public void cycleAmmoniaque(Eau eau) {
        //while()
            eau.ammoniaque = (float)(-3.2*((jours/7)-1.25)*((jours/7)-1.25)+5);
        System.out.println("while");
    }

    /*@Override
    public void run() { // TODO: updater avec changement de jour
        while (true) {
            //System.out.println("while");
            jours = GUIMain.jours;

            try {
                if (jours > 28) {
                    //System.out.println("compote");
                    comportNitrate();
                    Thread.sleep(1000); // à enlever
                } else Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }*/
}