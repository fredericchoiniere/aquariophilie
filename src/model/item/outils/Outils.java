//Jérémie Caron     itération 1
//Classe mère des différents outils

package model.item.outils;

public class Outils {

    // attributs de la classe
    public String nom = "";

    /** 
     *            méthode qui permet de donner le bo nom de l'outil
     */
    public void adapterNom() {
        nom = getClass().getName().toLowerCase();
        nom = nom.substring(6);
    }
}