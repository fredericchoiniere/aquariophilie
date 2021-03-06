// Itération 2: Jérémie Caron

//Classe pour l'outil filet

package model.outils;

import javax.swing.*;
import java.awt.*;

public class Filet extends Outils {

    // attributs de la classe
    ImageIcon icone_filet;

    public Filet() {
        super();
        adapterNom();
        icone_filet = new ImageIcon("res/outils/filet.png");
    }

    /**
     * @param label
     *              méthode qui permet d'afficher l'image de l'outil
     */
    public void setIcon(JLabel label) {
        label.setIcon(icone_filet);
    }

    /**
     * @param panel
     *              méthode qui permet de mettre le bon curseur
     */
    public void changerCurseurPanel(JPanel panel) {
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                icone_filet.getImage(),
                new Point(0, 0), "curseur plein"));
    }
}

// Слава Україні!