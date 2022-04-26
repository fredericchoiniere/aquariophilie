//Frédéric Choinière     itération 3

package model.poissons;

import java.awt.*;

import model.environnement.Temps;

public class PoissonNeo extends Poisson implements Runnable {

    // attributs de la classe
    int x = 12;
    int y = 120;
    int vel_x = 1;
    int vel_y = 1;
    public static int prix = 125;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_neo/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_neo/poisson_gauche.png");
    static Image empty = Toolkit.getDefaultToolkit().getImage("res/poissons/empty.png");

    public static int dechets = -2;

    /**
     * @param g
     *          méthode pour dessiner le poisson
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(getImage(direction, img, poisson_droite, poisson_gauche, empty), x, y, this);

    }

    /**
     * méthode pour faire bouger le poisson
     */
    public void deplacer() {
        this.x += getXVelocity();
        this.y += getYVelocity();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void run() {
        while (var) {
            if (!Temps.isPaused) {
                if (this.x > 286) {
                    setXVelocity(-vel_x);
                    direction = "gauche";
                }
                if (this.x < 4) {
                    setXVelocity(1);
                    direction = "droite";
                }
                if (this.y > 140) { // limite du bas
                    setYVelocity(-vel_y);
                }
                if (this.y < 135) { // limite du haut
                    setYVelocity(1);
                }
                deplacer();
            } else {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }

}
