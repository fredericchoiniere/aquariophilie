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

    public static float ph = 7;                 // Acidité de l'eau
    public static int phInt = 7;                // Test pour le ph en integer
    public static float gh = 10;                // Dureté de l'eau
    public static float kh = 6;                 // Alcalinité de l'eau
    private float penteNitrites = 0;            // Utile pour déterminer si la valeur des nitrites est en décroissance
    public float sommeAbsorptionNitrates = 0;   // Score global des plantes
    public float sommeContributionPH = 0;       // Utile pour délimiter l'intensité à laquelle le ph varie
    public float volumeEau = (float) 37.85;     // Décrit le volume total d'eau dans l'aquarium en litres
    public static float nitrites = 0;           // Quantité de nitrites mg/L. Doit tendre vers 0
    public static float nitrates = 0;           // Quantité de nitrates mg/L
    public static float ammoniaque = 0;         // Quantité d'ammoniaque dans l'eau
    private float sommeAmmoniaque, sommeNitrites;// Indique la somme de toute l'ammoniaque ou de tous les nitrites dans l'eau (comptabilise plusieurs cycles simultanés) 
    public float jours = GUIMain.jours;         // Indique le jour auquel on est rendu
    public float hauteur = 35, largeur = 20, longueur = (float) 54.07; // Dimensions de l'aquarium de 10 gallons/37.85L
    public static int hauteurEnPixels = 192;    // Hauteur en pixels de l'eau de l'aquarium rempli
    public static int positionEnPixels = 305;   //

    // public int temperature;

    private static float scorePH;
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
    public static int scoreEau;

    final short valeur_changement = 3;

    public ArrayList<Float> listeAmmoniaqueTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeAmmoniaque = Collections.synchronizedList(listeAmmoniaqueTemp); // Liste synchronisée
    public ArrayList<Float> listeAmmoniaqueIteration = new ArrayList<Float>(); // Liste pour itérer dans boucle
    public HashSet<Float> setAmmoniaque = new HashSet<Float>(listeAmmoniaqueTemp); // Liste pour additionner le montant
                                                                                   // total d'ammoniaque

    public ArrayList<Float> listeNitritesTemp = new ArrayList<Float>(0); // Liste à synchroniser
    public List<Float> listeNitrites = Collections.synchronizedList(listeNitritesTemp); // Liste synchronisée
    public ArrayList<Float> listeNitritesIteration = new ArrayList<Float>(); // Liste pour itérer dans boucle
    public HashSet<Float> setNitrites = new HashSet<Float>(listeNitritesTemp); // Liste pour additionner le montant
                                                                               // total de nitrites

    public ArrayList<Integer> listeAbsorption = new ArrayList<Integer>();

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
        phInt = (int) ph;
        return phInt;
    }

    /**
     * @param nouveauPH
     *                  Setter du pH
     */
    public void setPH(float nouveauPH) {
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

    /*
     * public void changerEau() {
     * ph = 7;
     * kh = 8;
     * gh = 5;
     * nitrites = 0;
     * nitrates = 0;
     * ammoniaque = 0;
     * 
     * nbAtomeN = 0;
     * nbAtomeO = 0;
     * nbAtomeH = 0;
     * }
     */

    /*
     * public void couleur() {
     * // pourcentage de vert ou de gris dans l'eau
     * }
     */

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
        listeAmmoniaqueIteration.addAll(listeAmmoniaque);
        for (Float valeur : listeAmmoniaqueIteration) {
            if (!setAmmoniaque.contains(valeur)) {
                setAmmoniaque.add(valeur);
                sommeAmmoniaque += valeur;
            }
        }
        ammoniaque = sommeAmmoniaque;
        return ammoniaque;
    }

    /**
     * @return float
     *         Additionne toutes les valeurs dans la listeNitrites
     */
    public float sommeNitrites() {
        sommeNitrites = 0;
        listeNitritesIteration.addAll(listeNitrites);
        for (Float valeur : listeNitritesIteration) {
            if (!setNitrites.contains(valeur)) { // TODO: fix problème de valeurs qui reviennent dans courbe, J25 à 30 +
                                                 // 34,35 sont à 0
                setNitrites.add(valeur);
                sommeNitrites += valeur;
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
     * Non fonctionnel pour l'instant
     */
    public void variationPH() { // TODO: à balancer
        if (kh < 4) {
            setPH(getPH() - (float) 0.3);
            setPH(getPH() + (float) (sommeContributionPH * 0.7));
        }
        if (kh >= 4 && kh <= 8) {
            setPH(getPH() - (float) 0.15);
            setPH(getPH() + (float) (sommeContributionPH * 0.5));
        }
        if (kh > 8) { // ph varie moins, mais score non optimal car kh trop élevé
            setPH(getPH() - (float) 0.1);
            setPH(getPH() + (float) (sommeContributionPH * 0.3));
        }
    }

    /**
     * Pour l'itération 3
     */
    public void variationKH() {
        // avec déchets
    }

    /**
     * Pour l'itération 3
     */
    public void variationGH() {
        // avec volume d'eau
    }

    /**
     * Dimension de l'aquarium en cm: 54,07L x 20W x 35H
     * La hauteur de l'eau dans l'aquarium rempli est 35cm
     * 
     * 
     */
    public void variationNiveauEau() {

        hauteur -= 0.182;

        hauteurEnPixels -= valeur_changement;
        positionEnPixels += valeur_changement;

        MethodeGUIMain.setEauDimensions(positionEnPixels, hauteurEnPixels);

        volumeEau = (float) ((hauteur * largeur * longueur) * 0.001);

        System.out.println("hauteur eau: " + GUIMain.rectEau.getHeight());
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
    public float comportNitrates() {
        nitrates = ((jours / 7) - 4);
        return nitrates;
    }

    /**
     * Pour l'itération 3
     */
    public static void setScoreEau() {
        scoreEau = (int) (setScoreAmmo() + setScoreGH() + setScoreKH() + setScoreNitrates() + setScoreNitrites()
                + setScorePH());
        // System.out.println("Score eau 1 : " + scoreEau);
    }

    /**
     * @return float
     *         Retourne la valeur du score pour le PH qui cotribue pour (14/100) du
     *         score de l'eau
     */
    public static float setScorePH() {

        float variationPH;

        if (ph >= 6 && ph <= 8) {
            variationPH = 0;
            scorePH = 14;
        } else if (ph < 6) {
            variationPH = 4 - ph;
            scorePH = (100 - (20 * variationPH)) * (14 / 100);
        } else if (ph > 8) {
            variationPH = ph - 8;
            scorePH = (100 - (20 * variationPH)) * (14 / 100);
        }
        return scorePH;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour le GH qui cotribue pour (14/100) du
     *         score de l'eau
     */
    public static float setScoreGH() {

        float variationGH;

        if (gh >= 5 && gh <= 15) {
            variationGH = 0;
            scoreGH = 14;
        } else if (gh < 5) {
            variationGH = 4 - gh;
            scoreGH = (100 - (4 * variationGH)) * (14 / 100);
        } else if (gh > 8) {
            variationGH = gh - 8;
            scoreGH = (100 - (4 * variationGH)) * (14 / 100);
        }
        return scoreGH;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour le KH qui contribue pour (14/100) du
     *         score de l'eau
     */
    public static float setScoreKH() {

        float variationKH;

        if (kh >= 4 && kh <= 8) {
            variationKH = 0;
            scoreKH = 14;
        } else if (kh < 4) {
            variationKH = 4 - kh;
            scoreKH = (float) (100 - (12.5 * variationKH)) * (14 / 100);
        } else if (kh > 8) {
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
    public static float setScoreAmmo() {

        float variationAmmo = 0;

        if (ammoniaque <= 0 && ammoniaque >= 0.5) {
            variationAmmo = 0;
            scoreAmmo = 18;
        } else if (ammoniaque > 0.5) {
            variationAmmo = (float) (ammoniaque - 0.5);
            scoreAmmo = (100 - ((200 / 19) * variationAmmo)) * (18 / 100);
        }
        return scoreAmmo;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour les nitrites qui cotribue pour
     *         (24/100) du score de l'eau
     */
    public static float setScoreNitrites() {

        float variationNitrites;

        if (nitrites <= 0 && nitrites >= 1) {
            variationNitrites = 0;
            scoreNitrites = 24;
        } else if (nitrites > 1) {
            variationNitrites = nitrites - 1;
            scoreNitrites = (100 - ((50 / 17) * variationNitrites)) * (24 / 100);
        }
        return scoreNitrites;
    }

    /**
     * @return float
     *         Retourne la valeur du score pour les nitrates qui cotribue pour
     *         (16/100) du score de l'eau
     */
    public static float setScoreNitrates() {

        float variationNitrates;

        if (nitrates <= 4 || nitrates >= 8) {
            variationNitrates = 0;
            scoreNitrates = 16;
        } else if (nitrates > 40) {
            variationNitrates = nitrates - 40;
            scoreNitrates = (100 - ((5 / 7) * variationNitrates)) * (16 / 100);
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
     * Méthode run de la classe Eau
     * Incomplète pour l'instant
     */
    @Override
    public void run() {
        penteNitrites = nitrites;
        while (true) {
            jours = GUIMain.jours;
            if (!Temps.isPaused) {

                GUIMain.panelTest.lblPH.setText(toString(GUIMain.eau.getPH()));
                GUIMain.panelTest.lblGH.setText(toString(GUIMain.eau.getGH()));
                GUIMain.panelTest.lblKH.setText(toString(GUIMain.eau.getKH()));
                GUIMain.panelTest.lblAmmo.setText(toString(GUIMain.eau.getAmmoniaque()));
                GUIMain.panelTest.lblNitrites.setText(toString(GUIMain.eau.getNitrites()));
                GUIMain.panelTest.lblNitrates.setText(toString(GUIMain.eau.getNitrates()));
                System.out.println(GUIMain.eau.getNitrates());

                try {
                    sommeAmmoniaque();
                    sommeNitrites();
                    accumulerDechets();
                    absorption();
                    // variationPH();
                    variationNiveauEau();

                    

                    if (penteNitrites > nitrites) {
                        comportNitrates();
                        /*
                         * System.out.println("nitrates: " + nitrates + " absorption nit: " +
                         * sommeAbsorptionNitrates +
                         * " abs déchets: " + sommeAbsorptionDechets + " somme déchets: " +
                         * sommeDechets + " au jour " + jours + " dans thread " +
                         * Thread.currentThread().getName());
                         */
                        GUIMain.actionEnCours = "Cycle nitrates";
                        if (nitrites != 0.0)
                            penteNitrites = nitrites;
                    } else {
                        penteNitrites = nitrites;
                    }
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