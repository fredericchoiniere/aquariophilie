package model.poissons;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PoissonRouge extends JLabel {
    // Attributs : coordonn�es de la boule
    public int x = 300;
    public int y = 100;
    int vel_x = 10;
    int vel_y = 10;

    // Dessine boule
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("../res/outils/aquarium_kit/aquarium_kit_open.png");
        g2d.drawImage(aquarium_1, x, y, this);

        //g2d.fillOval(x, y, 75, 75);
    }

    public void setXVelocity(int vel_x) {
        this.vel_x = vel_x;
    }

    public void setYVelocity(int vel_y) {
        this.vel_y = vel_y;
    }

    // D�placement boule selon les valeurs des param�tres x et y
    public void deplacer() {
        System.out.println(this.x + ", " + this.y);
        this.x += vel_x;
        this.y += vel_y;
        try {
            Thread.sleep(200); //Ici, une pause d'une seconde
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
        // L'objet  se redessine (actualiser)
        System.out.println("déplace");
        repaint();
    }
}