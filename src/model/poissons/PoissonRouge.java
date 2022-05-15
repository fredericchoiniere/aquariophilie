//Jérémie Caron, Frédéric Choinière     itération 2
// Jérémie Caron    itération 3

package model.poissons;

import java.awt.*;

import model.GestionException;
import model.environnement.Temps;
import view.GUIMain;

public class PoissonRouge extends Poisson implements Runnable {

    // attributs de la classe
    public int x_min = 4;
    public int x_max = 286;
    public int y_min = getHauteur() - 14;
    public int y_max = 120;
    public int x_temp = random.nextInt(x_max - x_min) + (1 + x_min);
    public int y_temp = random.nextInt(y_max - y_min) + (1 + y_min);
    public int side = random.nextInt(2) + 1;
    int vel_x = 1;
    int vel_y = 1;
    public static int prix = 50;
    public static int tolerance = 6;

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_rouge/poisson_gauche.png");
    static Image empty = Toolkit.getDefaultToolkit().getImage("res/poissons/empty.png");

    public static int dechets = 5;

    public PoissonRouge() {
        setImg();
    }

    public static boolean checkTolerances() {
        if (GUIMain.eau.getPH() < 3 || GUIMain.eau.getPH() > 9 || GUIMain.eau.getGH() < 3
                || GUIMain.eau.getAmmoniaque() > 3 || GUIMain.eau.getNitrites() > 2 || GUIMain.eau.getNitrates() > 50) {
            return false;
        }
        return true;
    }

    /**
     * @param g
     *          méthode pour dessiner le poisson
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;
        g2d.drawImage(getImage(direction, img, poisson_droite, poisson_gauche, empty, Poisson.rip), x_temp, y_temp,
                this);

    }

    /**
     * méthode pour faire bouger le poisson
     */
    public void deplacer() {
        x_temp += getXVelocity();
        y_temp += getYVelocity();
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            GestionException.GestionExceptionThreadTemps();
        }
        repaint();
    }

    public void setImg() {
        if (side == 1) {
            direction = "droite";
            img = poisson_droite;
            setXVelocity(1);
        } else {
            direction = "gauche";
            img = poisson_gauche;
            setXVelocity(-1);
        }
    }

    @Override
    public void run() {
        while (var) {
                if (!Temps.isPaused) {
                    if (x_temp > x_max) {
                        setXVelocity(-vel_x);
                        direction = "gauche";
                    }
                    if (x_temp < x_min) {
                        setXVelocity(1);
                        direction = "droite";
                    }
                    if (y_temp > y_max) {
                        setYVelocity(-vel_y);
                        if(isDead){
                            setYVelocity(0);
                            this.var = false;
                        }
                    }
                    if (y_temp < getHauteur() - 14) {
                        setYVelocity(1);
                    }
                    deplacer();
                } else {
                    try {
                        Thread.sleep(30);
                    } catch (Exception e) {
                        GestionException.GestionExceptionThreadTemps();
                    }
                }

            }
        
    }

}

// Слава Україні!