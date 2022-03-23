package model.poissons;

import javax.swing.JPanel;
import java.awt.*;

public class Poisson extends JPanel{

    int vel_x = 1;
    int vel_y = 1;
    
    public String empInv, empAqua, nom;

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

    public void setEmpInv(String empInv){
        this.empInv = empInv;
    }

    public void setEmpAqua(String empAqua){
        this.empAqua = empAqua;
    }

    public void setNom(String nom){
        this.nom = nom;
    }

    public int getXVelocity(){
        return vel_x;
    }

    public int getYVelocity(){
        return vel_y;
    }

    public String getEmpInv(){
        return empInv;
    }

    public String getEmpAqua(){
        return empAqua;
    }

    public String getNom(){
        return nom;
    }

    public Image getImage(String coter, Image img, Image poisson_droite, Image poisson_gauche) { // regarde pour le bon coter pour l'image
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
