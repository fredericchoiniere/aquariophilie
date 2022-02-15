package view;

//import model.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.outils.Pipette;
import model.outils.TestEau;
import view.tabs.*;

import java.util.*;

public class GUIMain extends JFrame implements ActionListener {

    JPanel panelPrincipal;
    JButton pousser, rapetisser;
    JLabel pipette;
    JLabel testEau;
    short stade, iteration = 0;
    String nom;

    public GUIMain() {

        // ----------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du premier tab
        JTabbedPane tabbedPane = new JTabbedPane();

        PanelAqua panelAqua = new PanelAqua(); // appel de la méthode paint de Home
        panelAqua.setLayout(null);
        panelAqua.setVisible(true);

        // creation de la pipette pour le drag and drop
        Pipette pipette = new Pipette();
        pipette.setIcon(new ImageIcon("res/outils/pipette.png"));

        Dimension size_pipette = pipette.getPreferredSize(); // prend la dimension de la photo
        pipette.setBounds(835, 110, size_pipette.width, size_pipette.height); // position d'origine

        panelAqua.add(pipette); // ajout de la pipette au frame
        pipette.setVisible(true);

        // creation du testeur d'eau pour le drag and drop
        TestEau testEau = new TestEau();
        testEau.setIcon(new ImageIcon("res/outils/testEau.png"));

        Dimension size_testEau = testEau.getPreferredSize(); // prend la dimension de la photo
        testEau.setBounds(835, 300, size_testEau.width, size_testEau.height); // position d'origine

        panelAqua.add(testEau); // ajout du testeur d'eau au frame
        testEau.setVisible(true);


        tabbedPane.add("Aquarium", panelAqua);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du 2em tab

        PanelShop panelShop = new PanelShop();
        tabbedPane.add("Magasin", panelShop);

        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du 3em tab

        PanelInfo panelInfo = new PanelInfo();

        tabbedPane.add("À propos", panelInfo);

        // ajout des tabs au frame
        add(tabbedPane);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

}
