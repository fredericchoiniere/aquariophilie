//Jérémie Caron     itération 2
//Classe pour l'outil filet

package model.item.outils;

import javax.swing.*;

public class Shop extends Outils {

    // attributs de la classe
    ImageIcon icone_shop; 

    public Shop() { 
        super();
        adapterNom();
        icone_shop = new ImageIcon("res/outils/shop.png"); 
    }

    /** 
     * @param label
     *            méthode qui permet d'afficher l'image de l'outil 
     */
    public void setIcon(JLabel label) {
        label.setIcon(icone_shop);
    }     
}
