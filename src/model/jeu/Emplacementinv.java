//Jérémie Caron, Frédéric Choinière     itération 1
//Classe des emplacements de l'inventaire

package model.jeu;
import javax.swing.JLabel;

public class Emplacementinv extends JLabel {

    public short position = 0;
    public float prix = 0;
    public boolean plein = false;

    // créer l'emplacement dans l'inventaire
    public Emplacementinv() {
        super();
    }

    // remplie l'emplacement
    public Boolean estPlein() {
        return plein;
    }
}
