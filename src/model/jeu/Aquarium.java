// Itération 1: Jérémie Caron
// Itération 2: Jérémie Caron
// Itération 3: Jérémie Caron

// Classe qui gère l'aquarium et ses emplacements

package model.jeu;

import java.awt.*;
import javax.swing.*;

public class Aquarium {

    // attributs de la classe
    public Emplacementaq emp1, emp2, emp3, aqua1, aqua2, aqua3, aqua4, aqua5, aqua6;

    final Dimension size_icone_inv = new Dimension(80, 80);
    final Dimension size_icone_poi = new Dimension(70, 70);

    public static ImageIcon empty_poi = new ImageIcon("res/poissons/empty.png");

    

    public Aquarium(JPanel panel) {

        // création de l'emplacement 1
        emp1 = new Emplacementaq();
        emp1.setBounds(353, 388, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp1.setIcon(null);
        panel.add(emp1);

        // création de l'emplacement 2
        emp2 = new Emplacementaq();
        emp2.setBounds(459, 388, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp2.setIcon(null);
        panel.add(emp2);

        // création de l'emplacement 3
        emp3 = new Emplacementaq();
        emp3.setBounds(567, 388, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp3.setIcon(null);
        panel.add(emp3);

        // création de l'emplacement 4
        aqua1 = new Emplacementaq();
        aqua1.setBounds(360, 301, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua1.setIcon(null);
        panel.add(aqua1);

        // création de l'emplacement 5
        aqua2 = new Emplacementaq();
        aqua2.setBounds(469, 301, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua2.setIcon(null);
        panel.add(aqua2);

        // création de l'emplacement 6
        aqua3 = new Emplacementaq();
        aqua3.setBounds(579, 301, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua3.setIcon(null);
        panel.add(aqua3);

        // création de l'emplacement 7
        aqua4 = new Emplacementaq();
        aqua4.setBounds(360, 397, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua4.setIcon(null);
        panel.add(aqua4);

        // création de l'emplacement 8
        aqua5 = new Emplacementaq();
        aqua5.setBounds(469, 397, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua5.setIcon(null);
        panel.add(aqua5);

        // création de l'emplacement 9
        aqua6 = new Emplacementaq();
        aqua6.setBounds(579, 397, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua6.setIcon(null);
        panel.add(aqua6);
    }

    /**
     * @param etat
     *             permet de set les label visible ou invisible
     */
    public void setVisible(boolean etat) {
        emp1.setVisible(etat);
        emp2.setVisible(etat);
        emp3.setVisible(etat);
        aqua1.setVisible(etat);
        aqua2.setVisible(etat);
        aqua3.setVisible(etat);
        aqua4.setVisible(etat);
        aqua5.setVisible(etat);
        aqua6.setVisible(etat);
    }
}

// Слава Україні!