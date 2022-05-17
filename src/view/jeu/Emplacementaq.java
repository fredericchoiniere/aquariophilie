//Itération 1: Jérémie Caron, Frédéric Choinière

//Classe des emplacements de l'aquarium

package view.jeu;

import javax.swing.JLabel;

public class Emplacementaq extends JLabel {
    
    public boolean plein = false;

    // créer un emplacement
    public Emplacementaq() {
        super();
    }

    /**
     * @return Boolean
     *         remplit l'inventaire
     */
    public Boolean estPlein() {
        return plein;
    }
}

// Слава Україні!