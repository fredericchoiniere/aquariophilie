//Jérémie Caron     itération 1
//Classe pour l'affichage de l'aquarium et du background

package view.tabs;

import java.awt.*;
import javax.swing.*;

public class PanelAqua extends JPanel { // extends JPanel pour créer un Jpanel

    public PanelAqua() {
        setPreferredSize(new Dimension(1000, 700)); // Taille du pane
    }

    /**
     * Permet de draw les components de PanelAqua
     */
    public void paintComponent(Graphics g) { // méthode paint
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // créer le background pour l'onglet Aquarium
        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background.png");
        g2D.drawImage(background, 5, 5, this);

        Image eau_1 = Toolkit.getDefaultToolkit().getImage("res/eau/eau_bleu.png");
        g2D.drawImage(eau_1, 327, 305, this);

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("res/accessoires/aquarium/aquarium_1.png");
        g2D.drawImage(aquarium_1, 320, 305, this);

    }

}
