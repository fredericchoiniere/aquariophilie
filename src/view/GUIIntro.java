//Jérémie Caron A21

package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUIIntro extends JFrame implements ActionListener {

    // appelle des variables de la classe

    
    public JButton btEnter;
	
   
    
    

    public GUIIntro() {

        JPanel simplePanel = new JPanel();


        btEnter = new JButton("enter");
        btEnter.addActionListener(this);
        simplePanel.add(btEnter);


        add(simplePanel); 

        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btEnter) {
            GUIMain aquarium = new GUIMain();
            aquarium.setResizable(false);
            aquarium.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            aquarium.pack();
            aquarium.setLocationRelativeTo(null);
            aquarium.setVisible(true);
        }
        
    }

    
    /** 
     * @param e
     */
    //--------------------------------------------------------------------------------------------------------------------------------

    
    
}


