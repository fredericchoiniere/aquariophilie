package view;

import javax.swing.*;
import java.awt.event.*;

public class GUIIntro extends JFrame implements ActionListener {

    public JButton btEnter;
    public JButton btnNouvellePartie;
    public JButton btnChargerPartie;
    public JButton btnModeEvaluation;
    public JButton btnAPropos;

    public GUIIntro() { // création du constructeur GUIIntro

        //Entrer dans l'application pour tester
        JPanel simplePanel = new JPanel();

        btEnter = new JButton("enter");
        btEnter.addActionListener(this);
        simplePanel.add(btEnter);

        add(simplePanel);

        /*//Crée une nouvelle partie
        JPanel nouvellePartie = new JPanel();

        btnNouvellePartie = new JButton("Nouvelle partie");
        btnNouvellePartie.addActionListener(this);
        nouvellePartie.add(btnNouvellePartie);

        add(nouvellePartie);
        */
    }

    @Override
    public void actionPerformed(ActionEvent e) { // initialise GuiMain lorsque l'on clique sur enter
        if (e.getSource() == btEnter) {
            GUIMain aquarium = new GUIMain();
            aquarium.setResizable(false);
            aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aquarium.pack();
            aquarium.setLocationRelativeTo(null);
            aquarium.setVisible(true);
            setVisible(false);

        }

    }

    // --------------------------------------------------------------------------------------------------------------------------------

}
