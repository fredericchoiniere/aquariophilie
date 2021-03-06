// Itération 2: Frédéric Choinière, Jérémie Caron
// Itération 3: Jérémie Caron, Frédéric Choinière

// Classe mère des poissons

package model.poissons;

import javax.swing.JLabel;
import javax.swing.JPanel;
import model.MethodeGUIMain;
import model.chimie.Eau;
import view.GUIMain;
import view.jeu.Inventaire;
import view.jeu.Sante;
import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

public class Poisson extends JPanel {

    // attributs de la classe
    int vel_x = 1;
    int vel_y = 1;
    int hauteur = Eau.hauteurEnPixels;
    public int index;

    private short sante = 100;

    public boolean var = true, boolTolerances = true, isDead = false;

    public String direction, empInv, empAqua, nom;

    static Poisson selection = new Poisson();

    public static Random random = new Random();

    static ArrayList<Short> listeACleanUp = new ArrayList<Short>();

    static Image rip = Toolkit.getDefaultToolkit().getImage("res/poissons/rip.png");

    /**
     * @param boolean
     *                méthode pour rendre opaque
     */
    @Override
    public void setOpaque(boolean isOpaque) {
        super.setOpaque(false);
    }

    /**
     * @param int
     *            méthode pour donner la vitesse en x
     */
    public void setXVelocity(int vel_x) {
        this.vel_x = vel_x;
    }

