// Itération 1: Jérémie Caron
// Itération 3: Jérémie Caron, Justin Plouffe

//Classe pour l'affichage du frame d'introduction

package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.URI;
import java.nio.file.Paths;
import javax.swing.*;
import model.jeu.Argent;
import model.plantes.*;
import model.poissons.*;
import java.awt.event.*;

public class GUIIntro extends JPanel {
    // attributs de la classe
    private Image image;

    static JEditorPane editorPane;

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
            btnNouvellePartie.setToolTipText("Démarre une nouvelle partie");
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
                    Argent.argent = 999999999;
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
            btnModeEvaluation.setToolTipText("Démarre une nouvelle partie avec un budget ∞");
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
            btnQuitter.setToolTipText("Quitte l'application");
            btnQuitter.setVisible(true);
            imagePanel.add(btnQuitter);

            // ajout du bouton pour les credits
            btnCredits = new JButton(new ImageIcon("res/intro/credits.png"));
            btnCredits.addActionListener((ActionListener) new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    JFrame frame = new JFrame("Crédits");
                    frame.setResizable(false);
                    frame.setSize(700, 700);
                    frame.setIconImage(img.getImage());
                    frame.setVisible(true);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.setLocationRelativeTo(null);
                    
                    File fileFred = Paths.get(("res/credits/fred.png")).toFile();
                    URI faceFred = fileFred.toURI();

                    File fileJay = Paths.get(("res/credits/jeremie.png")).toFile();
                    URI faceJay = fileJay.toURI();

                    File fileJustin = Paths.get(("res/credits/justin.png")).toFile();
                    URI faceJustin = fileJustin.toURI();


                    editorPane = new JEditorPane();
                    editorPane.setEditable(false);
                    editorPane.setContentType("text/html");
                    editorPane.setText("<html><h1 style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><strong><span style=\"color: #008080;\">AQUARIOPHILIE</span></span></strong></h1>" +
                    "<h3 style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">Projet final du programme SIM au Coll&egrave;ge de Rosemont<br /></span></span></h3>" +
                    "<h4 style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">420-204-RE H22</span></span></h4>" +
                    "<h4 style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">Pr&eacute;sent&eacute; &agrave; Mme Wafaa Niar Dinedane le 17 mai 2022</span></span></h4>" +
                    "<p style=\"text-align: center;\">&nbsp;</p>" +
                    "<p style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">Membres de l'&eacute;quipe:</span></span></p>" +
                    "<p style=\"text-align: center;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src='" + faceFred + "'  /></p>" +
                    "<p style=\"text-align: center;\"><strong><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">Fr&eacute;d&eacute;ric Choini&egrave;re</span></span></strong></p>" +
                    "<p style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">G&eacute;nie de la programmation et figure de proue du projet</span></span></p>" +
                    "<p style=\"text-align: center;\">&nbsp;</p>" +
                    "<p style=\"text-align: center;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src='" + faceJay + "'  /></p>" +
                    "<p style=\"text-align: center;\"><strong><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">J&eacute;r&eacute;mie Caron</span></span></strong></p>" +
                    "<p style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">Itin&eacute;rant qu'on a trouv&eacute; devant le c&eacute;gep, membre int&eacute;gral de l'&eacute;quipe</span></span></p>" + 
                    "<p style=\"text-align: center;\">&nbsp;</p>" +
                    "<p style=\"text-align: center;\"><img style=\"display: block; margin-left: auto; margin-right: auto;\" src='" + faceJustin + "'  /></p>" +
                    "<p style=\"text-align: center;\"><strong><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">Justin Plouffe</span></span></strong></p>" +
                    "<p style=\"text-align: center;\"><span style =\"font-family: Arial, sans-serif;\"><span style=\"color: #000000;\">e̵̝̅v̵̝͍̱̟̥̉e̸̟͗͛́̽̐ŗ̴͖̳̠̰͋y̴͉͉̲͈̓͗͑͘ͅ ̴̨͇̼̒͑s̷̯̠̱͐͂̐͋͛̾͜ḕ̴̩͊̇c̷̹̫̳̍̈̐͠o̵̻̯͙̬̍͐̇n̷̙̹͊d̶͓͍̯̱̏̂̕ ̴̰̫̔̇ͅỳ̸͔̬̰̠̹͇̄̍o̸̧̡̗̻̔̿̿͝ṷ̵̽̒'̶͎̽͑͆̌͜r̷͈͒̃͜͜͜͝ē̴͖̻̩ ̵͕̙̅n̵͈̞̗̈́̎̌ͅo̵̦͙̞̗͐̓͊̚͠t̷̙̽̏͛̿̓͊ ̶̞͋̿͊̄͗́ṙ̸̘̰͗u̸̧͚̦̱̠͎̽̋̈́̕͘͝n̵̦̣͚̱̋͆n̵̝̰̯̳̔̓̓͝͠ì̶̭̤̞̠̝̱n̸̢͓͈͑g̴̛͈̲̭̼̘͜ ̵̢̳̹̼͖̚Î̵̛̳̜̮̘̪͔̌͐͐̿'̶̝͛̋͘m̴̡̧̬̳̝̃͘͜ ̷̨̟̫̏̈́̑ò̶̫͂̀́n̷̡̼̒̇̑̅́l̷̜͔̫̠͐̀͂͒y̵̨͈̯̲̞̝̋̃̕ ̸̬͖̈͒̉̑̍̕͜g̴̲̫̹̣̺̜̾e̷̙̬̽͂̃̒͝t̸͚̻̳̪͍̍̈́͌͊̋ẗ̶̥́̎͛î̴͖̋̽n̷̲̻͋͗̄̈͠ͅg̸̮̹̙̖̲̱̃̈́̈́͗̈́ ̶̡̨̬̳̤͆ͅc̷̯͆l̸̬̟̦̆͂̏̈͐o̴̲̙̜̹̖͆̂̔͒ͅs̴̮̙̫̣̤̫̀̏̚ē̸̤̬̣̎̊͜r̷̖͋̉̿̆̓͘͜</span></span></p>" + 
                    "<p style=\"text-align: center;\">&nbsp;</p>" +

                    "</html>");


                    JScrollPane scrollPane = new JScrollPane(editorPane);
                    
                    frame.add(scrollPane);
                }
            });
            btnCredits.setBounds(255, 240, 105, 50);
            btnCredits.setOpaque(false);
            btnCredits.setContentAreaFilled(false);
            btnCredits.setBorderPainted(false);
            btnCredits.setToolTipText("Affiche les crédits et autres infos pertinentes");
            btnCredits.setVisible(true);
            imagePanel.add(btnCredits);

            // ajout du label titre
            JLabel label_titre = new JLabel();
            ImageIcon titre = new ImageIcon(new ImageIcon("res/background/aquariophilie2.png").getImage());
            label_titre.setIcon(titre);
            label_titre.setBounds(56, 40, 380, 52);
            label_titre.setToolTipText("Ça a failli partir sur une calculatrice de matrices");
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