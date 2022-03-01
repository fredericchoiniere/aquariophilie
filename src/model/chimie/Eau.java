package model.chimie;

import view.GUIMain;

public class Eau implements Runnable {

    public final double volumeEau = 37.85;
    public int scoreEau;

    public int ph = 7; // 0 à 14 (dépend des poissons à élever)
    public int kh = 8; // Dureté de l'eau 0 à 10? (8+ pour poissons d'eau douce en eau basique?)
    public int gh = 5; // 0 à 30?
    public int nitrites = 0; // Doit etre 0, maximum 5mg par litre
    public double nitrates = 0; // max 50mg/L
    public int ammoniac = 0;
    public int ammonium = 0;

    public int nbAtomeN = 0;
    public int nbAtomeO = 2103;
    public int nbAtomeH = 4206;

    public int bacteries;
    public int chlore;
    public int temperature;
    

    public float jours = GUIMain.jours; // TODO: va être remplacé

    public void changerEau() {

        ph = 7; 
        kh = 8; 
        gh = 5; 
        nitrites = 0;
        nitrates = 0;
        ammoniac = 0;
        ammonium = 0;
        nbAtomeN = 0;
        nbAtomeO = 0;
        nbAtomeH = 0;
        temperature = 15;

    }

    public void couleur() {

        //pourcentage de vert dans l'eau

    }

    public void comportAmmoniaque() { // voir fonction, mettre dans intervalle [tant que y > 0 && pente négative]

        

    }

    public double comportNitrite(){ // voir fonction, mettre dans intervalle [tant que y > 0 && pente négative]
        double pet = 0;
        return pet;
    }

    public double comportNitrate() {
        //System.out.println("nitrates"+ nitrates);
        this.nitrates = ((jours/7) - 4);
        return this.nitrates;
    }

    @Override
    public void run() { // TODO: updater avec changement de jour
        while (true) {
            //System.out.println("while");
            jours = GUIMain.jours;

            try {
                if (jours > 28) {
                    //System.out.println("compote");
                    comportNitrate();
                    Thread.sleep(1000); // à enlever
                } else Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    }
}
