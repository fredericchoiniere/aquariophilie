//Itération 1: Jérémie Caron, Frédéric Choinière

//Classe des emplacements de l'inventaire

package view.jeu;

import javax.swing.JLabel;

public class Emplacementinv extends JLabel {
    
    public boolean plein = false;

    // créer l'emplacement dans l'inventaire
    public Emplacementinv() {
        super();
    }

    /**
     * @return Boolean
     *         remplit l'emplacement
     */
    public Boolean estPlein() {
        return plein;
    }
}

// Слава Україні!