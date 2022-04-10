// Frédéric Choinière, Justin Plouffe   itération 1
// Frédéric Choinière   itération 2
// Classe qui contrôle les paramètres d'eau

package model.chimie;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import view.GUIMain;
import model.MethodeGUIMain;
import model.environnement.Temps;

public class Eau implements Runnable {

    public static int ph = 7; // 0 à 14
    public static int gh = 10; // Dureté de l'eau de 0 à 25+ (tolérée entre 5 et 15)
    public static int kh = 6; // Dureté de l'eau de 0 à 12+ (tolérée entre 4 et 8)
    public int nbAtomeN = 0;
    public int nbAtomeO = 2103;
    public int nbAtomeH = 4206;
    
    //public int temperature;
    public static int scoreEau;
    private static float scorePH;
    private static float scoreGH;
    private static float scoreKH;
    private static float scoreAmmo;
    private static float scoreNitrites;
    private static float scoreNitrates;
    private float penteNitrites = 0;
    public float sommeAbsorptionNitrates = 0; // score global des plantes
    public int sommeAbsorptionDechets = 0; 
    public int potentielDechets = 0, sommeDechets = 0; 

    public final float volumeEau = (float) 37.85;
    public static float nitrites = 0; // Doit etre 0, maximum 5mg par litre
    public static float nitrates = 0; // max 50mg/L
    public static float ammoniaque = 0;
    private float sommeAmmoniaque, sommeNitrites;

    public ArrayList<Float> listeAmmoniaqueTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeAmmoniaque = Collections.synchronizedList(listeAmmoniaqueTemp); // Liste synchronisée
    public ArrayList<Float> listeAmmoniaqueIteration = new ArrayList<Float>(); // Liste pour itérer dans boucle
    public HashSet<Float> setAmmoniaque = new HashSet<Float>(listeAmmoniaqueTemp); // Liste pour additionner le montant total d'ammoniaque

    public ArrayList<Float> listeNitritesTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeNitrites = Collections.synchronizedList(listeNitritesTemp); // Liste synchronisée
    public ArrayList<Float> listeNitritesIteration = new ArrayList<Float>(); // Liste pour itérer dans boucle
    public HashSet<Float> setNitrites = new HashSet<Float>(listeNitritesTemp); // Liste pour additionner le montant total de nitrites

    public ArrayList<Integer> listeAbsorption = new ArrayList<Integer>();

    public float jours = GUIMain.jours;

    public Eau(){
        listeAmmoniaque.add(0, ammoniaque);
        listeNitrites.add(0, nitrites);
    }

    // Getter pour le ph
    public int getPH() {
        return ph;
    }

    // Setter pour le ph
    public void setPH(int nouveauPH) {
        ph = nouveauPH;
    }

    // Getter pour le gh
    public int getGH() {
        return gh;
    }

    // Setter pour le gh
    public void setGH(int nouveauGH) {
        gh = nouveauGH;
    }

    // Getter pour le kh
    public int getKH() {
        return kh;
    }

    // Setter pour le kh
    public void setKH(int nouveauKH) {
        kh = nouveauKH;
    }

    // Getter pour le taux d'ammoniaque
    public float getAmmoniaque() {
        return sommeAmmoniaque;
    }

    /*// Setter pour le taux d'ammoniaque
    public void setAmmoniaque(float nouveauAmmoniaque) {
        sommeAmmoniaque = nouveauAmmoniaque;
    }*/

    // Getter pour le taux de nitrites
    public float getNitrites() {
        return sommeNitrites;
    }

    /*// Setter pour le taux de nitrites
    public void setNitrites(float nouveauNitrites) {
        sommeNitrites = nouveauNitrites;
    }*/

    // Getter pour le taux de nitrates
    public float getNitrates() {
        return nitrates;
    }

    /*// Setter pour le taux de nitrates
    public void setNitrates(float nouveauNitrates) {
        nitrates = nouveauNitrates;
    }*/

