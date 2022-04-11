// Frédéric Choinière, Jérémie Caron    itération 2

package model.poissons;

import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.*;

public class Poisson extends JPanel {

    // attributs de la classe
    int vel_x = 1;
    int vel_y = 1;
    static int sante = 100;
    public int index;
    public String direction = "droite";
    public boolean var = true;
    public String empInv, empAqua, nom;

    /**
     * @param isOpaque
     *                 méthode pour rendre opaque
     */
    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(false);
    }

    /**
     * @param vel_x
     *              méthode pour donner la vitesse en x
     */
    public void setXVelocity(int vel_x) {
        this.vel_x = vel_x;
    }

    /**
     * @param vel_y
     *              méthode pour donner la vitesse en y
     */
    public void setYVelocity(int vel_y) {
        this.vel_y = vel_y;
    }

    /**
     * @param empInv
     *               méthode pour donner l'emplacement
     */
    public void setEmpInv(String empInv) {
        this.empInv = empInv;
    }

    /**
     * @param empAqua
     *                méthode pour donner l'emplacement
     */
    public void setEmpAqua(String empAqua) {
        this.empAqua = empAqua;
    }

    /**
     * @param nom
     *            méthode pour donner le nom
     */
    public void setNom(String nom) {
        this.nom = nom;
    }

    /**
     * @return int
     *         méthode pour retourner la vitesse en x
     */
    public int getXVelocity() {
        return vel_x;
    }

    /**
     * @return int
     *         méthode pour retourner la vitesse en y
     */
    public int getYVelocity() {
        return vel_y;
    }

    /**
     * @return String
     *         méthode pour retourner l'emplacement
     */
    public String getEmpInv() {
        return empInv;
    }

    /**
     * @return String
     *         méthode pour retourner l'emplacement
     */
    public String getEmpAqua() {
        return empAqua;
    }

    /**
     * @return String
     *         méthode pour retourner le nom
     */
    public String getNom() {
        return nom;
    }

    /**
     * @param coter
     * @param img
     * @param poisson_droite
     * @param poisson_gauche
     * @param empty
     * @return Image
     *         méthode pour changer l'image selon la direction
     */
    public Image getImage(String coter, Image img, Image poisson_droite, Image poisson_gauche, Image empty) {
        if (coter == "droite") {
            img = poisson_droite;
        } else if (coter == "gauche") {
            img = poisson_gauche;
        } else if (coter == "empty") {
            img = empty;
        } else {
            img = poisson_droite;
        }
        return img;
    }

    /**
     * @param label
     * @param type
     *              méthode pour afficher les tooltip
     */
    public static void updateToolTip(JLabel label, String type) {
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
    }

}
