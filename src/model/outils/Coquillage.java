// Itération 3: Frédéric Choinière
// Classe pour l'outil coquillage (sert à remonter le niveau de KH)

package model.outils;

import javax.swing.*;
import java.awt.*;

public class Coquillage extends Outils{
    
    ImageIcon icone_coquillage;

    public Coquillage() {
        super();
        adapterNom();
        icone_coquillage = new ImageIcon("res/outils/coquillage.png");
    }

    /**
     * @param label
     *              méthode qui permet d'afficher l'image de l'outil
     */
    public void setIcon(JLabel label) {
        label.setIcon(icone_coquillage);
    }

    /**
     * @param panel
     *              méthode qui permet de mettre le bon curseur
     */
    public void changerCurseurPanel(JPanel panel) {
        panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                icone_coquillage.getImage(),
                new Point(0, 0), "curseur plein"));

    }
}

// Слава Україні!