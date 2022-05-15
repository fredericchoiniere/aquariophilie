// Itération 1: Jérémie Caron
// Itération 3: Jérémie Caron, Justin Plouffe
//Classe pour l'affichage du frame d'introduction

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
    public static JLabel label, lblNouvellePartie, lblModeEvaluation;
    public static JButton btnNouvellePartie, btnModeEvaluation, btnQuitter, btnCredits;

    static ImageIcon img = new ImageIcon("res/background/icone_aquariophilie.png");

    GUIIntro(Image image) {
        this.image = image;
    }

    /**
     * @param g
     *          permet de paint le frame d'introduction
     */
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
            
            lblNouvellePartie = new JLabel();

            // bouton pour nouvelle partie
            btnNouvellePartie = new JButton(new ImageIcon("res/intro/nouvellePartie.png"));

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
            btnNouvellePartie.setOpaque(false);
            btnNouvellePartie.setContentAreaFilled(false);
            btnNouvellePartie.setBorderPainted(false);
            btnNouvellePartie.setVisible(true);
            imagePanel.add(btnNouvellePartie);

            // bouton pour mode évaluation
            btnModeEvaluation = new JButton(new ImageIcon("res/intro/modeEvaluation.png"));
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
            btnModeEvaluation.setOpaque(false);
            btnModeEvaluation.setContentAreaFilled(false);
            btnModeEvaluation.setBorderPainted(false);
            btnModeEvaluation.setVisible(true);
            imagePanel.add(btnModeEvaluation);

            // ajout du bouton pour quitter
            btnQuitter = new JButton(new ImageIcon("res/intro/quitter.png"));
            btnQuitter.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.exit(0);
                }
            });
            btnQuitter.setBounds(140, 240, 105, 50);
            btnQuitter.setOpaque(false);
            btnQuitter.setContentAreaFilled(false);
            btnQuitter.setBorderPainted(false);
            btnQuitter.setVisible(true);
            imagePanel.add(btnQuitter);

            // ajout du bouton pour les credits
            btnCredits = new JButton(new ImageIcon("res/intro/credits.png"));
            btnCredits.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("Credits");
                    JTextArea textArea = new JTextArea();

                    textArea.setEditable(false);
                    textArea.setText("Heyo !\n" + "Canadian checkers are the best.\n" + "We hope you enjoy this game.\n"
                            + "Thanks for playing!\n" + "Jérémie Caron" + "\n" + "Justin Plouffe" + "/n" + "Version 1.0"
                            + "\n" + "Version 2.0" + "\n" + "Version 3.0" + "\n" + "Version 4.0" + "\n" + "Version 5.0"
                            + "\n" + "Version 6.0" + "\n1" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2"
                            + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2" + "\n2"
                            + "\n2" + "\n2" + "\n2");

                    JScrollPane scrollPane = new JScrollPane(textArea);

                    frame.add(scrollPane);

                    // rame.add(textArea);
                    frame.setSize(700, 700);
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                }
            });
            btnCredits.setBounds(255, 240, 105, 50);
            btnCredits.setOpaque(false);
            btnCredits.setContentAreaFilled(false);
            btnCredits.setBorderPainted(false);
            btnCredits.setVisible(true);
            imagePanel.add(btnCredits);

            // ajout du label titre
            JLabel label_titre = new JLabel();
            ImageIcon titre = new ImageIcon(
                    new ImageIcon("res/background/aquariophilie2.png").getImage());

            label_titre.setIcon(titre);
            label_titre.setBounds(56, 40, 380, 52);
            imagePanel.add(label_titre);

            // attributs du frame intro
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
}

// Слава Україні!