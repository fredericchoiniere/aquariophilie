//Jérémie Caron     itération 1
//Classe qui gère l'aquarium et ses emplacements

package model.jeu;
import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Aquarium {

    public Emplacementaq emp1, emp2, emp3, aqua1, aqua2, aqua3, aqua4, aqua5, aqua6;
    final Dimension size_icone_inv = new Dimension(80, 80);
    final Dimension size_icone_poi = new Dimension(70, 70);
    private ArrayList<Emplacementaq> listEmpPleins = new ArrayList<Emplacementaq>(3);

    public Aquarium(JPanel panel) {

        // rajoute les emplacements à l'aquarium
        emp1 = new Emplacementaq();
        emp1.setBounds(353, 408, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp1.setIcon(null);
        panel.add(emp1);

        emp2 = new Emplacementaq();
        emp2.setBounds(459, 408, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp2.setIcon(null);
        panel.add(emp2);

        emp3 = new Emplacementaq();
        emp3.setBounds(567, 408, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp3.setIcon(null);
        panel.add(emp3);

        aqua1 = new Emplacementaq();
        aqua1.setBounds(360, 321, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua1.setIcon(null);
        panel.add(aqua1);

        aqua2 = new Emplacementaq();
        aqua2.setBounds(469, 321, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua2.setIcon(null);
        panel.add(aqua2);

        aqua3 = new Emplacementaq();
        aqua3.setBounds(579, 321, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua3.setIcon(null);
        panel.add(aqua3);

        aqua4 = new Emplacementaq();
        aqua4.setBounds(360, 417, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua4.setIcon(null);
        panel.add(aqua4);

        aqua5 = new Emplacementaq();
        aqua5.setBounds(469, 417, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua5.setIcon(null);
        panel.add(aqua5);

        aqua6 = new Emplacementaq();
        aqua6.setBounds(579, 417, (int) size_icone_poi.getWidth(), (int) size_icone_poi.getHeight());
        aqua6.setIcon(null);
        panel.add(aqua6);
    }

    
    /** 
     * @param etat
     * permet de set les label visible ou invisible
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