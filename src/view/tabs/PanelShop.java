//Jérémie Caron     itération 1
//Classe pour l'affichage du magasin, pour itération 2

package view.tabs;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelShop extends JPanel implements ActionListener {

    JButton panel1, panel2, panel3, panel4;

    public PanelShop() { // Panel pour créer le magasin

        setLayout(null);

        panel1 = new JButton();
        panel1.setSize(100, 100);
        panel1.setText("poissonrouge");
        panel1.setBounds(50, 50, 100, 100);
        add(panel1);

        panel2 = new JButton();
        panel2.setSize(100, 100);
        panel2.setText("poissonbetta");
        panel2.setBounds(200, 50, 100, 100);
        add(panel2);

        panel3 = new JButton();
        panel3.setSize(100, 100);
        panel3.setText("marioplanty");
        panel3.setBounds(350, 50, 100, 100);
        add(panel3);

        panel4 = new JButton();
        panel4.setSize(100, 100);
        panel4.setText("calicul");
        panel4.setBounds(500, 50, 100, 100);
        add(panel4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == panel1) {
        }

        if (e.getSource() == panel2) {
        }

        if (e.getSource() == panel3) {
        }

        if (e.getSource() == panel4) {
        }

    }

    /*
     * public void paintComponent(Graphics g) { // méthode paint
     * super.paintComponent(g);
     * 
     * Graphics2D g2D = (Graphics2D) g;
     * 
     * g2D.setColor(Color.yellow);
     * g2D.fillRect(20, 20, 200, 200);
     * ;
     * 
     * }
     */
}
