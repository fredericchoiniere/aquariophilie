package control;

import javax.swing.*;
import view.*;
//allo
public class Control {

    // permet d'initialiser le frame Aquarium
    public static void main(String[] args) {
        GUIAqua aquarium = new GUIAqua();
        aquarium.setResizable(false);
        aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        aquarium.pack();
        aquarium.setLocationRelativeTo(null);
        aquarium.setVisible(true);
    }

}
