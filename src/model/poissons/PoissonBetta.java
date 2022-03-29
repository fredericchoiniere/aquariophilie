package model.poissons;

import java.awt.*;

public class PoissonBetta extends Poisson implements Runnable {
    public int x = 230;
    public int y = 120;
    public int vel_x = 1;
    public int vel_y = 1;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_gauche.png");
    
    public String direction = "droite";

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(getImage(direction, img, poisson_droite, poisson_gauche), x, y, this);
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
        while (true) {
            if (x > 286) {
                setXVelocity(-vel_x);
                direction = "gauche";
            }
            if (x < 4) {
                setXVelocity(1);
                direction = "droite"; // ne marchait pas avec vel_y, je ne sais pas pourquoi
            }
            if (y > 120) {
                setYVelocity(-vel_y);
            }
            if (y < 4) {
                setYVelocity(1); // ne marchait pas avec vel_y, je ne sais pas pourquoi
            }
            deplacer();
        }
    }

}
