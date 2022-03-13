package model.environnement;

import java.util.*;

import view.GUIMain;

public class Temps{
    Timer journee;

    // Incrémente GUIMain.jours (timer global) au 5 secondes

    public Temps(){
        journee = new Timer();
        journee.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run() {
                GUIMain.jours++;
            }
        }, 0, 5000);
    }
}

