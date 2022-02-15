package view.tabs;

import java.awt.*;
import javax.swing.*;

public class PanelAqua extends JPanel { // extends JPanel pour créer un Jpanel

    public PanelAqua() {
        setPreferredSize(new Dimension(1000, 700)); // Taille du panel
    }

    public void paintComponent(Graphics g) { // méthode paint
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // créer le background pour l'onglet Aquarium
        

        Image background = Toolkit.getDefaultToolkit().getImage("aquariophilie/res/background/background.png");
        g2D.drawImage(background, 0, 0, this);

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("aquariophilie/res/accessoires/aquarium/aquarium_1.png");
        g2D.drawImage(aquarium_1, 320, 305, this);

    }
}
