package view;

// TODO: CLASSE DE TEST TEMPORAIRE

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

import model.chimie.CycleAzote;

public class PanelTest extends JPanel implements ActionListener {

    CycleAzote cycle;
    JButton button1, button2;
    Thread cycle1;
    boolean isFocused;

    public PanelTest() {

        setSize(700, 500);
        setName("testeau");
        setVisible(true);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("res/icone_souris/pipe_vide.png").getImage(),
                new Point(0, 0), "custom cursor"));

        cycle = new CycleAzote();
        cycle1 = new Thread(cycle);

        button1 = new JButton("Afficher cycles");
        button1.addActionListener(this);
        button2 = new JButton("Ajouter nouveau cycle");
        button2.addActionListener(this);

        add(button1);
        add(button2);

        cycle1.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {

            System.out.println("Jour:" + cycle.jours);
            System.out.println("Ammoniaque:" + cycle.eau.sommeAmmoniaque());
            System.out.println("List:" + cycle.eau.listeAmmoniaque);
            
        }
        if (e.getSource() == button2) {
            cycle.eau.listeAmmoniaque.add((float)0);
            new Thread(new CycleAzote()).start();
        }
    }
}