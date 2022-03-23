package model.poissons;

import javax.swing.JPanel;
import java.awt.*;

public class Poisson extends JPanel{

    int x;
    int y;
    int vel_x;
    int vel_y;

    public String empInv, empAqua, nom, image;

    Image img, poisson_droite, poisson_gauche;
    
    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(false);
    }

    

    public void setXVelocity(int vel_x) {
        this.vel_x = vel_x;
    }

    public void setYVelocity(int vel_y) {
        this.vel_y = vel_y;
    }

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
}
