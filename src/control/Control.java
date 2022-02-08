package control;

import javax.swing.*;
import view.*;

public class Control {

    // permet d'initialiser le frame Aquarium
    public static void main(String[] args) {

        GUIIntro guiIntro = new GUIIntro();

        guiIntro.setSize(300, 250);
        guiIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiIntro.setResizable(false);
        guiIntro.setLocationRelativeTo(null);
        guiIntro.setVisible(true);

    }

}
