//Jérémie Caron     itération 1
//Jérémie Caron     itération 2
//Classe qui gère l'inventaire et ses emplacements

package model.jeu;

import java.util.*;
import java.awt.*;
import javax.swing.*;

import model.poissons.Poisson;
import model.poissons.PoissonRouge;
import view.GUIMain;

import java.awt.image.BufferedImage;

public class Inventaire {

        public static Emplacementinv emp1;
        public static Emplacementinv emp2;
        public static Emplacementinv emp3;
        public static Emplacementinv emp4;
        public static Emplacementinv emp5;
        public static Emplacementinv emp6;
        final Dimension size_icone_inv = new Dimension(80, 80);
        private ArrayList<Emplacementinv> listEmpPleins = new ArrayList<Emplacementinv>(69);

        Poisson poisson_default = new Poisson();

        


        ImageIcon img_aqua_poi_rouge = new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png");
        public static ImageIcon img_inv_poi_rouge = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_rouge/in_bag.png").getImage().getScaledInstance(80,
                                        80,
                                        Image.SCALE_DEFAULT));

        ImageIcon img_aqua_betta = new ImageIcon("res/poissons/poisson_betta/poisson_droite.png");
        public static ImageIcon img_inv_betta = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_betta/in_bag.png")
                                        .getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        ImageIcon img_aqua_tetra = new ImageIcon("res/poissons/poisson_tetra/poisson_gauche.png");
        public static ImageIcon img_inv_tetra = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_tetra/in_bag.png")
                                        .getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

        public static ImageIcon java_fern = new ImageIcon("res/background/decorations/java_fern.png");
        public static ImageIcon blue_blue = new ImageIcon("res/background/decorations/blue_blue.png");
        public static ImageIcon scarlet_rot = new ImageIcon("res/background/decorations/scarlet_rot.png");

        public static ImageIcon img_temp = new ImageIcon("res/background/decorations/planteTemp.png");

        ImageIcon empty_poi = new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png");
        public static ImageIcon empty_inv = new ImageIcon(
                        new ImageIcon("res/poissons/empty.png").getImage().getScaledInstance(80, 80,
                                        Image.SCALE_DEFAULT));

        public Inventaire(JLabel label) {

                // créer les emplacements dans l'inventaire
                emp1 = new Emplacementinv();
                emp1.setBounds(30, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
               /*  PoissonRouge poisson_rouge = new PoissonRouge();
                GUIMain.listePoissonsInv.add(poisson_rouge); */

               /*  GUIMain.listePoissonsInv.add(0, new PoissonRouge());
                GUIMain.listePoissonsInv.get(0).setName("rouge" + 0); */

                emp1.setIcon(empty_inv);
                label.add(emp1);

                emp2 = new Emplacementinv();
                emp2.setBounds(140, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp2.setIcon(empty_inv);
                label.add(emp2);

                emp3 = new Emplacementinv();
                emp3.setBounds(30, 196, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp3.setIcon(empty_inv);
                label.add(emp3);

                emp4 = new Emplacementinv();
                emp4.setBounds(140, 196, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp4.setIcon(empty_inv);
                label.add(emp4);

                emp5 = new Emplacementinv();
                emp5.setBounds(30, 362, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp5.setIcon(empty_inv);
                label.add(emp5);

                emp6 = new Emplacementinv();
                emp6.setBounds(140, 362, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp6.setIcon(empty_inv);
                label.add(emp6);
        }

        /**
         * @param etat
         *             permet de set les label visible ou invisible
         */
        public void setVisible(boolean etat) {
                emp1.setVisible(etat);
                emp2.setVisible(etat);
                emp3.setVisible(etat);
                emp4.setVisible(etat);
                emp5.setVisible(etat);
                emp6.setVisible(etat);
        }

}