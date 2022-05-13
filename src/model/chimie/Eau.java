// Frédéric Choinière, Justin Plouffe   itération 1
// Frédéric Choinière   itération 2
// Jérémie Caron  itération 3
// Classe qui contrôle les paramètres d'eau

package model.chimie;

import java.util.ArrayList;
import java.util.List;
import java.util.*;
import view.GUIMain;
import model.MethodeGUIMain;
import model.environnement.Temps;
import model.poissons.Poisson;

public class Eau implements Runnable {

    public static float ph = 7; // 0 à 14
    public static float gh = 8; // Dureté de l'eau de 0 à 25+ (tolérée entre 3 et 8) dGH
    public static float kh = 6; // Dureté de l'eau de 0 à 12+ (tolérée entre 4 et 8)
    private float penteNitrites = 0;
    public float sommeAbsorptionNitrates = 0; // score global des plantes
    public float sommeContributionPH = 0;
    public float variationPH = 0;
    public float volumeEau = (float) 37.85;
    public static float nitrites = 0; // Doit etre 0, maximum 5mg par litre
    public static float nitrates = 0; // max 50mg/L
    public static float ammoniaque = 0;
    public float tempAmmoniaque = 0;
    public float tempNitrites = 0;
    private float sommeAmmoniaque, sommeNitrites;
    public float jours = GUIMain.jours;
    public float jourInitial = 0;
    public float hauteur = 35, largeur = 20, longueur = (float) 54.07; // Dimensions de l'aquarium de 10 gallons/37.85L
    public static int hauteurEnPixels = 177; // 192// Hauteur en pixels de l'eau de l'aquarium rempli
    public static int positionEnPixels = 299;// 305

    private static float scorePH = 0;
    private static float scoreGH;
    private static float scoreKH;
    private static float scoreAmmo;
    private static float scoreNitrites;
    private static float scoreNitrates;

    public int sommeAbsorptionDechets = 0;
    public int potentielDechets = 0, sommeDechets = 0;
    public int nbAtomeN = 0;
    public int nbAtomeO = 2103;
    public int nbAtomeH = 4206;
    public float scoreEau = (float) 100.0;
    public static Random random = new Random();
    public static int randomNumber;

    final short valeur_changement = 1;

    public boolean dechetsCycleParti = false;
    public boolean cycleParti = true;
    public boolean menageDupesNit = true;

    public String actionEnCours = "Aucune action initiale";

    public ArrayList<Float> listeAmmoniaqueTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeAmmoniaque = Collections.synchronizedList(listeAmmoniaqueTemp); // Liste synchronisée
    public ListIterator<Float> iteratorAmmoniaque; // Itérateur pour additionner les valeurs d'ammoniaque
    public ArrayList<Float> listeAmmoniaqueIteration = new ArrayList<Float>(); //

    public ArrayList<Float> listeNitritesTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeNitrites = Collections.synchronizedList(listeNitritesTemp); // Liste synchronisée
    public ListIterator<Float> iteratorNitrites; // Itérateur pour additionner les valeurs de nitrites

    public ArrayList<Integer> listeAbsorption = new ArrayList<Integer>();

    public ArrayList<CycleAzote> listeCycles = new ArrayList<CycleAzote>();

    /**
     * @return float
     *         Retourne la valeur du pH
     */
    public float getPH() {
        return ph;
    }

    /**
     * @return int
     *         Retourne la valeur du pH en int
     */
    public int getPHint() {
        return (int) ph;
    }

    /**
     * @param nouveauPH
     *                  Setter du pH
     */
    public void setPH(float nouveauPH) {
        if (nouveauPH <= 0)
            ph = 0;
        else
            ph = nouveauPH;
    }

    /**
     * @return float
     *         Retourne le gH
     */
    public float getGH() {
        return gh;
    }

    /**
     * @param nouveauGH
     *                  Setter pour le gH
     */
    public void setGH(float nouveauGH) {
        if (nouveauGH <= 0)
            gh = 0;
        else
            gh = nouveauGH;
    }

    /**
     * @return float
     *         Retourne le kH
     */
    public float getKH() {
        return kh;
    }

    /**
     * @param nouveauKH
     *                  Setter pour le kH
     */
    public void setKH(float nouveauKH) {
        if (nouveauKH <= 0)
            kh = 0;
        else
            kh = nouveauKH;
    }

    /**
     * @return float
     *         Retourne le taux d'ammoniaque en mg/L
     */
    public float getAmmoniaque() {
        return sommeAmmoniaque;
    }

    /**
     * @return float
     *         Retourne le taux de nitrites en mg/L
     */
    public float getNitrites() {
        return sommeNitrites;
    }

