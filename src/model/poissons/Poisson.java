// Frédéric Choinière, Jérémie Caron    itération 2
// Jérémie Caron, Frédéric Choinière    itération 3

package model.poissons;

import javax.swing.JLabel;
import javax.swing.JPanel;
import model.MethodeGUIMain;
import model.chimie.Eau;
import model.jeu.Inventaire;
import model.jeu.Sante;
import view.GUIMain;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Poisson extends JPanel {

    // attributs de la classe
    int vel_x = 1;
    int vel_y = 1;
    private short sante = 100;
    public int index;
    public String direction;
    public boolean var = true, boolTolerances = true, isDead = false;
    public String empInv, empAqua, nom;
    int hauteur = Eau.hauteurEnPixels, compensationPosition = Eau.hauteurEnPixels - (4 + (192 - Eau.hauteurEnPixels));

    static Poisson selection = new Poisson();

    public static Random random = new Random();
    int randomNumber;

    static ArrayList<Short> listeACleanUp = new ArrayList<Short>();
    public static ArrayList<Poisson> listeVraisPoissons = new ArrayList<Poisson>(6);

    static Image rip = Toolkit.getDefaultToolkit().getImage("res/poissons/rip.png");

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
     * @return int
     */
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
    public Image getImage(String coter, Image img, Image poisson_droite, Image poisson_gauche, Image empty, Image rip) {
        if (coter == "droite") {
            img = poisson_droite;
        } else if (coter == "gauche") {
            img = poisson_gauche;
        } else if (coter == "rip") {
            img = rip;
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
            case "neo":
                label.setToolTipText("Type: Neo" + "\nSanté: ");
                break;
            default:
                label.setToolTipText("");
                break;
        }
    }

    /**
     * @param poisson
     * @return String
     */
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

    /**
     * @param numb
     */
    public static void setSante(short numb) {
        selection = GUIMain.listePoissonsAqua.get(numb);
        switch (fishType(numb)) {
            case "rouge":
                ajusterSante(numb, PoissonRouge.tolerance);
                //selection = (PoissonRouge) GUIMain.listePoissonsAqua.get(numb);
                if (!selection.checkTolerances("rouge") && !selection.isDead) {
                    selection.sante -= 15;
                    if (selection.sante <= 0) {
                        killFish(numb);
                        selection.isDead = true;
                    }
                }
                break;
            case "betta":
                ajusterSante(numb, PoissonBetta.tolerance);
                //selection = (PoissonBetta) GUIMain.listePoissonsAqua.get(numb);
                if (!selection.checkTolerances("betta") && !selection.isDead) {
                    selection.sante -= 15;
                    if (selection.sante <= 0) {
                        killFish(numb);
                        selection.isDead = true;
                    }
                }
                break;
            case "tetra":
                ajusterSante(numb, PoissonTetra.tolerance);
                //selection = (PoissonTetra) GUIMain.listePoissonsAqua.get(numb);
                if (!selection.checkTolerances("tetra") && !selection.isDead) {
                    selection.sante -= 15;
                    if (selection.sante <= 0) {
                        killFish(numb);
                        selection.isDead = true;
                    }
                }
                break;
            case "neo":
                ajusterSante(numb, PoissonNeo.tolerance);
                //selection = (PoissonNeo) GUIMain.listePoissonsAqua.get(numb);
                if (!selection.checkTolerances("neo") && !selection.isDead) {
                    selection.sante -= 15;
                    if (selection.sante <= 0) {
                        killFish(numb);
                        selection.isDead = true;
                    }
                }
                break;
            default:
                break;
        }
    }

    /**
     * @param numb
     * @param tolerance
     */
    public static void ajusterSante(short numb, int tolerance) {
        if (GUIMain.eau.scoreEau >= 66 - tolerance) {
            if (selection.sante < 100
                    && selection.sante > 0) {
                selection.sante += 1;
            } else {
                selection.sante = 100;
            }
            setBarValue(numb);
        } else if (GUIMain.eau.scoreEau >= 33 - tolerance) {
            if (selection.sante <= 100
                    && selection.sante > 0) {
                selection.sante -= 1;
            } else {
                killFish(numb);
            }
            setBarValue(numb);
        } else if (GUIMain.eau.scoreEau > 0 - tolerance) {
            if (selection.sante <= 100
                    && selection.sante > 0) {
                selection.sante -= 2;
            } else {
                killFish(numb);
            }
            setBarValue(numb);
        }
    }

    
    /** 
     * @param type
     * @return boolean
     */
    public boolean checkTolerances(String type) {

        switch (type) {
            case "rouge":
                boolTolerances = PoissonRouge.checkTolerances();
                break;
            case "betta":
                boolTolerances = PoissonBetta.checkTolerances();
                break;
            case "tetra":
                boolTolerances = PoissonTetra.checkTolerances();
                break;
            case "neo":
                boolTolerances = PoissonNeo.checkTolerances();
                break;

            default:
                break;
        }

        return boolTolerances;
    }

    
    /** 
     * @param numb
     */
    public static void killFish(short numb) {
        MethodeGUIMain.checkFishType(fishType(numb));
        GUIMain.listePoissonsAqua.get(numb).direction = "rip";
        GUIMain.listePoissonsAqua.get(numb).setXVelocity(0);
        GUIMain.listePoissonsAqua.get(numb).setYVelocity(1);
        listeACleanUp.add(numb);
    }

    public static void cleanUp() {
        for (short indexMorts : listeACleanUp) {
            setFalse(indexMorts);
        }
        listeACleanUp.clear();
    }

    /**
     * @param numb
     */
    public static void setFalse(short numb) {
        GUIMain.listePoissonsAqua.get(numb).direction = "empty";
        GUIMain.listePoissonsAqua.set(numb, GUIMain.poisson_default);
        switch (numb) {
            case 0:
                GUIMain.hasFish1 = false;
                GUIMain.aquarium.aqua1.setIcon(Inventaire.empty_inv);
                GUIMain.aqua1 = "empty";
                Sante.emp1.setValue(100);
                break;
            case 1:
                GUIMain.hasFish2 = false;
                GUIMain.aquarium.aqua2.setIcon(Inventaire.empty_inv);
                GUIMain.aqua2 = "empty";
                Sante.emp2.setValue(100);
                break;
            case 2:
                GUIMain.hasFish3 = false;
                GUIMain.aquarium.aqua3.setIcon(Inventaire.empty_inv);
                GUIMain.aqua3 = "empty";
                Sante.emp3.setValue(100);
                break;
            case 3:
                GUIMain.hasFish4 = false;
                GUIMain.aquarium.aqua4.setIcon(Inventaire.empty_inv);
                GUIMain.aqua4 = "empty";
                Sante.emp4.setValue(100);
                break;
            case 4:
                GUIMain.hasFish5 = false;
                GUIMain.aquarium.aqua5.setIcon(Inventaire.empty_inv);
                GUIMain.aqua5 = "empty";
                Sante.emp5.setValue(100);
                break;
            case 5:
                GUIMain.hasFish6 = false;
                GUIMain.aquarium.aqua6.setIcon(Inventaire.empty_inv);
                GUIMain.aqua6 = "empty";
                Sante.emp6.setValue(100);
                break;
        }
    }

    /**
     * @param index
     */
    public static void setBarValue(short index) {
        if (GUIMain.hasFish1) {
            Sante.emp1.setVisible(true);
            Sante.emp1.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp1.setValue(0);
            }
        } if (GUIMain.hasFish2) {
            Sante.emp2.setVisible(true);
            Sante.emp2.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp2.setValue(0);
            }
        } if (GUIMain.hasFish3) {
            Sante.emp3.setVisible(true);
            Sante.emp3.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp3.setValue(0);
            }
        } if (GUIMain.hasFish4) {
            Sante.emp4.setVisible(true);
            Sante.emp4.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp4.setValue(0);
            }
        } if (GUIMain.hasFish5) {
            Sante.emp5.setVisible(true);
            Sante.emp5.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp5.setValue(0);
            }
        } if (GUIMain.hasFish6) {
            Sante.emp6.setVisible(true);
            Sante.emp6.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp6.setValue(0);
            }
        } else {
            System.out.println("Were fucked");
        }
    }
       
    public static void trackFishTypeAndProgressBarCalicul() {
        System.out.println(GUIMain.hasFish1 + " " + GUIMain.hasFish2 + " " + GUIMain.hasFish3 + " " + GUIMain.hasFish4 + " " + GUIMain.hasFish5 + " " + GUIMain.hasFish6);
    }
}

// Слава Україні!
