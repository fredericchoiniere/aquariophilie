//Itération 3: Frédéric Choinière, Jérémie Caron

// Classe qui permet de stocker les attributs et faire nager le poisson

package model.poissons;

import java.awt.*;
import model.GestionException;
import model.environnement.Temps;
import view.GUIMain;

public class PoissonNeo extends Poisson implements Runnable {

    // attributs de la classe
    public int x_min = 4;
    public int x_max = 286;
    public int y_min = 120;
    public int y_max = 125;
    public int x_temp = random.nextInt(x_max - x_min) + (1 + x_min);
    public int y_temp = random.nextInt(y_max - y_min) + (1 + y_min);
    public int side = random.nextInt(2) + 1;
    int vel_x = 1;
    int vel_y = 1;
    public static int prix = 125;
    public static int tolerance = 0;
    public static int dechets = (-2);

    Image img;
    Image poisson_droite = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_neo/poisson_droite.png");
    Image poisson_gauche = Toolkit.getDefaultToolkit().getImage("res/poissons/poisson_neo/poisson_gauche.png");
    static Image empty = Toolkit.getDefaultToolkit().getImage("res/poissons/empty.png");

    public PoissonNeo() {
        setImg();
    }

    
    /** 
     * @return boolean
     *        Évalue si le poisson tolère les paramètres d'eau actuels
     */
    public static boolean checkTolerances() { // ammo 2 nit 1 nat 40
        if (GUIMain.eau.getPH() < 4 || GUIMain.eau.getPH() > 8 || GUIMain.eau.getGH() < 3
                || GUIMain.eau.getAmmoniaque() > 1 || GUIMain.eau.getNitrites() > 1 || GUIMain.eau.getNitrates() > 50) {
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
        g2d.drawImage(getImage(direction, img, poisson_droite, poisson_gauche, empty, Poisson.rip), x_temp, y_temp, this);

    }

    /**
     * méthode pour faire bouger le poisson
     */
    public void deplacer() {
        x_temp += getXVelocity();
        y_temp += getYVelocity();
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            GestionException.GestionExceptionThreadTemps();
        }
        repaint();
    }

    /**
     *         Méthode qui permet de faire tourner le poisson
     */
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

    /**
     *         Méthode qui permet de faire nager le poisson
     */
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
                if (y_temp > y_max) { // limite du bas
                    setYVelocity(0);
                    if(isDead){
                        setYVelocity(0);
                        this.var = false;
                    }
                }
                if (y_temp < y_min) { // limite du haut
                    setYVelocity(0);
                }
                deplacer();
            } else {
                try {
                    Thread.sleep(50);
                } catch (Exception e) {
                    GestionException.GestionExceptionThreadTemps();
                }
            }

        }
    }

}

// Слава Україні!