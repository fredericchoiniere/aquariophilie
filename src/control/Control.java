

package control;

import javax.swing.*;
import view.*;
import java.awt.*;

public class Control {

    // permet d'initialiser le frame Aquarium
    public static void main(String[] args) {

        GUIIntro guiIntro = new GUIIntro();

        // attributs du Frame intro
        guiIntro.setSize(500, 400);
        guiIntro.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        guiIntro.setResizable(false);
        guiIntro.setLocationRelativeTo(null);
        guiIntro.setVisible(true);

    }

}
