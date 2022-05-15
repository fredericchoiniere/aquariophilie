// Itération 1: Jérémie Caron
// Itération 2: Jérémie Caron
// Itération 3: Jérémie Caron

//Classe qui gère l'inventaire et ses emplacements

package view.jeu;

import java.awt.*;
import javax.swing.*;

import model.poissons.Poisson;

public class Inventaire {

        // attributs de la classe
        public static Emplacementinv emp1;
        public static Emplacementinv emp2;
        public static Emplacementinv emp3;
        public static Emplacementinv emp4;
        public static Emplacementinv emp5;
        public static Emplacementinv emp6;

        final Dimension size_icone_inv = new Dimension(80, 80);

        Poisson poisson_default = new Poisson();

        // création des images des poissons et des plantes
        ImageIcon img_aqua_poi_rouge = new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png");
        public static ImageIcon img_inv_poi_rouge = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_rouge/in_bag.png").getImage().getScaledInstance(80,
                                        80,
                                        Image.SCALE_DEFAULT));
        public static ImageIcon img_rouge_aqua = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png").getImage().getScaledInstance(70,
                                        70,
                                        Image.SCALE_DEFAULT));

        ImageIcon img_aqua_betta = new ImageIcon("res/poissons/poisson_betta/poisson_droite.png");
        public static ImageIcon img_inv_betta = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_betta/in_bag.png")
                                        .getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        public static ImageIcon img_betta_aqua = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_betta/poisson_droite.png").getImage().getScaledInstance(55,
                                        55,
                                        Image.SCALE_DEFAULT));

        ImageIcon img_aqua_tetra = new ImageIcon("res/poissons/poisson_tetra/poisson_gauche.png");
        public static ImageIcon img_inv_tetra = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_tetra/in_bag.png")
                                        .getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
        public static ImageIcon img_tetra_aqua = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_tetra/poisson_droite.png").getImage().getScaledInstance(55,
                                        55,
                                        Image.SCALE_DEFAULT));

        public static ImageIcon img_inv_neo = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_neo/in_bag.png").getImage().getScaledInstance(80,
                                        80,
                                        Image.SCALE_DEFAULT));;
        public static ImageIcon img_neo_aqua = new ImageIcon(
                        new ImageIcon("res/poissons/poisson_neo/aqua_img.png").getImage().getScaledInstance(55,
                                        55,
                                        Image.SCALE_DEFAULT));

        public static ImageIcon java_fern = new ImageIcon("res/background/decorations/java_fern.png");
        public static ImageIcon blue_blue = new ImageIcon("res/background/decorations/blue_blue.png");
        public static ImageIcon scarlet_rot = new ImageIcon("res/background/decorations/scarlet_rot.png");
        public static ImageIcon img_temp = new ImageIcon("res/background/decorations/planteTemp.png");
        ImageIcon empty_poi = new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png");
        public static ImageIcon empty_inv = new ImageIcon(
                        new ImageIcon("res/poissons/empty.png").getImage().getScaledInstance(80, 80,
                                        Image.SCALE_DEFAULT));

        public Inventaire(JLabel label) {

                // ajout de l'emplacement 1
                emp1 = new Emplacementinv();
                emp1.setBounds(30, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp1.setIcon(empty_inv);
                label.add(emp1);

                // ajout de l'emplacement 2
                emp2 = new Emplacementinv();
                emp2.setBounds(140, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp2.setIcon(empty_inv);
                label.add(emp2);

                // ajout de l'emplacement 3
                emp3 = new Emplacementinv();
                emp3.setBounds(30, 196, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp3.setIcon(empty_inv);
                label.add(emp3);

                // ajout de l'emplacement 4
                emp4 = new Emplacementinv();
                emp4.setBounds(140, 196, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp4.setIcon(empty_inv);
                label.add(emp4);

                // ajout de l'emplacement 5
                emp5 = new Emplacementinv();
                emp5.setBounds(30, 362, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
                emp5.setIcon(empty_inv);
                label.add(emp5);

                // ajout de l'emplacement 6
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

// Слава Україні!