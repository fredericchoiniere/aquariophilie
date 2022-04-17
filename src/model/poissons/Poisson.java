// Frédéric Choinière, Jérémie Caron    itération 2

package model.poissons;

import javax.swing.JLabel;
import javax.swing.JPanel;

import model.MethodeGUIMain;
import model.chimie.Eau;
import model.jeu.Inventaire;
import model.jeu.Sante;
import view.GUIMain;

import java.awt.*;

public class Poisson extends JPanel {

    // attributs de la classe
    int vel_x = 1;
    int vel_y = 1;
    private short sante = 100;
    public int index;
    public String direction = "droite";
    public boolean var = true;
    public String empInv, empAqua, nom;
    int hauteur = Eau.hauteurEnPixels, compensationPosition = Eau.hauteurEnPixels - (4 + (192 - Eau.hauteurEnPixels));

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

    public int getHauteur() {
        hauteur = 196 - Eau.hauteurEnPixels; // Traduit la hauteur en pixels de l'eau en coordonnées pour les poissons
        return hauteur;
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
     *              méthode pour afficher les tooltips
     */
    public static void updateToolTip(JLabel label, String type) { // TODO: terminer
        switch (type) {
            case "rouge":
                label.setToolTipText("Type: Poisson rouge" + "\nSanté: ");
                break;
            case "betta":
                label.setToolTipText("Type: Betta" + "\nSanté: ");
                break;
            case "tetra":
                label.setToolTipText("Type: Tetra" + "\nSanté: ");
                break;
            default:
                label.setToolTipText("");
                break;
        }
    }

    public static void setSante(short poisson) {
        if (fishType(poisson) == "rouge") {
            levels("rouge", poisson);
        } else if (fishType(poisson) == "betta") {
            levels("betta", poisson);
        } else if (fishType(poisson) == "tetra") {
            levels("tetra", poisson);
        }

    }

    public static String fishType(short poisson) {
        switch (poisson) {
            case 0:
                return GUIMain.aqua1;
            case 1:
                return GUIMain.aqua2;
            case 2:
                return GUIMain.aqua3;
            case 3:
                return GUIMain.aqua4;
            case 4:
                return GUIMain.aqua5;
            case 5:
                return GUIMain.aqua6;
            default:
                return "";
        }
    }

    public static void levels(String type, short numb) {
        //System.out.println("ScroreEau : " + GUIMain.eau.scoreEau);
        switch (type) {

            case "rouge":
                if (GUIMain.eau.scoreEau >= 66 - PoissonRouge.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante < 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante += 1;
                    } else {
                        GUIMain.listePoissonsAqua.get(numb).sante = 100;
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                } else if (GUIMain.eau.scoreEau >= 33 - PoissonRouge.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante <= 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante -= 1;
                    } else {
                        killFish(numb);
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                } else if (GUIMain.eau.scoreEau > 0 - PoissonRouge.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante <= 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante -= 2;
                    } else {
                        killFish(numb);
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                }
                break;
            case "betta":
                if (GUIMain.eau.scoreEau >= 66 - PoissonBetta.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante < 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante += 1;
                    } else {
                        GUIMain.listePoissonsAqua.get(numb).sante = 100;
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                } else if (GUIMain.eau.scoreEau >= 33 - PoissonBetta.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante <= 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante -= 1;
                    } else {
                        killFish(numb);
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                } else if (GUIMain.eau.scoreEau > 0 - PoissonBetta.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante <= 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante -= 2;
                    } else {
                        killFish(numb);
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                }
                break;
            case "tetra":
                if (GUIMain.eau.scoreEau >= 66 - PoissonTetra.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante < 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante += 1;
                    } else {
                        GUIMain.listePoissonsAqua.get(numb).sante = 100;
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                } else if (GUIMain.eau.scoreEau >= 33 - PoissonTetra.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante <= 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante -= 1;
                    } else {
                        killFish(numb);
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                } else if (GUIMain.eau.scoreEau > 0 - PoissonTetra.tolerance) {
                    if (GUIMain.listePoissonsAqua.get(numb).sante <= 100
                            && GUIMain.listePoissonsAqua.get(numb).sante > 0) {
                        GUIMain.listePoissonsAqua.get(numb).sante -= 2;
                    } else {
                        killFish(numb);
                    }
                    //System.out.println("Santé: " + GUIMain.listePoissonsAqua.get(numb).sante);
                    setBarValue(numb);
                }
                break;
            default:
                break;
        }
    }

    public static void killFish(short numb) {
        MethodeGUIMain.checkFishType(fishType(numb));
        setFalse(numb);
        GUIMain.listePoissonsAqua.get(numb).direction = "empty";
        GUIMain.listePoissonsAqua.get(numb).var = false;
        GUIMain.listePoissonsAqua.set(numb, GUIMain.poisson_default);
    }

    public static void setFalse(short numb) {
        switch (numb) {
            case 0:
                GUIMain.hasFish1 = false;
                GUIMain.aquarium.aqua1.setIcon(Inventaire.empty_inv);
                GUIMain.aqua1 = "empty";
                break;
            case 1:
                GUIMain.hasFish2 = false;
                GUIMain.aquarium.aqua2.setIcon(Inventaire.empty_inv);
                GUIMain.aqua2 = "empty";
                break;
            case 2:
                GUIMain.hasFish3 = false;
                GUIMain.aquarium.aqua3.setIcon(Inventaire.empty_inv);
                GUIMain.aqua3 = "empty";
                break;
            case 3:
                GUIMain.hasFish4 = false;
                GUIMain.aquarium.aqua4.setIcon(Inventaire.empty_inv);
                GUIMain.aqua4 = "empty";
                break;
            case 4:
                GUIMain.hasFish5 = false;
                GUIMain.aquarium.aqua5.setIcon(Inventaire.empty_inv);
                GUIMain.aqua5 = "empty";
                break;
            case 5:
                GUIMain.hasFish6 = false;
                GUIMain.aquarium.aqua6.setIcon(Inventaire.empty_inv);
                GUIMain.aqua6 = "empty";
                break;
        }
    }

    public static void setBarValue(short index) {
        switch (index) {
            case 0:
                Sante.emp1.setValue(GUIMain.listePoissonsAqua.get(index).sante);
                break;
            case 1:
                Sante.emp2.setValue(GUIMain.listePoissonsAqua.get(index).sante);
                break;
            case 2:
                Sante.emp3.setValue(GUIMain.listePoissonsAqua.get(index).sante);
                break;
            case 3:
                Sante.emp4.setValue(GUIMain.listePoissonsAqua.get(index).sante);
                break;
            case 4:
                Sante.emp5.setValue(GUIMain.listePoissonsAqua.get(index).sante);
                break;
            case 5:
                Sante.emp6.setValue(GUIMain.listePoissonsAqua.get(index).sante);
                break;
            default:
                break;
        }
    }
}
