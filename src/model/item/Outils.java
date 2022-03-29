//Jérémie Caron     itération 1
//Classe mère des différents outils

package model.item;

public class Outils { // extends Draggable components pour les Outils

    public String nom = "";

    // permet de prendre le nom pipette
    public void adapterNom() {
        nom = getClass().getName().toLowerCase();
        nom = nom.substring(6);
    }
}