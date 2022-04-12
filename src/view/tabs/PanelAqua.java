//Jérémie Caron     itération 1
//Classe pour l'affichage de l'aquarium et du background

package view.tabs;

import java.awt.*;
import javax.swing.*;

import model.MethodeGUIMain;

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
        g2D.drawImage(background, 5, 0, this);

        g2D.setColor(new Color(102, 181, 255, 174));
        g2D.fill(MethodeGUIMain.getEauDimensions());

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("res/accessoires/aquarium/aquarium_1.png");
        g2D.drawImage(aquarium_1, 320, 305, this);

    }

}
