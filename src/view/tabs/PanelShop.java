//Jérémie Caron     itération 1
//Classe pour l'affichage du magasin, pour itération 2

package view.tabs;

import java.awt.*;
import javax.swing.*;

import model.jeu.Inventaire;
import view.GUIMain;

import java.awt.event.*;

public class PanelShop extends JPanel implements ActionListener {

    JButton panel1, panel2, panel3, panel4;

    public PanelShop() { // Panel pour créer le magasin

        setLayout(null);

        panel1 = new JButton();
        panel1.setSize(100, 100);
        panel1.setText("poissonrouge");
        panel1.setBounds(50, 50, 100, 100);
        panel1.addActionListener(this);
        add(panel1);

        panel2 = new JButton();
        panel2.setSize(100, 100);
        panel2.setText("poissonbetta");
        panel2.setBounds(200, 50, 100, 100);
        panel2.addActionListener(this);
        add(panel2);

        panel3 = new JButton();
        panel3.setSize(100, 100);
        panel3.setText("marioplanty");
        panel3.setBounds(350, 50, 100, 100);
        panel3.addActionListener(this);
        add(panel3);

        panel4 = new JButton();
        panel4.setSize(100, 100);
        panel4.setText("calicul");
        panel4.setBounds(500, 50, 100, 100);
        panel4.addActionListener(this);
        add(panel4);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == panel1) {
            checkCase(Inventaire.img_inv_poi_rouge, "poisson");
        }

        if (e.getSource() == panel2) {
            checkCase(Inventaire.img_inv_betta, "poisson");
        }

        if (e.getSource() == panel3) {
        }

        if (e.getSource() == panel4) {
        }

    }

    public void checkCase(ImageIcon icon, String type) {
        if (GUIMain.empla1 == "empty") {
            GUIMain.empla1 = type;
            Inventaire.emp1.setIcon(icon);
        } 
        else if (GUIMain.empla2 == "empty") {
            GUIMain.empla2 = type;
            Inventaire.emp2.setIcon(icon);
        }
        else if (GUIMain.empla3 == "empty") {
            GUIMain.empla3 = type;
            Inventaire.emp3.setIcon(icon);
            
        }
        else if (GUIMain.empla4 == "empty") {
            GUIMain.empla4 = type;
            Inventaire.emp4.setIcon(icon);
            
        }
        else if (GUIMain.empla5 == "empty") {
            GUIMain.empla5 = type;
            Inventaire.emp5.setIcon(icon);
        }
        else if (GUIMain.empla6 == "empty") {
            GUIMain.empla6 = type;
            Inventaire.emp6.setIcon(icon);
        }
        else{
            System.out.println("inbentaire plein");
        }
    }
}
