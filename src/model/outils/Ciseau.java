//Jérémie Caron     itération 2
//Classe pour l'outil ciseau

package model.outils;

import javax.swing.*;

import java.awt.*;

public class Ciseau extends Outils {

    // attributs de la classe
    ImageIcon icone_ciseau;

    public Ciseau() {
        super();
        adapterNom();
        icone_ciseau = new ImageIcon("res/outils/ciseau.png");
    }

    /**
     * @param label
     *              méthode qui permet d'afficher l'image de l'outil
     */
    public void setIcon(JLabel label) {
        label.setIcon(icone_ciseau);
    }

    /**
     * @param panel
     *              méthode qui permet de mettre le bon curseur
     */
    public void changerCurseurPanel(JPanel panel) {
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                icone_ciseau.getImage(),
                new Point(0, 0), "curseur plein"));

    }
}

// Слава Україні!