    /**
     * @param int
     *            méthode pour donner la vitesse en y
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
     *         Traduit la hauteur en pixels de l'eau en coordonnées pour les poissons
     */
    public int getHauteur() {
        hauteur = 196 - Eau.hauteurEnPixels;
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
     * @param JLabel
     * @param String
     *               méthode pour afficher les tooltips des poissons dans l'inventaire
     */
    public static void updateToolTip(JLabel label, String type) {
        switch (type) {
            case "rouge":
                label.setToolTipText(
                        "<html><p>Type: <span style=\"color: #008080;\"><strong>Poisson rouge</strong></span></p>" +
                        "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #008080;\">" + PoissonRouge.prix + "</span></span><span style=\"color: #008080;\">฿</span></p>" +
                        "<p><span style=\"color: #000000;\">Rapporte <span style=\"color: #008080;\">1฿ <span style=\"color: #000000;\">par jour</span></span></span></p>" +
                        "<p>G&eacute;n&egrave;re <span style=\"color: #008080;\">5 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></p>" +
                        "<p><span style=\"color: #008080;\"><span style=\"color: #000000;\">Tol&eacute;rance: <span style=\"color: #ff9900;\">moyenne</span></span></span></p></html>");
                break;
            case "betta":
                label.setToolTipText("<html><p>Type: <span style=\"color: #008080;\"><strong>Betta</strong></span></p>" +
                        "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #008080;\">" + PoissonBetta.prix + "</span></span><span style=\"color: #008080;\">฿</span></p>" +
                        "<p><span style=\"color: #000000;\">Rapporte <span style=\"color: #008080;\">3฿ <span style=\"color: #000000;\">par jour</span></span></span></p>" +
                        "<p>G&eacute;n&egrave;re <span style=\"color: #008080;\">4 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></p>" +
                        "<p><span style=\"color: #008080;\"><span style=\"color: #000000;\">Tol&eacute;rance: <span style=\"color: #008000;\">&eacute;lev&eacute;e</span></span></span></p></html>");
                break;
            case "tetra":
                label.setToolTipText("<html><p>Type: <span style=\"color: #008080;\"><strong>Tetra</strong></span></p>" +
                        "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #008080;\">" + PoissonTetra.prix + "</span></span><span style=\"color: #008080;\">฿</span></p>" +
                        "<p><span style=\"color: #000000;\">Rapporte <span style=\"color: #008080;\">2฿ <span style=\"color: #000000;\">par jour</span></span></span></p>" +
                        "<p>G&eacute;n&egrave;re <span style=\"color: #008080;\">2 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></p>" +
                        "<p><span style=\"color: #008080;\"><span style=\"color: #000000;\">Tol&eacute;rance: <span style=\"color: #993366;\">faible</span></span></span></p></html>");
                break;
            case "neo":
                label.setToolTipText("<html><p>Type: <span style=\"color: #008080;\"><strong>Neocaridina</strong></span></p>" +
                        "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #008080;\">" + PoissonNeo.prix + "</span></span><span style=\"color: #008080;\">฿</span></p>" +
                        "<p><span style=\"color: #000000;\">Rapporte <span style=\"color: #008080;\">2฿ <span style=\"color: #000000;\">par jour</span></span></span></p>" +
                        "<p>Absorbe <span style=\"color: #008080;\">2 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></p>" +
                        "<p><span style=\"color: #008080;\"><span style=\"color: #000000;\">Tol&eacute;rance: <span style=\"color: #ff0000;\">tr&egrave;s faible</span></span></span></p></html>");
                break;
            default:
                break;
        }
    }

    /**
     * @param poisson
     * @return String
     *         Méthode qui retourne le type de poisson dans un emplacement
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
     * @param short
     *              Méthode qui change la sante d'un poisson selon son index
     */
    public static void setSante(short numb) {
        selection = GUIMain.listePoissonsAqua.get(numb);
        switch (fishType(numb)) {
            case "rouge":
                ajusterSante(numb, PoissonRouge.tolerance);
                if (!selection.checkTolerances("rouge") && !selection.isDead) { // Si le poisson ne tolère pas les paramètre d'eau et n'est pas mort, perd graduellement de la vie
                    selection.sante -= 10;
                    if (selection.sante <= 0) {
                        killFish(numb);
                        selection.isDead = true;
                    }
                }
                break;
            case "betta":
                ajusterSante(numb, PoissonBetta.tolerance);
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
     *                  Méthode qui ajuste la sante du poisson selon le score de l'eau
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
     * @return boolean
     *         Méthode qui vérifie si la tolérance des poissons en fonction de leur type
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
     * 
     * @param short
     *              Gère le décès des poissons
     */
    public static void killFish(short numb) {
        MethodeGUIMain.checkFishType(fishType(numb));
        GUIMain.listePoissonsAqua.get(numb).direction = "rip";
        GUIMain.listePoissonsAqua.get(numb).setXVelocity(0);
        GUIMain.listePoissonsAqua.get(numb).setYVelocity(1);
        listeACleanUp.add(numb);
    }

    /**
     * Méthode pour nettoyer les poissons morts
     */
    public static void cleanUp() {
        for (short indexMorts : listeACleanUp) {
            setFalse(indexMorts);
        }
        listeACleanUp.clear();
    }

    /**
     * @param short
     *              Méthode qui supprime les poissons morts des listes et de l'aquarium
     */
    public static void setFalse(short numb) {
        GUIMain.listePoissonsAqua.get(numb).direction = "empty";
        GUIMain.listePoissonsAqua.set(numb, GUIMain.poisson_default);
        switch (numb) {
            case 0:
                GUIMain.hasFish1 = false;
                GUIMain.aquarium.aqua1.setIcon(Inventaire.empty_inv);
                GUIMain.aqua1 = "empty";
                Sante.emp1.setVisible(false);
                Sante.emp1.setValue(100);
                break;
            case 1:
                GUIMain.hasFish2 = false;
                GUIMain.aquarium.aqua2.setIcon(Inventaire.empty_inv);
                GUIMain.aqua2 = "empty";
                Sante.emp2.setVisible(false);
                Sante.emp2.setValue(100);
                break;
            case 2:
                GUIMain.hasFish3 = false;
                GUIMain.aquarium.aqua3.setIcon(Inventaire.empty_inv);
                GUIMain.aqua3 = "empty";
                Sante.emp3.setVisible(false);
                Sante.emp3.setValue(100);
                break;
            case 3:
                GUIMain.hasFish4 = false;
                GUIMain.aquarium.aqua4.setIcon(Inventaire.empty_inv);
                GUIMain.aqua4 = "empty";
                Sante.emp4.setVisible(false);
                Sante.emp4.setValue(100);
                break;
            case 4:
                GUIMain.hasFish5 = false;
                GUIMain.aquarium.aqua5.setIcon(Inventaire.empty_inv);
                GUIMain.aqua5 = "empty";
                Sante.emp5.setVisible(false);
                Sante.emp5.setValue(100);
                break;
            case 5:
                GUIMain.hasFish6 = false;
                GUIMain.aquarium.aqua6.setIcon(Inventaire.empty_inv);
                GUIMain.aqua6 = "empty";
                Sante.emp6.setVisible(false);
                Sante.emp6.setValue(100);
                break;
        }
    }

    /**
     * @param index
     *              Méthode qui permet de mettre les barres de vie à jour
     */
    public static void setBarValue(short index) {
        if (GUIMain.hasFish1) {
            Sante.emp1.setVisible(true);
            Sante.emp1.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp1.setValue(0);
            }
        }
        if (GUIMain.hasFish2) {
            Sante.emp2.setVisible(true);
            Sante.emp2.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp2.setValue(0);
            }
        }
        if (GUIMain.hasFish3) {
            Sante.emp3.setVisible(true);
            Sante.emp3.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp3.setValue(0);
            }
        }
        if (GUIMain.hasFish4) {
            Sante.emp4.setVisible(true);
            Sante.emp4.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp4.setValue(0);
            }
        }
        if (GUIMain.hasFish5) {
            Sante.emp5.setVisible(true);
            Sante.emp5.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp5.setValue(0);
            }
        }
        if (GUIMain.hasFish6) {
            Sante.emp6.setVisible(true);
            Sante.emp6.setValue(GUIMain.listePoissonsAqua.get(index).sante);
            if (selection.isDead) {
                Sante.emp6.setValue(0);
            }
        }
    }
}

// Слава Україні!
