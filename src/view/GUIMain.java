//Jérémie Caron, Frédéric Choinière     itération 1
//Classe d'affichage principale


package view;

// import pour le bon fonctionnement de la classe

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.LineBorder;

import model.chimie.Eau;
import model.environnement.Temps;
import model.item.outils.Pipette;
import model.jeu.Aquarium;
import model.jeu.Inventaire;
import model.poissons.*;
import view.tabs.*;

public class GUIMain extends JFrame implements Runnable {

    // appel des attributs de la classe GUIMain
    PanelAqua panelAqua;
    PanelTest panelTest;
    JTabbedPane tabbedPane;
    JButton pousser, rapetisser;
    JLabel testEau, empty, aquarium_kit_ouvert, aquarium_kit_fermer, pipette, eau_label, inventaire_ouvert,
            inventaire_fermer, inventaire_bg;
    JLabel label_argent;
    String nom, empla1, empla2, empla3, empla4, empla5, empla6, poi1, poi2, poi3, poi4, poi5, poi6;
    Rectangle rectTest, rectEau, rectEmp1, rectEmp2, rectEmp3, rectAqua1, rectAqua2, rectAqua3, rectAqua4, rectAqua5,
            rectAqua6;

    // creation des objets
    Temps temps;
    public static Eau eau;
    Poisson1 poisson1;
    Poisson2 poisson2;
    Pipette pipette2;
    ImageIcon tetra_curseur;
    Inventaire inventaire;
    Aquarium aquarium;

    // les threads
    // Thread tpoisson1 = new Thread(); //TODO: à refaire à l'itération 2
    // Thread tpoisson2 = new Thread();
    Thread GUIMainThread = new Thread(this);
    Thread threadEau;

    // les attributs
    short stade, iteration = 0;
    int vel_x = 2;
    int vel_y = 2;
    public static byte cycle = 1;
    public int argent = 0;
    public static float jours = (float) 0; // TIMER GLOBAL