    /**
     * @return float
     *         Retourne le taux de nitrates en mg/L
     */
    public float getNitrates() {
        return nitrates;
    }

    /**
     * @param ammoniaque
     *                   Ajoute une valeur d'ammoniaque fournie dans la
     *                   listeAmmoniaque
     */
    public void addAmmoniaque(float ammoniaque) { // ajouter différence, mettre dans intervalle [tant que y > 0 && pente
                                                  // négative]
        listeAmmoniaque.add(ammoniaque);
    }

    /**
     * @param nitrites
     *                 Ajoute une valeur de nitrites fournie dans la listeNitrites
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

        iteratorAmmoniaque = listeAmmoniaqueTemp.listIterator();

        while (iteratorAmmoniaque.hasNext()) {

            sommeAmmoniaque += iteratorAmmoniaque.next();
            iteratorAmmoniaque.remove();

        }

        listeAmmoniaqueTemp.addAll(listeAmmoniaque);

        ammoniaque = sommeAmmoniaque;
        return ammoniaque;
    }

    /**
     * @return float
     *         Additionne toutes les valeurs dans la listeNitrites
     */
    public float sommeNitrites() {
        sommeNitrites = 0;
        iteratorNitrites = listeNitrites.listIterator();

        while (iteratorNitrites.hasNext()) {

            if (iteratorNitrites.hasNext()) {
                sommeNitrites += iteratorNitrites.next();
                iteratorNitrites.remove();
            }
        }

        nitrites = sommeNitrites;
        return nitrites;
    }

    /**
     * Gère l'absorption des déchets et des nitrates par les plantes
     */
    public void absorption() {
        sommeDechets -= sommeAbsorptionDechets;
        nitrates -= sommeAbsorptionNitrates;
        if (sommeAbsorptionNitrates != 0) {
            sommeAbsorptionNitrates += 0.14;
            if (!MethodeGUIMain.hasPlants()) {
                sommeAbsorptionNitrates = 0;
            }
        }
        if (sommeDechets <= 0)
            sommeDechets = 0;
        if (nitrates <= 0)
            nitrates = 0;
    }

    /**
     * Gère la variation de pH
     * pH diminue avec temps, plantes augmentent pH
     */
    public void variationPH() {
        if (getKH() > 8) {
            setPH(getPH() - (float) 0.008);
            setPH(getPH() + (float) (sommeContributionPH * 0.05));
        }
        if (getKH() <= 8 && getKH() > 6) {
            setPH(getPH() - (float) 0.014);
            setPH(getPH() + (float) (sommeContributionPH * 0.09));
        }
        if (getKH() <= 6 && getKH() > 5) {
            setPH(getPH() - (float) 0.024);
            setPH(getPH() + (float) (sommeContributionPH * 0.14));
        }
        if (getKH() <= 5 && getKH() > 4) {
            setPH(getPH() - (float) 0.068);
            setPH(getPH() + (float) (sommeContributionPH * 0.22));
        }
        if (getKH() <= 4) {
            setPH(getPH() - (float) 0.128);
            setPH(getPH() + (float) (sommeContributionPH * 0.4));
        }
    }

    /**
     * Pour l'itération 3
     */
    public void variationKH() { // acceptable de 4 à 8

        if (sommeDechets > 10 && sommeDechets < 90) {
            setKH((float) (kh - 0.006));
        }
        if (sommeDechets >= 90 && sommeDechets < 150) {
            setKH((float) (kh - 0.018));
        }
        if (sommeDechets >= 150 && sommeDechets < 250) {
            setKH((float) (kh - 0.084));
        }
        if (sommeDechets >= 250) {
            setKH((float) (kh - 0.156));
            if (!dechetsCycleParti) {
                dechetsCycleParti = true;
                partirCycle(jours);
                // System.out.println("cycle démarré, boolean " + dechetsCycleParti);
            }
        }
    }

    /**
     * Pour l'itération 3
     */
    public void variationGH() { // acceptable de 5 à 15
        // avec volume d'eau
        if (volumeEau < 37.85 && volumeEau >= 32) {
            setGH((float) (gh - 0.009));
        }
        if (volumeEau < 32 && volumeEau >= 29) {
            setGH((float) (gh - 0.035));
        }
        if (volumeEau < 29 && volumeEau >= 27) {
            setGH((float) (gh - 0.095));
        }
        if (volumeEau < 27 && volumeEau >= 25) {
            setGH((float) (gh - 0.156));
        }
        if (volumeEau < 25) {
            setGH((float) (gh - 0.315));
        }

    }

