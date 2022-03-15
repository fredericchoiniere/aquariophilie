package model.poissons;
import java.awt.*;
import javax.swing.*;

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class Poisson2 extends JPanel { //TODO: implements runnable
    // Attributs : coordonnees de la boule
    public int x = 10;
    public int y = 10;
    public int vel_x = 1;
    public int vel_y = 1;
    public String image = "droite";
    public boolean swim = true;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_gauche.png");
    Image empty = Toolkit.getDefaultToolkit().getImage("res/poissons/empty.png");
    PanelAqua panelAqua;

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(false);
    }

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
        img = poisson_droite;
        g2d.drawImage(setImage(image), x, y, this);
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
        this.x += vel_x;
        this.y += vel_y;
        try {
            Thread.sleep(100); // Ici, une pause d'une seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // L'objet se redessine (actualiser)
        repaint();
    }

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public Image setImage(String coter) { // regarde pour le bon coter pour l'image
        if (coter == "droite") {
            img = poisson_droite;
        }
        if (coter == "gauche") {
            img = poisson_gauche;
        }
        if (coter == "empty") {
            img = empty;
        } else {
            img = poisson_droite;
        }
        return img;
    }

    // permet au poisson de nager correctement dans son espace
    public void nager() {
        if (this.x > 286) {
            this.setXVelocity(-this.vel_x);
            this.image = "gauche";
        }
        if (this.x < 4) {
            this.setXVelocity(1);
            this.image = "droite";
        }
        if (this.y > 120) {
            this.setYVelocity(-this.vel_y);
        }
        if (this.y < 4) {
            this.setYVelocity(1); // ne marchait pas avec vel_y, je ne sais pas pourquoi
        }
        this.deplacer();
    }

    public void setImageEmpty(String string) {
        this.image = "empty";
    }

}