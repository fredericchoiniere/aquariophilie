//Frédéric Choinière, Justin Plouffe
// Itération 2

package model.chimie;

import view.GUIMain;

public class Molecules{

    public Eau eau = GUIMain.eau;

    double molAtomeNAmmo = 0, molAtomeNNi = 0, molAtomeNNa = 0;
    double molAtomeONi = 0, molAtomeONa = 0;
    public double molAtomeH = 0;
    double sommeMolN, sommeMolO;

    double molAmmoniaque = 0;
    public double molNitrites = 0;
    double molNitrates = 0;

    float masseMolaireAmmoniaque = (float) 17.03; // g/mol
    float masseMolaireNitrites = (float) 46.01;
    float masseMolaireNitrates = (float) 62.01;

    
    /** 
     * @return double
     * Convertit le montant d'ammoniaque de mg/L à mols
     */
    public double ammoniaqueMgLtoMol(){
        molAmmoniaque = (eau.getAmmoniaque()/1000)/masseMolaireAmmoniaque;
        return molAmmoniaque;
    }

    /**
     * Calcule le nombre d'atomes dans les molécules d'ammoniaque
     */
    public void ammoniaqueAtomesMol(){
        molAtomeNAmmo = ammoniaqueMgLtoMol() * 0.822; //  82.2% de la masse correspond à l'azote
        molAtomeH = ammoniaqueMgLtoMol() * 0.178; //  17.8% de la masse correspond à l'hydrogène
    }

    
    /** 
     * @return double
     * Convertit le montant de nitrites de mg/L à mols
     */
    public double nitritesMgLtoMol(){
        molNitrites = (eau.getNitrites()/1000)/masseMolaireNitrites;
        return molNitrites;
    }

    /**
     * Calcule le nombre d'atomes dans les molécules de nitrites
     */
    public void nitritesAtomesMol(){
        molAtomeNNi= nitritesMgLtoMol() * 0.304; //  30.4% de la masse correspond à l'azote
        molAtomeONi = nitritesMgLtoMol() * 0.696; //  69.6% de la masse correspond à l'oxygène
    }

    
    /** 
     * @return double
     * Convertit le montant de nitrates de mg/L à mols
     */
    public double nitratesMgLtoMol(){
        molNitrates = (eau.getNitrates()/1000)/masseMolaireNitrates;
        return molNitrates;
    }

    /**
     * Calcule le nombre d'atomes dans les molécules de nitrates
     */
    public void nitratesAtomesMol(){
        molAtomeNNa = nitratesMgLtoMol() * 0.226; //  22.6% de la masse correspond à l'azote
        molAtomeONa = nitratesMgLtoMol() * 0.774; //  77.4% de la masse correspond à l'oxygène
    }

    /** 
     * @return double
     * Retourne la somme d'atomes d'azote en mols
     */
    public double sommeMolN(){
        sommeMolN = molAtomeNAmmo + molAtomeNNa + molAtomeNNi;
        return sommeMolN;
    }

    /** 
     * @return double
     * Retourne la somme d'atomes d'oxygène en mols
     */
    public double sommeMolO(){
        sommeMolO = molAtomeONa + molAtomeONi;
        return sommeMolO;
    }

}