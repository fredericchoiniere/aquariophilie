//Jérémie Caron     itération 1
//Jérémie Caron, Frédéric Choinière     itération 2
// Jérémie Caron    itération 3
//Classe pour l'affichage du magasin, pour itération 3

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
    public static JButton poisson_rouge;
    public static JButton poisson_betta;
    public static JButton poisson_tetra;
    public static JButton poisson_neo;
    public static JButton planteBlue;
    public static JButton planteFern;
    public static JButton planteScarlet;
    public static JButton planteErdtree;
    public JLabel rouge, betta, tetra, neo, blue, fern, scarlet, erdtree;
    public static JLabel rabais_rouge;
    public static JLabel rabais_betta;
    public static JLabel rabais_tetra;
    public static JLabel rabais_neo;
    public static JLabel rabais_blue;
    public static JLabel rabais_fern;
    public static JLabel rabais_scarlet;
    public static JLabel rabais_erdtree;
    public static JLabel message;
    public static Dimension shop_dimension = new Dimension(80, 80);
    JLabel label_tutoriel, label_information;

    public PanelShop() {
        setLayout(null);

        // ajout du bouton poisson rouge
        poisson_rouge = new JButton();
        poisson_rouge.setIcon(new ImageIcon("res/poissons/poisson_rouge/in_bag.png"));
        poisson_rouge.setBackground(new Color(53, 109, 127));
        poisson_rouge.setBorderPainted(false);
        poisson_rouge.setBounds(35, 209, shop_dimension.width, shop_dimension.height);
        poisson_rouge.setToolTipText("Prix: " + PoissonRouge.prix + "฿");
        poisson_rouge.addActionListener(this);
        add(poisson_rouge);

        // ajout du bouton poisson betta
        poisson_betta = new JButton();
        poisson_betta.setIcon(new ImageIcon("res/poissons/poisson_betta/in_bag.png"));
        poisson_betta.setBackground(new Color(53, 109, 127));
        poisson_betta.setBorderPainted(false);
        poisson_betta.setBounds(155, 209, shop_dimension.width, shop_dimension.height);
        poisson_betta.setToolTipText("Prix: " + PoissonBetta.prix + "฿");
        poisson_betta.addActionListener(this);
        add(poisson_betta);

        // ajout du bouton poisson tetra
        poisson_tetra = new JButton();
        poisson_tetra.setIcon(new ImageIcon("res/poissons/poisson_tetra/in_bag.png"));
        poisson_tetra.setBackground(new Color(53, 109, 127));
        poisson_tetra.setBorderPainted(false);
        poisson_tetra.setBounds(273, 209, shop_dimension.width, shop_dimension.height);
        poisson_tetra.setToolTipText("Prix: " + PoissonTetra.prix + "฿");
        poisson_tetra.addActionListener(this);
        add(poisson_tetra);

        poisson_neo = new JButton();
        poisson_neo.setIcon(new ImageIcon("res/poissons/poisson_neo/in_bag.png"));
        poisson_neo.setBackground(new Color(53, 109, 127));
        poisson_neo.setBorderPainted(false);
        poisson_neo.setBounds(390, 209, shop_dimension.width, shop_dimension.height);
        poisson_neo.setToolTipText("Prix: " + PoissonNeo.prix + "฿");
        poisson_neo.addActionListener(this);
        add(poisson_neo);

        // ajout du bouton plante bleue
        planteBlue = new JButton();
        planteBlue.setIcon(BlueBlue.icon);
        planteBlue.setBackground(new Color(53, 109, 127));
        planteBlue.setBorderPainted(false);
        planteBlue.setBounds(35, 379, shop_dimension.width, shop_dimension.height);
        planteBlue.setToolTipText("Prix: " + BlueBlue.prix + "฿");
        planteBlue.addActionListener(this);
        add(planteBlue);

        // ajout du bouton plante fern
        planteFern = new JButton();
        planteFern.setIcon(JavaFern.icon);
        planteFern.setBackground(new Color(53, 109, 127));
        planteFern.setBorderPainted(false);
        planteFern.setBounds(155, 379, shop_dimension.width, shop_dimension.height);
        planteFern.setToolTipText("Prix: " + JavaFern.prix + "฿");
        planteFern.addActionListener(this);
        add(planteFern);

        // ajout du bouton plante scarlet
        planteScarlet = new JButton();
        planteScarlet.setIcon(ScarletRot.icon);
        planteScarlet.setBackground(new Color(53, 109, 127));
        planteScarlet.setBorderPainted(false);
        planteScarlet.setBounds(273, 379, shop_dimension.width, shop_dimension.height);
        planteScarlet.setToolTipText("Prix: " + ScarletRot.prix + "฿");
        planteScarlet.addActionListener(this);
        add(planteScarlet);

        // ajout du bouton plante erdtree
        planteErdtree = new JButton();
        planteErdtree.setIcon(Erdtree.icon);
        planteErdtree.setBackground(new Color(53, 109, 127));
        planteErdtree.setBorderPainted(false);
        planteErdtree.setBounds(390, 379, shop_dimension.width, shop_dimension.height);
        planteErdtree.setToolTipText("Prix: " + Erdtree.prix + "฿");
        planteErdtree.addActionListener(this);
        add(planteErdtree);

        // ajout du label pour le tutoriel

        // création des labels pour afficher les prix des poissons
        rouge = new JLabel();
        rouge.setBounds(66, 290, 100, 50);
        rouge.setText(Magasin.prix_rouge + "฿");
        rouge.setFont(new Font("", Font.BOLD, 14));
        rouge.setForeground(new Color(51, 0, 0));
        rouge.setVisible(true);
        add(rouge);

        betta = new JLabel();
        betta.setBounds(180, 290, 100, 50);
        betta.setText(Magasin.prix_betta + "฿");
        betta.setFont(new Font("", Font.BOLD, 14));
        betta.setForeground(new Color(51, 0, 0));
        betta.setVisible(true);
        add(betta);

        tetra = new JLabel();
        tetra.setBounds(300, 290, 100, 50);
        tetra.setText(Magasin.prix_tetra + "฿");
        tetra.setFont(new Font("", Font.BOLD, 14));
        tetra.setForeground(new Color(51, 0, 0));
        tetra.setVisible(true);
        add(tetra);

        neo = new JLabel();
        neo.setBounds(417, 290, 100, 50);
        neo.setText(Magasin.prix_neo + "฿");
        neo.setFont(new Font("", Font.BOLD, 14));
        neo.setForeground(new Color(51, 0, 0));
        neo.setVisible(true);
        add(neo);

        blue = new JLabel();
        blue.setBounds(63, 460, 100, 50);
        blue.setText(Magasin.prix_blue + "฿");
        blue.setFont(new Font("", Font.BOLD, 14));
        blue.setForeground(new Color(51, 0, 0));
        blue.setVisible(true);
        add(blue);

        fern = new JLabel();
        fern.setBounds(180, 460, 100, 50);
        fern.setText(Magasin.prix_java + "฿");
        fern.setFont(new Font("", Font.BOLD, 14));
        fern.setForeground(new Color(51, 0, 0));
        fern.setVisible(true);
        add(fern);

        scarlet = new JLabel();
        scarlet.setBounds(293, 460, 100, 50);
        scarlet.setText(Magasin.prix_scarlet + "฿");
        scarlet.setFont(new Font("", Font.BOLD, 14));
        scarlet.setForeground(new Color(51, 0, 0));
        scarlet.setVisible(true);
        add(scarlet);

        erdtree = new JLabel();
        erdtree.setBounds(415, 460, 100, 50);
        erdtree.setText(Magasin.prix_erdtree + "฿");
        erdtree.setFont(new Font("", Font.BOLD, 14));
        erdtree.setForeground(new Color(51, 0, 0));
        erdtree.setVisible(true);
        add(erdtree);

        // création des labels pour afficher le prix en rabais
        rabais_rouge = new JLabel();
        rabais_rouge.setBounds(678, 462, 100, 50);
        rabais_rouge.setText(Magasin.prix_rouge / 2 + "฿");
        rabais_rouge.setFont(new Font("", Font.BOLD, 16));
        rabais_rouge.setForeground(new Color(51, 0, 0));
        rabais_rouge.setVisible(false);
        add(rabais_rouge);

        rabais_betta = new JLabel();
        rabais_betta.setBounds(675, 462, 100, 50);
        rabais_betta.setText(Magasin.prix_betta / 2 + "฿");
        rabais_betta.setFont(new Font("", Font.BOLD, 16));
        rabais_betta.setForeground(new Color(51, 0, 0));
        rabais_betta.setVisible(false);
        add(rabais_betta);

        rabais_tetra = new JLabel();
        rabais_tetra.setBounds(675, 462, 100, 50);
        rabais_tetra.setText(Magasin.prix_tetra / 2 + "฿");
        rabais_tetra.setFont(new Font("", Font.BOLD, 16));
        rabais_tetra.setForeground(new Color(51, 0, 0));
        rabais_tetra.setVisible(false);
        add(rabais_tetra);

        rabais_neo = new JLabel();
        rabais_neo.setBounds(676, 462, 100, 50);
        rabais_neo.setText(Magasin.prix_neo / 2 + "฿");
        rabais_neo.setFont(new Font("", Font.BOLD, 16));
        rabais_neo.setForeground(new Color(51, 0, 0));
        rabais_neo.setVisible(false);
        add(rabais_neo);

        rabais_blue = new JLabel();
        rabais_blue.setBounds(675, 462, 100, 50);
        rabais_blue.setText(Magasin.prix_blue / 2 + "฿");
        rabais_blue.setFont(new Font("", Font.BOLD, 16));
        rabais_blue.setForeground(new Color(51, 0, 0));
        rabais_blue.setVisible(false);
        add(rabais_blue);

        rabais_fern = new JLabel();
        rabais_fern.setBounds(675, 462, 100, 50);
        rabais_fern.setText(Magasin.prix_java / 2 + "฿");
        rabais_fern.setFont(new Font("", Font.BOLD, 16));
        rabais_fern.setForeground(new Color(51, 0, 0));
        rabais_fern.setVisible(false);
        add(rabais_fern);

        rabais_scarlet = new JLabel();
        rabais_scarlet.setBounds(675, 462, 100, 50);
        rabais_scarlet.setText(Magasin.prix_scarlet / 2 + "฿");
        rabais_scarlet.setFont(new Font("", Font.BOLD, 16));
        rabais_scarlet.setForeground(new Color(51, 0, 0));
        rabais_scarlet.setVisible(false);
        add(rabais_scarlet);

        rabais_erdtree = new JLabel();
        rabais_erdtree.setBounds(670, 462, 100, 50);
        rabais_erdtree.setText(Magasin.prix_erdtree / 2 + "฿");
        rabais_erdtree.setFont(new Font("", Font.BOLD, 16));
        rabais_erdtree.setForeground(new Color(51, 0, 0));
        rabais_erdtree.setVisible(false);
        add(rabais_erdtree);

        message = new JLabel();
        message.setBounds(647, 462, 100, 50);
        message.setText("Rabais au jour 7!");
        message.setFont(new Font("", Font.BOLD, 11));
        message.setForeground(new Color(51, 0, 0));
        message.setVisible(true);
        add(message);
    }
    // actionlistener pour fermer le tutoriel

    /**
     * @param Graphics
     *                 méthode pour paint le background du panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background_shop.png");
        g2D.drawImage(background, 5, 0, this);
    }

    // action listener des labels pour acheter
    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------

    /**
     * @param icon
     * @param type
     * @param poisson
     * @param plante
     *                méthode pour voir dans quel emplacement de l'inventaire l'item
     *                sera placé
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
            case "erdtree":
                GUIMain.listePlantesInv.set(index, new Erdtree());
                GUIMain.listePlantesInv.get(index).setName("erdtree" + i);
                setLabel(index, Erdtree.icon, typePlante);
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
     *          Action listener pour acheter les poissons et les plantes du
     *          panelShop
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == poisson_rouge) {
            if (GUIMain.isSelected6) {
                GUIMain.label_tuto7.setVisible(false);
                GUIMain.tabbedPane.setSelectedIndex(2);
                GUIMain.label_tuto8.setVisible(true);
                GUIMain.isSelected6 = false;
            } else {
                label_tutoriel.setVisible(false);
                if (Magasin.gotMoney("rouge")) {
                    checkCase(Inventaire.img_inv_poi_rouge, "poisson", "rouge", "");
                } else {
                    JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        if (e.getSource() == poisson_betta) {
            if (GUIMain.isSelected6) {
                GUIMain.label_tuto7.setVisible(false);
                GUIMain.tabbedPane.setSelectedIndex(2);
                GUIMain.label_tuto8.setVisible(true);
                GUIMain.isSelected6 = false;
            } else {
                label_tutoriel.setVisible(false);
                if (Magasin.gotMoney("betta")) {
                    checkCase(Inventaire.img_inv_betta, "poisson", "betta", "");
                } else {
                    JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        if (e.getSource() == poisson_tetra) {
            if (GUIMain.isSelected6) {
                GUIMain.label_tuto7.setVisible(false);
                GUIMain.tabbedPane.setSelectedIndex(2);
                GUIMain.label_tuto8.setVisible(true);
                GUIMain.isSelected6 = false;
            } else {
                label_tutoriel.setVisible(false);
                if (Magasin.gotMoney("tetra")) {
                    checkCase(Inventaire.img_inv_tetra, "poisson", "tetra", "");
                } else {
                    JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        if (e.getSource() == poisson_neo) {
            if (GUIMain.isSelected6) {
                GUIMain.label_tuto7.setVisible(false);
                GUIMain.tabbedPane.setSelectedIndex(2);
                GUIMain.label_tuto8.setVisible(true);
                GUIMain.isSelected6 = false;
            } else {
                label_tutoriel.setVisible(false);
                if (Magasin.gotMoney("neo")) {
                    checkCase(Inventaire.img_inv_neo, "poisson", "neo", "");
                } else {
                    JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        if (e.getSource() == planteBlue) {
            label_tutoriel.setVisible(false);
            if (Magasin.gotMoney("blue")) {
                checkCase(Inventaire.img_inv_tetra, "decoration", "", "blue");
            } else {
                JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                        JOptionPane.PLAIN_MESSAGE);
            }
        }
        if (e.getSource() == planteFern) {
            if (GUIMain.isSelected6) {
                GUIMain.label_tuto7.setVisible(false);
                GUIMain.tabbedPane.setSelectedIndex(2);
                GUIMain.label_tuto8.setVisible(true);
                GUIMain.isSelected6 = false;
            } else {
                label_tutoriel.setVisible(false);
                if (Magasin.gotMoney("java")) {
                    checkCase(Inventaire.img_inv_tetra, "decoration", "", "java");
                } else {
                    JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        if (e.getSource() == planteScarlet) {
            if (GUIMain.isSelected6) {
                GUIMain.label_tuto7.setVisible(false);
                GUIMain.tabbedPane.setSelectedIndex(2);
                GUIMain.label_tuto8.setVisible(true);
                GUIMain.isSelected6 = false;
            } else {
                label_tutoriel.setVisible(false);
                if (Magasin.gotMoney("scarlet")) {
                    checkCase(Inventaire.img_inv_tetra, "decoration", "", "scarlet");
                } else {
                    JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
        if (e.getSource() == planteErdtree) {
            if (GUIMain.isSelected6) {
                GUIMain.label_tuto7.setVisible(false);
                GUIMain.tabbedPane.setSelectedIndex(2);
                GUIMain.label_tuto8.setVisible(true);
                GUIMain.isSelected6 = false;
            } else {
                label_tutoriel.setVisible(false);
                if (Magasin.gotMoney("erdtree")) {
                    checkCase(Inventaire.img_inv_tetra, "decoration", "", "erdtree");
                } else {
                    JOptionPane.showMessageDialog(null, "Carte refusée: fonds insuffisants", "Erreur",
                            JOptionPane.PLAIN_MESSAGE);
                }
            }
        }
    }

}
