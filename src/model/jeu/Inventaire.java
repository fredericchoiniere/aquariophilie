package model.jeu;

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Inventaire{

    Emplacementinv emp1, emp2, emp3, emp4;
    final Dimension size_icone_inv = new Dimension(80, 80);

    private ArrayList<Emplacementinv> listEmpPleins = new ArrayList<Emplacementinv>(4);

    public Inventaire(JLabel label){
        emp1 = new Emplacementinv();
        
        emp1.setBounds(30, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp1.setIcon(new ImageIcon("res/background/decorations/plante_bleu.png"));
        

        label.add(emp1);

        emp2 = new Emplacementinv();
        
        emp2.setBounds(140, 30, (int) size_icone_inv.getWidth(), (int) size_icone_inv.getHeight());
        emp2.setIcon(new ImageIcon("res/background/decorations/plante_bleu.png"));

        label.add(emp2);
    }

    public void setVisible(boolean etat){
        emp1.setVisible(etat);
        emp2.setVisible(etat);
    }
}