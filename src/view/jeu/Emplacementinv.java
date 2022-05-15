//Itération 1: Jérémie Caron, Frédéric Choinière

//Classe des emplacements de l'inventaire

package view.jeu;

import javax.swing.JLabel;

public class Emplacementinv extends JLabel {

    public short position = 0;

    public float prix = 0;
    
    public boolean plein = false;

    // créer l'emplacement dans l'inventaire
    public Emplacementinv() {
        super();
    }

    /**
     * @return Boolean
     *         remplie l'emplacement
     */
    public Boolean estPlein() {
        return plein;
    }
}

// Слава Україні!