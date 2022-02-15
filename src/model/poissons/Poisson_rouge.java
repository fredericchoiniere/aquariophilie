package model.poissons;

// activit� 2-
// Exemple d'animation: Boule qui se d�place dans une frame

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class Poisson_rouge extends JFrame implements Runnable {

    public static void main(String[] args) {
    	new Poisson_rouge();
    }

    JButton btnAction = new JButton("Lancer le traitement");
    JButton btnStop = new JButton("Stopper le traitement");
    AnimPanel panel;
    Thread tAnim = new Thread(this);

    // Controleur
    public Poisson_rouge () {
        // Initialisation de la fen�tre...
		setTitle("Animation");
	    setSize(600,600);
	    setLocationRelativeTo(null);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        add(btnAction, BorderLayout.NORTH);
        add(btnStop,  BorderLayout.SOUTH);

	    //on place le panneau dans la fen�tre
	    panel=new AnimPanel();
        this.add( panel );     // ajout de panneau contenant boule
		setVisible(true);

        tAnim.start();

        btnStop.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setXVelocity(0);
                    panel.setYVelocity(0);
                }
            }
        );

        btnAction.addActionListener(
            new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    panel.setXVelocity(10);
                    panel.setYVelocity(10);
                }
            }
        );

    }

    @Override
    public void run() {
        while (true) {
            
            if (panel.x > 500) {
                panel.setXVelocity(-10);
            }
            if (panel.x <= 0) {
                panel.setXVelocity(10);
            }
            if (panel.y > 440) {
                panel.setYVelocity(-10);
            }
            if (panel.y <= 0) {
                panel.setYVelocity(10);
            }
            panel.deplacer();
        }
    }
}

// classe pour un panel contenant une boule anim�e
class AnimPanel extends JPanel {
    // Attributs : coordonn�es de la boule
    int x = 300;
    int y = 100;
    int vel_x = 10;
    int vel_y = 10;

    // Dessine boule
    public void paintComponent(Graphics g) {
    	super.paintComponent(g);
        Graphics2D g2d = (Graphics2D) g;

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("aquariophilie/res/poissons/poisson_rouge/fish-red-right.png");
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
}