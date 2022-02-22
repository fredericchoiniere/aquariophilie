package view;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.event.*;
import javax.swing.*;

import model.chimie.TestStoech;

public class PanelTest extends JPanel implements ActionListener{//MouseListener, ActionListener, FocusListener{

    TestStoech stoech;
    JButton button1, button2;
    Thread pet;
    JLabel label;
    boolean isFocused;

    public PanelTest() {

        //addFocusListener(this);
        //addMouseListener(this);
        setSize(700, 500);
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

    /* @Override
    public void focusGained(FocusEvent e) {
        isFocused = false;
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        setVisible(false);
        isFocused = true;
    }

    @Override
    public void mousePressed(MouseEvent me){
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocus();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

	public boolean isFocused() {
        boolean fact = isFocused;
		return fact;
	} */
    
}