//Jérémie Caron     itération 1
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

        // Entrer dans l'application pour tester
        JPanel simplePanel = new JPanel();

        // Gestionnaire
        GridBagLayout g = new GridBagLayout();
        simplePanel.setLayout(g);
        GridBagConstraints constraints = new GridBagConstraints();

        // label pour le titre
        titre = new JLabel("Aquariophilie");
        titre.setFont(new Font("Verdana", Font.BOLD, 30));
        constraints.gridx = 0;
        constraints.gridy = 0;
        constraints.weightx = 0.5;
        constraints.weighty = 0.5;
        constraints.gridwidth = 3;
        constraints.gridheight = 1;
        constraints.fill = 0;
        simplePanel.add(titre, constraints);

        // création des boutons pour les nombreuses action possible sur le Frame intro
        // -----------------------------------------------------------------------------------------------------------------------------

        // nouvelle partie
        btnNouvellePartie = new JButton("Nouvelle Partie");
        btnNouvellePartie.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 1;
        constraints.gridwidth = 1;
        constraints.gridheight = 1;
        constraints.fill = 2;
        simplePanel.add(btnNouvellePartie, constraints);

        // charger partie
        btnChargerPartie = new JButton("Charger Partie");
        btnChargerPartie.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 2;
        simplePanel.add(btnChargerPartie, constraints);

        // mode evaluation
        btnModeEvaluation = new JButton("Mode Evaluation");
        btnModeEvaluation.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 3;
        simplePanel.add(btnModeEvaluation, constraints);

        // credit
        btnCredit = new JButton("Credit");
        btnCredit.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 4;
        simplePanel.add(btnCredit, constraints);

        // fermer l'application
        btClose = new JButton("Fermer");
        btClose.addActionListener(this);
        constraints.gridx = 0;
        constraints.gridy = 5;
        constraints.fill = 0;
        simplePanel.add(btClose, constraints);

        // classement
        btClassement = new JButton("Classement");
        btClassement.addActionListener(this);
        constraints.gridx = 1;
        constraints.gridy = 5;
        simplePanel.add(btClassement, constraints);

        // inspirations
        btInspiration = new JButton("Inspiration");
        btInspiration.addActionListener(this);
        constraints.gridx = 2;
        constraints.gridy = 5;
        simplePanel.add(btInspiration, constraints);

        add(simplePanel);

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

        // bouton pour reprendre la partie
        if (e.getSource() == btnChargerPartie) {
            // TODO
        }

        // bouton pour le mode évaluation
        if (e.getSource() == btnModeEvaluation) {
            // TODO
        }

        // bouton pour les credits
        if (e.getSource() == btnCredit) { // TODO: à revoir
            /*
             * JFrame frame = new JFrame("Credit");
             * 
             * frame.setSize(500, 400);
             * frame.setResizable(false);
             * frame.setLocationRelativeTo(null);
             * frame.setVisible(true);
             * JPanel panel = new JPanel();
             * 
             * GridBagLayout g = new GridBagLayout(); // Gestionnaire
             * panel.setLayout(g);
             * GridBagConstraints constraints = new GridBagConstraints();
             * 
             * JLabel label = new JLabel("Créateur:");
             * constraints.gridx = 0;
             * constraints.gridy = 0;
             * constraints.weightx = 0.5;
             * constraints.weighty = 0.5;
             * constraints.gridwidth = 1;
             * constraints.gridheight = 1;
             * constraints.fill = 0;
             * panel.add(label, constraints);
             * 
             * JLabel createur1 = new JLabel("Jeremie Caron");
             * constraints.gridx = 1;
             * constraints.gridy = 0;
             * panel.add(createur1, constraints);
             * 
             * JLabel createur2 = new JLabel("Frederic Choiniere");
             * constraints.gridx = 1;
             * constraints.gridy = 1;
             * panel.add(createur2, constraints);
             * 
             * JLabel createur3 = new JLabel("Justin Plouffe");
             * constraints.gridx = 1;
             * constraints.gridy = 2;
             * panel.add(createur3, constraints);
             * 
             * frame.add(panel);
             * add(frame);
             */
        }

        // bouton pour fermer l'application
        if (e.getSource() == btClose) {
            System.exit(0);
        }

        // bouton pour les classements
        if (e.getSource() == btClassement) {
            // TODO
        }

        // bouton pour les inspirations du projet
        if (e.getSource() == btInspiration) {
            // TODO
        }

    }

    // --------------------------------------------------------------------------------------------------------------------------------

}
