//Jérémie Caron     itération 1
//Classe pour l'affichage du magasin, pour itération 2

package view.tabs;

import java.awt.*;
import javax.swing.*;

import model.jeu.Inventaire;
import model.poissons.PoissonBetta;
import model.poissons.PoissonRouge;
import view.GUIMain;

import java.awt.event.*;

public class PanelShop extends JPanel implements ActionListener {

    JButton boutonRouge, boutonBetta, boutonTetra, boutonMario, boutonCul;

    public PanelShop() { // Panel pour créer le magasin

        setLayout(null);

        boutonRouge = new JButton();
        boutonRouge.setSize(100, 100);
        boutonRouge.setText("poissonrouge");
        boutonRouge.setBounds(50, 50, 100, 100);
        boutonRouge.addActionListener(this);
        add(boutonRouge);

        boutonBetta = new JButton();
        boutonBetta.setSize(100, 100);
        boutonBetta.setText("poissonbetta");
        boutonBetta.setBounds(200, 50, 100, 100);
        boutonBetta.addActionListener(this);
        add(boutonBetta);

        boutonTetra = new JButton();
        boutonTetra.setSize(100, 100);
        boutonTetra.setText("poissonbetta");
        boutonTetra.setBounds(200, 220, 100, 100);
        boutonTetra.addActionListener(this);
        add(boutonTetra);

        boutonMario = new JButton();
        boutonMario.setSize(100, 100);
        boutonMario.setText("marioplanty");
        boutonMario.setBounds(350, 50, 100, 100);
        boutonMario.addActionListener(this);
        add(boutonMario);

        boutonCul = new JButton();
        boutonCul.setSize(100, 100);
        boutonCul.setText("calicul");
        boutonCul.setBounds(500, 50, 100, 100);
        boutonCul.addActionListener(this);
        add(boutonCul);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == boutonRouge) {
            checkCase(Inventaire.img_inv_poi_rouge, "poisson");

        }

        if (e.getSource() == boutonBetta) {
            checkCase(Inventaire.img_inv_betta, "poisson");
        }

        if (e.getSource() == boutonTetra) {
            checkCase(Inventaire.img_inv_tetra, "poisson");
        }

        if (e.getSource() == boutonMario) {
            checkCase(Inventaire.img_temp, "decoration");
        }

        if (e.getSource() == boutonCul) {
            checkCase(Inventaire.img_java_fern, "decoration");
        }

    }

    public void checkCase(ImageIcon icon, String type) {
        if (GUIMain.empla1 == "empty") {
            GUIMain.empla1 = type;
            Inventaire.emp1.setIcon(icon);
        } else if (GUIMain.empla2 == "empty") {
            GUIMain.empla2 = type;
            Inventaire.emp2.setIcon(icon);
        } else if (GUIMain.empla3 == "empty") {
            GUIMain.empla3 = type;
            Inventaire.emp3.setIcon(icon);

        } else if (GUIMain.empla4 == "empty") {
            GUIMain.empla4 = type;
            Inventaire.emp4.setIcon(icon);

        } else if (GUIMain.empla5 == "empty") {
            GUIMain.empla5 = type;
            Inventaire.emp5.setIcon(icon);
        } else if (GUIMain.empla6 == "empty") {
            GUIMain.empla6 = type;
            Inventaire.emp6.setIcon(icon);
        } else {
            System.out.println("inventaire plein");
        }
    }

}
