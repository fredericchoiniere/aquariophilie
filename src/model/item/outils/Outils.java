package model.item.outils;

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class Outils{ // extends Draggable components pour les Outils
    
    public String nom = "";

    // permet de prendre le nom pipette
    public void adapterNom() { 
        nom = getClass().getName().toLowerCase();
        nom = nom.substring(6);
    }
}