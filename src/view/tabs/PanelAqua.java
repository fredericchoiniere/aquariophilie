//Jérémie Caron     itération 1
//Frédéric Choinière     itération 2
//Classe pour l'affichage de l'aquarium et du background

package view.tabs;

import java.awt.*;
import javax.swing.*;

import model.MethodeGUIMain;

public class PanelAqua extends JPanel { // extends JPanel pour créer un Jpanel

    public static Image background = Toolkit.getDefaultToolkit().getImage("res/background/background.png");

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
        g2D.drawImage(background, 5, 0, this);
        g2D.setColor(new Color(102, 181, 255, 174));
        g2D.fill(MethodeGUIMain.getEauDimensions());

        

    }

}
