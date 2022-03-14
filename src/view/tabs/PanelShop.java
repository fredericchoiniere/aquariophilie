package view.tabs;

import java.awt.*;
import javax.swing.*;

public class PanelShop extends JPanel {

    public PanelShop() { // Panel pour créer le magasin
        setPreferredSize(new Dimension(1000, 700)); // Taille
    }

    public void paintComponent(Graphics g) { // méthode paint
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.yellow);
        g2D.fillRect(20, 20, 200, 200);
        ;

    }
}
