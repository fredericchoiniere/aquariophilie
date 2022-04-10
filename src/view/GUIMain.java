
//Jérémie Caron, Frédéric Choinière     itération 1
//Classe d'affichage principale

package view;

// import pour le bon fonctionnement de la classe

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

import model.MethodeGUIMain;
import model.chimie.CycleAzote;
import model.chimie.Eau;
import model.environnement.Temps;
import model.item.outils.Ciseau;
import model.item.outils.Filet;
import model.item.outils.Pipette;
import model.item.outils.Shop;
import model.jeu.Aquarium;
import model.jeu.Argent;
import model.jeu.Inventaire;

import model.plantes.Plante;

import model.poissons.*;
import view.tabs.*;

public class GUIMain extends JFrame {

    // appel des attributs de la classe GUIMain
    public static PanelAqua panelAqua;
    public static PanelTest panelTest;
    JTabbedPane tabbedPane;
    JButton passer_journée;
    JLabel testEau, empty, aquarium_kit_ouvert, aquarium_kit_fermer, eau_label, inventaire_ouvert,
            inventaire_fermer, inventaire_bg, filet_label, pause_label, reprendre_label;
    public static JLabel shop_label;
    JLabel hamis;
    JLabel ciseau_label;
    JLabel label_argent;
    public static JLabel lblPipette = new JLabel();
    // String nom, empla1, empla2, empla3, empla4, empla5, empla6, poi1, poi2, poi3,
    // poi4, poi5, poi6;
    public static JLabel label_argent_aqua = new JLabel("");
    public static JLabel label_argent_shop = new JLabel("");
    public static String nom, empla1, empla2, empla3, empla4, empla5, empla6, poi1, poi2, poi3, poi4, poi5, poi6,
            actionEnCours, pla1, pla2, pla3, pla4, pla5, pla6, aqua1, aqua2, aqua3, aqua4, aqua5, aqua6, emplacement,
            aquaPla1, aquaPla2, aquaPla3, aquaPla4, aquaPla5, aquaPla6;
    Rectangle rectTest, rectEau, rectEmp1, rectEmp2, rectEmp3, rectAqua1, rectAqua2, rectAqua3, rectAqua4, rectAqua5,
            rectAqua6, rectShop;

    // creation des objets
    Temps temps;
    public static Eau eau;
    public static Pipette pipette;
    public static Poisson poisson_default = new Poisson();
    public static Plante plante_default = new Plante();
    public static PoissonRouge poisson_rouge;
    public static PoissonBetta poisson_betta;
    public static PoissonTetra poisson_tetra;
    Pipette pipette2;
    Filet filet;
    Ciseau ciseau;
    Shop shop;
    ImageIcon tetra_curseur;
    ImageIcon rajoutIcon = new ImageIcon();
    ImageIcon iconeAppli = new ImageIcon("res/background/icone_aquariophilie.png");
    Inventaire inventaire;
    Aquarium aquarium;
    public static CycleAzote cycleInitial;

    public static ArrayList<Poisson> listePoissonsAqua = new ArrayList<Poisson>(6);
    public static ArrayList<Poisson> listePoissonsInv = new ArrayList<Poisson>(6);
    public static ArrayList<Plante> listePlantesInv = new ArrayList<Plante>(6);
    public static ArrayList<Plante> listePlantesAqua = new ArrayList<Plante>(3);

    // les threads
    public static Thread tpoisson_rouge;
    public static Thread tpoisson_betta;
    public static Thread tpoisson_tetra;
    // Thread GUIMainThread = new Thread(this);
    Thread threadEau;
    Thread tCycleInitial;
    Thread tPanelInfo;

    // les attributs
    short stade, iteration = 0;
    int vel_x = 2;
    int vel_y = 2;
    public int argent = 0;
    public static float jours = (float) 0; // TIMER GLOBAL
    public static boolean hasFish1;
    public static boolean hasFish2;
    public static boolean hasFish3;
    public static boolean hasFish4;
    public static boolean hasFish5;
    public static boolean hasFish6;
    public static boolean hasPlant1;
    public static boolean hasPlant2;
    public static boolean hasPlant3;