    public void changerEau() {
        ph = 7; 
        kh = 8; 
        gh = 5; 
        nitrites = 0;
        nitrates = 0;
        ammoniaque = 0;

        nbAtomeN = 0;
        nbAtomeO = 0;
        nbAtomeH = 0;
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
        listeAmmoniaqueIteration.addAll(listeAmmoniaque);
        for (Float valeur : listeAmmoniaqueIteration) {
            if(!setAmmoniaque.contains(valeur)){
                setAmmoniaque.add(valeur);
                sommeAmmoniaque += valeur;
            }
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
        listeNitritesIteration.addAll(listeNitrites);
        for (Float valeur : listeNitritesIteration) {
            if (!setNitrites.contains(valeur)) {
                setNitrites.add(valeur);
                sommeNitrites += valeur;
            }
        }
        nitrites = sommeNitrites;
        return nitrites;
    }

    public void absorption(){ // absorber nitrates
        sommeDechets -= sommeAbsorptionDechets;
        nitrates -= sommeAbsorptionNitrates; 
        if (sommeAbsorptionNitrates != 0) {     // TODO: à paufiner et éviter les négatifs
            sommeAbsorptionNitrates += 0.14;
            if(!MethodeGUIMain.hasPlants()){
                sommeAbsorptionNitrates = 0;
            }
        }

    }

    public void accumulerDechets(){
        sommeDechets += potentielDechets;
    }


    /** 
     * @return float
     *         Dicte le comportement des nitrates selon une courbe
     */
    public float comportNitrates() {
        nitrates = ((jours / 7) - 4);
        return nitrates;
    }
    
    /** 
     * @return flo
     *         Dicte le comportement des nitrates selon une courbe
     *//*
    public int actualiserScoreEau() {
        scoreEau = ();
        return scoreEau;
    }

    public int evaporationEau() {
        //set gh selon volume d'eau
    }

    scorePh
    scoreGh
    scoreKh
    scoreAmmo
    scoreNitrites
    scoreNitrates
{}
    scoreEau*/

    public static void setScoreEau() {
        scoreEau = (int) (setScoreAmmo() + setScoreGH() + setScoreKH() + setScoreNitrates() + setScoreNitrites() + setScorePH());
        //System.out.println("Score eau 1 : " + scoreEau);
    }

    /** 
     * @return float
     *         Retourne la valeur du score pour le PH qui cotribue pour (14/100) du score de l'eau
     */
    public static float setScorePH() {

        float variationPH;

        if(ph >= 6 && ph <= 8){
            variationPH = 0;
            scorePH= 14;
        }
        else if(ph < 6){
            variationPH = 4 - ph;
            scorePH = (100-(20*variationPH))*(14/100);
        }
        else if(ph > 8){
            variationPH = ph - 8;
            scorePH = (100-(20*variationPH))*(14/100);
        }
        return scorePH;
    }

    /** 
     * @return float
     *         Retourne la valeur du score pour le GH qui cotribue pour (14/100) du score de l'eau
     */
    public static float setScoreGH() {

        float variationGH;

        if(gh >= 5 && gh <= 15){
            variationGH = 0;
            scoreGH= 14;
        }
        else if(gh < 5){
            variationGH = 4 - gh;
            scoreGH = (100-(4*variationGH))*(14/100);
        }
        else if(gh > 8){
            variationGH = gh - 8;
            scoreGH = (100-(4*variationGH))*(14/100);
        }
        return scoreGH;
    }

    /** 
     * @return float
     *         Retourne la valeur du score pour le KH qui contribue pour (14/100) du score de l'eau
     */
    public static float setScoreKH() {

        float variationKH;

        if(kh >= 4  && kh <= 8){
            variationKH = 0;
            scoreKH= 14;
        }
        else if(kh < 4){
            variationKH = 4 - kh;
            scoreKH = (float)(100-(12.5*variationKH))*(14/100);
        }
        else if(kh > 8){
            variationKH = kh - 8;
            scoreKH = (float)(100-(12.5*variationKH))*(14/100);
        }
        return scoreKH;
    }

    /** 
     * @return float
     *         Retourne la valeur du score pour l'ammoniaque qui cotribue pour (18/100) du score de l'eau
     */
    public static float setScoreAmmo() {

        float variationAmmo = 0;

        if(ammoniaque <= 0 && ammoniaque >= 0.5){
            variationAmmo = 0;
            scoreAmmo= 18;
        }
        else if(ammoniaque > 0.5){
            variationAmmo = (float)(ammoniaque - 0.5);
            scoreAmmo = (100-((200/19)*variationAmmo))*(18/100);
        }
        return scoreAmmo;
    }


/** 
     * @return float
     *         Retourne la valeur du score pour le PH qui cotribue pour (24/100) du score de l'eau
     */
    public static float setScoreNitrites() {

        float variationNitrites;

        if(nitrites <= 4 && nitrites>= 8){
            variationNitrites = 0;
            scoreNitrites= 14;
        }
        else if(nitrites < 4){
            variationNitrites = 4 - nitrites;
            scoreNitrites = 100-(20*variationNitrites)*(14/100);
        }
        else if(nitrites > 8){
            variationNitrites= ph - 8;
            scoreNitrites= (100-(20*variationNitrites))*(14/100);
        }
        return scoreNitrites;
    }

    /** 
     * @return float
     *         Retourne la valeur du score pour le PH qui cotribue pour (16/100) du score de l'eau
     */
    public static float setScoreNitrates() {

        float variationNitrates;

        if(nitrates <= 4 || nitrates >= 8){
            variationNitrates = 0;
            scoreNitrates = 14;
        }
        else if(nitrates < 4){
            variationNitrates = 4 - nitrates;
            scoreNitrates = (100-(20*variationNitrates))*(14/100);
        }
        else if(nitrates> 8){
            variationNitrates = nitrates- 8;
            scoreNitrates = (100-(20*variationNitrates))*(14/100);
        }
        return scoreNitrates;
    }
    
    /** 
     * Méthode run de la classe Eau
     * Incomplète pour l'instant
     */
    @Override
    public void run() { // TODO: faire shush quand pause
        penteNitrites = nitrites;
        while (true) {
            jours = GUIMain.jours;
            // System.out.println("pente: " + penteNitrites + " total: " + nitrites + "
            // jour: " + jours);
            try {                   
                sommeAmmoniaque();          // à faire planter
                sommeNitrites();
                if (penteNitrites > nitrites) {
                    comportNitrates();
                    accumulerDechets();
                    absorption();
                    //System.out.println("nitrates: " + nitrates + " absorption nit: " + sommeAbsorptionNitrates +
                     //" abs déchets: " + sommeAbsorptionDechets + " somme déchets: " + sommeDechets);
                    GUIMain.actionEnCours = "Cycle nitrates";
                    if (nitrites != 0.0)
                        penteNitrites = nitrites;
                } else {
                    penteNitrites = nitrites;
                }
                Thread.sleep(Temps.DUREE);
            } catch (Exception e) {
                //System.out.println("Erreur dans le thread: " + Thread.currentThread().getName());
                e.printStackTrace();
            }
        }
    }
}