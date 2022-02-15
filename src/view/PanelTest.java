package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import java.nio.Buffer;

import model.chimie.TestStoech;

public class PanelTest extends JPanel implements ActionListener{

    TestStoech stoech;
    JButton button1, button2;
    Thread pet;
    JLabel label;

    public PanelTest() {

        setSize(300, 300);
        setName("testeau");
        setVisible(true);

        stoech = new TestStoech();
        pet = new Thread(stoech);

        label = new JLabel("Ammoniaque: ");
        add(label);

        button1 = new JButton("+");
        button1.addActionListener(this);
        button2 = new JButton("-");
        button2.addActionListener(this);

        

        add(stoech.barAmmoniaque);
        add(button1);
        add(button2);

        pet.start();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
         if(e.getSource() == button1){
             stoech.quantAmmoniaque += 10;
         }
         if(e.getSource() == button2){
            stoech.quantAmmoniaque -= 10;
        }
    }
}