package model.plantes;

import javax.swing.ImageIcon;

public class JavaFern extends Plante {
    public int prix = 450;

    public static ImageIcon icon = new  ImageIcon("res/background/decorations/java_fern.png");

    public JavaFern(){
        prix = 450;
        absorption = 5; // pet cul
    }
}
