package model.environnement;
import java.util.*;
import view.GUIMain;

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class Temps{
    Timer journee;

    //public float jours = 0;

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
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

