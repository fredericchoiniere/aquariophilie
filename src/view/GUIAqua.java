package view;

//import model.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import model.outils.Pipette;
import view.tabs.*;

import java.util.*;

public class GUIAqua extends JFrame implements ActionListener {

    JPanel panelPrincipal;
    JButton pousser, rapetisser;
    JLabel pipette;
    short stade, iteration = 0;
    String nom;

    public GUIAqua() {

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
        // TODO Auto-generated method stub

    }

}
