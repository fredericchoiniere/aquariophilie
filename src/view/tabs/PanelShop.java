//Jérémie Caron     itération 1
//Jérémie Caron, Frédéric Choinière     itération 2
//Classe pour l'affichage du magasin, pour itération 2

package view.tabs;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import model.jeu.*;
import model.plantes.*;
import model.poissons.*;
import view.GUIMain;

public class PanelShop extends JPanel implements ActionListener {

    // Attributs de la classe
    static int i = 1;
    JButton poisson_rouge, poisson_betta, poisson_tetra, poisson_neo, planteBlue, planteFern, planteScarlet;
    Dimension shop_dimension = new Dimension(80, 80);
    JLabel label_tutoriel, label_information;

    public PanelShop() {
        setLayout(null);

        // ajout du bouton poisson rouge
        poisson_rouge = new JButton();
        poisson_rouge.setIcon(new ImageIcon("res/poissons/poisson_rouge/in_bag.png"));
        poisson_rouge.setBackground(new Color(53, 109, 127));
        poisson_rouge.setBorderPainted(false);
        poisson_rouge.setBounds(35, 214, shop_dimension.width, shop_dimension.height);
        poisson_rouge.setToolTipText("Prix: " + PoissonRouge.prix + "₴");
        poisson_rouge.addActionListener(this);
        add(poisson_rouge);

        // ajout du bouton poisson betta
        poisson_betta = new JButton();
        poisson_betta.setIcon(new ImageIcon("res/poissons/poisson_betta/in_bag.png"));
        poisson_betta.setBackground(new Color(53, 109, 127));
        poisson_betta.setBorderPainted(false);
        poisson_betta.setBounds(135, 214, shop_dimension.width, shop_dimension.height);
        poisson_betta.setToolTipText("Prix: " + PoissonBetta.prix + "₴");
        poisson_betta.addActionListener(this);
        add(poisson_betta);

        // ajout du bouton poisson tetra
        poisson_tetra = new JButton();
        poisson_tetra.setIcon(new ImageIcon("res/poissons/poisson_tetra/in_bag.png"));
        poisson_tetra.setBackground(new Color(53, 109, 127));
        poisson_tetra.setBorderPainted(false);
        poisson_tetra.setBounds(235, 214, shop_dimension.width, shop_dimension.height);
        poisson_tetra.setToolTipText("Prix: " + PoissonTetra.prix + "₴");
        poisson_tetra.addActionListener(this);
        add(poisson_tetra);

        poisson_neo = new JButton();
        poisson_neo.setIcon(new ImageIcon("res/poissons/poisson_neo/in_bag.png"));
        poisson_neo.setBackground(new Color(53, 109, 127));
        poisson_neo.setBorderPainted(false);
        poisson_neo.setBounds(335, 214, shop_dimension.width, shop_dimension.height);
        poisson_neo.setToolTipText("Prix: " + PoissonNeo.prix + "₴");
        poisson_neo.addActionListener(this);
        add(poisson_neo);

        // ajout du bouton plante bleue
        planteBlue = new JButton();
        planteBlue.setIcon(BlueBlue.icon);
        planteBlue.setBackground(new Color(53, 109, 127));
        planteBlue.setBorderPainted(false);
        planteBlue.setBounds(35, 384, shop_dimension.width, shop_dimension.height);
        planteBlue.setToolTipText("Prix: " + BlueBlue.prix + "₴");
        planteBlue.addActionListener(this);
        add(planteBlue);

        // ajout du bouton plante fern
        planteFern = new JButton();
        planteFern.setIcon(JavaFern.icon);
        planteFern.setBackground(new Color(53, 109, 127));
        planteFern.setBorderPainted(false);
        planteFern.setBounds(135, 384, shop_dimension.width, shop_dimension.height);
        planteFern.setToolTipText("Prix: " + JavaFern.prix + "₴");
        planteFern.addActionListener(this);
        add(planteFern);

        // ajout du bouton plante scarlet
        planteScarlet = new JButton();
        planteScarlet.setIcon(ScarletRot.icon);
        planteScarlet.setBackground(new Color(53, 109, 127));
        planteScarlet.setBorderPainted(false);
        planteScarlet.setBounds(235, 384, shop_dimension.width, shop_dimension.height);
        planteScarlet.setToolTipText("Prix: " + ScarletRot.prix + "₴");
        planteScarlet.addActionListener(this);
        add(planteScarlet);

        // ajout du label pour le tutoriel
        label_tutoriel = new JLabel();
        label_tutoriel.setBounds(0, 0, 1000, 700);
        label_tutoriel.setIcon(new ImageIcon("res/background/tutoriel_shop.png"));
        label_tutoriel.setVisible(true);
        add(label_tutoriel);

        // ajout du label pour information
        label_information = new JLabel();
        label_information.setBounds(965, 5, 30, 30);
        label_information.setIcon(new ImageIcon("res/background/informations.png"));
        label_information.setVisible(true);
        add(label_information);

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
            }
        });
    }

    /**
     * @param Graphics
     *                 méthode pour paint le background du panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background_shop.png");
        g2D.drawImage(background, 5, 5, this);
    }

    // action listener des labels pour acheter
    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * @param icon
     * @param type
     * @param poisson
     * @param plante
     * méthode pour voir dans quel emplacement de l'inventaire l'item sera placé
     */
    public static void checkCase(ImageIcon icon, String type, String poisson, String plante) {
        if (GUIMain.empla1 == "empty") {
            GUIMain.empla1 = type;
            Inventaire.emp1.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 0);
                GUIMain.poi1 = poisson;
                Poisson.updateToolTip(Inventaire.emp1, poisson);
                Magasin.checkPoissonPrix(poisson);
            }
            if (type == "decoration") {
                checkPlant(plante, 0);
                Magasin.checkPlantePrix(plante);
            }
        } else if (GUIMain.empla2 == "empty") {
            GUIMain.empla2 = type;
            Inventaire.emp2.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 1);
                GUIMain.poi2 = poisson;
                Poisson.updateToolTip(Inventaire.emp2, poisson);
                Magasin.checkPoissonPrix(poisson);
            }
            if (type == "decoration") {
                checkPlant(plante, 1);
                Magasin.checkPlantePrix(plante);
            }
        } else if (GUIMain.empla3 == "empty") {
            GUIMain.empla3 = type;
            Inventaire.emp3.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 2);
                GUIMain.poi3 = poisson;
                Poisson.updateToolTip(Inventaire.emp3, poisson);
                Magasin.checkPoissonPrix(poisson);
            }
            if (type == "decoration") {
                checkPlant(plante, 2);
                Magasin.checkPlantePrix(plante);
            }
        } else if (GUIMain.empla4 == "empty") {
            GUIMain.empla4 = type;
            Inventaire.emp4.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 3);
                GUIMain.poi4 = poisson;
                Poisson.updateToolTip(Inventaire.emp4, poisson);
                Magasin.checkPoissonPrix(poisson);
            }
            if (type == "decoration") {
                checkPlant(plante, 3);
                Magasin.checkPlantePrix(plante);
            }
        } else if (GUIMain.empla5 == "empty") {
            GUIMain.empla5 = type;
            Inventaire.emp5.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 4);
                GUIMain.poi5 = poisson;
                Poisson.updateToolTip(Inventaire.emp5, poisson);
                Magasin.checkPoissonPrix(poisson);
            }
            if (type == "decoration") {
                checkPlant(plante, 4);
                Magasin.checkPlantePrix(plante);
            }
        } else if (GUIMain.empla6 == "empty") {
            GUIMain.empla6 = type;
            Inventaire.emp6.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 5);
                GUIMain.poi6 = poisson;
                Poisson.updateToolTip(Inventaire.emp6, poisson);
                Magasin.checkPoissonPrix(poisson);
            }
            if (type == "decoration") {
                checkPlant(plante, 5);
                Magasin.checkPlantePrix(plante);
            }
        } else {
            System.out.println("Inventaire rempli");
        }
    }

    /**
     * @param typePoisson
     * @param index
     *                    méthode pour voir quel poisson ajouter à l'inventaire
     */
    public static void checkFish(String typePoisson, int index) { 
        switch (typePoisson) {
            case "rouge":
                GUIMain.listePoissonsInv.set(index, new PoissonRouge());
                GUIMain.listePoissonsInv.get(index).setName("rouge" + i);
                i++;
                break;
            case "betta":
                GUIMain.listePoissonsInv.set(index, new PoissonBetta());
                GUIMain.listePoissonsInv.get(index).setName("betta" + i);
                i++;
                break;
            case "tetra":
                GUIMain.listePoissonsInv.set(index, new PoissonTetra());
                GUIMain.listePoissonsInv.get(index).setName("tetra" + i);
                i++;
                break;
            case "neo":
                GUIMain.listePoissonsInv.set(index, new PoissonNeo());
                GUIMain.listePoissonsInv.get(index).setName("neo" + i);
                i++;
                break;
            default:
                break;
        }
    }

    /**
     * @param typePlante
     * @param index
     *                   méthode pour voir quel plante ajouter à l'inventaire
     */
    public static void checkPlant(String typePlante, int index) {
        switch (typePlante) {
            case "java":
                GUIMain.listePlantesInv.set(index, new JavaFern());
                GUIMain.listePlantesInv.get(index).setName("java" + i);
                setLabel(index, JavaFern.icon, typePlante);
                setName(index, typePlante);
                i++;
                break;
            case "blue":
                GUIMain.listePlantesInv.set(index, new BlueBlue());
                GUIMain.listePlantesInv.get(index).setName("blue" + i);
                setLabel(index, BlueBlue.icon, typePlante);
                setName(index, typePlante);
                i++;
                break;
            case "scarlet":
                GUIMain.listePlantesInv.set(index, new ScarletRot());
                GUIMain.listePlantesInv.get(index).setName("scarlet" + i);
                setLabel(index, ScarletRot.icon, typePlante);
                setName(index, typePlante);
                i++;
                break;
            default:
                break;
        }

    }

    /**
     * @param index
     * @param icon
     * @param typePlante
     *                   méthode pour mettre l'icone dans l'inventaire selon l'index
     */
    public static void setLabel(int index, ImageIcon icon, String typePlante) {
        switch (index) {
            case 0:
                Inventaire.emp1.setIcon(icon);
                GUIMain.pla1 = typePlante;
                break;
            case 1:
                Inventaire.emp2.setIcon(icon);
                GUIMain.pla2 = typePlante;
                break;
            case 2:
                Inventaire.emp3.setIcon(icon);
                GUIMain.pla3 = typePlante;
                break;
            case 3:
                Inventaire.emp4.setIcon(icon);
                GUIMain.pla4 = typePlante;
                break;
            case 4:
                Inventaire.emp5.setIcon(icon);
                GUIMain.pla5 = typePlante;
                break;
            case 5:
                Inventaire.emp6.setIcon(icon);
                GUIMain.pla6 = typePlante;
                break;
            default:
                break;
        }
    }

    /**
     * @param index
     * @param typePlante
     *                   méthode pour donner le bon nom à la bonne variable
     */
    public static void setName(int index, String typePlante) {
        switch (index) {
            case 0:
                GUIMain.pla1 = typePlante;
                break;
            case 1:
                GUIMain.pla2 = typePlante;
                break;
            case 2:
                GUIMain.pla3 = typePlante;
                break;
            case 3:
                GUIMain.pla4 = typePlante;
                break;
            case 4:
                GUIMain.pla5 = typePlante;
                break;
            case 5:
                GUIMain.pla6 = typePlante;
                break;
            default:
                break;
        }
    }

    /**
     * @param e
     *          Action listener pour acheter les poissons et les plantes du panelShop
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == poisson_rouge) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("rouge")) {
                checkCase(Inventaire.img_inv_poi_rouge, "poisson", "rouge", "");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == poisson_betta) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("betta")) {
                checkCase(Inventaire.img_inv_betta, "poisson", "betta", "");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == poisson_tetra) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("tetra")) {
                checkCase(Inventaire.img_inv_tetra, "poisson", "tetra", "");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == poisson_neo) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("neo")) {
                checkCase(Inventaire.img_inv_neo, "poisson", "neo", "");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == planteBlue) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("blue")) {
                checkCase(Inventaire.img_inv_tetra, "decoration", "", "blue");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == planteFern) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("java")) {
                checkCase(Inventaire.img_inv_tetra, "decoration", "", "java");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == planteScarlet) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("scarlet")) {
                checkCase(Inventaire.img_inv_tetra, "decoration", "", "scarlet");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur", JOptionPane.PLAIN_MESSAGE);
            }
        }
    }


    
}
