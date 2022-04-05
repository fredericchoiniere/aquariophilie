package model.poissons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PoissonTetra extends Poisson implements Runnable {
    // Attributs : coordonn�es de la boule
    int x = 160;
    int y = 60;
    int vel_x = 1;
    int vel_y = 1;
    int prix = 200;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_tetra/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_tetra/poisson_gauche.png");

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(getImage(direction, img, poisson_droite, poisson_gauche, PoissonRouge.empty), x, y, this);
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
        // System.out.println("run");
        while (var) {
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
