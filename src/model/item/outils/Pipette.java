//Jérémie Caron     itération 1
//Classe pour l'outil pipette

package model.item.outils;

import javax.swing.*;
import java.awt.*;

public class Pipette extends Outils {

    ImageIcon curseur_vide, curseur_plein, icone_vide, icone_plein;
    public boolean est_remplie = false;
    public int nbGouttes = 0;

    public Pipette() { // Création de l'objet pipette
        super();
        adapterNom();
        curseur_vide = new ImageIcon("res/icone_souris/pipe_vide.png");
        curseur_plein = new ImageIcon("res/icone_souris/pipe_remplie.png");
        icone_vide = new ImageIcon("res/outils/pipette_vide.png");
        icone_plein = new ImageIcon("res/outils/pipette_pleine.png");
    }

    // Getter pour le statut de est_remplis
    public boolean getEstRemplie() {
        return est_remplie;
    }

    // Setter pour le statut de est_remplis
    public void setEstRemplie(boolean proposition) {
        this.est_remplie = proposition;
    }

    // Getter pour le nombre de gouttes
    public int getNbGouttes() {
        return nbGouttes;
    }

    // Setter pour le nombre de gouttes
    public void setNbGouttes(int nouveauNbGouttes) {
        this.nbGouttes = nouveauNbGouttes;
        if(nouveauNbGouttes == 0)
            est_remplie=false;
    }

    // Setter pour le nombre de gouttes
    public void enleverUneGoutte() {
        this.nbGouttes--;
        if(nbGouttes == 0){
            est_remplie=false;
            //changerEtatPanel(panelTest);
        }
    }

    /** 
     * @param label
     * Change l'état de la pipette
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
     * change l'état du panel
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