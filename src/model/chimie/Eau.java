// Frédéric Choinière, Justin Plouffe   itération 1
// Classe qui contrôle les paramètres d'eau

package model.chimie;

import java.util.ArrayList;
import java.util.List;
import model.environnement.Temps;
import java.util.*;
import view.GUIMain;

public class Eau implements Runnable {

    public int ph = 7; // 0 à 14 (dépend des poissons à élever)
    public int kh = 8; // Dureté de l'eau 0 à 10? (8+ pour poissons d'eau douce en eau basique?)
    public int gh = 5; // 0 à 30?
    public int ammonium = 0;
    public int nbAtomeN = 0;
    public int nbAtomeO = 2103;
    public int nbAtomeH = 4206;

    public int bacteries;
    public int chlore;
    public int temperature;
    public int scoreEau;

    public final float volumeEau = (float) 37.85;
    public float jours = GUIMain.jours;
    public float nitrites = 0; // Doit etre 0, maximum 5mg par litre
    public float nitrates = 0; // max 50mg/L
    public float ammoniaque = 0;
    private float sommeAmmoniaque, sommeNitrites;

    public ArrayList<Float> listeAmmoniaqueTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeAmmoniaque = Collections.synchronizedList(listeAmmoniaqueTemp); // Liste synchronisée

    public ArrayList<Float> listeNitritesTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeNitrites = Collections.synchronizedList(listeNitritesTemp); // Liste synchronisée

    public float penteNitrites = 0;

    public Eau(){
        listeAmmoniaque.add(0, ammoniaque);
        listeNitrites.add(0, nitrites);
    }

    public void changerEau() {
        ph = 7; 
        kh = 8; 
        gh = 5; 
        nitrites = 0;
        nitrates = 0;
        ammoniaque = 0;
        ammonium = 0;
        nbAtomeN = 0;
        nbAtomeO = 0;
        nbAtomeH = 0;
        temperature = 15;

    }

    public void couleur() {
        //pourcentage de vert ou de gris dans l'eau
    }
    
    /** 
     * @param ammoniaque
     * Ajoute une valeur d'ammoniaque fournie dans la listeAmmoniaque
     */
    public void addAmmoniaque(float ammoniaque) { // ajouter différence, mettre dans intervalle [tant que y > 0 && pente négative]
        listeAmmoniaque.add(ammoniaque);
    }

    /** 
     * @param nitrites
     * Ajoute une valeur de nitrites fournie dans la listeNitrites
     */
    public void addNitrites(float nitrites) { // ajouter différence, mettre dans intervalle
        listeNitrites.add(nitrites);
    }
    
    /** 
     * @return float
     *         Additionne toutes les valeurs dans la listeAmmoniaque
     */
    public float sommeAmmoniaque() {
        sommeAmmoniaque = 0;
        for (Float valeur : listeAmmoniaque) {
            sommeAmmoniaque += valeur;
        }
        ammoniaque = sommeAmmoniaque;
        return ammoniaque;
    }
    
    /** 
     * @return float
     * Additionne toutes les valeurs dans la listeNitrites
     */
    public float sommeNitrites() {
        sommeNitrites = 0;
        for (Float valeur : listeNitrites) {
            sommeNitrites += valeur;
        }
        nitrites = sommeNitrites;
        return nitrites;
    }

    /** 
     * @return float
     *         Dicte le comportement des nitrates selon une courbe
     */
    public float comportNitrates() {
        nitrates = ((jours / 7));
        return nitrates;
    }
    
    /* /**
     * @return boolean
     * Retourne true si la pente des Nitrites est négative et false si non
     
    public boolean verifPenteNitrites() {

        if () {
            
        } else {
            
        }


        return penteNitrites;
    }*/
 
    /** 
     * Méthode run de la classe Eau
     * Incomplète pour l'instant
     */
    @Override
    public void run() {
        penteNitrites = nitrites;
        while (true) {
            jours = GUIMain.jours;
            sommeAmmoniaque();
            sommeNitrites();
            System.out.println("pente: " + penteNitrites + " total: " + nitrites + " jour: " + jours);
            try {
                if (penteNitrites > nitrites) {
                    comportNitrates();  // vérifier calculs
                    System.out.println("nitrates " + nitrates);
                    Thread.sleep(Temps.DUREE);
                    if(nitrites != 0.0)
                        penteNitrites = nitrites;
                } else {
                    Thread.sleep(Temps.DUREE);
                    penteNitrites = nitrites;
                }
            } catch (Exception e) {
                System.out.println("Erreur dans le run() d'Eau.java");
                e.printStackTrace();
            }
        }
    }
}
