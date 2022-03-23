package model.poissons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PoissonRouge extends Poisson implements Runnable {
    // Attributs : coordonn�es de la boule
    int x = 10;
    int y = 10;
    int vel_x = 1;
    int vel_y = 1;

    public String empInv;
    public String empAqua;
    public String nom;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_droite.png");
    // g2d.drawImage(poisson_droite, x, y, this);

    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_gauche.png");
    // g2d.drawImage(poisson_gauche, x, y, this);

    public String image = "droite";

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(setImage(image), x, y, this);
    }

    @Override
    public void run() {
        //System.out.println("run");
        while (true) {
            //System.out.println(this.x + ", " + this.y);
            if (x > 286) {
                setXVelocity(-vel_x);
                image = "gauche";
            }
            if (x < 4) {
                setXVelocity(1);
                image = "droite"; // ne marchait pas avec vel_y, je ne sais pas pourquoi
            }
            if (y > 120) {
                setYVelocity(-vel_y);
            }
            if (y < 4) {
                setYVelocity(1); // ne marchait pas avec vel_y, je ne sais pas pourquoi
            }
            this.deplacer();
        }
    }

}
