//Jérémie Caron     itération 1
//Jérémie Caron, Frédéric Choinière     itération 2
//Classe pour l'affichage du magasin, pour itération 2

package view.tabs;

import java.awt.*;
import javax.swing.*;

import model.jeu.Inventaire;
import model.jeu.Magasin;
import model.plantes.BlueBlue;
import model.plantes.JavaFern;
import model.plantes.ScarletRot;
import model.poissons.Poisson;
import model.poissons.PoissonBetta;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;
import view.GUIMain;

import java.awt.event.*;

public class PanelShop extends JPanel implements ActionListener {

    static int i = 1;
    JButton poisson_rouge, poisson_betta, poisson_tetra, planteBlue, planteFern, planteScarlet;
    Dimension shop_dimension = new Dimension(80, 80);

    public PanelShop() { // Panel pour créer le magasin
        setLayout(null);

        poisson_rouge = new JButton();
        poisson_rouge.setIcon(new ImageIcon("res/poissons/poisson_rouge/in_bag.png"));
        poisson_rouge.setBounds(85, 230, shop_dimension.width, shop_dimension.height);
        //poisson_rouge.setOpaque(true);
        poisson_rouge.setToolTipText("Prix: " + PoissonRouge.prix + "₴");
        poisson_rouge.addActionListener(this);

        add(poisson_rouge);

        poisson_betta = new JButton();
        poisson_betta.setIcon(new ImageIcon("res/poissons/poisson_betta/in_bag.png"));
        poisson_betta.setBounds(185, 230, shop_dimension.width, shop_dimension.height);
        poisson_betta.setToolTipText("Prix: " + PoissonBetta.prix + "₴");
        poisson_betta.addActionListener(this);
        add(poisson_betta);

        poisson_tetra = new JButton();
        poisson_tetra.setIcon(new ImageIcon("res/poissons/poisson_tetra/in_bag.png"));
        poisson_tetra.setBounds(285, 230, shop_dimension.width, shop_dimension.height);
        poisson_tetra.setToolTipText("Prix: " + PoissonTetra.prix + "₴");
        poisson_tetra.addActionListener(this);
        add(poisson_tetra);

        planteBlue = new JButton();
        planteBlue.setIcon(BlueBlue.icon);
        planteBlue.setBounds(85, 390, shop_dimension.width, shop_dimension.height);
        planteBlue.setToolTipText("Prix: " + BlueBlue.prix + "₴");
        planteBlue.addActionListener(this);
        add(planteBlue);

        planteFern = new JButton();
        planteFern.setIcon(JavaFern.icon);
        planteFern.setBounds(185, 390, shop_dimension.width, shop_dimension.height);
        planteFern.setToolTipText("Prix: " + JavaFern.prix + "₴");
        planteFern.addActionListener(this);
        add(planteFern);

        planteScarlet = new JButton();
        planteScarlet.setIcon(ScarletRot.icon);
        planteScarlet.setBounds(285, 390, shop_dimension.width, shop_dimension.height);
        planteScarlet.setToolTipText("Prix: " + ScarletRot.prix + "₴");
        planteScarlet.addActionListener(this);
        add(planteScarlet);

    }

    public void paintComponent(Graphics g) { // méthode paint
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // créer le background pour l'onglet Aquarium
        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background_shop.png");
        g2D.drawImage(background, 5, 5, this);
    }

    // action listener des labels pour acheter
    // -------------------------------------------------------------------------------------------------------------------------------------------------------------------

    public static void checkCase(ImageIcon icon, String type, String poisson, String plante) {

        if (GUIMain.empla1 == "empty") {
            GUIMain.empla1 = type;
            Inventaire.emp1.setIcon(icon);

            // destruction();

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

            // destruction();

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

            // destruction();
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

            // destruction();
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

            // destruction();
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

            // destruction();
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
            System.out.println("inventaire plein");
        }
    }

    public static void checkFish(String typePoisson, int index) { // méthode pour vérifier si l'utilisateur a assez
                                                                  // d'argent pour acheter un objet
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
            default:
                break;
        }
    }

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

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == poisson_rouge) {
            if (Magasin.gotMoney("rouge")) {
                checkCase(Inventaire.img_inv_poi_rouge, "poisson", "rouge", "");
            } else {
                System.out.println("Pas assez d'argent");
            }
        }

        if (e.getSource() == poisson_betta) {
            if (Magasin.gotMoney("betta")) {
                checkCase(Inventaire.img_inv_betta, "poisson", "betta", "");
            } else {
                System.out.println("pas assez d'argent");
            }

        }

        if (e.getSource() == poisson_tetra) {
            if (Magasin.gotMoney("tetra")) {
                checkCase(Inventaire.img_inv_tetra, "poisson", "tetra", "");
            } else {
                System.out.println("pas assez d'argent");
            }

        }

        if (e.getSource() == planteBlue) {
            if (Magasin.gotMoney("blue")) {
                checkCase(Inventaire.img_inv_tetra, "decoration", "", "blue");
            } else {
                System.out.println("pas assez d'argent");
            }

        }

        if (e.getSource() == planteFern) {
            if (Magasin.gotMoney("java")) {
                checkCase(Inventaire.img_inv_tetra, "decoration", "", "java");
            } else {
                System.out.println("pas assez d'argent");
            }

        }

        if (e.getSource() == planteScarlet) {
            if (Magasin.gotMoney("scarlet")) {
                checkCase(Inventaire.img_inv_tetra, "decoration", "", "scarlet");
            } else {
                System.out.println("pas assez d'argent");
            }

        }



    }

}
