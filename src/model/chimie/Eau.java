package model.chimie;

import java.util.ArrayList;
import java.util.List;
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
    public float nitrites = 0; // Doit etre 0, maximum 5mg par litre
    public float nitrates = 0; // max 50mg/L
    public float ammoniaque = 0;
    private float sommeAmmoniaque, sommeNitrites;

    public ArrayList<Float> listeAmmoniaqueTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeAmmoniaque = Collections.synchronizedList(listeAmmoniaqueTemp); // Liste synchronisée

    public ArrayList<Float> listeNitritesTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeNitrites = Collections.synchronizedList(listeNitritesTemp); // Liste synchronisée

    public float jours = GUIMain.jours;
    public byte cycle = 0;

    public Eau(){
        listeAmmoniaque.add(0, this.ammoniaque);
        listeAmmoniaque.add(1, this.ammoniaque);
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
     * @param cycle
     *                   Ajoute une valeur d'ammoniaque fournie dans la
     *                   listeAmmoniaque à l'index spécifié
     */
    public void addAmmoniaque(float ammoniaque, byte cycle) { // ajouter différence, mettre dans intervalle [tant que y
                                                              // > 0 && pente négative]
        listeAmmoniaque.add(cycle, ammoniaque);
    }

    /** 
     * @param nitrites
     * @param cycle
     * Ajoute une valeur de nitrites fournie dans la listeNitrites à l'index spécifié
     */
    public void addNitrites(float nitrites, byte cycle) { // ajouter différence, mettre dans intervalle
        listeNitrites.add(cycle, nitrites);
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
        this.ammoniaque = sommeAmmoniaque;
        return this.ammoniaque;
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
        this.nitrites = sommeNitrites;
        return this.nitrites;
    }

    /** 
     * @return float
     *         Dicte le comportement des nitrates selon une courbe
     */
    public float comportNitrates() {
        this.nitrates = ((jours / 7) - 4);
        return this.nitrates;
    }
    
    /** 
     * Méthode run de la classe Eau
     * Incomplète pour l'instant
     */
    @Override
    public void run() {
        while (true) {
            jours = GUIMain.jours;
            try {
                if (jours > 28) {
                    comportNitrates();
                    Thread.sleep(1000);
                } else
                    Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
