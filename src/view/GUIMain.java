package view;

//import model.*;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.MouseInputListener;

import model.chimie.Eau;
import model.chimie.TestStoech;
import model.environnement.Temps;
import model.item.outils.Pipette;
import model.poissons.*;
import view.tabs.*;

public class GUIMain extends JFrame implements ActionListener, MouseListener{

    // appel des attributs de la classe GUIMain

    JPanel panelPrincipal;
    JButton pousser, rapetisser;
    Pipette pipette;
    JLabel testEau;
    short stade, iteration = 0;
    String nom;
    PoissonRouge poisson_rouge;
    PanelTest panelTest;
    JLabel aquarium_kit_ouvert, aquarium_kit_fermer;
    
    Temps temps;
    public static float jours = (float) 27;

    Eau eau;
    Thread threadEau;
    

    public GUIMain() { // création du constructeur GuiMain

        addMouseListener(this);

        temps = new Temps();
        
        eau = new Eau();
        threadEau = new Thread(eau);

        // ----------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du premier tab
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addMouseListener(this);

        // création du layered pane
        JLayeredPane lpane = new JLayeredPane();
        lpane.setLayout(null);

        // création du panelaqua
        PanelAqua panelAqua = new PanelAqua(); // appel de la méthode paint de Home
        panelAqua.setLayout(null);
        panelAqua.setVisible(true);
        panelAqua.addMouseListener(this);

        
        // création des icones
        //----------------------------------------

        // creation de la pipette pour le drag and drop
        Pipette pipette = new Pipette();
        pipette.setIcon(new ImageIcon("res/outils/pipette.png"));
        Dimension size_pipette = pipette.getPreferredSize(); // prend la dimension de la photo
        pipette.setBounds(860, 200, size_pipette.width, size_pipette.height); // position d'origine
        pipette.setVisible(true);
        panelAqua.add(pipette); // ajout de la pipette au frame

        /*// creation du testeur d'eau pour le drag and drop
        TestEau testEau = new TestEau();
        testEau.setIcon(new ImageIcon("res/outils/testEau.png"));
        Dimension size_testEau = testEau.getPreferredSize(); // prend la dimension de la photo
        testEau.setBounds(835, 300, size_testEau.width, size_testEau.height); // position d'origine
        panelAqua.add(testEau); // ajout du testeur d'eau au frame
        testEau.setVisible(true);
        */

        // ajout des éléments d'aquariophilie
        //--------------------------------------

        // ajout du panel de l'interface du kit
        panelTest = new PanelTest();
        panelTest.setBounds(150, 100, 700, 500);
        panelTest.setVisible(false); // visible false pour qu'il apparaisse avec le bouton
        lpane.add(panelTest);

        // ajout de l'icone de notre kit ouvert
        aquarium_kit_ouvert = new JLabel();
        aquarium_kit_ouvert.setIcon(new ImageIcon("res/outils/aquarium_kit/aquarium_kit_open.png"));
        Dimension size_wallgear_icon1 = aquarium_kit_ouvert.getPreferredSize(); // prend la dimension de la photo
        aquarium_kit_ouvert.setBounds(850, 60, size_wallgear_icon1.width, size_wallgear_icon1.height);
        panelAqua.add(aquarium_kit_ouvert);
        aquarium_kit_ouvert.addMouseListener(this);
        aquarium_kit_ouvert.setVisible(false);

        // ajout de l'icone de notre kit fermer
        aquarium_kit_fermer = new JLabel();
        aquarium_kit_fermer.setIcon(new ImageIcon("res/outils/aquarium_kit/aquarium_kit_closed.png"));
        Dimension size_wallgear_icon2 = aquarium_kit_fermer.getPreferredSize(); // prend la dimension de la photo
        aquarium_kit_fermer.setBounds(850, 60, size_wallgear_icon2.width, size_wallgear_icon2.height);
        aquarium_kit_fermer.setVisible(true);
        aquarium_kit_fermer.addMouseListener(this);
        panelAqua.add(aquarium_kit_fermer);
    

        // ajout de panel Aqua au layered pane
        Dimension size_panel_aqua = panelAqua.getPreferredSize(); // prend la dimension de la photo
        panelAqua.setBounds(0, 0, size_panel_aqua.width, size_panel_aqua.height);
        panelAqua.setVisible(true);
        lpane.add(panelAqua);

        
        // ajout du layeredpane au tabbedane
        tabbedPane.add("Aquarium", lpane);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du 2em tab

        // création du panel Magasin
        PanelShop panelShop = new PanelShop();

        // ajout du panel Magasin au tabbed pane
        tabbedPane.add("Magasin", panelShop);

        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du 3em tab

        // création du panel Magasin
        PanelInfo panelInfo = new PanelInfo();
        tabbedPane.add("À propos", panelInfo);

        // ajout du panel Info au tabbed pane
        add(tabbedPane);
      

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // action listener de GUIMain

        // action listener sur les labels qui font apparaitre les interfaces
        aquarium_kit_ouvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // rends les bons label visible ou invisible
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
            }
        });

        aquarium_kit_fermer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // rends les bons label visible ou invisible
                aquarium_kit_fermer.setVisible(false);
                aquarium_kit_ouvert.setVisible(true);
                panelTest.setVisible(true);
                panelTest.grabFocus();
            }
        });
        

    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        /* if(panelTest.isFocused() == false){
            aquarium_kit_fermer.setVisible(true);
            aquarium_kit_ouvert.setVisible(false);
        } */
        
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

 

    

}