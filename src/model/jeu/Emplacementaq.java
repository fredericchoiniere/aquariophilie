//Itération 1: Jérémie Caron, Frédéric Choinière

//Classe des emplacements de l'aquarium

package model.jeu;

import javax.swing.JLabel;

public class Emplacementaq extends JLabel {

    public short position = 0;

    public float prix = 0;
    
    public boolean plein = false;

    // créer un emplacement
    public Emplacementaq() {
        super();
    }

    /**
     * @return Boolean
     *         rempli l'inventaire
     */
    public Boolean estPlein() {
        return plein;
    }
}

// Слава Україні!