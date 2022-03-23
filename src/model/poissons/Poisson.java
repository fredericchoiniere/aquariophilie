package model.poissons;

import javax.swing.JPanel;
import java.awt.*;

public class Poisson extends JPanel{

    int x;
    int y;
    int vel_x = 1;
    int vel_y = 1;

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

    public int getXVelocity(){
        return vel_x;
    }

    public int getYVelocity(){
        return vel_y;
    }

    public Image getImage(String coter) { // regarde pour le bon coter pour l'image
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
