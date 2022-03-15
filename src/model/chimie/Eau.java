package model.chimie;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import view.GUIMain;

/**
 * <p> description </p>
 * @param 
 * @return 
 * @since Iteration #1
 */
public class Eau implements Runnable {

    public final float volumeEau = (float) 37.85;
    public int scoreEau;

    public int ph = 7; // 0 à 14 (dépend des poissons à élever)
    public int kh = 8; // Dureté de l'eau 0 à 10? (8+ pour poissons d'eau douce en eau basique?)
    public int gh = 5; // 0 à 30?
    public float nitrites = 0; // Doit etre 0, maximum 5mg par litre
    public float nitrates = 0; // max 50mg/L
    public float ammoniaque = 0;
    private float sommeAmmoniaque, sommeNitrites;
    public int ammonium = 0;

    public int nbAtomeN = 0;
    public int nbAtomeO = 2103;
    public int nbAtomeH = 4206;

    public int bacteries;
    public int chlore;
    public int temperature;
    

    public ArrayList<Float> listeAmmoniaqueTemp = new ArrayList<Float>(0);                  // Liste à synchroniser
    public List<Float> listeAmmoniaque = Collections.synchronizedList(listeAmmoniaqueTemp); // Liste synchronisée

    // ArrayBlockingQueue? comment manipuler la différence de valeurs?
    // live on check-then-act ce qui est un big no no

    public float jours = GUIMain.jours; // TODO: va être remplacé
    public byte cycle = 0;

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public Eau(){
        listeAmmoniaque.add(0, this.ammoniaque);
        listeAmmoniaque.add(1, this.ammoniaque);


        //listeAmmoniaque.add(1,(float) 0);
    }

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
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

    /**
     * <p> description </p>
     * @param 
     * @return 
     * @since Iteration #1
     */
    public void couleur() {

        //pourcentage de vert ou de gris dans l'eau

    }

    
    /** 
     * @param ammoniaque
     * @param cycle
     * Ajoute une valeur d'ammoniaque fournie dans la listeAmmoniaque à l'index spécifié
     */
    public void addAmmoniaque(float ammoniaque, byte cycle) { // ajouter différence, mettre dans intervalle [tant que y > 0 && pente négative]
        listeAmmoniaque.add(cycle, ammoniaque);
    }

    
    /** 
     * @return float
     * Additionne toutes les valeurs dans la listeAmmoniaque
     */
    public float sommeAmmoniaque(){
        sommeAmmoniaque = 0;
        for (Float valeur : listeAmmoniaque) {
            sommeAmmoniaque += valeur;
        }
        this.ammoniaque = sommeAmmoniaque;
        return this.ammoniaque;
    }

    
    /** 
     * @return double
     * Dicte le comportement des nitrites, incomplet
     */
    public double comportNitrite(){ // voir fonction, mettre dans intervalle [tant que y > 0 && pente négative]
        double temp = 0;
        return temp;
    }

    
    /** 
     * @return float
     * Dicte le comportement des nitrates selon une courbe
     */
    public float comportNitrate() {
        this.nitrates = ((jours/7) - 4);
        return this.nitrates;
    }

    
    /** 
     * Méthode run de la classe Eau
     * Incomplète pour l'instant
     */
    @Override
    public void run() { // TODO: updater avec changement de jour
        while (true) {
            jours = GUIMain.jours;
            try {
                if (jours > 28) {
                    comportNitrate();
                    Thread.sleep(1000);
                } else Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