    /**
     * Dimension de l'aquarium en cm: 54,07L x 20W x 35H
     * La hauteur de l'eau dans l'aquarium rempli est 35cm
     * 
     * Pour l'itération 3
     */
    public void variationNiveauEau() {

        if (hauteurEnPixels > 100) {
            hauteur -= 0.182;
            hauteurEnPixels -= valeur_changement;
            positionEnPixels += valeur_changement;
            MethodeGUIMain.setEauDimensions(positionEnPixels, hauteurEnPixels);
        } else {
            MethodeGUIMain.setEauDimensions(positionEnPixels, hauteurEnPixels);
        }
        volumeEau = (float) ((hauteur * largeur * longueur) * 0.001);
        //System.out.println("volume eau: " + volumeEau);
        //System.out.println("GH: " + gh);

        // System.out.println("hauteur eau: " + GUIMain.rectEau.getHeight());
    }
    
    
    /** 
     * @param accumulerDechets(
     */
    public void changerEau(){ // TODO: clean up poissons morts
        volumeEau = (float) 37.85;
        hauteur = 35;
        kh = 6;
        gh = 10;
        ph = 7;
        nitrates -= 10;
        System.out.println("déchets pré changement: " + sommeDechets);
        sommeDechets -= (sommeDechets * 0.50);
        System.out.println("déchets post changement: " + sommeDechets);
    }

    /**
     * Calcule la somme de déchets potentiels
     */
    public void accumulerDechets() {
        sommeDechets += potentielDechets;
    }

    /**
     * @return float
     *         Dicte le comportement des nitrates selon une courbe
     */
    public void comportNitrates() {
        nitrates = ((jours / 7) - 4);
    }

