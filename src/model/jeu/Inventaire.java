package model.jeu;

import java.util.*;
import java.awt.*;
import javax.swing.*;

public class Inventaire {

    public Emplacementinv emp1, emp2, emp3, emp4, emp5, emp6;
    final Dimension size_icone_inv = new Dimension(80, 80);

    private ArrayList<Emplacementinv> listEmpPleins = new ArrayList<Emplacementinv>(6);

    public Inventaire(JLabel label) {

        // créer les emplacements dans l'inventaire
        emp1 = new Emplacementinv();
        emp1.setBounds(30, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp1.setIcon(new ImageIcon("res/background/decorations/plante_bleu.png"));
        label.add(emp1);

        emp2 = new Emplacementinv();
        emp2.setBounds(140, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp2.setIcon(new ImageIcon("res/background/decorations/poisson_rouge_item.png"));
        label.add(emp2);

        emp3 = new Emplacementinv();
        emp3.setBounds(30, 196, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp3.setIcon(new ImageIcon("res/background/decorations/lol.png"));
        label.add(emp3);

        emp4 = new Emplacementinv();
        emp4.setBounds(140, 196, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp4.setIcon(new ImageIcon("res/background/decorations/lol.png"));
        label.add(emp4);

        emp5 = new Emplacementinv();
        emp5.setBounds(30, 362, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp5.setIcon(new ImageIcon("res/background/decorations/lol.png"));
        label.add(emp5);

        emp6 = new Emplacementinv();
        emp6.setBounds(140, 362, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp6.setIcon(new ImageIcon("res/background/decorations/lol.png"));
        label.add(emp6);
    }

    // permet de set les label visible ou invisible
    public void setVisible(boolean etat) {
        emp1.setVisible(etat);
        emp2.setVisible(etat);
        emp3.setVisible(etat);
        emp4.setVisible(etat);
        emp5.setVisible(etat);
        emp6.setVisible(etat);
    }

}