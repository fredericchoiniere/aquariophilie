package view;

//import model.*;

import java.awt.*;
import java.awt.event.*;
import java.nio.channels.Pipe;

import javax.swing.*;

import model.chimie.Eau;

import model.environnement.Temps;
import model.item.outils.Pipette;
import model.poissons.*;
import view.tabs.*;

public class GUIMain extends JFrame implements ActionListener, MouseListener, Runnable {

    // appel des attributs de la classe GUIMain

    JPanel panelPrincipal;
    JButton pousser, rapetisser;
    JLabel testEau, empty, aquarium_kit_ouvert, aquarium_kit_fermer, pipette, eau_label;
    String nom;
    PanelTest panelTest;
    Rectangle rectTest, rectEau;
    Temps temps;
    Eau eau;
    Thread threadEau;
    Poisson2 poisson2;
    Thread tAnim = new Thread(this);
    Pipette pipette2;
    ImageIcon tetra_curseur;

    short stade, iteration = 0;
    int vel_x = 2;
    int vel_y = 2;
    public static float jours = (float) 27;

    public GUIMain() { // création du constructeur GuiMain

        addMouseListener(this);

        tetra_curseur = new ImageIcon("res/icone_souris/tetra_cursor.png");

        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                tetra_curseur.getImage(),
                new Point(0, 0), "custom cursor"));

        temps = new Temps();

        eau = new Eau();
        threadEau = new Thread(eau);

        // ----------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du premier tab
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addMouseListener(this);

        // création du layered pane
        // JLayeredPane lpane = new JLayeredPane();
        // lpane.setLayout(null);

        // création du panelaqua
        PanelAqua panelAqua = new PanelAqua(); // appel de la méthode paint de Home
        panelAqua.setLayout(null);
        panelAqua.setVisible(true);
        panelAqua.addMouseListener(this);

        // création des icones
        // ----------------------------------------

        // creation de la pipette pour le drag and drop
        /*
         * Pipette pipette = new Pipette();
         * pipette.setIcon(new ImageIcon("res/outils/pipette.png"));
         * Dimension size_pipette = pipette.getPreferredSize(); // prend la dimension de
         * la photo
         * pipette.setBounds(860, 200, size_pipette.width, size_pipette.height); //
         * position d'origine
         * pipette.setVisible(true);
         * panelAqua.add(pipette);
         */ // ajout de la pipette au frame

        // ajout des éléments d'aquariophilie
        // --------------------------------------

        // ajout du panel de l'interface du kit
        panelTest = new PanelTest();
        panelTest.setBounds(150, 100, 700, 500);
        rectTest = new Rectangle(panelTest.getBounds());
        panelTest.setVisible(false); // visible false pour qu'il apparaisse avec le bouton
        panelAqua.add(panelTest);

        // ajout du label pour la pipette

        pipette = new JLabel();
        pipette2 = new Pipette();
        // pipette.setIcon(new ImageIcon("res/outils/pipette_vide.png"));
        pipette2.changerEtatLabel(pipette);
        Dimension size_pipette = pipette.getPreferredSize(); // prend la dimension de la photo
        pipette.setBounds(850, 200, size_pipette.width, size_pipette.height);
        pipette.setVisible(true);
        pipette.addMouseListener(this);
        panelAqua.add(pipette);

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

        // labels

        empty = new JLabel("");
        empty.setBounds(0, 0, 1000, 700);
        empty.addMouseListener(this);
        empty.setVisible(false);
        panelAqua.add(empty);

        // ajout de panel Aqua au layered pane
        Dimension size_panel_aqua = panelAqua.getPreferredSize(); // prend la dimension de la photo
        panelAqua.setBounds(0, 0, size_panel_aqua.width, size_panel_aqua.height);
        panelAqua.setVisible(true);
        // lpane.add(panelAqua);

        rectEau = new Rectangle(330, 310, 344, 192);

        poisson2 = new Poisson2();
        poisson2.setBounds(340, 324, 322, 156);
        tAnim.start();
        panelAqua.add(poisson2);

        // ajout du layeredpane au tabbedane
        tabbedPane.add("Aquarium", panelAqua);

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
                empty.setVisible(false);
                pipette.setVisible(true);
            }
        });

        aquarium_kit_fermer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                // rends les bons label visible ou invisible
                aquarium_kit_fermer.setVisible(false);
                aquarium_kit_ouvert.setVisible(true);
                empty.setVisible(true);
                panelTest.setVisible(true);

                pipette.setVisible(false);
            }
        });

        pipette.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                // System.out.println("pressed");

                /*
                 * setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                 * new ImageIcon("res/icone_souris/pipe_vide.png").getImage(),
                 * new Point(0, 0), "curseur vide"));
                 */

                pipette2.changerEtatPanel(panelAqua);

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                // System.out.println("released");

                panelAqua.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        tetra_curseur.getImage(),
                        new Point(0, 0), "custom cursor"));

                if (panelAqua.getMousePosition().getX() >= rectEau.getMinX()
                        && panelAqua.getMousePosition().getX() <= rectEau.getMaxX()
                        && panelAqua.getMousePosition().getY() >= rectEau.getMinY()
                        && panelAqua.getMousePosition().getY() <= rectEau.getMaxY()) {
                    pipette.setIcon(new ImageIcon("res/outils/pipette_pleine.png"));

                    pipette2.est_remplie = true;
                    pipette2.changerEtatLabel(pipette);
                    pipette2.changerEtatPanel(panelTest);
                } // TODO

            }
        });

        empty.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (panelAqua.getMousePosition().getX() <= rectTest.getMinX()
                        || panelAqua.getMousePosition().getX() >= rectTest.getMaxX()
                        || panelAqua.getMousePosition().getY() <= rectTest.getMinY()
                        || panelAqua.getMousePosition().getY() >= rectTest.getMaxY()) {
                    panelTest.setVisible(false);
                    empty.setVisible(false);
                    pipette.setVisible(true);
                    aquarium_kit_ouvert.setVisible(false);
                    aquarium_kit_fermer.setVisible(true);
                }

            }
        });

    }

    @Override
    public void run() {
        while (true) {
            if (poisson2.x > 286) {
                poisson2.setXVelocity(-poisson2.vel_x);
                poisson2.image = "gauche";
            }
            if (poisson2.x < 4) {
                poisson2.setXVelocity(1);
                poisson2.image = "droite";
            }
            if (poisson2.y > 120) {
                poisson2.setYVelocity(-poisson2.vel_y);
            }
            if (poisson2.y < 4) {
                poisson2.setYVelocity(1); // ne marchait pas avec vel_y, je ne sais pas pourquoi
            }
            poisson2.deplacer();
        }
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

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

    @Override
    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub

    }

}
