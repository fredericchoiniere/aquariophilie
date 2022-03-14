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

    // rempli l'inventaire
    public Boolean estPlein() {
        return plein;
    }
}
