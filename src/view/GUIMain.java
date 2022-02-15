package view;

//import model.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


import model.outils.Pipette;
import model.poissons.*;
import view.tabs.*;

import java.util.*;

public class GUIMain extends JFrame implements ActionListener, Runnable {

    JPanel panelPrincipal;
    JButton pousser, rapetisser;
    JLabel pipette;
    short stade, iteration = 0;
    String nom;
    PoissonRouge poisson_rouge ;
    Thread tAnim = new Thread(this);

    public GUIMain() {

        // ----------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du premier tab
        JTabbedPane tabbedPane = new JTabbedPane();


        PanelAqua panelAqua = new PanelAqua(); // appel de la méthode paint de Home
        panelAqua.setLayout(null);
        panelAqua.setVisible(true);



        //-----------------------------------------------------------------------------------------------------------------------------------
        //création des icones


        // creation de la pipette pour le drag and drop
        Pipette pipette = new Pipette();
        pipette.setIcon(new ImageIcon("aquariophilie/res/outils/pipette.png"));

        Dimension size_pipette = pipette.getPreferredSize(); // prend la dimension de la photo
        pipette.setBounds(860, 200, size_pipette.width, size_pipette.height); // position d'origine

        pipette.setVisible(true);
        panelAqua.add(pipette); // ajout de la pipette au frame


        // ajout des éléments d'aquariophilie

        //interface
        JLabel aquarium_kit_interface = new JLabel();
        aquarium_kit_interface.setIcon(new ImageIcon("aquariophilie/res/outils/aquarium_kit/allo.png"));

        Dimension size_wallgear = aquarium_kit_interface.getPreferredSize(); // prend la dimension de la photo
        aquarium_kit_interface.setBounds(300, 100, size_wallgear.width, size_wallgear.height);

        panelAqua.add(aquarium_kit_interface);
        aquarium_kit_interface.setVisible(false);


        // icone du kit ouvert et fermer
        JLabel aquarium_kit_ouvert = new JLabel();
        aquarium_kit_ouvert.setIcon(new ImageIcon("aquariophilie/res/outils/aquarium_kit/aquarium_kit_open.png"));

        Dimension size_wallgear_icon1 = aquarium_kit_ouvert.getPreferredSize(); // prend la dimension de la photo
        aquarium_kit_ouvert.setBounds(850, 60, size_wallgear_icon1.width, size_wallgear_icon1.height);

        panelAqua.add(aquarium_kit_ouvert);
        aquarium_kit_ouvert.setVisible(false);

        JLabel aquarium_kit_fermer = new JLabel();
        aquarium_kit_fermer.setIcon(new ImageIcon("aquariophilie/res/outils/aquarium_kit/aquarium_kit_closed.png"));

        Dimension size_wallgear_icon2 = aquarium_kit_fermer.getPreferredSize(); // prend la dimension de la photo
        aquarium_kit_fermer.setBounds(850, 60, size_wallgear_icon2.width, size_wallgear_icon2.height);

        panelAqua.add(aquarium_kit_fermer);
        aquarium_kit_fermer.setVisible(true);


        //-------------------------------------------------------------------------------------------------------------------------------------------------------------------
        //ajout des poissons

       /*  poisson_rouge = new PoissonRouge();

        Dimension size_poisson_rouge = poisson_rouge.getPreferredSize(); // prend la dimension de la photo
        poisson_rouge.setBounds(200, 200, size_poisson_rouge.width, size_poisson_rouge.height);

        panelAqua.add(poisson_rouge);
        poisson_rouge.setVisible(true);

        tAnim.start(); */
        
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



        //-------------------------------------------------------------------------------------------------------------
        //action listener de GUIMain

        // action listener sur les labels qui font apparaitre les interfaces de coté 
        aquarium_kit_ouvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                aquarium_kit_interface.setVisible(false);
                pipette.setVisible(true);
            }
        });

        aquarium_kit_fermer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_fermer.setVisible(false);
                aquarium_kit_ouvert.setVisible(true);
                aquarium_kit_interface.setVisible(true);
                pipette.setVisible(false);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }


    // Gestion des threads pour les poissons

    @Override
    public void run() {
        while (true) {
            
            if (poisson_rouge.x > 500) {
                poisson_rouge.setXVelocity(-10);
            }
            if (poisson_rouge.x <= 0) {
                poisson_rouge.setXVelocity(10);
            }
            if (poisson_rouge.y > 440) {
                poisson_rouge.setYVelocity(-10);
            }
            if (poisson_rouge.y <= 0) {
                poisson_rouge.setYVelocity(10);
            }
            poisson_rouge.deplacer();
        }
    }

    

    
}