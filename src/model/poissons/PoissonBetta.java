package model.poissons;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import view.GUIMain;
import view.tabs.PanelAqua;

public class PoissonBetta extends JPanel{ //TODO: implements runnable
    // Attributs : coordonn�es de la boule
    public int x = 230;
    public int y = 120;
    public int vel_x = 1;
    public int vel_y = 1;
    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_droite.png");
    // g2d.drawImage(poisson_droite, x, y, this);

    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_gauche.png");
    // g2d.drawImage(poisson_gauche, x, y, this);

    public String image = "droite";
    PanelAqua panelAqua;
    public boolean swim = true;
    Image empty = Toolkit.getDefaultToolkit().getImage("res/poissons/empty.png");

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
            Thread.sleep(100); // Ici, une pause d'une seconde
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
        }
            if (coter == "empty") {
                img = empty;
        } else {
            img = poisson_droite;
        }
        return img;
    }

    public void nager(){
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


}