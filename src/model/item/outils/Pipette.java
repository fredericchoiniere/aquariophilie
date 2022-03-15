package model.item.outils;

import javax.swing.*;
import java.awt.*;


/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class Pipette extends Outils {

    ImageIcon curseur_vide, curseur_plein, icone_vide, icone_plein;
    public boolean est_remplie = false;

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public Pipette() { // Création de l'objet pipette
        super();
        adapterNom();
        curseur_vide = new ImageIcon("res/icone_souris/pipe_vide.png");
        curseur_plein = new ImageIcon("res/icone_souris/pipe_remplie.png");
        icone_vide = new ImageIcon("res/outils/pipette_vide.png");
        icone_plein = new ImageIcon("res/outils/pipette_pleine.png");

    }

    // Change l'état de la pipette
    public void changerEtatLabel(JLabel label) {
        if (est_remplie) {
            label.setIcon(icone_plein);
        } else {
            label.setIcon(icone_vide);
        }
    }

    // change l'état du panel
    public void changerEtatPanel(JPanel panel) {
        if (est_remplie) {
            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    curseur_plein.getImage(),
                    new Point(0, 0), "curseur plein"));
        } else {
            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    curseur_vide.getImage(),
                    new Point(0, 0), "curseur vide"));
        }
    }

}