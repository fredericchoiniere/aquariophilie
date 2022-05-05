package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.event.*;

public class GUIIntro extends JPanel {
    private Image image;
    public static JLabel label;
    public static JButton btnNouvellePartie, btnChargerPartie, btnModeEvaluation, btnCredit, btClose, btClassement,
            btInspiration;

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
            btnNouvellePartie.setBounds(150, 0, 200, 50);
            btnNouvellePartie.setVisible(true);
            imagePanel.add(btnNouvellePartie);

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