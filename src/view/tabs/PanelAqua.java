package view.tabs;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class PanelAqua extends JPanel implements MouseListener, FocusListener{ // extends JPanel pour créer un Jpanel

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public PanelAqua() {
        setPreferredSize(new Dimension(1000, 700)); // Taille du panel
        addFocusListener(this);
        addMouseListener(this);
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

        // créer le background pour l'onglet Aquarium
        
        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background.png");
        g2D.drawImage(background,5, 5, this);

        Image eau_1 = Toolkit.getDefaultToolkit().getImage("res/eau/eau_bleu.png");
        g2D.drawImage(eau_1, 325, 305, this);

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("res/accessoires/aquarium/aquarium_1.png");
        g2D.drawImage(aquarium_1, 320, 305, this);

    }

    @Override
    public void focusGained(FocusEvent e) {
        //System.out.println("gloup");
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        //System.out.println("lost");
        
    }

    @Override
    public void mousePressed(MouseEvent me){
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocus();
        //System.out.println("fuck");
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }
}

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
class AnimPanel extends JPanel {
    // Attributs : coordonn�es de la boule
    int x = 300;
    int y = 100;
    int vel_x = 10;
    int vel_y = 10;

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    // Dessine boule
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("fish.png");
        g2d.drawImage(aquarium_1, x, y, this);

        //g2d.fillOval(x, y, 75, 75);
    }

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public void setXVelocity(int vel_x) {
        this.vel_x = vel_x;
    }

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public void setYVelocity(int vel_y) {
        this.vel_y = vel_y;
    }

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    // Deplacement boule selon les valeurs des parametres x et y
    public void deplacer() {
        System.out.println(this.x + ", " + this.y);
        this.x += vel_x;
        this.y += vel_y;
        try {
            Thread.sleep(200); //Ici, une pause d'une seconde
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        // L'objet  se redessine (actualiser)
        repaint();
    }
}