package model.plantes;

import javax.swing.ImageIcon;

public class ScarletRot extends Plante {

    public static ImageIcon icon = new ImageIcon("res/background/decorations/scarlet_rot.png");

    public ScarletRot(){
        prix = 1000;
        absorption = 8; // valeur arbitraire
    }
}
