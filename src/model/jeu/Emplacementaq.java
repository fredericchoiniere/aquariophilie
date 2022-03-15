package model.jeu;
import javax.swing.JLabel;

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class Emplacementaq extends JLabel{
    
    public short position = 0;
    public float prix = 0;
    public boolean plein = false;

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public Emplacementaq(){
        super();
    }

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public Boolean estPlein(){
        return plein;
    }
}