    public GUIMain() { // création du constructeur GUIMain

        setTitle("Aquariophilie");

        setIconImage(iconeAppli.getImage());

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
        threadEau.setName("ThreadEau");
        cycleInitial = new CycleAzote();
        tCycleInitial = new Thread(cycleInitial);
        tCycleInitial.setName("ThreadCycleInitial");

        actionEnCours = cycleInitial.actionEnCours;

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
        pipette = new Pipette();

        // ajout du label pour la pipette
        lblPipette = new JLabel();
        pipette.changerEtatLabel(lblPipette);
        Dimension size_pipette = lblPipette.getPreferredSize(); // prend la dimension de la photo
        lblPipette.setBounds(850, 200, size_pipette.width, size_pipette.height);
        lblPipette.setVisible(true);
        panelAqua.add(lblPipette);

        filet = new Filet();
        // ajout du label pour le filet
        filet_label = new JLabel();
        filet.setIcon(filet_label);
        Dimension size_filet = filet_label.getPreferredSize(); // prend la dimension de la photo
        filet_label.setBounds(850, 350, size_filet.width, size_filet.height);
        filet_label.setVisible(true);
        panelAqua.add(filet_label);

        ciseau = new Ciseau();
        // ajout du label pour le ciseau
        ciseau_label = new JLabel();
        ciseau.setIcon(ciseau_label);
        Dimension size_ciseau = ciseau_label.getPreferredSize(); // prend la dimension de la photo
        ciseau_label.setBounds(850, 500, size_ciseau.width, size_ciseau.height);
        ciseau_label.setVisible(true);
        panelAqua.add(ciseau_label);

        shop = new Shop();
        // ajout du label pour le shop
        shop_label = new JLabel();
        shop.setIcon(shop_label);
        Dimension size_shop = new Dimension(300, 200); // prend la dimension de la photo
        shop_label.setBounds(700, 505, size_shop.width, size_shop.height);
        shop_label.setVisible(false);
        // panelAqua.add(shop_label);

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
        inventaire_fermer.setToolTipText("Ouvre l'inventaire");
        inventaire_fermer.setVisible(true);
        panelAqua.add(inventaire_fermer);

        // ajout du label pour icones de l'inventaire
        pause_label = new JLabel();
        pause_label.setIcon(new ImageIcon("res/background/pause.png"));
        pause_label.setBounds(865, 5, 30, 30);
        pause_label.setToolTipText("Ouvre l'inventaire");
        pause_label.setVisible(true);
        panelAqua.add(pause_label);

        reprendre_label = new JLabel();
        reprendre_label.setIcon(new ImageIcon("res/background/backward.png"));
        reprendre_label.setBounds(915, 5, 30, 30);
        reprendre_label.setToolTipText("Ouvre l'inventaire");
        reprendre_label.setVisible(true);
        panelAqua.add(reprendre_label);

        // ajout de l'inventaire au panel aqua
        inventaire_bg = new JLabel();
        inventaire_bg.setIcon(new ImageIcon("res/background/inventaire.png"));
        Dimension size_inventaire = inventaire_bg.getPreferredSize();
        inventaire_bg.setBounds(5, 140, size_inventaire.width, size_inventaire.height);
        inventaire_bg.setVisible(false);
        panelAqua.add(inventaire_bg);
        inventaire = new Inventaire(inventaire_bg);
        inventaire.setVisible(false);

        // hamis love label
        hamis = new JLabel();
        hamis.setIcon(new ImageIcon("res/background/hamis_love.png"));// prend la dimension de la photo
        hamis.setBounds(137, 247, 25, 25);
        hamis.setVisible(false);
        panelAqua.add(hamis);

        // ajout du label vide pour les actions listener
        empty = new JLabel("");
        empty.setBounds(0, 0, 1000, 700);
        empty.setVisible(false);
        panelAqua.add(empty);

        // label pour l'argent que l'on a

        label_argent_aqua.setBounds(475, 10, 100, 50);
        label_argent_aqua.setFont(new Font("Verdana", Font.BOLD, 16));
        label_argent_aqua.setText(Argent.montant + "₴");
        label_argent_aqua.setVisible(true);
        panelAqua.add(label_argent_aqua);

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
        rectShop = new Rectangle(705, 505, 300, 200);

        aquarium = new Aquarium(panelAqua);

        // ajout du layeredpane au tabbedane
        tabbedPane.add("Aquarium", panelAqua);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du 2em tab

        // création du panel Magasin
        PanelShop panelShop = new PanelShop();

        label_argent_shop.setBounds(475, 10, 100, 50);
        label_argent_shop.setFont(new Font("Verdana", Font.BOLD, 16));
        label_argent_shop.setText("50 ₴");
        label_argent_shop.setVisible(true);
        panelShop.add(label_argent_shop);

        tabbedPane.add("Magasin", panelShop);

        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // creation du 3em tab

        // création du panel Magasin
        PanelInfo panelInfo = new PanelInfo();
        tPanelInfo = new Thread(panelInfo);
        tPanelInfo.start();
        tabbedPane.add("À propos", panelInfo);

        // ajout du panel Info au tabbed pane
        add(tabbedPane);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // action listener de GUIMain

        // pour les plantes dans l'inventaire
        pla1 = "";
        pla2 = "";
        pla3 = "";
        pla4 = "";
        pla5 = "";
        pla6 = "";

        // pour les plantes dans l'aquarium
        aquaPla1 = "";
        aquaPla2 = "";
        aquaPla3 = "";

        // action listener sur les labels qui font apparaitre les interfaces
        aquarium_kit_ouvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                empty.setVisible(false);
                setOutilsVisible();
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
                setOutilsInvisible();
                // tpoisson_betta.interrupt();
            }
        });

        // action listener pour la pipette et les changements d'états du curseur et du
        // label
        lblPipette.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                pipette.changerEtatPanel(panelAqua);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                if (panelAqua.getMousePosition().getX() >= rectEau.getMinX()
                        && panelAqua.getMousePosition().getX() <= rectEau.getMaxX()
                        && panelAqua.getMousePosition().getY() >= rectEau.getMinY()
                        && panelAqua.getMousePosition().getY() <= rectEau.getMaxY()) {
                    lblPipette.setIcon(new ImageIcon("res/outils/pipette_pleine.png"));
                    pipette.setEstRemplie(true);
                    pipette.setNbGouttes(6);
                    pipette.changerEtatLabel(lblPipette);
                    pipette.changerEtatPanel(panelTest);
                }
            }
        });

        label_argent_aqua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hamis.setVisible(true);
            }
        });

        filet_label.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                filet.changerCurseurPanel(panelAqua);
                visibleBordersPoi();
                aquaVisibleTrue();
                empVisibleFalse();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                invisibleBordersPoi();
                aquaVisibleFalse();
                empVisibleTrue();

                MethodeGUIMain.checkRectanglesPoiFilet(rectAqua1, aquarium.aqua1, Inventaire.empty_inv, hasFish1,
                        "hasFish1", 0,
                        aqua1);
                MethodeGUIMain.checkRectanglesPoiFilet(rectAqua2, aquarium.aqua2, Inventaire.empty_inv, hasFish2,
                        "hasFish2", 1,
                        aqua2);
                MethodeGUIMain.checkRectanglesPoiFilet(rectAqua3, aquarium.aqua3, Inventaire.empty_inv, hasFish3,
                        "hasFish3", 2,
                        aqua3);
                MethodeGUIMain.checkRectanglesPoiFilet(rectAqua4, aquarium.aqua4, Inventaire.empty_inv, hasFish4,
                        "hasFish4", 3,
                        aqua4);
                MethodeGUIMain.checkRectanglesPoiFilet(rectAqua5, aquarium.aqua5, Inventaire.empty_inv, hasFish5,
                        "hasFish5", 4,
                        aqua5);
                MethodeGUIMain.checkRectanglesPoiFilet(rectAqua6, aquarium.aqua6, Inventaire.empty_inv, hasFish6,
                        "hasFish6", 5,
                        aqua6);
            }
        });

        ciseau_label.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                ciseau.changerCurseurPanel(panelAqua);
                visibleBordersDeco();
                // empVisibleFalse();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                invisibleBordersDeco();
                // empVisibleTrue();

                MethodeGUIMain.checkRectanglesDecoCis(rectEmp1, aquarium.emp1, Inventaire.empty_inv, hasPlant1,
                        "hasPlant1", 0,
                        aquaPla1);
                MethodeGUIMain.checkRectanglesDecoCis(rectEmp2, aquarium.emp2, Inventaire.empty_inv, hasPlant2,
                        "hasPlant2", 1,
                        aquaPla2);
                MethodeGUIMain.checkRectanglesDecoCis(rectEmp3, aquarium.emp3, Inventaire.empty_inv, hasPlant3,
                        "hasPlant3", 2,
                        aquaPla3);
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
                    setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                            tetra_curseur.getImage(),
                            new Point(0, 0), "curseur tétra"));
                    panelTest.setVisible(false);
                    empty.setVisible(false);
                    lblPipette.setVisible(true);
                    aquarium_kit_ouvert.setVisible(false);
                    setOutilsVisible();

                }
            }
        });

        // action listener sur le label icone pour faire disparaitre ou apparaitre
        // l'inventaire
        inventaire_ouvert.addMouseListener(new MouseAdapter() {

            @Override
            public void mouseClicked(MouseEvent e) {
                setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        tetra_curseur.getImage(),
                        new Point(0, 0), "curseur tétra"));
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
                hamis.setVisible(false);
            }
        });

        // actionlistener pour le temps
        pause_label.addMouseListener(new MouseAdapter() { // TODO: à revoir
            @Override
            public void mouseClicked(MouseEvent e) {
                Temps.pause();
                System.out.println("jour " + jours);
            }
        });

        reprendre_label.addMouseListener(new MouseAdapter() { // TODO: à revoir
            @Override
            public void mouseClicked(MouseEvent e) {
                Temps.reprendre();
                System.out.println("jour " + jours);
            }
        });

        // actionlistener sur les items de l'inventaire
        // ---------------------------------------------------------------------------------------------------------------------------------------------------

        // pour voir le type d'item dans l'inventaire
        empla1 = "empty";
        empla2 = "empty";
        empla3 = "empty";
        empla4 = "empty";
        empla5 = "empty";
        empla6 = "empty";

        // pour voir si il y a un poisson
        hasFish1 = false;
        hasFish2 = false;
        hasFish3 = false;
        hasFish4 = false;
        hasFish5 = false;
        hasFish6 = false;

        // pour voir si il y a une plante
        hasPlant1 = false;
        hasPlant2 = false;
        hasPlant3 = false;

        // pour les poissons dans l'inventaire
        poi1 = "";
        poi2 = "";
        poi3 = "";
        poi4 = "";
        poi5 = "";
        poi6 = "";

        // pour les poissons dans l'aquarium
        aqua1 = "";
        aqua2 = "";
        aqua3 = "";
        aqua4 = "";
        aqua5 = "";
        aqua6 = "";

        // ---------------------------------------------------------------------------------------------------------------------------------------------------

        listePoissonsInv.add(0, poisson_default);
        listePoissonsInv.add(1, poisson_default);
        listePoissonsInv.add(2, poisson_default);
        listePoissonsInv.add(3, poisson_default);
        listePoissonsInv.add(4, poisson_default);
        listePoissonsInv.add(5, poisson_default);

        listePoissonsAqua.add(0, poisson_default);
        listePoissonsAqua.add(1, poisson_default);
        listePoissonsAqua.add(2, poisson_default);
        listePoissonsAqua.add(3, poisson_default);
        listePoissonsAqua.add(4, poisson_default);
        listePoissonsAqua.add(5, poisson_default);

        listePlantesInv.add(0, plante_default);
        listePlantesInv.add(1, plante_default);
        listePlantesInv.add(2, plante_default);
        listePlantesInv.add(3, plante_default);
        listePlantesInv.add(4, plante_default);
        listePlantesInv.add(5, plante_default);

        listePlantesAqua.add(0, plante_default);
        listePlantesAqua.add(1, plante_default);
        listePlantesAqua.add(2, plante_default);

        // inventaire 1
        Inventaire.emp1.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla1 == "decoration") {
                    setCursor(Inventaire.emp1);
                    visibleBordersDeco();
                }
                if (empla1 == "poisson") {
                    setCursor(Inventaire.emp1);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                    empVisibleFalse();

                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla1 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    MethodeGUIMain.checkRectanglesDeco(rectEmp1, aquarium.emp1, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasPlant1, "hasPlant1", 0, 0, pla1);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp2, aquarium.emp2, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasPlant2, "hasPlant2", 0, 1, pla1);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp3, aquarium.emp3, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasPlant3, "hasPlant3", 0, 2, pla1);
                }
                if (empla1 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    empVisibleTrue();
                    MethodeGUIMain.checkRectanglesPoi(rectAqua1, aquarium.aqua1, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasFish1, "hasFish1", 0, poi1, aqua1);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua2, aquarium.aqua2, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasFish2, "hasFish2", 1, poi1, aqua2);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua3, aquarium.aqua3, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasFish3, "hasFish3", 2, poi1, aqua3);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua4, aquarium.aqua4, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasFish4, "hasFish4", 3, poi1, aqua4);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua5, aquarium.aqua5, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasFish5, "hasFish5", 4, poi1, aqua5);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua6, aquarium.aqua6, Inventaire.emp1.getIcon(),
                            Inventaire.emp1, "empla1",
                            hasFish6, "hasFish6", 5, poi1, aqua6);

                }
            }
        });

        // inventaire 2
        Inventaire.emp2.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla2 == "decoration") {
                    setCursor(Inventaire.emp2);
                    visibleBordersDeco();
                }
                if (empla2 == "poisson") {
                    setCursor(Inventaire.emp2);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                    empVisibleFalse();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla2 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    MethodeGUIMain.checkRectanglesDeco(rectEmp1, aquarium.emp1, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasPlant1, "hasPlant1", 1, 0, pla2);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp2, aquarium.emp2, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasPlant2, "hasPlant2", 1, 1, pla2);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp3, aquarium.emp3, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasPlant3, "hasPlant3", 1, 2, pla2);
                }
                if (empla2 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    empVisibleTrue();
                    MethodeGUIMain.checkRectanglesPoi(rectAqua1, aquarium.aqua1, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasFish1, "hasFish1", 0, poi2, aqua1);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua2, aquarium.aqua2, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasFish2, "hasFish2", 1, poi2, aqua2);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua3, aquarium.aqua3, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasFish3, "hasFish3", 2, poi2, aqua3);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua4, aquarium.aqua4, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasFish4, "hasFish4", 3, poi2, aqua4);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua5, aquarium.aqua5, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasFish5, "hasFish5", 4, poi2, aqua5);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua6, aquarium.aqua6, Inventaire.emp2.getIcon(),
                            Inventaire.emp2, "empla2",
                            hasFish6, "hasFish6", 5, poi2, aqua6);

                }
            }
        });

        // inventaire 3
        Inventaire.emp3.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla3 == "decoration") {
                    setCursor(Inventaire.emp3);
                    visibleBordersDeco();
                }
                if (empla3 == "poisson") {
                    setCursor(Inventaire.emp3);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                    empVisibleFalse();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla3 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    MethodeGUIMain.checkRectanglesDeco(rectEmp1, aquarium.emp1, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasPlant1, "hasPlant1", 2, 0, pla3);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp2, aquarium.emp2, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasPlant2, "hasPlant2", 2, 1, pla3);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp3, aquarium.emp3, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasPlant3, "hasPlant3", 2, 2, pla3);
                }
                if (empla3 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    empVisibleTrue();
                    MethodeGUIMain.checkRectanglesPoi(rectAqua1, aquarium.aqua1, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasFish1, "hasFish1", 0, poi3, aqua1);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua2, aquarium.aqua2, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasFish2, "hasFish2", 1, poi3, aqua2);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua3, aquarium.aqua3, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasFish3, "hasFish3", 2, poi3, aqua3);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua4, aquarium.aqua4, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasFish4, "hasFish4", 3, poi3, aqua4);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua5, aquarium.aqua5, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasFish5, "hasFish5", 4, poi3, aqua5);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua6, aquarium.aqua6, Inventaire.emp3.getIcon(),
                            Inventaire.emp3, "empla3",
                            hasFish6, "hasFish6", 5, poi3, aqua6);

                }
            }
        });

        // inventaire 4
        Inventaire.emp4.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla4 == "decoration") {
                    setCursor(Inventaire.emp4);
                    visibleBordersDeco();
                }
                if (empla4 == "poisson") {
                    setCursor(Inventaire.emp4);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                    empVisibleFalse();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla4 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    MethodeGUIMain.checkRectanglesDeco(rectEmp1, aquarium.emp1, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasPlant1, "hasPlant1", 3, 0, pla4);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp2, aquarium.emp2, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasPlant2, "hasPlant2", 3, 1, pla4);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp3, aquarium.emp3, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasPlant3, "hasPlant3", 3, 2, pla4);
                }
                if (empla4 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    empVisibleTrue();
                    MethodeGUIMain.checkRectanglesPoi(rectAqua1, aquarium.aqua1, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasFish1, "hasFish1", 0, poi4, aqua1);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua2, aquarium.aqua2, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasFish2, "hasFish2", 1, poi4, aqua2);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua3, aquarium.aqua3, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasFish3, "hasFish3", 2, poi4, aqua3);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua4, aquarium.aqua4, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasFish4, "hasFish4", 3, poi4, aqua4);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua5, aquarium.aqua5, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasFish5, "hasFish5", 4, poi4, aqua5);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua6, aquarium.aqua6, Inventaire.emp4.getIcon(),
                            Inventaire.emp4, "empla4",
                            hasFish6, "hasFish6", 5, poi4, aqua6);

                }
            }
        });

        // inventaire 5
        Inventaire.emp5.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla5 == "decoration") {
                    setCursor(Inventaire.emp5);
                    visibleBordersDeco();
                }
                if (empla5 == "poisson") {
                    setCursor(Inventaire.emp5);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                    empVisibleFalse();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla5 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    MethodeGUIMain.checkRectanglesDeco(rectEmp1, aquarium.emp1, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasPlant1, "hasPlant1", 4, 0, pla5);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp2, aquarium.emp2, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasPlant2, "hasPlant2", 4, 1, pla5);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp3, aquarium.emp3, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasPlant3, "hasPlant3", 4, 2, pla5);
                }
                if (empla5 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    empVisibleTrue();
                    MethodeGUIMain.checkRectanglesPoi(rectAqua1, aquarium.aqua1, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasFish1, "hasFish1", 0, poi5, aqua1);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua2, aquarium.aqua2, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasFish2, "hasFish2", 1, poi5, aqua2);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua3, aquarium.aqua3, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasFish3, "hasFish3", 2, poi5, aqua3);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua4, aquarium.aqua4, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasFish4, "hasFish4", 3, poi5, aqua4);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua5, aquarium.aqua5, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasFish5, "hasFish5", 4, poi5, aqua5);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua6, aquarium.aqua6, Inventaire.emp5.getIcon(),
                            Inventaire.emp5, "empla5",
                            hasFish6, "hasFish6", 5, poi5, aqua6);

                }
            }

        });

        // inventaire 6
        Inventaire.emp6.addMouseListener(new MouseAdapter() {

            @Override
            public void mousePressed(MouseEvent e) {
                if (empla6 == "decoration") {
                    setCursor(Inventaire.emp6);
                    visibleBordersDeco();
                }
                if (empla6 == "poisson") {
                    setCursor(Inventaire.emp6);
                    visibleBordersPoi();
                    aquaVisibleTrue();
                    empVisibleFalse();
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (empla6 == "decoration") {
                    basicCursor();
                    invisibleBordersDeco();
                    MethodeGUIMain.checkRectanglesDeco(rectEmp1, aquarium.emp1, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasPlant1, "hasPlant1", 5, 0, pla6);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp2, aquarium.emp2, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasPlant2, "hasPlant2", 5, 1, pla6);
                    MethodeGUIMain.checkRectanglesDeco(rectEmp3, aquarium.emp3, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasPlant3, "hasPlant3", 5, 2, pla6);
                }
                if (empla6 == "poisson") {
                    basicCursor();
                    invisibleBordersPoi();
                    aquaVisibleFalse();
                    empVisibleTrue();
                    MethodeGUIMain.checkRectanglesPoi(rectAqua1, aquarium.aqua1, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasFish1, "hasFish1", 0, poi6, aqua1);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua2, aquarium.aqua2, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasFish2, "hasFish2", 1, poi6, aqua2);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua3, aquarium.aqua3, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasFish3, "hasFish3", 2, poi6, aqua3);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua4, aquarium.aqua4, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasFish4, "hasFish4", 3, poi6, aqua4);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua5, aquarium.aqua5, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasFish5, "hasFish5", 4, poi6, aqua5);
                    MethodeGUIMain.checkRectanglesPoi(rectAqua6, aquarium.aqua6, Inventaire.emp6.getIcon(),
                            Inventaire.emp6, "empla6",
                            hasFish6, "hasFish6", 5, poi6, aqua6);

                }
            }
        });

        // GUIMainThread.start();
        threadEau.start();
        tCycleInitial.start();

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
        aquarium.aqua1.setBorder(new LineBorder(Color.blue, 2));
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

    public void invisibleBordersPoi() {
        aquarium.aqua1.setBorder(null);
        aquarium.aqua2.setBorder(null);
        aquarium.aqua3.setBorder(null);
        aquarium.aqua4.setBorder(null);
        aquarium.aqua5.setBorder(null);
        aquarium.aqua6.setBorder(null);
    }

    public void basicCursor() {
        tetra_curseur = new ImageIcon("res/icone_souris/tetra_cursor.png");
        panelAqua.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                tetra_curseur.getImage(),
                new Point(0, 0), "custom cursor"));
    }

    public void setCursor(JLabel label) {
        ImageIcon curseur = (ImageIcon) label.getIcon();
        panelAqua.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                curseur.getImage(),
                new Point(0, 0), "curseur tétra"));
    }

    public void aquaVisibleTrue() {
        aquarium.aqua1.setVisible(true);
        aquarium.aqua2.setVisible(true);
        aquarium.aqua3.setVisible(true);
        aquarium.aqua4.setVisible(true);
        aquarium.aqua5.setVisible(true);
        aquarium.aqua6.setVisible(true);
        shop_label.setVisible(true);
    }

    public void aquaVisibleFalse() {
        aquarium.aqua1.setVisible(false);
        aquarium.aqua2.setVisible(false);
        aquarium.aqua3.setVisible(false);
        aquarium.aqua4.setVisible(false);
        aquarium.aqua5.setVisible(false);
        aquarium.aqua6.setVisible(false);
        shop_label.setVisible(false);
    }

    public void empVisibleTrue() { // set les labels des emplacements visible
        aquarium.emp1.setVisible(true);
        aquarium.emp2.setVisible(true);
        aquarium.emp3.setVisible(true);

    }

    public void empVisibleFalse() { // set les labels des emplacements invisible
        aquarium.emp1.setVisible(false);
        aquarium.emp2.setVisible(false);
        aquarium.emp3.setVisible(false);
    }

    public void setOutilsVisible() {
        lblPipette.setVisible(true);
        aquarium_kit_fermer.setVisible(true);
        inventaire_fermer.setVisible(true);
        label_argent_aqua.setVisible(true);
        ciseau_label.setVisible(true);
        filet_label.setVisible(true);
        pause_label.setVisible(true);
        reprendre_label.setVisible(true);
    }

    public void setOutilsInvisible() {
        lblPipette.setVisible(false);
        inventaire_ouvert.setVisible(false);
        inventaire_fermer.setVisible(false);
        inventaire_bg.setVisible(false);
        label_argent_aqua.setVisible(false);
        ciseau_label.setVisible(false);
        filet_label.setVisible(false);
        pause_label.setVisible(false);
        reprendre_label.setVisible(false);
    }

    // ------------------------------------------------------------------------------------------------------------------------------------------------------

}

// Слава Україні!