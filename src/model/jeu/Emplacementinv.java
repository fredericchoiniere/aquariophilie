package model.jeu;

import javax.swing.JLabel;
import java.awt.event.*;
import java.awt.*;

public class Emplacementinv extends JLabel{
    
    public short position = 0;
    public float prix = 0;
    public boolean plein = false;

    public Emplacementinv(){
        super();
    }

    public Boolean estPlein(){


        
        return plein;
    }
}
