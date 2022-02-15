package model;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class DraggableComponent extends JLabel { // Classe Draggable component pour le drag and drop des outils

  public static int x;
  public static int y;
  private volatile int screenX = 0;
  private volatile int screenY = 0;
  private volatile int myX = 0;
  private volatile int myY = 0;

  public DraggableComponent() {  // creation du constructeur
    setBorder(new LineBorder(Color.BLUE, 3));
    setBackground(Color.WHITE);
    setBounds(0, 0, 100, 100);
    setOpaque(false);


    //--------------------------------------------------------------------------------------------------------------------------------------------------
      // actions listener pour suivre la souris
      
    addMouseListener(new MouseListener() {

      @Override
      public void mouseClicked(MouseEvent e) {
      }

      @Override
      public void mousePressed(MouseEvent e) {
        screenX = e.getXOnScreen();
        screenY = e.getYOnScreen();

        myX = getX();
        myY = getY();

        x = getX();
        y = getY();

      }

      @Override
      public void mouseReleased(MouseEvent e) {
        setLocation(x, y);
      }

      @Override
      public void mouseEntered(MouseEvent e) {
      }

      @Override
      public void mouseExited(MouseEvent e) {
      }

    });
    addMouseMotionListener(new MouseMotionListener() { 

      @Override
      public void mouseDragged(MouseEvent e) {
        int deltaX = e.getXOnScreen() - screenX;
        int deltaY = e.getYOnScreen() - screenY;

        setLocation(myX + deltaX, myY + deltaY);
      }

      @Override
      public void mouseMoved(MouseEvent e) {
      }

    });

  }

}
