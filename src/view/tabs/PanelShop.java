package view.tabs;
import java.awt.*;
import javax.swing.*;

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class PanelShop extends JPanel {

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public PanelShop() { // Panel pour créer le magasin
        setPreferredSize(new Dimension(1000, 700)); // Taille
    }

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public void paintComponent(Graphics g) { // méthode paint
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        g2D.setColor(Color.yellow);
        g2D.fillRect(20, 20, 200, 200);
        ;

    }
}
