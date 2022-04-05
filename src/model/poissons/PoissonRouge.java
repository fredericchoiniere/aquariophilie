package model.poissons;

import java.awt.*;

import model.jeu.Aquarium;

public class PoissonRouge extends Poisson implements Runnable {
    int x = 10;
    int y = 10;
    int vel_x = 1;
    int vel_y = 1;
    public static int prix = 50;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_gauche.png");
    static Image empty = Toolkit.getDefaultToolkit().getImage("res/poissons/empty.png");

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(getImage(direction, img, poisson_droite, poisson_gauche, empty), x, y, this);

    }

    public void deplacer() {
        this.x += getXVelocity();
        this.y += getYVelocity();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    @Override
    public void run() {

        while (var) {
            // System.out.println("run");
            if (this.x > 286) {
                setXVelocity(-vel_x);
                direction = "gauche";
            }
            if (this.x < 4) {
                setXVelocity(1);
                direction = "droite"; // ne marchait pas avec vel_y, je ne sais pas pourquoi
            }
            if (this.y > 120) {
                setYVelocity(-vel_y);
            }
            if (this.y < 4) {
                setYVelocity(1); // ne marchait pas avec vel_y, je ne sais pas pourquoi
            }
            deplacer();
        }
    }

}
