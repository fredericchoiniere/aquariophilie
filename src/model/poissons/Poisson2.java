package model.poissons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Poisson2 extends JPanel {
    // Attributs : coordonn�es de la boule
    public int x = 10;
    public int y = 10;
    public int vel_x = 2;
    public int vel_y = 2;
    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_droite.png");
        //g2d.drawImage(poisson_droite, x, y, this);

    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_gauche.png");
        //g2d.drawImage(poisson_gauche, x, y, this);
    
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
        repaint();
    }

    public Image setImage(String coter){ //regarde pour le bon coter pour l'image
        if(coter == "droite"){
            img = poisson_droite;
        }
        if(coter == "gauche"){
            img = poisson_gauche;
        } else {
            img = poisson_droite;
        }
        return img;
    }

    
}