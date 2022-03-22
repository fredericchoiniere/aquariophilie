package model.poissons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class PoissonTetra extends JPanel implements Runnable {
    // Attributs : coordonn�es de la boule
    public int x = 160;
    public int y = 60;
    public int vel_x = 1;
    public int vel_y = 1;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_tetra/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_tetra/poisson_gauche.png");
    public String image = "droite";

    @Override

    public void setOpaque(boolean isOpaque) {
        // TODO Auto-generated method stub
        super.setOpaque(false);
    }

    // Dessine boule
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(setImage(image), x, y, this);

        // g2d.fillOval(x, y, 75, 75);
    }

    public void setXVelocity(int vel_x) {
        this.vel_x = vel_x;
    }

    public void setYVelocity(int vel_y) {
        this.vel_y = vel_y;
    }

    // D�placement boule selon les valeurs des param�tres x et y
    public void deplacer() {
        // System.out.println(this.x + ", " + this.y);
        this.x += vel_x;
        this.y += vel_y;
        try {
            Thread.sleep(30); // Ici, une pause d'une seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // L'objet se redessine (actualiser)
        repaint();
    }

    public Image setImage(String coter) { // regarde pour le bon coter pour l'image
        if (coter == "droite") {
            img = poisson_droite;
        }
        if (coter == "gauche") {
            img = poisson_gauche;
        } else {
            img = poisson_droite;
        }
        return img;
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
