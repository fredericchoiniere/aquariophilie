package model.jeu;



import javax.swing.JLabel;
import javax.swing.JPanel;

import java.awt.event.*;
import java.awt.*;

public class Emplacementaq extends JLabel{
    
    public short position = 0;
    public float prix = 0;
    public boolean plein = false;

    public Emplacementaq(){
        super();
    }

    public Boolean estPlein(){
        return plein;
    }
}




