//Jérémie Caron     itération 2
//Classe pour l'outil filet

package model.item.outils;

import javax.swing.*;

import java.awt.*;

public class Filet extends Outils {

    ImageIcon icone_filet; // icone du filet

    public Filet() { // Création de l'objet filet
        super();
        adapterNom();

        icone_filet = new ImageIcon("res/outils/filet.png"); // icone du filet
    }

    public void setIcon(JLabel label) {
        label.setIcon(icone_filet);
    }

    public void changerCurseurPanel(JPanel panel) {
      
            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    icone_filet.getImage(),
                    new Point(0, 0), "curseur plein"));
       
}
}