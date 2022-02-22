package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;

import model.chimie.Eau;
import model.chimie.TestStoech;
import model.environnement.Temps;

public class PanelTest extends JPanel implements ActionListener {

    TestStoech stoech;
    Eau  eau;
    Temps temps;
    JButton button1, button2, button3;
    Thread pet, prout;
    JLabel label, label2;
    boolean isFocused;

    public PanelTest() {

        //addFocusListener(this);
        //addMouseListener(this);
        setSize(700, 500);
        setName("testeau");
        setVisible(true);

        stoech = new TestStoech();
        pet = new Thread(stoech);

        eau = new Eau();
        prout = new Thread(eau);


        label = new JLabel("Ammoniaque: ");
        add(label);

        button1 = new JButton("+");
        button1.addActionListener(this);
        button2 = new JButton("-");
        button2.addActionListener(this);

        add(stoech.barAmmoniaque);
        add(button1);
        add(button2);

        label2 = new JLabel("Test Nitrates: " + eau.nitrates);
        button3 = new JButton("+ jours: " + (eau.jours));
        button3.addActionListener(this);

        add(label2);
        add(button3);

        pet.start();
        prout.start();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            stoech.quantAmmoniaque += 10;
        }
        if (e.getSource() == button2) {
            stoech.quantAmmoniaque -= 10;
        }
        if (e.getSource() == button3) {
            
            label2.setText("Test Nitrates: " + eau.nitrates);
            button3.setText("+ jours: " + (eau.jours));
            
        }
    }

}