    public GUIMain() { // création du constructeur GUIMain

        // création du curseur custom
        tetra_curseur = new ImageIcon("res/icone_souris/tetra_cursor.png");

        // spécificité du constructeur
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                tetra_curseur.getImage(),
                new Point(0, 0), "curseur tétra"));

        // attributs du constructeur
        temps = new Temps();
        eau = new Eau();
        threadEau = new Thread(eau);

        // creation du main tab
        tabbedPane = new JTabbedPane();

        // creation du premier tab
        // ----------------------------------------------------------------------------------------------------------------------------------------------------

        // création du panelaqua
        panelAqua = new PanelAqua();
        panelAqua.setLayout(null);
        panelAqua.setVisible(true);

        // ajout du panel de l'interface du kit
        panelTest = new PanelTest();
        panelTest.setBounds(150, 100, 700, 500);
        panelTest.setVisible(false);
        panelAqua.add(panelTest);

        // ajouts des labels du premier tab
        // -----------------------------------

        // ajout de l'objet de la classe pipette
        pipette2 = new Pipette();

        // ajout du label pour la pipette
        pipette = new JLabel();
        pipette2.changerEtatLabel(pipette);
        Dimension size_pipette = pipette.getPreferredSize(); // prend la dimension de la photo
        pipette.setBounds(850, 200, size_pipette.width, size_pipette.height);
        pipette.setVisible(true);
        panelAqua.add(pipette);

        // ajout de l'icone de notre kit ouvert
        aquarium_kit_ouvert = new JLabel();
        aquarium_kit_ouvert.setIcon(new ImageIcon("res/outils/aquarium_kit/aquarium_kit_open.png"));
        Dimension size_wallgear_icon1 = aquarium_kit_ouvert.getPreferredSize(); // prend la dimension de la photo
        aquarium_kit_ouvert.setBounds(850, 60, size_wallgear_icon1.width, size_wallgear_icon1.height);
        panelAqua.add(aquarium_kit_ouvert);
        aquarium_kit_ouvert.setVisible(false);

        // ajout de l'icone de notre kit fermer
        aquarium_kit_fermer = new JLabel();
        aquarium_kit_fermer.setIcon(new ImageIcon("res/outils/aquarium_kit/aquarium_kit_closed.png"));
        Dimension size_wallgear_icon2 = aquarium_kit_fermer.getPreferredSize(); // prend la dimension de la photo
        aquarium_kit_fermer.setBounds(850, 60, size_wallgear_icon2.width, size_wallgear_icon2.height);
        aquarium_kit_fermer.setVisible(true);
        panelAqua.add(aquarium_kit_fermer);

        // ajout du label pour icones de l'inventaire
        inventaire_ouvert = new JLabel();
        inventaire_ouvert.setIcon(new ImageIcon("res/background/inventaire_ouvert.png"));
        Dimension size_icone_inv = inventaire_ouvert.getPreferredSize(); // prend la dimension de la photo
        inventaire_ouvert.setBounds(50, 60, size_icone_inv.width, size_icone_inv.height);
        inventaire_ouvert.setVisible(false);
        panelAqua.add(inventaire_ouvert);

        inventaire_fermer = new JLabel();
        inventaire_fermer.setIcon(new ImageIcon("res/background/inventaire_fermer.png"));
        inventaire_fermer.setBounds(50, 60, size_icone_inv.width, size_icone_inv.height);
        inventaire_fermer.setVisible(true);
        panelAqua.add(inventaire_fermer);

        // ajout de l'inventaire au panel aqua
        inventaire_bg = new JLabel();
        inventaire_bg.setIcon(new ImageIcon("res/background/inventaire.png"));
        Dimension size_inventaire = inventaire_bg.getPreferredSize();
        inventaire_bg.setBounds(5, 140, size_inventaire.width, size_inventaire.height);
        inventaire_bg.setVisible(false);
        panelAqua.add(inventaire_bg);
        inventaire = new Inventaire(inventaire_bg);
        inventaire.setVisible(false);

        // ajout du label vide pour les actions listener
        empty = new JLabel("");
        empty.setBounds(0, 0, 1000, 700);
        empty.setVisible(false);
        panelAqua.add(empty);

        // label pour l'argent que l'on a

        label_argent = new JLabel();
        label_argent.setBounds(30, 10, 100, 50);
        label_argent.setFont(new Font("Verdana", Font.BOLD, 20));
        label_argent.setText("$$");
        label_argent.setVisible(true);
        panelAqua.add(label_argent);

        // ajout de panel Aqua au layered pane
        Dimension size_panel_aqua = panelAqua.getPreferredSize(); // prend la dimension de la photo
        panelAqua.setBounds(0, 0, size_panel_aqua.width, size_panel_aqua.height);
        panelAqua.setVisible(true);
        // lpane.add(panelAqua);

        // ajout des zones pour les action listener
        rectEau = new Rectangle(330, 310, 344, 192);
        rectTest = new Rectangle(panelTest.getBounds());
        rectEmp1 = new Rectangle(358, 408, 80, 80);
        rectEmp2 = new Rectangle(464, 408, 80, 80);
        rectEmp3 = new Rectangle(572, 408, 80, 80);
        rectAqua1 = new Rectangle(365, 321, 70, 70);
        rectAqua2 = new Rectangle(474, 321, 70, 70);
        rectAqua3 = new Rectangle(584, 321, 70, 70);
        rectAqua4 = new Rectangle(365, 417, 70, 70);
        rectAqua5 = new Rectangle(474, 417, 70, 70);
        rectAqua6 = new Rectangle(584, 417, 70, 70);

        // ajout des poissons dans l'aquarium
        poisson2 = new Poisson2();
        poisson2.setBounds(340, 324, 322, 156);
        // tpoisson2.start();
        panelAqua.add(poisson2);

        poisson1 = new Poisson1();
        poisson1.setBounds(340, 324, 322, 156);
        // tpoisson1.start();
        panelAqua.add(poisson1);

        aquarium = new Aquarium(panelAqua);

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
        // action listener de GUIMain TODO: placer dans les mouselistener en bas

        // action listener sur les labels qui font apparaitre les interfaces
        aquarium_kit_ouvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                empty.setVisible(false);
                pipette.setVisible(true);
                inventaire_fermer.setVisible(true);
                label_argent.setVisible(true);
            }
        });

        // action listener sur les labels qui font apparaitre les interfaces
        aquarium_kit_fermer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // rends les bons label visible ou invisible
                aquarium_kit_fermer.setVisible(false);
                aquarium_kit_ouvert.setVisible(true);
                empty.setVisible(true);
                panelTest.setVisible(true);
                pipette.setVisible(false);
                inventaire_ouvert.setVisible(false);
                inventaire_fermer.setVisible(false);
                inventaire_bg.setVisible(false);
                label_argent.setVisible(false);
            }
        });

        // action listener pour la pipette et les changements d'états du curseur et du
        // label
        pipette.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                pipette2.changerEtatPanel(panelAqua);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                if (panelAqua.getMousePosition().getX() >= rectEau.getMinX()
                        && panelAqua.getMousePosition().getX() <= rectEau.getMaxX()
                        && panelAqua.getMousePosition().getY() >= rectEau.getMinY()
                        && panelAqua.getMousePosition().getY() <= rectEau.getMaxY()) {
                    pipette.setIcon(new ImageIcon("res/outils/pipette_pleine.png"));
                    pipette2.est_remplie = true;
                    pipette2.changerEtatLabel(pipette);
                    pipette2.changerEtatPanel(panelTest);
                }
            }
        });

        // actionlistener du label empty pour fermer le paneltest
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
                    inventaire_fermer.setVisible(true);
                    label_argent.setVisible(true);
                }
            }
        });

        // action listener sur le label icone pour faire disparaitre ou apparaitre
        // l'inventaire
        inventaire_ouvert.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                inventaire_ouvert.setVisible(false);
                inventaire_fermer.setVisible(true);
                inventaire_bg.setVisible(false);
                inventaire.setVisible(false);
            }
        });

        // action listener sur le label icone pour faire disparaitre ou apparaitre
        // l'inventaire
        inventaire_fermer.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                inventaire_ouvert.setVisible(true);
                inventaire_fermer.setVisible(false);
                inventaire_bg.setVisible(true);
                inventaire.setVisible(true);
            }
        });

        // actionlistener sur les items de l'inventaire
        // ---------------------------------------------------------------------------------------------------------------------------------------------------

        // pour les deco
        empla1 = "decoration";
        empla2 = "poisson";
        empla3 = "";
        empla4 = "";
        empla5 = "decoration";
        empla6 = "";

        // pour les poissons
        poi1 = "rouge";
        poi2 = "betta";
        poi3 = "";
        poi4 = "";
        poi5 = "";
        poi6 = "";

        // inventaire 1
        inventaire.emp1.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla1 == "decoration") {
                    setCursor(inventaire.emp1);
                    visibleBordersDeco();
                }
                if (empla1 == "poisson") {
                    setCursor(inventaire.emp1);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla1 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    checkRectanglesDeco(rectEmp1, aquarium.emp1, inventaire.emp1.getIcon());
                    checkRectanglesDeco(rectEmp2, aquarium.emp2, inventaire.emp1.getIcon());
                    checkRectanglesDeco(rectEmp3, aquarium.emp3, inventaire.emp1.getIcon());
                }
                if (empla1 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    checkRectanglesPoi(rectAqua1, aquarium.aqua1, inventaire.emp1.getIcon());
                    checkRectanglesPoi(rectAqua2, aquarium.aqua2, inventaire.emp1.getIcon());
                    checkRectanglesPoi(rectAqua3, aquarium.aqua3, inventaire.emp1.getIcon());
                    checkRectanglesPoi(rectAqua4, aquarium.aqua4, inventaire.emp1.getIcon());
                    checkRectanglesPoi(rectAqua5, aquarium.aqua5, inventaire.emp1.getIcon());
                    checkRectanglesPoi(rectAqua6, aquarium.aqua6, inventaire.emp1.getIcon());

                }
            }
        });

        // inventaire 2
        inventaire.emp2.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla2 == "decoration") {
                    setCursor(inventaire.emp2);
                    visibleBordersDeco();
                }
                if (empla2 == "poisson") {
                    setCursor(inventaire.emp2);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla2 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    checkRectanglesDeco(rectEmp1, aquarium.emp1, inventaire.emp2.getIcon());
                    checkRectanglesDeco(rectEmp2, aquarium.emp2, inventaire.emp2.getIcon());
                    checkRectanglesDeco(rectEmp3, aquarium.emp3, inventaire.emp2.getIcon());
                }
                if (empla2 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    checkRectanglesPoi(rectAqua1, aquarium.aqua1, inventaire.emp2.getIcon());
                    checkRectanglesPoi(rectAqua2, aquarium.aqua2, inventaire.emp2.getIcon());
                    checkRectanglesPoi(rectAqua3, aquarium.aqua3, inventaire.emp2.getIcon());
                    checkRectanglesPoi(rectAqua4, aquarium.aqua4, inventaire.emp2.getIcon());
                    checkRectanglesPoi(rectAqua5, aquarium.aqua5, inventaire.emp2.getIcon());
                    checkRectanglesPoi(rectAqua6, aquarium.aqua6, inventaire.emp2.getIcon());
                }
            }
        });

        // inventaire 3
        inventaire.emp3.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(inventaire.emp3);
                visibleBordersDeco();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                invisibleBordersDeco();
                checkRectanglesDeco(rectEmp1, aquarium.emp1, inventaire.emp3.getIcon());
                checkRectanglesDeco(rectEmp2, aquarium.emp2, inventaire.emp3.getIcon());
                checkRectanglesDeco(rectEmp3, aquarium.emp3, inventaire.emp3.getIcon());
            }
        });

        // inventaire 4
        inventaire.emp4.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(inventaire.emp4);
                visibleBordersDeco();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                invisibleBordersDeco();
                checkRectanglesDeco(rectEmp1, aquarium.emp1, inventaire.emp4.getIcon());
                checkRectanglesDeco(rectEmp2, aquarium.emp2, inventaire.emp4.getIcon());
                checkRectanglesDeco(rectEmp3, aquarium.emp3, inventaire.emp4.getIcon());
            }
        });

        // inventaire 5
        inventaire.emp5.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla5 == "decoration") {
                    setCursor(inventaire.emp5);
                    visibleBordersDeco();
                }
                if (empla5 == "poisson") {
                    setCursor(inventaire.emp5);
                    visibleBordersPoi();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla5 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    checkRectanglesDeco(rectEmp1, aquarium.emp1, inventaire.emp5.getIcon());
                    checkRectanglesDeco(rectEmp2, aquarium.emp2, inventaire.emp5.getIcon());
                    checkRectanglesDeco(rectEmp3, aquarium.emp3, inventaire.emp5.getIcon());
                }
                if (empla5 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                }
            }

        });

        // inventaire 6
        inventaire.emp6.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                setCursor(inventaire.emp6);
                visibleBordersDeco();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                invisibleBordersDeco();
                checkRectanglesDeco(rectEmp1, aquarium.emp1, inventaire.emp6.getIcon());
                checkRectanglesDeco(rectEmp2, aquarium.emp2, inventaire.emp6.getIcon());
                checkRectanglesDeco(rectEmp3, aquarium.emp3, inventaire.emp6.getIcon());
            }
        });

        GUIMainThread.start();

    } // fin du constructeur GUIMain

    // méthode de GUIMain
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * méthode pour set les borders visible
     */
    public void visibleBordersDeco() {
        aquarium.emp1.setBorder(new LineBorder(Color.yellow, 2));
        aquarium.emp2.setBorder(new LineBorder(Color.yellow, 2));
        aquarium.emp3.setBorder(new LineBorder(Color.yellow, 2));
    }

    /**
     * méthode pour set les borders visible
     */
    public void visibleBordersPoi() {
        aquarium.aqua1.setBorder(new LineBorder(Color.black, 2));
        aquarium.aqua2.setBorder(new LineBorder(Color.blue, 2));
        aquarium.aqua3.setBorder(new LineBorder(Color.blue, 2));
        aquarium.aqua4.setBorder(new LineBorder(Color.blue, 2));
        aquarium.aqua5.setBorder(new LineBorder(Color.blue, 2));
        aquarium.aqua6.setBorder(new LineBorder(Color.blue, 2));
    }

    /**
     * méthode pour set les borders invisible
     */
    public void invisibleBordersDeco() {
        aquarium.emp1.setBorder(null);
        aquarium.emp2.setBorder(null);
        aquarium.emp3.setBorder(null);
    }

    /**
     * méthode pour set les borders invisible
     */
    public void invisibleBordersPoi() {
        aquarium.aqua1.setBorder(null);
        aquarium.aqua2.setBorder(null);
        aquarium.aqua3.setBorder(null);
        aquarium.aqua4.setBorder(null);
        aquarium.aqua5.setBorder(null);
        aquarium.aqua6.setBorder(null);
    }

    /**
     * méthode pour set curseur de base
     */
    public void basicCursor() {
        tetra_curseur = new ImageIcon("res/icone_souris/tetra_cursor.png");
        panelAqua.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                tetra_curseur.getImage(),
                new Point(0, 0), "custom cursor"));
    }

    /**
     * @param label
     * Créé et applique un curseur custom
     */
    public void setCursor(JLabel label) {
        ImageIcon curseur = (ImageIcon) label.getIcon();
        panelAqua.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                curseur.getImage(),
                new Point(0, 0), "curseur tétra"));
    }

    /**
     * @param rectangle
     * @param label
     * @param icone
     *                  Vérifie la position de la souris en fonction du rectangle
     *                  fourni
     */
    public void checkRectanglesDeco(Rectangle rectangle, JLabel label, Icon icone) {
        if (panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                && panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                && panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                && panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {
            label.setIcon(icone);
        }
    }

    /**
     * @param rectangle
     * @param label
     * @param icone
     *                  regarder si la souris est dans le rectangle lors du
     *                  lachement de la touche
     */
    public void checkRectanglesPoi(Rectangle rectangle, JLabel label, Icon icone) {
        if (panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                && panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                && panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                && panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {
            label.setIcon(icone);
        }
    }

    /**
     * set les labels des poissons visible
     */
    public void aquaVisibleTrue() {
        aquarium.aqua1.setVisible(true);
        aquarium.aqua2.setVisible(true);
        aquarium.aqua3.setVisible(true);
        aquarium.aqua4.setVisible(true);
        aquarium.aqua5.setVisible(true);
        aquarium.aqua6.setVisible(true);
    }

    /**
     * set les labels des poissons invisible
     */
    public void aquaVisibleFalse() {
        aquarium.aqua1.setVisible(false);
        aquarium.aqua2.setVisible(false);
        aquarium.aqua3.setVisible(false);
        aquarium.aqua4.setVisible(false);
        aquarium.aqua5.setVisible(false);
        aquarium.aqua6.setVisible(false);
    }

    // création des threads pour les poissons dans l'aquarium
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * thread du poisson rouge
     */
    @Override
    public void run() { // TODO: overhaul nécessaire
        while (true) {

            if (poisson1.swim) {
                poisson1.image = "droite";
                poisson1.nager();
            } else if (!poisson1.swim) {
                poisson1.nager();
                poisson1.image = "empty";
            }

            if (poisson2.swim) {
                poisson2.image = "droite";
                poisson2.nager();
            } else if (!poisson2.swim) {
                poisson2.nager();
                poisson2.image = "empty";
            }

        }
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------

}

// Слава Україні!