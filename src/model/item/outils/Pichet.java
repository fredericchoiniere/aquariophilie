//Jérémie Caron     itération 3
//Classe pour l'outil pichet

package model.item.outils;

import javax.swing.*;

import java.awt.*;

public class Pichet extends Outils {

    // attributs de la classe
    ImageIcon icone_pilet; 

    public Pichet() { 
        super();
        adapterNom();
        icone_pilet = new ImageIcon("res/outils/pichet.png"); 
    }

    
    /** 
     * @param label
     *             méthode qui permet d'afficher l'image de l'outil 
     */
    public void setIcon(JLabel label) {
        label.setIcon(icone_pilet);
    }

    
    /** 
     * @param panel
     *            méthode qui permet de mettre le bon curseur 
     */
    public void changerCurseurPanel(JPanel panel) {
            panel.setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                    icone_pilet.getImage(),
                    new Point(0, 0), "curseur plein"));
       
}
}