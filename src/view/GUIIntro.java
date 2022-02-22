package view;

import javax.swing.*;
import java.awt.event.*;

public class GUIIntro extends JFrame implements ActionListener {

    public JButton btEnter;

    public GUIIntro() { // création du constructeur GUIIntro

        JPanel simplePanel = new JPanel();

        btEnter = new JButton("enter");
        btEnter.addActionListener(this);
        simplePanel.add(btEnter);

        add(simplePanel);

        // action listener sur la touche enter pour aller plus vite
        btEnter.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                if(evt.getKeyCode() == KeyEvent.VK_ENTER){
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
