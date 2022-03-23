package model.poissons;

import java.awt.*;
import javax.swing.*;

public class PoissonBetta extends Poisson implements Runnable {
    // Attributs : coordonn�es de la boule
    public int x = 230;
    public int y = 120;
    public int vel_x = 1;
    public int vel_y = 1;

    public String empInv;
    public String empAqua;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_gauche.png");
    public String image = "droite";

    public void deplacer() {
        // System.out.println(this.x + ", " + this.y);
        x += vel_x;
        y += vel_y;
        try {
            Thread.sleep(30); // Ici, une pause d'une seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // L'objet se redessine (actualiser)
        repaint();
    }

    @Override
    public void run() {
        while (true) {
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
            deplacer();
        }
    }

}
