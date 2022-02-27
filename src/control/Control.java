package control;

import javax.swing.*;
import view.*;
import java.awt.*;

public class Control {

    // permet d'initialiser le frame Aquarium
    public static void main(String[] args) {

        GUIIntro guiIntro = new GUIIntro();

        guiIntro.setSize(300, 250);
        guiIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiIntro.setResizable(false);
        guiIntro.setLocationRelativeTo(null);
        guiIntro.setVisible(true);


        /* Toolkit toolkit = Toolkit.getDefaultToolkit();
        Image image = toolkit.getImage("icons/handwriting.gif");
        Cursor c = toolkit.createCustomCursor(image , new Point(guiIntro.getX(), 
           guiIntro.getY()), "res/icone_souris/penis.png");
        guiIntro.setCursor (c); */

    }

}