    /**
     * Pour l'itération 3
     */
    public float getScoreEau() {
        scoreEau = (setScorePH() + setScoreGH() + setScoreKH() + setScoreAmmo() + setScoreNitrates()
                + setScoreNitrites());
        return scoreEau;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour le PH qui cotribue pour (14/100) du
     *         score de l'eau
     */
    public float setScorePH() {

        if (ph >= 6 && ph <= 9) {
            scorePH = (float) 14.0;
        }
        if (getPH() <= 1){
            scorePH = (float) 0.0;
        }
        if (getPH() < 6 && getPH() > 1) {
            variationPH = 6 - getPH();
            scorePH = (float) ((100.0 - (20.0 * variationPH)) * (14.0 / 100.0));
        }
        if (getPH() > 9) {
            variationPH = getPH() - 9;
            scorePH = (float) ((100.0 - (20.0 * variationPH)) * (14.0 / 100.0));
        }
        return scorePH;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour le GH qui cotribue pour (14/100) du
     *         score de l'eau
     */
    public float setScoreGH() {

        float variationGH;
        
        if (gh >= 6 && gh <= 8) {
            scoreGH = (float) 14.0;
        }
        if (gh == 0) {
            scoreGH = (float) 0.0;
        }
        if (gh < 6 && gh != 0) {
            variationGH = 6 - gh;
            scoreGH = (float) ((100.0 - (15.0 * variationGH)) * (14.0 / 100.0));
        }
        if (gh > 8) {
            variationGH = gh - 8;
            scoreGH = (float) ((100.0 - (15.0 * variationGH)) * (14.0 / 100.0));
        }
        return scoreGH;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour le KH qui contribue pour (14/100) du
     *         score de l'eau
     */
    public float setScoreKH() {

        float variationKH;

        if (kh >= 4 && kh <= 8) {
            scoreKH = (float) 14.0;
        }
        if (kh == 0) {
            scoreKH = (float) 0.0;
        }
        if (kh < 4 && kh != 0) {
            variationKH = 4 - kh;
            scoreKH = (float) (100 - (12.5 * variationKH)) * (14 / 100);
        }
        if (kh > 8) {
            variationKH = kh - 8;
            scoreKH = (float) (100 - (12.5 * variationKH)) * (14 / 100);
        }
        return scoreKH;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour l'ammoniaque qui cotribue pour
     *         (18/100) du score de l'eau
     */
    public float setScoreAmmo() {

        float variationAmmo = 0;

        if (ammoniaque <= 0.5) {
            variationAmmo = 0;
            scoreAmmo = (float) 18.0;
        } else if (ammoniaque > 0.5) {
            variationAmmo = (float) (ammoniaque - 0.5);
            scoreAmmo = (float) ((100.0 - ((200.0 / 19.0) * variationAmmo)) * (18.0 / 100.0));
        }
        return scoreAmmo;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour les nitrites qui cotribue pour
     *         (24/100) du score de l'eau
     */
    public float setScoreNitrites() {

        float variationNitrites;

        if (nitrites <= 1) {
            variationNitrites = 0;
            scoreNitrites = (float) 24.0;
        } else if (nitrites > 1) {
            variationNitrites = nitrites - 1;
            scoreNitrites = (float) ((100.0 - ((50.0 / 17.0) * variationNitrites)) * (24.0 / 100.0));
        }
        return scoreNitrites;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour les nitrates qui cotribue pour
     *         (16/100) du score de l'eau
     */
    public float setScoreNitrates() {

        float variationNitrates;

        if (nitrates <= 40) {
            variationNitrates = 0;
            scoreNitrates = (float) 16.0;
        } else if (nitrates > 40) {
            variationNitrates = nitrates - 40;
            scoreNitrates = (float) ((100.0 - ((5.0 / 7.0) * variationNitrates)) * (16.0 / 100.0));
        }
        return scoreNitrates;
    }

    /**
     * @return string
     *         Transforme un float en string (format 2 décimales #,##)
     */
    public String toString(float flt) {

        String str = "0.00";

        if (String.valueOf(flt).length() >= 4) {
            str = String.valueOf(flt).substring(0, 4);
        } else {
            str = String.valueOf(flt);
        }
        return str;
    }

    
    /** 
     * @param jourInit
     */
    public void partirCycle(float jourInit) {
        listeCycles.add(new CycleAzote(jourInit));
    }

    /**
     * Méthode run de la classe Eau
     * Incomplète pour l'instant
     */
    @Override
    public void run() {
        penteNitrites = nitrites;
        jours = GUIMain.jours;
        jourInitial = jours;
        while (true) {
            jours = GUIMain.jours;
            // setCompteurJoursCycle(jours - jourInitial);

            if (!Temps.isPaused) {
                try {
                    sommeAmmoniaque();
                    sommeNitrites();
                    accumulerDechets();
                    absorption();
                    variationPH();
                    variationNiveauEau();
                    variationGH();
                    variationKH();

                    GUIMain.panelTest.lblPH.setText(toString(GUIMain.eau.getPH()));
                    GUIMain.panelTest.lblGH.setText(toString(GUIMain.eau.getGH()));
                    GUIMain.panelTest.lblKH.setText(toString(GUIMain.eau.getKH()));
                    GUIMain.panelTest.lblAmmo.setText(toString(GUIMain.eau.getAmmoniaque()));
                    GUIMain.panelTest.lblNitrites.setText(toString(GUIMain.eau.getNitrites()));
                    GUIMain.panelTest.lblNitrates.setText(toString(GUIMain.eau.getNitrates()));

                    GUIMain.panelTest.lblScorePH.setText(toString(GUIMain.eau.setScorePH()));
                    GUIMain.panelTest.lblScoreGH.setText(toString(GUIMain.eau.setScoreGH()));
                    GUIMain.panelTest.lblScoreKH.setText(toString(GUIMain.eau.setScoreKH()));
                    GUIMain.panelTest.lblScoreAmmo.setText(toString(GUIMain.eau.setScoreAmmo()));
                    GUIMain.panelTest.lblScoreNitrites.setText(toString(GUIMain.eau.setScoreNitrites()));
                    GUIMain.panelTest.lblScoreNitrates.setText(toString(GUIMain.eau.setScoreNitrates()));

                    GUIMain.panelTest.lblScoreEau.setText(toString(GUIMain.eau.getScoreEau()));
                    

                    // System.out.println("Compteur jours: " + Eau.compteurJoursCycle);
                    // System.out.println("déchets: " + sommeDechets);

                    for (short i = 0; i < 6; i++)
                        Poisson.setSante(i);

                    for (CycleAzote cycle : listeCycles) {
                        // cycle.setCompteurJoursCycle(jours);
                        cycle.incrJoursCalcul();
                        cycle.cycler(jours);
                    }

                    if (penteNitrites >= nitrites) {
                        comportNitrates();
                        actionEnCours = "Cycle nitrates";
                        if (nitrites != 0.0)
                            penteNitrites = nitrites;
                        // if (dechetsCycleParti)
                        // dechetsCycleParti = false;
                    } else {
                        penteNitrites = nitrites;
                    }

                    GUIMain.actionEnCours = actionEnCours;
                    Thread.sleep(Temps.DUREE);

                } catch (Exception e) {
                    e.printStackTrace();

                }
            } else { // permet de ne pas utiliser 23% du processeur si le temps est en pause
                try {
                    Thread.sleep(Temps.DUREE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }
}

// Слава Україні!