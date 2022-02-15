package view.tabs;

import java.awt.*;
import javax.swing.*;



import java.awt.event.*;

public class PanelAqua extends JPanel implements MouseListener, FocusListener{ // extends JPanel pour créer un Jpanel

    public PanelAqua() {
        setPreferredSize(new Dimension(1000, 700)); // Taille du panel
        addFocusListener(this);
        addMouseListener(this);
    }

    public void paintComponent(Graphics g) { // méthode paint
        super.paintComponent(g);

        Graphics2D g2D = (Graphics2D) g;

        // créer le background pour l'onglet Aquarium
        

        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background.png");
        g2D.drawImage(background,5, 5, this);

        Image aquarium_1 = Toolkit.getDefaultToolkit().getImage("res/accessoires/aquarium/aquarium_1.png");
        g2D.drawImage(aquarium_1, 320, 305, this);

    }
    @Override
    public void focusGained(FocusEvent e) {
        //System.out.println("gloup");
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        //System.out.println("lost");
        
    }

    @Override
    public void mousePressed(MouseEvent me){
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        requestFocus();
        //System.out.println("fuck");

        
        
        
        
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
}
