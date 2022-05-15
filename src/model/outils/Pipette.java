// Itération 1: Jérémie Caron
// Itération 2 : Justin Plouffe
//Classe pour l'outil pipette

package model.outils;

import javax.swing.*;
import java.awt.*;

import view.GUIMain;

public class Pipette extends Outils {

    // attributs de la classe
    ImageIcon curseur_vide, curseur_plein, icone_vide, icone_plein;
    public boolean est_remplie = false;
    public int nbGouttes = 0;

    public Pipette() {
        super();
        adapterNom();
        curseur_vide = new ImageIcon("res/icone_souris/pipe_vide.png");
        curseur_plein = new ImageIcon("res/icone_souris/pipe_remplie.png");
        icone_vide = new ImageIcon("res/outils/pipette_vide.png");
        icone_plein = new ImageIcon("res/outils/pipette_pleine.png");
    }

    /**
     * @return boolean
     *         méthode qui permet de savoir si la pipette est remplie ou non
     */
    public boolean getEstRemplie() {
        return est_remplie;
    }

    /**
     * @param proposition
     *                    méthode qui permet de rendre le pipette remplie ou non
     */
    public void setEstRemplie(boolean proposition) {
        this.est_remplie = proposition;
    }

    /**
     * @return int
     *         méthode qui permet de savoir le nombre de gouttes dans la pipette
     */
    public int getNbGouttes() {
        return nbGouttes;
    }

    /**
     * @param nouveauNbGouttes
     *                         méthode qui permet de changer le nombre de gouttes
     *                         dans la pipette
     */
    public void setNbGouttes(int nouveauNbGouttes) {
        this.nbGouttes = nouveauNbGouttes;
        if (nouveauNbGouttes == 0)
            est_remplie = false;
    }

    /**
     * méthode pour enlever une goutte de la pipette
     */
    public void enleverUneGoutte() {
        this.nbGouttes--;
        if (nbGouttes == 0) {
            est_remplie = false;
            changerEtatLabel(GUIMain.lblPipette);
            changerEtatPanel(GUIMain.panelTest);
            changerEtatPanel(GUIMain.panelAqua);
        }
    }

    /**
     * @param label
     *              méthode pour changer l'état de la pipette
     */
    public void changerEtatLabel(JLabel label) {
        if (est_remplie) {
            label.setIcon(icone_plein);
        } else {
            label.setIcon(icone_vide);
        }
    }

    /**
     * @param panel
     *              méthode pour changer l'état du panel
     */
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

// Слава Україні!