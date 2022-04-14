//Jérémie Caron, Frédéric Choinière     itération 2

package model.poissons;

import java.awt.*;

public class PoissonTetra extends Poisson implements Runnable {
    // attributs de la classe
    int x = 160;
    int y = 60;
    int vel_x = 1;
    int vel_y = 1;
    public static int prix = 200;
    public static int dechets = 2;
    public static int tolerance = 0;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_tetra/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_tetra/poisson_gauche.png");

    public PoissonTetra() {
    }

    /**
     * @param g
     *          méthode pour dessiner le poisson
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(getImage(direction, img, poisson_droite, poisson_gauche, PoissonRouge.empty), x, y, this);
    }

    /**
     * méthode pour faire bouger le poisson
     */
    public void deplacer() {
        this.x += getXVelocity();
        this.y += getYVelocity();
        try {
            Thread.sleep(20);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void run() {
        while (var) {
            if (this.x > 286) {
                setXVelocity(-vel_x);
                direction = "gauche";
            }
            if (this.x < 4) {
                setXVelocity(1);
                direction = "droite";
            }
            if (this.y > 120) {
                setYVelocity(-vel_y);
            }
            if (this.y < 90) {
                setYVelocity(1);
            }
            deplacer();
        }
    }

}
