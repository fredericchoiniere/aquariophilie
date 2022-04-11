//Jérémie Caron     itération 2
//Classe pour l'outil filet

package model.item.outils;

import javax.swing.*;

import java.awt.*;

public class Shop extends Outils {

    ImageIcon icone_shop; // icone du shop

    public Shop() { // Création de l'objet filet
        super();
        adapterNom();

        icone_shop = new ImageIcon("res/outils/shop.png"); // icone du filet
    }

    public void setIcon(JLabel label) {
        label.setIcon(icone_shop);
    }


       
}
