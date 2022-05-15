//Itération 1: Jérémie Caron

//Classe mère des différents outils

package model.outils;

public class Outils {

    // attributs de la classe
    public String nom = "";

    /** 
     *            méthode qui permet de donner le bon nom de l'outil
     */
    public void adapterNom() {
        nom = getClass().getName().toLowerCase();
        nom = nom.substring(6);
    }
}

// Слава Україні!