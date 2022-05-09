package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

import model.jeu.Argent;
import model.plantes.*;
import model.poissons.*;

import java.awt.event.*;

public class GUIIntro extends JPanel {
    private Image image;
    public static JLabel label;
    public static JButton btnNouvellePartie, btnModeEvaluation, btnQuitter, btnCredits;

    static ImageIcon img = new ImageIcon("res/background/icone_aquariophilie.png");

    GUIIntro(Image image) {
        this.image = image;
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, getWidth(), getHeight(), this);
    }

    public static void guiIntroFrame() {
        try {
            JFrame frame = new JFrame("Image");

            Image image = Toolkit.getDefaultToolkit().getImage(
                    "res/background/intro.gif");

            GUIIntro imagePanel = new GUIIntro(image);
            imagePanel.setLayout(null);

            btnNouvellePartie = new JButton("Nouvelle Partie");
            // ils sont ici parce que ca marchait pas en les callant à l'extérieur de la
            // méthode so fuckit (pour fred qui va se plaindre)
            btnNouvellePartie.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GUIMain aquarium = new GUIMain();
                    aquarium.setResizable(false);
                    aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    aquarium.pack();
                    aquarium.setLocationRelativeTo(null);
                    aquarium.setVisible(true);
                    frame.setVisible(false);
                }
            });
            btnNouvellePartie.addKeyListener(new java.awt.event.KeyAdapter() {
                public void keyPressed(java.awt.event.KeyEvent evt) {
                    if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                        GUIMain aquarium = new GUIMain();
                        aquarium.setResizable(false);
                        aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        aquarium.pack();
                        aquarium.setLocationRelativeTo(null);
                        aquarium.setVisible(true);
                        frame.setVisible(false);
                    }
                }
            });
            btnNouvellePartie.setBounds(140, 130, 220, 50);
            btnNouvellePartie.setVisible(true);
            imagePanel.add(btnNouvellePartie);

            btnModeEvaluation = new JButton("Mode Évaluation");
            btnModeEvaluation.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    GUIMain aquarium = new GUIMain();
            aquarium.setResizable(false);
            aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aquarium.pack();
            aquarium.setLocationRelativeTo(null);
            aquarium.setVisible(true);
            frame.setVisible(false);

            // enlevement du systeme de progression
            PoissonRouge.prix = 0;
            PoissonBetta.prix = 0;
            PoissonTetra.prix = 0;
            PoissonNeo.prix = 0;
            JavaFern.prix = 0;
            BlueBlue.prix = 0;
            ScarletRot.prix = 0;
            Erdtree.prix = 0;
            Argent.argent = 0;
            Argent.montant = "∞";
            GUIMain.label_argent_aqua.setText("∞");
            GUIMain.label_argent_shop.setText("∞");
            Argent.normal = false;
                }
            });
            btnModeEvaluation.setBounds(140, 185, 220, 50);
            btnModeEvaluation.setVisible(true);
            imagePanel.add(btnModeEvaluation);


            btnQuitter = new JButton("Quitter");
            btnQuitter.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            btnQuitter.setBounds(140, 240, 105, 50);
            btnQuitter.setVisible(true);
            imagePanel.add(btnQuitter);


            btnCredits = new JButton("Credits");
            btnQuitter.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    //TOTO: afficher les credits
                }
            });
            btnCredits.setBounds(255, 240, 105, 50);
            btnCredits.setVisible(true);
            imagePanel.add(btnCredits);


            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setLocationRelativeTo(null);
            frame.add(imagePanel);
            frame.setSize(500, 400);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setResizable(false);
            frame.setIconImage(img.getImage());
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setTitle("Aquariophilie");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * public static void main(String[] args) {
     * 
     * SwingUtilities.invokeLater(new Runnable() {
     * public void run() {
     * createAndShowUI();
     * }
     * });
     * }
     */
}