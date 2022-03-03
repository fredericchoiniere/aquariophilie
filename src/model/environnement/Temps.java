package model.environnement;


import java.util.*;

import view.GUIMain;

public class Temps{
    Timer journee;

    
    //public float jours = 0;

    public Temps(){
        journee = new Timer();
        journee.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                //System.out.println("jours: " + GUIMain.jours);
                GUIMain.jours++;

            }
        }, 0, 5000);
    }
    

}

