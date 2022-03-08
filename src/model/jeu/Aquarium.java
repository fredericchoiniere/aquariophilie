package model.jeu;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Aquarium {

    public Emplacementaq emp1, emp2, emp3;
    final Dimension size_icone_inv = new Dimension(80, 80);

    private ArrayList<Emplacementaq> listEmpPleins = new ArrayList<Emplacementaq>(3);

    public Aquarium(JPanel panel) {

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
    }

    public void setVisible(boolean etat) {
        emp1.setVisible(etat);
        emp2.setVisible(etat);
        emp3.setVisible(etat);
    }

}