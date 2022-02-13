package model.poissons;

import java.awt.*;
import javax.swing.*;

public class Poisson extends JPanel implements Runnable{
    
        // Attributs : coordonn�es de la boule
        int x = 300;
        int y = 100;
        int vel_x = 10;
        int vel_y = 10;
        int velocity_X;
        int velocity_Y;
    
        // Dessine boule
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
    
            Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("fish.png");
            g2d.drawImage(aquarium_1, x, y, this);
    
            //g2d.fillOval(x, y, 75, 75);
        }
    
        public void setXVelocity(int vel_x) {
            this.vel_x = vel_x;
        }
    
        public void setYVelocity(int vel_y) {
            this.vel_y = vel_y;
        }
    
        // D�placement boule selon les valeurs des param�tres x et y
        public void deplacer() {
            System.out.println(this.x + ", " + this.y);
            this.x += vel_x;
            this.y += vel_y;
            try {
                Thread.sleep(200); //Ici, une pause d'une seconde
            }catch(InterruptedException e) {
                e.printStackTrace();
            }
            // L'objet  se redessine (actualiser)
            repaint();
        }

        @Override
        public void run() {
            // TODO Auto-generated method stub
            
        }

        /* @Override
        public void run() {
            while (true) {
                
                if (panel.x > 500) {
                    panel.setXVelocity(-velocity_X);
                }
                if (panel.x <= 0) {
                    panel.setXVelocity(velocity_X);
                }
                if (panel.y > 440) {
                    panel.setYVelocity(-velocity_Y);
                }
                if (panel.y <= 0) {
                    panel.setYVelocity(velocity_Y);
                }
                panel.deplacer();
            }  
        } */
    
}
