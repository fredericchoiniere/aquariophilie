//Jérémie Caron     itération 1
// Justin Plouffe Itération 3
//Classe pour l'affichage du frame d'introduction

package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class GUIIntro extends JFrame implements ActionListener {

    // créer les attributs de la classe
    public JButton btnNouvellePartie, btnChargerPartie, btnModeEvaluation, btnCredit, btClose, btClassement,
            btInspiration;
    public JLabel titre;

    public GUIIntro() { // création du constructeur GUIIntro

        setTitle("Aquariophilie");

        // Entrer dans l'application pour tester
        JPanel panelIntro = new JPanel();
        panelIntro.setOpaque(false);
        panelIntro.setLayout(null);

        JLayeredPane layerIntro = new JLayeredPane();

        JLabel lblGif = new JLabel();
        lblGif.setIcon(new ImageIcon("res/background/intro2.png"));
        lblGif.setBounds(0,0,500,400);
        panelIntro.add(lblGif);
        //layerIntro.add(lblGif,0);
            
        // label pour le titre
        titre = new JLabel("Aquariophilie");
        titre.setFont(new Font("Verdana", Font.BOLD, 30));
        titre.setBounds(100, 0, 350, 100);
        panelIntro.add(titre);
        //layerIntro.add(titre,1);
        
        // création des boutons pour les nombreuses action possible sur le Frame intro
        // -----------------------------------------------------------------------------------------------------------------------------

        // nouvelle partie
        btnNouvellePartie = new JButton("Nouvelle Partie");
        btnNouvellePartie.addActionListener(this);
        btnNouvellePartie.setBounds(150, 0, 200, 50);
        //btnNouvellePartie.setVisible(true);
        panelIntro.add(btnNouvellePartie);
        //layerIntro.add(btnNouvellePartie);
       
        // mode evaluation
        btnModeEvaluation = new JButton("Mode Evaluation");
        btnModeEvaluation.addActionListener(this);
        
        // credit
        btnCredit = new JButton("Credit");
        btnCredit.addActionListener(this);

        // fermer l'application
        btClose = new JButton("Fermer");
        btClose.addActionListener(this);

        panelIntro.add(layerIntro);
        add(panelIntro);

        // action listener sur la touche enter pour aller plus vite
        btnNouvellePartie.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
                    GUIMain aquarium = new GUIMain();
                    aquarium.setResizable(false);
                    aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    aquarium.pack();
                    aquarium.setLocationRelativeTo(null);
                    aquarium.setVisible(true);
                    setVisible(false);
                }
            }
        });

    }

    /**
     * ActionListeners pour la classe GUIIntro
     */
    @Override
    public void actionPerformed(ActionEvent e) { // initialise GuiMain lorsque l'on clique sur enter
        // bouton pour une nouvelle partie
        if (e.getSource() == btnNouvellePartie) {
            GUIMain aquarium = new GUIMain();
            aquarium.setResizable(false);
            aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aquarium.pack();
            aquarium.setLocationRelativeTo(null);
            aquarium.setVisible(true);
            setVisible(false);
        }

        // bouton pour le mode évaluation
        if (e.getSource() == btnModeEvaluation) {
            // TODO
        }

        // bouton pour les credits
        if (e.getSource() == btnCredit) { // TODO: à revoir
           
        }

        // bouton pour fermer l'application
        if (e.getSource() == btClose) {
            System.exit(0);
        }

    }

    // --------------------------------------------------------------------------------------------------------------------------------

}