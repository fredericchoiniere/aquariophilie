//Jérémie Caron     itération 1
//Classe qui gère l'inventaire et ses emplacements

package model.jeu;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.image.BufferedImage;

public class Inventaire {

    public static Emplacementinv emp1;
	public static Emplacementinv emp2;
	public static Emplacementinv emp3;
	public static Emplacementinv emp4;
	public static Emplacementinv emp5;
	public static Emplacementinv emp6;
    final Dimension size_icone_inv = new Dimension(80, 80);
    private ArrayList<Emplacementinv> listEmpPleins = new ArrayList<Emplacementinv>(6);

    ImageIcon img_aqua_poi_rouge = new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png");
    public static ImageIcon img_inv_poi_rouge = new ImageIcon(new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

    ImageIcon img_aqua_betta = new ImageIcon("res/poissons/poisson_betta/poisson_droite.png");
    public static ImageIcon img_inv_betta = new ImageIcon(new ImageIcon("res/poissons/poisson_betta/poisson_droite.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));
    
    ImageIcon empty_poi = new ImageIcon("res/poissons/poisson_rouge/poisson_droite.png");
    public static ImageIcon empty_inv = new ImageIcon(new ImageIcon("res/poissons/empty.png").getImage().getScaledInstance(80, 80, Image.SCALE_DEFAULT));

    public Inventaire(JLabel label) {

        // créer les emplacements dans l'inventaire
        emp1 = new Emplacementinv();
        emp1.setBounds(30, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp1.setIcon(img_inv_poi_rouge);
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