//Jérémie Caron     itération 1
//Classe pour l'affichage du magasin, pour itération 2

package view.tabs;

import java.awt.*;
import javax.swing.*;

import model.jeu.Inventaire;
import model.poissons.PoissonBetta;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;
import view.GUIMain;

import java.awt.event.*;

public class PanelShop extends JPanel implements ActionListener {

    JButton boutonRouge, boutonBetta, boutonTetra, boutonMario, boutonCul;
    static int i = 1;
    JLabel poisson_rouge, poisson_betta, poisson_tetra, planteMario, planteCul;
    Dimension shop_dimension = new Dimension(80, 80);

    public PanelShop() { // Panel pour créer le magasin

        setLayout(null);

       
        poisson_rouge = new JLabel();
        poisson_rouge.setIcon(new ImageIcon("res/outils/aquarium_kit/poisson_rouge.png"));
        poisson_rouge.setBounds(850, 60, shop_dimension.width, shop_dimension.height);
        add(poisson_rouge);
        poisson_rouge.setVisible(false);

        poisson_betta = new JLabel();
        poisson_betta.setIcon(new ImageIcon("res/outils/aquarium_kit/poisson_betta.png"));
        poisson_betta.setBounds(850, 220, shop_dimension.width, shop_dimension.height);
        add(poisson_betta);

        poisson_tetra = new JLabel();
        poisson_tetra.setIcon(new ImageIcon("res/outils/aquarium_kit/poisson_tetra.png"));
        poisson_tetra.setBounds(850, 380, shop_dimension.width, shop_dimension.height);
        add(poisson_tetra);

        planteMario = new JLabel();
        planteMario.setIcon(new ImageIcon("res/outils/aquarium_kit/plante_mario.png"));
        planteMario.setBounds(850, 540, shop_dimension.width, shop_dimension.height);
        add(planteMario);

        planteCul = new JLabel();
        planteCul.setIcon(new ImageIcon("res/outils/aquarium_kit/plante_cul.png"));
        planteCul.setBounds(850, 700, shop_dimension.width, shop_dimension.height);
        add(planteCul);

    }

    public void paintComponent(Graphics g) { // méthode paint
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // créer le background pour l'onglet Aquarium
        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background_shop.png");
        g2D.drawImage(background, 5, 5, this);

        // action listener des labels pour acheter
        // -------------------------------------------------------------------------------------------------------------------------------------------------------------------

        poisson_rouge.addMouseListener(new MouseAdapter() { // pour le poisson rouge

            @Override
            public void mouseClicked(MouseEvent e) {
                checkCase(Inventaire.img_inv_poi_rouge, "poisson", "rouge");
            }
        });

        poisson_betta.addMouseListener(new MouseAdapter() { // pour le poisson betta

            @Override
            public void mouseClicked(MouseEvent e) {
                checkCase(Inventaire.img_inv_betta, "poisson", "betta");
            }
        });

        poisson_tetra.addMouseListener(new MouseAdapter() { // pour le poisson tetra

            @Override
            public void mouseClicked(MouseEvent e) {
                checkCase(Inventaire.img_inv_tetra, "poisson", "tetra");
            }
        });

        planteMario.addMouseListener(new MouseAdapter() { // pour la plante mario

            @Override
            public void mouseClicked(MouseEvent e) {
                checkCase(Inventaire.img_temp, "decoration", "");
            }
        });

        planteCul.addMouseListener(new MouseAdapter() { // pour la plante cul

            @Override
            public void mouseClicked(MouseEvent e) {
                checkCase(Inventaire.img_java_fern, "decoration", "");
            }
        });

    }

    public static void checkCase(ImageIcon icon, String type, String poisson) { // méthode pour vérifier si l'utilisateur a assez d'argent pour acheter un objet
        if (GUIMain.empla1 == "empty") {
            GUIMain.empla1 = type;
            Inventaire.emp1.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 0);
            }
        } else if (GUIMain.empla2 == "empty") {
            GUIMain.empla2 = type;
            Inventaire.emp2.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 1);
            }
        } else if (GUIMain.empla3 == "empty") {
            GUIMain.empla3 = type;
            Inventaire.emp3.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 2);
            }

        } else if (GUIMain.empla4 == "empty") {
            GUIMain.empla4 = type;
            Inventaire.emp4.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 3);
            }

        } else if (GUIMain.empla5 == "empty") {
            GUIMain.empla5 = type;
            Inventaire.emp5.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 4);
            }
        } else if (GUIMain.empla6 == "empty") {
            GUIMain.empla6 = type;
            Inventaire.emp6.setIcon(icon);
            if (type == "poisson") {
                checkFish(poisson, 5);
            }
        } else {
            System.out.println("inventaire plein");
        }
    }

    public static void checkFish(String typePoisson, int index) { // méthode pour vérifier si l'utilisateur a assez d'argent pour acheter un objet
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
        // TODO Auto-generated method stub
        
    }

}
