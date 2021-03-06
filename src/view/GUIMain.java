// Itération 1: Jérémie Caron, Frédéric Choinière
// Itération 2: Jérémie Caron, Frédéric Choinière
// Itération 3: Jérémie Caron, Frédéric Choinière, Justin Plouffe

//Classe d'affichage principale

package view;

// import pour le bon fonctionnement de la classe
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.util.ArrayList;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import control.Control;
import model.*;
import model.chimie.*;
import model.environnement.Temps;
import model.outils.*;
import model.jeu.*;
import model.plantes.Plante;
import model.poissons.*;
import view.jeu.Aquarium;
import view.jeu.Inventaire;
import view.jeu.Sante;
import view.tabs.*;

public class GUIMain extends JFrame {

    // appel des attributs de la classe GUIMain
    // -----------------------------------------------------------------------------------------------------------------------------------------------------------------
    // création du JTabbedPane
    public static JTabbedPane tabbedPane;

    // création des labels
    JLabel  empty, aquarium_kit_ouvert, aquarium_kit_fermer, inventaire_ouvert,
            inventaire_fermer, inventaire_bg, filet_label, pause_label, reprendre_label, label_tutoriel,
            label_tutoriel1,
            label_information, label_information1, hamis, ciseau_label, label_pause2, label_reprendre2,
            meme, label_tuto1,
            label_tuto2, label_tuto3, label_tuto4, label_tuto5, label_tuto6, skip_tuto3,
            radio_on, radio_off, kit_ouvert, kit_fermer, kit_bg, plant, skip_tuto1, skip_tuto2;

    public static JLabel label_tuto7, label_tuto8, label_jours2, pichet_label, coquillage_label;
    public static JLabel lblPipette = new JLabel();
    public static JLabel label_argent_aqua = new JLabel("");
    public static JLabel label_argent_shop = new JLabel("");
    public static JLabel label_jours = new JLabel("");

    // création des String
    public static String empla1, empla2, empla3, empla4, empla5, empla6, poi1, poi2, poi3, poi4, poi5, poi6,
            actionEnCours, pla1, pla2, pla3, pla4, pla5, pla6, aqua1, aqua2, aqua3, aqua4, aqua5, aqua6, 
            aquaPla1, aquaPla2, aquaPla3, aquaPla4, aquaPla5, aquaPla6;

    // création des rectangles
    Rectangle rectTest, rectEmp1, rectEmp2, rectEmp3, rectAqua1, rectAqua2, rectAqua3, rectAqua4, rectAqua5,
            rectAqua6;

    public static Rectangle rectPlant, rectEau, rectAquarium;

    // creation des objets
    public static Eau eau;
    public static Pipette pipette;
    public static Poisson poisson_default = new Poisson();
    public static Plante plante_default = new Plante();
    public static PoissonRouge poisson_rouge;
    public static PoissonBetta poisson_betta;
    public static PoissonTetra poisson_tetra;
    public static PoissonNeo poisson_neo;
    Filet filet;
    Ciseau ciseau;
    static Pichet pichet;
    static Coquillage coquillage;
    ImageIcon tetra_curseur;
    ImageIcon iconeAppli = new ImageIcon("res/background/icone_aquariophilie.png");
    Inventaire inventaire;
    Sante sante;
    public static Aquarium aquarium;
    public static PanelAqua panelAqua;
    public static PanelTest panelTest;

    // création des listes
    public static ArrayList<Poisson> listePoissonsAqua = new ArrayList<Poisson>(6);
    public static ArrayList<Poisson> listePoissonsInv = new ArrayList<Poisson>(6);
    public static ArrayList<Plante> listePlantesInv = new ArrayList<Plante>(6);
    public static ArrayList<Plante> listePlantesAqua = new ArrayList<Plante>(3);

    // création des threads
    public static Thread tpoisson_rouge, tpoisson_betta, tpoisson_tetra, tpoisson_neo;

    Thread threadEau, tPanelInfo;

    public static float jours = (float) 0; // TIMER GLOBAL

    public static boolean hasFish1, hasFish2, hasFish3, hasFish4, hasFish5, hasFish6, hasPlant1, hasPlant2, hasPlant3,
            isSelected6;

