// Frédéric Choinière, Jérémie Caron    itération 2

package model.poissons;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Poisson extends JPanel {

    int vel_x = 1;
    int vel_y = 1;
    static int sante = 100;
    public int index;
    public String direction = "droite";
    public boolean var = true;
    
    
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

    public Image getImage(String coter, Image img, Image poisson_droite, Image poisson_gauche, Image empty) { // regarde pour le bon coter pour l'image
        if (coter == "droite") {
            img = poisson_droite;
        }
        else if (coter == "gauche") {
            img = poisson_gauche;
        }else if (coter == "empty") {
            img = empty;
        } else {
            img = poisson_droite;
        }
        return img;
    }

    public static void updateToolTip(JLabel label, String type){ // TODO: ajouter déchets
        switch (type) {
            case "rouge":
                label.setToolTipText("Type: Poisson rouge" + "\nSanté: " + sante);
                break;

            case "betta":
                label.setToolTipText("Type: Betta" + "\nSanté: " + sante);
                break;

            case "tetra":
                label.setToolTipText("Type: Tetra" + "\nSanté: " + sante);
                break;
        
            default:
                label.setToolTipText("");
                break;
        }



        System.out.println(type);
    }

}
