package model.item.outils;


public class Outils{ // extends Draggable components pour les Outils
    
    public String nom = "";

    public void adapterNom() { 

        nom = getClass().getName().toLowerCase();
        nom = nom.substring(6);

    }
}