    public GUIMain() { // création du constructeur GUIMain

        // titre et image
        setTitle("Aquariophilie");
        setIconImage(iconeAppli.getImage());

        // création du curseur custom
        tetra_curseur = new ImageIcon("res/icone_souris/tetra_cursor.png");

        // spécificité du constructeur
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                tetra_curseur.getImage(),
                new Point(0, 0), "curseur tétra"));

        // attributs du constructeur
        eau = new Eau();
        threadEau = new Thread(eau);
        threadEau.setName("ThreadEau");
        eau.partirCycle(jours);
        actionEnCours = "Aucune action en cours";

        // creation du main tab
        UIManager.put("TabbedPane.selected", new Color(0, 153, 153));
        UIManager.put("Button.select", new Color(53, 109, 127));
        tabbedPane = new JTabbedPane();

        // creation du premier tab
        // ----------------------------------------------------------------------------------------------------------------------------------------------------

        // création du panelaqua
        panelAqua = new PanelAqua();
        panelAqua.setLayout(null);
        panelAqua.setVisible(true);

        // -----------------------------------------------------------------------
        // ajout des labels tuto

        skip_tuto1 = new JLabel();
        skip_tuto1.setBounds(930, 660, 60, 34);
        skip_tuto1.setIcon(new ImageIcon("res/tutoriel/skip_tuto.png"));
        skip_tuto1.setVisible(true);
        panelAqua.add(skip_tuto1);

        label_tuto1 = new JLabel();
        label_tuto1.setBounds(5, 0, 1000, 700);
        label_tuto1.setIcon(new ImageIcon("res/tutoriel/tuto1.png"));
        label_tuto1.setVisible(true);
        panelAqua.add(label_tuto1);

        label_tuto2 = new JLabel();
        label_tuto2.setBounds(5, 0, 1000, 700);
        label_tuto2.setIcon(new ImageIcon("res/tutoriel/tuto2.png"));
        label_tuto2.setVisible(false);
        panelAqua.add(label_tuto2);

        label_tuto3 = new JLabel();
        label_tuto3.setBounds(5, 0, 1000, 700);
        label_tuto3.setIcon(new ImageIcon("res/tutoriel/tuto3.png"));
        label_tuto3.setVisible(false);
        panelAqua.add(label_tuto3);

        label_tuto4 = new JLabel();
        label_tuto4.setBounds(5, 0, 1000, 700);
        label_tuto4.setIcon(new ImageIcon("res/tutoriel/tuto4.png"));
        label_tuto4.setVisible(false);
        panelAqua.add(label_tuto4);

        label_tuto5 = new JLabel();
        label_tuto5.setBounds(5, 0, 1000, 700);
        label_tuto5.setIcon(new ImageIcon("res/tutoriel/tuto5.png"));
        label_tuto5.setVisible(false);
        panelAqua.add(label_tuto5);

        label_tuto6 = new JLabel();
        label_tuto6.setBounds(5, 0, 1000, 700);
        label_tuto6.setIcon(new ImageIcon("res/tutoriel/tuto6.png"));
        label_tuto6.setVisible(false);
        panelAqua.add(label_tuto6);

        // ajout inventaire background
        inventaire_bg = new JLabel();
        kit_bg = new JLabel();
        radio_on = new JLabel();
        radio_off = new JLabel();

        // ajout du panel de l'interface du kit
        panelTest = new PanelTest();
        panelTest.setBounds(150, 100, 700, 500);
        panelTest.setVisible(false);
        panelAqua.add(panelTest);

        // ajouts des labels du premier tab
        // ------------------------------------------

        // ajout de l'objet de la classe pipette
        pipette = new Pipette();

        // ajout du label pour la pipette
        lblPipette = new JLabel();
        pipette.changerEtatLabel(lblPipette);
        Dimension size_pipette = lblPipette.getPreferredSize();
        lblPipette.setBounds(830, 120, size_pipette.width, size_pipette.height);
        lblPipette.setToolTipText("<html><h4 style=\"text-align: center;\">Pipette</h4>" +
        "<p>Permet d'effectuer un test visuel des paramètres d'eau</p>" +
        "<p>Pour effectuer un test:</p>" +
        "<p>- Récolter un échantillon d'eau</p>" +
        "<p>- Ouvrir le kit de test</p>" +
        "<p>- Déposer une goutte d'eau dans chaque tube</p></html>");
        lblPipette.setVisible(true);
        panelAqua.add(lblPipette);

        // ajout du label pour le filet
        filet = new Filet();
        filet_label = new JLabel();
        filet.setIcon(filet_label);
        Dimension size_filet = filet_label.getPreferredSize();
        filet_label.setBounds(912, 200, size_filet.width, size_filet.height);
        filet_label.setToolTipText("<html><h4 style=\"text-align: center;\">Filet</h4>" +
        "<p>Permet de retirer un poisson de l'aquarium et le vendre pour 50% de son prix</p></html>");
        filet_label.setVisible(true);
        panelAqua.add(filet_label);

        // ajout du label pour les ciseaux
        ciseau = new Ciseau();
        ciseau_label = new JLabel();
        ciseau.setIcon(ciseau_label);
        Dimension size_ciseau = ciseau_label.getPreferredSize();
        ciseau_label.setBounds(830, 200, size_ciseau.width, size_ciseau.height);
        ciseau_label.setToolTipText("<html><h4 style=\"text-align: center;\">Ciseaux</h4>" +
        "<p>Permettent de retirer une plante de l'aquarium et la vendre pour 50% de son prix</p></html>");
        ciseau_label.setVisible(true);
        panelAqua.add(ciseau_label);

        // ajout du label pour le pichet
        pichet = new Pichet();
        pichet_label = new JLabel();
        pichet.setIcon(pichet_label);
        Dimension size_pichet = pichet_label.getPreferredSize();
        pichet_label.setBounds(912, 123, size_pichet.width, size_pichet.height);
        pichet_label.setToolTipText("<html><h4 style=\"text-align: center;\">Pichet</h4>" +
        "<p>Permet d'effectuer un changement d'eau</p>" +
        "<p>- Remplit l'aquarium</p>" +
        "<p>- Réinitialise les paramètres</p>" +
        "<p>- Nettoie le fond de l'aquarium</p>" +
        "<p>Cooldown de 20 secondes</p></html>");
        pichet_label.setVisible(true);
        panelAqua.add(pichet_label);

        // ajout du label pour le pichet
        coquillage = new Coquillage();
        coquillage_label = new JLabel();
        coquillage.setIcon(coquillage_label);
        Dimension size_coquillage = coquillage_label.getPreferredSize();
        coquillage_label.setBounds(872, 270, size_coquillage.width, size_coquillage.height);
        coquillage_label.setToolTipText("<html><h4 style=\"text-align: center;\">Coquillage</h4>" +
        "<p>Permet de rehausser le KH de l'eau</p>" +
        "<p>Cooldown de 12 secondes</p></html>");
        coquillage_label.setVisible(true);
        panelAqua.add(coquillage_label);

        // ajout de l'icone de notre kit ouvert
        aquarium_kit_ouvert = new JLabel();
        aquarium_kit_ouvert.setIcon(new ImageIcon("res/outils/aquarium_kit/aquarium_kit_open.png"));
        Dimension size_wallgear_icon1 = aquarium_kit_ouvert.getPreferredSize();
        aquarium_kit_ouvert.setBounds(146, 50, size_wallgear_icon1.width, size_wallgear_icon1.height);
        panelAqua.add(aquarium_kit_ouvert);
        aquarium_kit_ouvert.setVisible(false);

        // ajout de l'icone de notre kit fermé
        aquarium_kit_fermer = new JLabel();
        aquarium_kit_fermer.setIcon(new ImageIcon("res/outils/aquarium_kit/aquarium_kit_closed.png"));
        Dimension size_wallgear_icon2 = aquarium_kit_fermer.getPreferredSize();
        aquarium_kit_fermer.setBounds(146, 62, size_wallgear_icon2.width, size_wallgear_icon2.height);
        aquarium_kit_fermer.setToolTipText("Kit de test");
        aquarium_kit_fermer.setVisible(true);
        panelAqua.add(aquarium_kit_fermer);

        // ajout du label pour icones de l'inventaire ouvert
        inventaire_ouvert = new JLabel();
        inventaire_ouvert.setIcon(new ImageIcon("res/background/inventaire_ouvert.png"));
        Dimension size_icone_inv = inventaire_ouvert.getPreferredSize();
        inventaire_ouvert.setBounds(19, 60, size_icone_inv.width, size_icone_inv.height);
        inventaire_ouvert.setVisible(false);
        panelAqua.add(inventaire_ouvert);

        // ajout du label pour icones de l'inventaire fermé
        inventaire_fermer = new JLabel();
        inventaire_fermer.setIcon(new ImageIcon("res/background/inventaire_fermer.png"));
        inventaire_fermer.setBounds(19, 60, size_icone_inv.width, size_icone_inv.height);
        inventaire_fermer.setToolTipText("Inventaire");
        inventaire_fermer.setVisible(true);
        panelAqua.add(inventaire_fermer);

        // kit de soin ouvert
        kit_ouvert = new JLabel();
        kit_ouvert.setIcon(new ImageIcon("res/background/kit_ouvert.png"));
        Dimension size_kit_ouvert = kit_ouvert.getPreferredSize();
        kit_ouvert.setBounds(82, 51, size_kit_ouvert.width, size_kit_ouvert.height);
        kit_ouvert.setVisible(false);
        panelAqua.add(kit_ouvert);

        // kit de soin fermé
        kit_fermer = new JLabel();
        kit_fermer.setIcon(new ImageIcon("res/background/kit_fermer.png"));
        Dimension size_kit_fermer = kit_fermer.getPreferredSize();
        kit_fermer.setBounds(82, 51, size_kit_fermer.width, size_kit_fermer.height);
        kit_fermer.setToolTipText("Trousse de santé");
        kit_fermer.setVisible(true);
        panelAqua.add(kit_fermer);

        // ajout du label pour pause
        pause_label = new JLabel();
        pause_label.setIcon(new ImageIcon("res/background/pause.png"));
        pause_label.setBounds(492, 13, 40, 40);
        pause_label.setToolTipText("Pause la progression du temps");
        pause_label.setVisible(false);
        panelAqua.add(pause_label);

        // ajout du label pour reprendre
        reprendre_label = new JLabel();
        reprendre_label.setIcon(new ImageIcon("res/background/reprendre.png"));
        reprendre_label.setBounds(492, 13, 40, 40);
        reprendre_label.setToolTipText("Reprend la progression du temps");
        reprendre_label.setVisible(true);
        panelAqua.add(reprendre_label);

        // ajout du label pour le radio
        inventaire_bg.setIcon(new ImageIcon("res/background/inventaire.png"));
        inventaire_bg.setBounds(10, 130, 250, 475);
        inventaire_bg.setVisible(false);
        panelAqua.add(inventaire_bg);
        inventaire = new Inventaire(inventaire_bg);
        inventaire.setVisible(false);

        // ajout du background du kit de soin
        kit_bg.setIcon(new ImageIcon("res/background/kit.png"));
        kit_bg.setBounds(10, 130, 250, 475);
        kit_bg.setVisible(false);
        sante = new Sante(kit_bg);
        sante.setVisible(Sante.state1, Sante.state2, Sante.state3, Sante.state4, Sante.state5, Sante.state6);
        panelAqua.add(kit_bg);

        // ajout de la radio allumée
        radio_on.setIcon(new ImageIcon("res/outils/radio_on.png"));
        radio_on.setBounds(240, 400, 70, 70);
        radio_on.setToolTipText("Mettre la radio sur OFF");
        radio_on.setVisible(false);
        panelAqua.add(radio_on);

        // ajout du label pour la radio éteinte
        radio_off.setIcon(new ImageIcon("res/outils/radio_off.png"));
        radio_off.setBounds(240, 400, 70, 70);
        radio_off.setToolTipText("Mettre la radio sur ON");
        radio_off.setVisible(true);
        panelAqua.add(radio_off);

        // hamis love label
        hamis = new JLabel();
        hamis.setIcon(new ImageIcon("res/background/hamis_love.png"));
        hamis.setBounds(125, 215, 25, 25);
        hamis.setToolTipText("My beloved");
        hamis.setVisible(false);
        panelAqua.add(hamis);

        // ajout du label pour la plante
        plant = new JLabel();
        plant.setIcon(new ImageIcon("res/background/hamis_love.png"));
        plant.setBounds(845, 570, 25, 25);
        plant.setVisible(false);
        panelAqua.add(plant);

        // ajout du label vide
        empty = new JLabel("");
        empty.setBounds(0, 0, 1000, 700);
        empty.setVisible(false);
        panelAqua.add(empty);

        // ajout du label pour l'argent
        label_argent_aqua.setBounds(612, 10, 100, 50);
        label_argent_aqua.setFont(new Font("Verdana", Font.BOLD, 16));
        label_argent_aqua.setText(Argent.montant + "฿");
        label_argent_aqua.setForeground(Color.WHITE);
        label_argent_aqua.setVisible(true);
        panelAqua.add(label_argent_aqua);

        // ajout du label pour les jours
        label_jours.setBounds(363, 10, 100, 50);
        label_jours.setFont(new Font("Verdana", Font.BOLD, 16));
        label_jours.setText("1");
        label_jours.setForeground(Color.WHITE);
        label_jours.setVisible(true);
        panelAqua.add(label_jours);

        // ajout du label pour information panelAqua
        label_tutoriel = new JLabel();
        label_tutoriel.setBounds(5, 0, 1000, 700);
        label_tutoriel.setIcon(new ImageIcon("res/tutoriel/info/infoAqua.png"));
        label_tutoriel.setVisible(false);
        panelAqua.add(label_tutoriel);

        // ajout du label pour information
        label_information = new JLabel();
        label_information.setBounds(965, 5, 30, 30);
        label_information.setIcon(new ImageIcon("res/tutoriel/info/informations.png"));
        label_information.setToolTipText("Afficher l'aide à l'utilisateur");
        label_information.setVisible(true);
        panelAqua.add(label_information);

        // ajout du label meme
        meme = new JLabel(".");
        meme.setBounds(0, 0, 3, 3);
        meme.setVisible(true);
        panelAqua.add(meme);

        // ajout de panel Aqua
        Dimension size_panel_aqua = panelAqua.getPreferredSize();
        panelAqua.setBounds(0, 0, size_panel_aqua.width, size_panel_aqua.height);
        panelAqua.setVisible(true);

        // ajout des zones pour les action listener
        rectEau = new Rectangle(341, 299, 336, 177);
        rectAquarium = new Rectangle(330, 305, 344, 192);
        rectTest = new Rectangle(panelTest.getBounds());
        rectEmp1 = new Rectangle(358, 388, 80, 80);
        rectEmp2 = new Rectangle(464, 388, 80, 80);
        rectEmp3 = new Rectangle(572, 388, 80, 80);
        rectAqua1 = new Rectangle(365, 301, 70, 70);
        rectAqua2 = new Rectangle(474, 301, 70, 70);
        rectAqua3 = new Rectangle(584, 301, 70, 70);
        rectAqua4 = new Rectangle(365, 397, 70, 70);
        rectAqua5 = new Rectangle(474, 397, 70, 70);
        rectAqua6 = new Rectangle(584, 397, 70, 70);
        rectPlant = new Rectangle(850, 500, 100, 200);

        // création de l'aquarium
        aquarium = new Aquarium(panelAqua);

        // ajout du layeredpane au tabbedane
        tabbedPane.add("Aquarium", panelAqua);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // création du 2ème tab

        // création du panel Magasin
        PanelShop panelShop = new PanelShop();

        // ajout du bouton skip tutoriel
        skip_tuto2 = new JLabel();
        skip_tuto2.setBounds(930, 660, 60, 34);
        skip_tuto2.setIcon(new ImageIcon("res/tutoriel/skip_tuto.png"));
        skip_tuto2.setVisible(true);
        panelShop.add(skip_tuto2);

        // ajout du label information pour le panel aqua
        label_tuto7 = new JLabel();
        label_tuto7.setBounds(5, 0, 1000, 700);
        label_tuto7.setIcon(new ImageIcon("res/tutoriel/tuto7.png"));
        label_tuto7.setVisible(false);
        panelShop.add(label_tuto7);

        // ajout du label information du magasin
        label_tutoriel1 = new JLabel();
        label_tutoriel1.setBounds(5, 0, 1000, 700);
        label_tutoriel1.setIcon(new ImageIcon("res/tutoriel/info/infoMagasin.png"));
        label_tutoriel1.setVisible(false);
        panelShop.add(label_tutoriel1);

        // ajout du label pour information du panel aqua
        label_information1 = new JLabel();
        label_information1.setBounds(965, 5, 30, 30);
        label_information1.setIcon(new ImageIcon("res/tutoriel/info/informations.png"));
        label_information1.setToolTipText("Afficher l'aide à l'utilisateur");
        label_information1.setVisible(true);
        panelShop.add(label_information1);

        // ajout du label pour l'argent
        label_argent_shop.setBounds(612, 8, 100, 50);
        label_argent_shop.setFont(new Font("Verdana", Font.BOLD, 16));
        label_argent_shop.setForeground(Color.WHITE);
        label_argent_shop.setText("500฿"); // Afficher vraie valeur
        label_argent_shop.setVisible(true);
        panelShop.add(label_argent_shop);

        // ajout du label pour pause le jeu
        label_pause2 = new JLabel();
        label_pause2.setIcon(new ImageIcon("res/background/pause.png"));
        label_pause2.setBounds(492, 16, 40, 40);
        label_pause2.setToolTipText("Pause la progression du temps");
        label_pause2.setVisible(false);
        panelShop.add(label_pause2);

        // ajout du label pour reprendre
        label_reprendre2 = new JLabel();
        label_reprendre2.setIcon(new ImageIcon("res/background/reprendre.png"));
        label_reprendre2.setBounds(492, 16, 40, 40);
        label_reprendre2.setToolTipText("Reprend la progression du temps");
        label_reprendre2.setVisible(true);
        panelShop.add(label_reprendre2);

        // ajout du label pour les jours
        label_jours2 = new JLabel();
        label_jours2.setBounds(363, 13, 100, 50);
        label_jours2.setFont(new Font("Verdana", Font.BOLD, 16));
        label_jours2.setText("1");
        label_jours2.setForeground(Color.WHITE);
        label_jours2.setVisible(true);
        panelShop.add(label_jours2);

        // ajout du layeredpane au tabbedane
        tabbedPane.add("Magasin", panelShop);

        // --------------------------------------------------------------------------------------------------------------------------------------------------------
        // création du 3ème tab

        // création du panel Magasin
        PanelInfo panelInfo = new PanelInfo();
        tPanelInfo = new Thread(panelInfo);
        tPanelInfo.start();
        tabbedPane.add("Détails", panelInfo);

        // ajout du label pour le tutoriel
        label_tuto8 = new JLabel();
        label_tuto8.setBounds(0, -30, 520, 765);
        label_tuto8.setIcon(new ImageIcon("res/tutoriel/tuto8.png"));
        label_tuto8.setVisible(false);
        panelInfo.add(label_tuto8);

        // ajout du panel Info au tabbed pane
        tabbedPane.setEnabledAt(0, false);
        tabbedPane.setEnabledAt(1, false);
        tabbedPane.setEnabledAt(2, false);
        add(tabbedPane);

        // ---------------------------------------------------------------------------------------------------------------------------------------------------------
        // action listener de GUIMain

        // tags pour les plantes dans l'inventaire
        pla1 = "";
        pla2 = "";
        pla3 = "";
        pla4 = "";
        pla5 = "";
        pla6 = "";

        // tags pour les plantes dans l'aquarium
        aquaPla1 = "";
        aquaPla2 = "";
        aquaPla3 = "";

        // change listener pour le 3e tab "Détails"
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JTabbedPane tabSelection = (JTabbedPane) e.getSource();
                switch (tabSelection.getSelectedIndex()) {
                    case 0: // Vérifie si le tab "Aquarium" est sélectionné
                        setSize(1020, 765);
                        setLocationRelativeTo(null);
                        break;
                    case 1: // Vérifie si le tab "Magasin" est sélectionné
                        setSize(1020, 765);
                        setLocationRelativeTo(null);
                        break;
                    case 2: // Vérifie si le tab "Détails" est sélectionné
                        setSize(520, 765);
                        setLocationRelativeTo(null);
                        break;
                    default:
                        break;
                }
            }
        });

        // action listener pour fermer panelTest
        aquarium_kit_ouvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                empty.setVisible(false);
                label_tutoriel.setVisible(false);
                basicCursor();
                kit_fermer.setVisible(true);
            }
        });

        // action listener pour ouvrir panelTest
        aquarium_kit_fermer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_fermer.setVisible(false);
                aquarium_kit_ouvert.setVisible(true);
                empty.setVisible(true);
                panelTest.setVisible(true);
                label_tutoriel.setVisible(false);
                inventaire_bg.setVisible(false);
                inventaire_ouvert.setVisible(false);
                inventaire_fermer.setVisible(true);
                kit_fermer.setVisible(true);
                kit_bg.setVisible(false);
                kit_ouvert.setVisible(false);
            }
        });

        // action listener pour changer l'image du panel
        meme.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                PanelAqua.background = Toolkit.getDefaultToolkit().getImage("res/meme/god.png");
                JOptionPane.showMessageDialog(null, "Vous avez découvert un easter egg!" + "\n"
                        + "Vous pouvez retourner en arrière en appuyant sur l'inventaire!", "Surprise!", JOptionPane.PLAIN_MESSAGE);
            }
        });

        // action listener pour la pipette
        lblPipette.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                pipette.changerEtatPanel(panelAqua);
                label_tutoriel.setVisible(false);
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                try {
                    basicCursor();
                    if (MethodeGUIMain.rectAquarium()) {
                        lblPipette.setIcon(new ImageIcon("res/outils/pipette_pleine.png"));
                        pipette.setEstRemplie(true);
                        pipette.setNbGouttes(6);
                        pipette.changerEtatLabel(lblPipette);
                        pipette.changerEtatPanel(panelTest);
                    }
                } catch (NullPointerException e1) {
                    GestionException.GestionExceptionObjet();
                }
            }
        });

        // action listener pour le pichet
        pichet_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!MethodeGUIMain.cooldownP()) {
                    pichet.changerCurseurPanel(panelAqua);
                    label_tutoriel.setVisible(false);
                    aquarium_kit_ouvert.setVisible(false);
                    aquarium_kit_fermer.setVisible(true);
                    panelTest.setVisible(false);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!MethodeGUIMain.cooldownP()) {
                    try {
                        basicCursor();
                        if (MethodeGUIMain.rectAquarium()) {
                            MethodeGUIMain.dansRectP = true;
                            Eau.hauteurEnPixels = 177;
                            Eau.positionEnPixels = 298;
                            eau.changerEau();
                            panelAqua.repaint();
                        } else if (MethodeGUIMain.rectPlant()) {
                            plant.setVisible(true);
                        }
                    } catch (NullPointerException e1) {
                        GestionException.GestionExceptionObjet();
                    }
                }
            }
        });

        // action listener pour le coquillage
        coquillage_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                if (!MethodeGUIMain.cooldownC()) {
                    coquillage.changerCurseurPanel(panelAqua);
                    label_tutoriel.setVisible(false);
                    aquarium_kit_ouvert.setVisible(false);
                    aquarium_kit_fermer.setVisible(true);
                    panelTest.setVisible(false);
                }
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                if (!MethodeGUIMain.cooldownC()) {
                    try {
                        basicCursor();
                        if (MethodeGUIMain.rectAquarium()) {
                            MethodeGUIMain.dansRectC = true;
                            eau.setKH((float) (eau.getKH() + (eau.getKH() * 0.2)));
                        }
                    } catch (NullPointerException e1) {
                        GestionException.GestionExceptionObjet();
                    }
                }
            }
        });

        // action listener pour l'argent (easter egg)
        label_argent_aqua.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                hamis.setVisible(true);
                label_tutoriel.setVisible(false);
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
            }
        });

        // action listener pour le filet
        filet_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                filet.changerCurseurPanel(panelAqua);
                visibleBordersPoi();
                aquaVisibleTrue();
                empVisibleFalse();
                label_tutoriel.setVisible(false);
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
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

        // action listener pour le ciseau
        ciseau_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                ciseau.changerCurseurPanel(panelAqua);
                visibleBordersDeco();
                label_tutoriel.setVisible(false);
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                basicCursor();
                invisibleBordersDeco();
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
                    label_tutoriel.setVisible(false);
                    basicCursor();
                    kit_fermer.setVisible(true);
                }
            }
        });

        // action listener pour fermer l'inventaire
        inventaire_ouvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                setCursor(Toolkit.getDefaultToolkit().createCustomCursor(tetra_curseur.getImage(), new Point(0, 0),
                        "curseur tétra"));

                inventaire_ouvert.setVisible(false);
                inventaire_fermer.setVisible(true);
                inventaire_bg.setVisible(false);
                label_tutoriel.setVisible(false);
                PanelAqua.background = Toolkit.getDefaultToolkit().getImage("res/background/background.png");
            }
        });

        // action listener pour ouvrir l'inventaire
        inventaire_fermer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                inventaire_ouvert.setVisible(true);
                inventaire_fermer.setVisible(false);
                inventaire_bg.setVisible(true);
                inventaire.setVisible(true);
                hamis.setVisible(false);
                label_tutoriel.setVisible(false);
                kit_bg.setVisible(false);
                kit_ouvert.setVisible(false);
                kit_fermer.setVisible(true);
                PanelAqua.background = Toolkit.getDefaultToolkit().getImage("res/background/background.png");
            }
        });

        // action listener pour fermer le kit
        kit_ouvert.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                kit_ouvert.setVisible(false);
                kit_fermer.setVisible(true);
                kit_bg.setVisible(false);
                inventaire_bg.setVisible(false);
                kit_bg.setVisible(false);
                inventaire_fermer.setVisible(true);
                inventaire_ouvert.setVisible(false);
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
            }
        });

        // action listener pour ouvrir le kit
        kit_fermer.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                kit_ouvert.setVisible(true);
                kit_fermer.setVisible(false);
                // layerAqua.add(inventaire_bg, 1);
                inventaire_bg.setVisible(false);
                kit_bg.setVisible(true);
                inventaire_fermer.setVisible(true);
                inventaire_ouvert.setVisible(false);
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                label_tutoriel.setVisible(false);
            }
        });

        // actionlistener pour arreter le jeu
        pause_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                Temps.pause();
                pause_label.setVisible(false);
                label_pause2.setVisible(false);
                reprendre_label.setVisible(true);
                label_reprendre2.setVisible(true);
                label_tutoriel.setVisible(false);
                Temps.isPaused = true;
            }
        });

        // actionlistener pour reprendre le jeu
        reprendre_label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                Temps.reprendre();
                pause_label.setVisible(true);
                reprendre_label.setVisible(false);
                label_pause2.setVisible(true);
                label_reprendre2.setVisible(false);
                label_tutoriel.setVisible(false);
                Temps.isPaused = false;
            }
        });

        // actionlistener pour arreter le jeu
        label_pause2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                Temps.pause();
                pause_label.setVisible(false);
                reprendre_label.setVisible(true);
                label_pause2.setVisible(false);
                label_reprendre2.setVisible(true);
                label_tutoriel.setVisible(false);
                Temps.isPaused = true;
            }
        });

        // actionlistener pour reprendre le jeu
        label_reprendre2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                Temps.reprendre();
                pause_label.setVisible(true);
                reprendre_label.setVisible(false);
                label_pause2.setVisible(true);
                label_reprendre2.setVisible(false);
                label_tutoriel.setVisible(false);
                Temps.isPaused = false;
            }
        });

        // actionlistener pour fermer le tutoriel
        label_tutoriel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tutoriel.setVisible(false);
            }
        });

        // actionlistener pour ouvrir le tutoriel
        label_information.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tutoriel.setVisible(true);
                setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                        tetra_curseur.getImage(),
                        new Point(0, 0), "curseur tétra"));
                inventaire_ouvert.setVisible(false);
                inventaire_fermer.setVisible(true);
                kit_bg.setVisible(false);
                kit_fermer.setVisible(true);
                kit_ouvert.setVisible(false);
                // layerAqua.add(inventaire_bg, 1);
                inventaire_bg.setVisible(false);
                inventaire.setVisible(false);
            }
        });

        // actionlistener pour ouvrir la radio
        radio_off.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                radio_off.setVisible(false);
                // layerAqua.add(radio_on, 0);
                radio_on.setVisible(true);
                label_tutoriel.setVisible(false);
                try {
                    Control.audioPlayer.resumeAudio();
                } catch (UnsupportedAudioFileException e1) {
                    GestionException.GestionExceptionRadio2();
                } catch (IOException e1) {
                    GestionException.GestionExceptionRadio2();
                } catch (LineUnavailableException e1) {
                    GestionException.GestionExceptionRadio2();
                }
            }
        });

        // actionlistener pour fermer la radio
        radio_on.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                radio_off.setVisible(true);
                radio_on.setVisible(false);
                label_tutoriel.setVisible(false);
                Control.audioPlayer.pause();
            }
        });

        // actionlistener pour ouvrir le tutoriel
        label_tutoriel1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tutoriel1.setVisible(false);
            }
        });

        // actionlistener pour ouvrir le tutoriel
        label_information1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tutoriel1.setVisible(true);
            }
        });

        // actionlistener pour ouvrir le tutoriel
        // --------------------------------------------------------------------------

        // actionlistener pour avancer dans le tutoriel
        label_tuto1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tuto1.setVisible(false);
                label_tuto2.setVisible(true);
                inventaire_fermer.setVisible(false);
                kit_fermer.setVisible(false);
                aquarium_kit_fermer.setVisible(false);
                pichet_label.setVisible(false);
                lblPipette.setVisible(false);
                ciseau_label.setVisible(false);
                filet_label.setVisible(false);
                coquillage_label.setVisible(false);
            }
        });

        // actionlistener pour avancer dans le tutoriel
        label_tuto2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tuto2.setVisible(false);
                label_tuto3.setVisible(true);
                inventaire_fermer.setVisible(false);
                inventaire_ouvert.setVisible(true);
                inventaire_bg.setVisible(true);
            }
        });

        // actionlistener pour avancer dans le tutoriel
        label_tuto3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tuto3.setVisible(false);
                label_tuto4.setVisible(true);
                inventaire_fermer.setVisible(true);
                inventaire_ouvert.setVisible(false);
                inventaire_bg.setVisible(false);
                kit_fermer.setVisible(false);
                kit_ouvert.setVisible(true);
                kit_bg.setVisible(true);
            }
        });

        // actionlistener pour avancer dans le tutoriel
        label_tuto4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tuto4.setVisible(false);
                label_tuto5.setVisible(true);
                kit_fermer.setVisible(true);
                kit_ouvert.setVisible(false);
                kit_bg.setVisible(false);
                aquarium_kit_ouvert.setVisible(true);
                aquarium_kit_fermer.setVisible(false);
                panelTest.setVisible(true);
            }
        });

        // actionlistener pour avancer dans le tutoriel
        label_tuto5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tuto5.setVisible(false);
                label_tuto6.setVisible(true);
                aquarium_kit_ouvert.setVisible(false);
                aquarium_kit_fermer.setVisible(true);
                panelTest.setVisible(false);
                pichet_label.setVisible(true);
                lblPipette.setVisible(true);
                ciseau_label.setVisible(true);
                filet_label.setVisible(true);
                coquillage_label.setVisible(true);
            }
        });

        // actionlistener pour avancer dans le tutoriel
        label_tuto6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tuto6.setVisible(false);
                label_tuto7.setVisible(true);
                tabbedPane.setSelectedIndex(1);
                isSelected6 = true;
            }
        });

        // actionlistener pour avancer dans le tutoriel
        label_tuto7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                label_tuto7.setVisible(false);
                tabbedPane.setSelectedIndex(2);
                label_tuto8.setVisible(true);
                isSelected6 = false;
                PanelInfo.lblAction.setVisible(false);
                PanelInfo.lblN.setVisible(false);
                PanelInfo.lblH.setVisible(false);
                PanelInfo.lblO.setVisible(false);
                PanelInfo.lblAmmo.setVisible(false);
                PanelInfo.lblNit.setVisible(false);
                PanelInfo.lblNat.setVisible(false);
                PanelInfo.lblScore.setVisible(false);
                PanelInfo.lblDechets.setVisible(false);
                PanelInfo.lblAbsDechets.setVisible(false);
                PanelInfo.progressBar.setVisible(false);
                PanelInfo.lblPH.setVisible(false);
                PanelInfo.lblKH.setVisible(false);
                PanelInfo.lblGH.setVisible(false);
            }
        });

        // actionlistener pour avancer dans le tutoriel
        label_tuto8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setEverythingGood();
            }
        });

        // actionlistener pour skip le tutoriel
        skip_tuto1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setEverythingGood();
            }
        });

        // actionlistener pour skip le tutoriel
        skip_tuto2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setEverythingGood();
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

        // pour voir si il y a un poisson dans l'aquarium
        hasFish1 = false;
        hasFish2 = false;
        hasFish3 = false;
        hasFish4 = false;
        hasFish5 = false;
        hasFish6 = false;

        // pour voir si il y a une plante dans l'aquarium
        hasPlant1 = false;
        hasPlant2 = false;
        hasPlant3 = false;

        // pour les types de poissons dans l'inventaire
        poi1 = "";
        poi2 = "";
        poi3 = "";
        poi4 = "";
        poi5 = "";
        poi6 = "";

        // pour les types de poissons dans l'aquarium
        aqua1 = "";
        aqua2 = "";
        aqua3 = "";
        aqua4 = "";
        aqua5 = "";
        aqua6 = "";

        // initialisation des élément par défaut dans les listes
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

        // action listener pour le premier item de l'inventaire
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

        // action listener pour le deuxième item de l'inventaire
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

        // action listener pour le troisième item de l'inventaire
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

        // action listener pour le quatrième item de l'inventaire
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

        // action listener pour le cinquième item de l'inventaire
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

        // action listener pour le sixième item de l'inventaire
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

        // début des Threads pour l'eau
        threadEau.start();
        Temps.checkCooldown();

    } // fin du constructeur GUIMain

    // méthode de GUIMain
    // --------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * méthode pour set les borders des plantes visible
     */
    public void visibleBordersDeco() {
        aquarium.emp1.setBorder(new LineBorder(Color.yellow, 2));
        aquarium.emp2.setBorder(new LineBorder(Color.yellow, 2));
        aquarium.emp3.setBorder(new LineBorder(Color.yellow, 2));
    }

    /**
     * méthode pour set les borders des poissons visible
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
     * méthode pour set les borders des plantes invisible
     */
    public void invisibleBordersDeco() {
        aquarium.emp1.setBorder(null);
        aquarium.emp2.setBorder(null);
        aquarium.emp3.setBorder(null);
    }

    /**
     * méthode pour set les borders des poissons invisible
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
     * @param label
     *              méthode pour set un autre curseur
     */
    public void setCursor(JLabel label) {
        ImageIcon curseur = (ImageIcon) label.getIcon();
        panelAqua.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                curseur.getImage(),
                new Point(0, 0), "curseur tétra"));
    }

    /**
     * méthode pour rendre les emplacements des poissons visible
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
     * méthode pour rendre les emplacements des poissons invisible
     */
    public void aquaVisibleFalse() {
        aquarium.aqua1.setVisible(false);
        aquarium.aqua2.setVisible(false);
        aquarium.aqua3.setVisible(false);
        aquarium.aqua4.setVisible(false);
        aquarium.aqua5.setVisible(false);
        aquarium.aqua6.setVisible(false);
    }

    /**
     * méthode pour rendre les emplacements des plantes visible
     */
    public void empVisibleTrue() { // set les labels des emplacements visible
        aquarium.emp1.setVisible(true);
        aquarium.emp2.setVisible(true);
        aquarium.emp3.setVisible(true);

    }

    /**
     * méthode pour rendre les emplacement des plante invisible
     */
    public void empVisibleFalse() { // set les labels des emplacements invisible
        aquarium.emp1.setVisible(false);
        aquarium.emp2.setVisible(false);
        aquarium.emp3.setVisible(false);
    }

    /**
     * méthode pour rendre les outils visible
     */
    public void setOutilsVisible() {
        lblPipette.setVisible(true);
        aquarium_kit_fermer.setVisible(true);
        inventaire_fermer.setVisible(true);
        label_argent_aqua.setVisible(true);
        ciseau_label.setVisible(true);
        filet_label.setVisible(true);
        label_information.setVisible(true);
        pichet_label.setVisible(true);
        coquillage_label.setVisible(true);
    }

    /**
     * méthode pour rendre les outils invisible
     */
    public void setOutilsInvisible() {
        lblPipette.setVisible(false);
        ciseau_label.setVisible(false);
        filet_label.setVisible(false);
        label_information.setVisible(false);
        pichet_label.setVisible(false);
        coquillage_label.setVisible(false);
    }

    /**
     * méthode pour rendre le cooldown du coquillage visible
     */
    public static void setCooldownVisibleC() {
        coquillage_label.setIcon(new ImageIcon("res/outils/coquillage_cd.png"));
    }

    /**
     * méthode pour rendre le cooldown du coquillage invisible
     */
    public static void setCooldownInvisibleC() {
        coquillage.setIcon(coquillage_label);
    }

    /**
     * méthode pour rendre le cooldown du pichet visible
     */
    public static void setCooldownVisibleP() {
        pichet_label.setIcon(new ImageIcon("res/outils/pichet_cd.png"));
    }

    /**
     * méthode pour rendre le cooldown du pichet invisible
     */
    public static void setCooldownInvisibleP() {
        pichet.setIcon(pichet_label);
    }

    /**
     * méthode pour set le curseur de la souris
     */
    public void basicCursor() {
        tetra_curseur = new ImageIcon("res/icone_souris/tetra_cursor.png");
        panelAqua.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                tetra_curseur.getImage(),
                new Point(0, 0), "custom cursor"));
    }

    /**
     * méthode pour rendre l'application prête à l'utilisation après tutoriel
     */
    public void setEverythingGood() {
        skip_tuto1.setVisible(false);
        skip_tuto2.setVisible(false);
        label_tuto1.setVisible(false);
        label_tuto2.setVisible(false);
        label_tuto3.setVisible(false);
        label_tuto4.setVisible(false);
        label_tuto5.setVisible(false);
        label_tuto6.setVisible(false);
        label_tuto7.setVisible(false);
        label_tuto8.setVisible(false);
        inventaire_fermer.setVisible(true);
        inventaire_ouvert.setVisible(false);
        inventaire_bg.setVisible(false);
        kit_fermer.setVisible(true);
        kit_ouvert.setVisible(false);
        kit_bg.setVisible(false);
        aquarium_kit_ouvert.setVisible(false);
        aquarium_kit_fermer.setVisible(true);
        panelTest.setVisible(false);
        pichet_label.setVisible(true);
        lblPipette.setVisible(true);
        ciseau_label.setVisible(true);
        filet_label.setVisible(true);
        coquillage_label.setVisible(true);
        tabbedPane.setSelectedIndex(0);
        tabbedPane.setEnabledAt(0, true);
        tabbedPane.setEnabledAt(1, true);
        tabbedPane.setEnabledAt(2, true);
        PanelInfo.lblAction.setVisible(true);
        PanelInfo.lblN.setVisible(true);
        PanelInfo.lblH.setVisible(true);
        PanelInfo.lblO.setVisible(true);
        PanelInfo.lblAmmo.setVisible(true);
        PanelInfo.lblNit.setVisible(true);
        PanelInfo.lblNat.setVisible(true);
        PanelInfo.lblScore.setVisible(true);
        PanelInfo.lblDechets.setVisible(true);
        PanelInfo.lblAbsDechets.setVisible(true);
        PanelInfo.progressBar.setVisible(true);
        PanelInfo.lblPH.setVisible(true);
        PanelInfo.lblKH.setVisible(true);
        PanelInfo.lblGH.setVisible(true);
        PanelShop.message.setVisible(true);
    }

    /**
     * @param y
     * @param height
     *               Redéfinit les dimensions du rectangle Eau en fonction des
     *               paramètres spécifiés
     *               Rafraîchit l'affichage de l'eau
     */
    public static void setEauDimensions(int y, int height) {
        GUIMain.rectEau.setBounds((int) GUIMain.rectEau.getX(), y, (int) GUIMain.rectEau.getWidth(), height);
        GUIMain.panelAqua.repaint();
    }

}

// Слава Україні!
