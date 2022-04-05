// Frédéric Choinière, Justin Plouffe   itération 1
// Classe qui contrôle les paramètres d'eau

package model.chimie;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import view.GUIMain;

public class Eau implements Runnable {

    public int ph = 7; // 0 à 14
    public int gh = 10; // Dureté de l'eau de 0 à 25+ (tolérée entre 5 et 15)
    public int kh = 6; // Dureté de l'eau de 0 à 12+ (tolérée entre 4 et 8)
    public int nbAtomeN = 0;
    public int nbAtomeO = 2103;
    public int nbAtomeH = 4206;

    //public int temperature;
    public int scoreEau;
    private float scorePH;
    private float scoreGH;
    private float scoreKH;
    private float scoreAmmo;
    private float scoreNitrites;
    private float scoreNitrates;


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

    public Eau(){
        listeAmmoniaque.add(0, this.ammoniaque);
        listeNitrites.add(0, this.nitrites);
    }

    // Getter pour le ph
    public int getPH() {
        return ph;
    }

    // Setter pour le ph
    public void setPH(int nouveauPH) {
        this.ph = nouveauPH;
    }

    // Getter pour le gh
    public int getGH() {
        return gh;
    }

    // Setter pour le gh
    public void setGH(int nouveauGH) {
        this.gh = nouveauGH;
    }

    // Getter pour le kh
    public int getKH() {
        return kh;
    }

    // Setter pour le kh
    public void setKH(int nouveauKH) {
        this.kh = nouveauKH;
    }

    // Getter pour le taux d'ammoniaque
    public float getAmmoniaque() {
        return sommeAmmoniaque;
    }

    /*// Setter pour le taux d'ammoniaque
    public void setAmmoniaque(float nouveauAmmoniaque) {
        this.sommeAmmoniaque = nouveauAmmoniaque;
    }*/

    // Getter pour le taux de nitrites
    public float getNitrites() {
        return sommeNitrites;
    }

    /*// Setter pour le taux de nitrites
    public void setNitrites(float nouveauNitrites) {
        this.sommeNitrites = nouveauNitrites;
    }*/

    // Getter pour le taux de nitrates
    public float getNitrates() {
        return nitrates;
    }

    /*// Setter pour le taux de nitrates
    public void setNitrates(float nouveauNitrates) {
        this.nitrates = nouveauNitrates;
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
     * @return float
     *         Dicte le comportement des nitrates selon une courbe
     *//*
    public int actualiserScoreEau() {
        this.scoreEau = ();
        return scoreEau;
    }

    //TODO: 
    public int evaporationEau() {
        //set gh selon volume d'eau
    }

   

    /** 
     * @return float
     *         Retourne la valeur du score pour le PH qui cotribue pour (14/100) du score de l'eau
     */
    public float getScorePH() {

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
    public float getScoreGH() {

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
    public float getScoreKH() {

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
    public float getScoreAmmo() {

        float variationAmmo;

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
     *         Retourne la valeur du score pour les nitrites qui cotribue pour (24/100) du score de l'eau
     */
    public float getScoreNitrites() {

        float variationNitrites;

        if(nitrites <= 0 && nitrites>= 1){
            variationNitrites = 0;
            scoreNitrites= 24;
        }
        else if(nitrites > 1){
            variationNitrites= nitrites - 1;
            scoreNitrites= (100-((50/17)*variationNitrites))*(24/100);
        }
        return scoreNitrites;
    }

    /** 
     * @return float
     *         Retourne la valeur du score pour les nitrates qui cotribue pour (16/100) du score de l'eau
     */
    public float getScoreNitrates() {

        float variationNitrates;

        if(nitrates >= 0 && nitrates <= 40){
            variationNitrates = 0;
            scoreNitrates = 16;
        }
        else if(nitrates > 40){
            variationNitrates = nitrates- 40;
            scoreNitrates = (100-((5/7)*variationNitrates))*(16/100);
        }
        return scoreNitrates;
    }

    /** 
     * @return float
     *         Retourne un entier représentant la valeur du score de l'eau sur 100 
     */
    public int getScoreEau() {

        scoreEau = (int)(scorePH + scoreGH + scoreKH + scoreAmmo + scoreNitrites + scoreNitrates);
        return scoreEau;
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
                System.out.println("Erreur dans le run() d'Eau.java");
                e.printStackTrace();
            }
        }
    }
}
