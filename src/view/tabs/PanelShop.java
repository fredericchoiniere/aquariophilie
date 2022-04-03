//Jérémie Caron     itération 1
//Classe pour l'affichage du magasin, pour itération 2

package view.tabs;

import java.awt.*;
import javax.swing.*;

import model.jeu.Inventaire;
import model.jeu.Magasin;
import model.poissons.PoissonBetta;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;
import view.GUIMain;

import java.awt.event.*;

public class PanelShop extends JPanel implements ActionListener {

    static int i = 1;
    JButton poisson_rouge, poisson_betta, poisson_tetra, planteMario, planteCul;
    Dimension shop_dimension = new Dimension(80, 80);

    public PanelShop() { // Panel pour créer le magasin
        // TODO changer les labels pour des boutons
        setLayout(null);

        poisson_rouge = new JButton();
        poisson_rouge.setIcon(new ImageIcon("res/poissons/poisson_rouge/in_bag.png"));
        poisson_rouge.setBounds(85, 230, shop_dimension.width, shop_dimension.height);
        poisson_rouge.setOpaque(true);

        poisson_rouge.addActionListener(this);

        add(poisson_rouge);

        poisson_betta = new JButton();
        poisson_betta.setIcon(new ImageIcon("res/poissons/poisson_betta/in_bag.png"));
        poisson_betta.setBounds(185, 230, shop_dimension.width, shop_dimension.height);
        poisson_betta.setVisible(true);
        poisson_betta.addActionListener(this);
        add(poisson_betta);

        poisson_tetra = new JButton();
        poisson_tetra.setIcon(new ImageIcon("res/poissons/poisson_tetra/in_bag.png"));
        poisson_tetra.setBounds(285, 230, shop_dimension.width, shop_dimension.height);
        poisson_tetra.setVisible(true);
        poisson_tetra.addActionListener(this);
        add(poisson_tetra);

        planteMario = new JButton();
        planteMario.setIcon(new ImageIcon("res/outils/aquarium_kit/plante_mario.png"));
        planteMario.setBounds(850, 540, shop_dimension.width, shop_dimension.height);
        planteMario.setVisible(true);

        add(planteMario);

        planteCul = new JButton();
        planteCul.setIcon(new ImageIcon("res/outils/aquarium_kit/plante_cul.png"));
        planteCul.setBounds(850, 700, shop_dimension.width, shop_dimension.height);
        planteCul.setVisible(true);
        add(planteCul);

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

    public static void checkCase(ImageIcon icon, String type, String poisson) {

        if (GUIMain.empla1 == "empty") {
            GUIMain.empla1 = type;
            Inventaire.emp1.setIcon(icon);

            // destruction();

            if (type == "poisson") {
                checkFish(poisson, 0);
                GUIMain.poi1 = poisson;
                Magasin.checkPoissonPrix(poisson);
            }

        } else if (GUIMain.empla2 == "empty") {
            GUIMain.empla2 = type;
            Inventaire.emp2.setIcon(icon);

            // destruction();

            if (type == "poisson") {
                checkFish(poisson, 1);
                GUIMain.poi2 = poisson;
                Magasin.checkPoissonPrix(poisson);
            }
        } else if (GUIMain.empla3 == "empty") {
            GUIMain.empla3 = type;
            Inventaire.emp3.setIcon(icon);

            // destruction();
            if (type == "poisson") {
                checkFish(poisson, 2);
                GUIMain.poi3 = poisson;
                Magasin.checkPoissonPrix(poisson);
            }

        } else if (GUIMain.empla4 == "empty") {
            GUIMain.empla4 = type;
            Inventaire.emp4.setIcon(icon);

            // destruction();
            if (type == "poisson") {
                checkFish(poisson, 3);
                GUIMain.poi4 = poisson;
                Magasin.checkPoissonPrix(poisson);
            }

        } else if (GUIMain.empla5 == "empty") {
            GUIMain.empla5 = type;
            Inventaire.emp5.setIcon(icon);

            // destruction();
            if (type == "poisson") {
                checkFish(poisson, 4);
                GUIMain.poi5 = poisson;
                Magasin.checkPoissonPrix(poisson);
            }
        } else if (GUIMain.empla6 == "empty") {
            GUIMain.empla6 = type;
            Inventaire.emp6.setIcon(icon);

            // destruction();
            if (type == "poisson") {
                checkFish(poisson, 5);
                GUIMain.poi6 = poisson;
                Magasin.checkPoissonPrix(poisson);
            }
        } else {
            System.out.println("inventaire plein");
        }
    }

    public static void checkFish(String typePoisson, int index) { // méthode pour vérifier si l'utilisateur a assez
                                                                  // d'argent pour acheter un objet
        switch (typePoisson) {
            case "rouge":
                GUIMain.listePoissonsInv.add(index, new PoissonRouge());
                GUIMain.listePoissonsInv.get(index).setName("rouge" + i);
                i++;
                break;

            case "betta":
                GUIMain.listePoissonsInv.add(index, new PoissonBetta());
                GUIMain.listePoissonsInv.get(index).setName("betta" + i);
                i++;
                break;

            case "tetra":
                GUIMain.listePoissonsInv.add(index, new PoissonTetra());
                GUIMain.listePoissonsInv.get(index).setName("tetra" + i);
                i++;
                break;
            default:
                break;
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == poisson_rouge) {
            if (Magasin.gotMoney("rouge")) {
                checkCase(Inventaire.img_inv_poi_rouge, "poisson", "rouge");
            } else {
                System.out.println("Pas assez d'argent");
            }
        }

        if (e.getSource() == poisson_betta) {
            if (Magasin.gotMoney("betta")) {
                checkCase(Inventaire.img_inv_betta, "poisson", "betta");
            } else {
                System.out.println("pas assez d'argent");
            }

        }

        if (e.getSource() == poisson_tetra) {
            if (Magasin.gotMoney("tetra")) {
                checkCase(Inventaire.img_inv_tetra, "poisson", "tetra");
            } else {
                System.out.println("pas assez d'argent");
            }

        }

        if (e.getSource() == planteMario) {
            checkCase(Inventaire.img_temp, "decoration", "");
        }

        if (e.getSource() == planteCul) {
            checkCase(Inventaire.img_java_fern, "decoration", "");
        }
    }

}
