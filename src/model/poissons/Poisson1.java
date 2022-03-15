package model.poissons;

import java.awt.*;
import javax.swing.*;

import view.tabs.PanelAqua;

public class Poisson1 extends JPanel {

    // création des attributs de la classe
    public int x = 230;
    public int y = 120;
    public int vel_x = 1;
    public int vel_y = 1;
    public String image = "droite";
    public boolean swim = true;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_betta/poisson_gauche.png");
    Image empty = Toolkit.getDefaultToolkit().getImage("res/poissons/empty.png");
    PanelAqua panelAqua;

    // permet de rendre le poisson opaque
    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(false);
    }

    // permet de déssiner le poisson
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        img = poisson_droite;
        g2d.drawImage(setImage(image), x, y, this);
    }

    // set la velociter du poisson
    public void setXVelocity(int vel_x) {
        this.vel_x = vel_x;
    }

    // set la velociter du poisson
    public void setYVelocity(int vel_y) {
        this.vel_y = vel_y;
    }

    // Deplacement du poisson selon les valeurs des parametres x et y
    public void deplacer() {
        this.x += vel_x;
        this.y += vel_y;
        try {
            Thread.sleep(100); // Ici, une pause d'une seconde
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        repaint();
    }

    // regarde pour le bon coter pour l'image
    public Image setImage(String coter) {
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

    // permet au poisson de nager correctement dans son aquarium
    public void nager() {
        if (this.x > 286) {
            this.setXVelocity(-this.vel_x);
            image = "gauche";
        }
        if (this.x < 4) {
            this.setXVelocity(1);
            image = "droite";
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