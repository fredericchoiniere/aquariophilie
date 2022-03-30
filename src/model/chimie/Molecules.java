//Frédéric Choinière, Justin Plouffe
// Itération 2

package model.chimie;

import view.GUIMain;

public class Molecules{

    Eau eau = GUIMain.eau;

    double molAtomeNAmmo = 0, molAtomeNNi = 0, molAtomeNNa = 0;
    double molAtomeONi = 0, molAtomeONa = 0;
    public double molAtomeH = 0;
    double sommeMolN, sommeMolO;

    double molAmmoniaque = 0;
    double molNitrites = 0;
    double molNitrates = 0;

    float masseMolaireAmmoniaque = (float) 17.03; // g/mol
    float masseMolaireNitrites = (float) 46.01;
    float masseMolaireNitrates = (float) 62.01;

    public double ammoniaqueMgLtoMol(){
        molAmmoniaque = (eau.ammoniaque/1000)/masseMolaireAmmoniaque;
        return molAmmoniaque;
    }

    public void ammoniaqueAtomesMol(){
        molAtomeNAmmo = ammoniaqueMgLtoMol() * 0.822; //  82.2% de la masse correspond à l'azote
        molAtomeH = ammoniaqueMgLtoMol() * 0.178; //  17.8% de la masse correspond à l'hydrogène
    }

    public double nitritesMgLtoMol(){
        molNitrites = (eau.nitrites/1000)/masseMolaireNitrites;
        return molNitrites;
    }

    public void nitritesAtomesMol(){
        molAtomeNNi= nitritesMgLtoMol() * 0.304; //  30.4% de la masse correspond à l'azote
        molAtomeONi = nitritesMgLtoMol() * 0.696; //  69.6% de la masse correspond à l'oxygène
    }

    public double nitratesMgLtoMol(){
        molNitrates = (eau.nitrates/1000)/masseMolaireNitrates;
        return molNitrates;
    }

    public void nitratesAtomesMol(){
        molAtomeNNa = nitratesMgLtoMol() * 0.226; //  22.6% de la masse correspond à l'azote
        molAtomeONa = nitratesMgLtoMol() * 0.774; //  77.4% de la masse correspond à l'oxygène
    }

    public double sommeMolN(){
        sommeMolN = molAtomeNAmmo + molAtomeNNa + molAtomeNNi;
        return sommeMolN;
    }

    public double sommeMolO(){
        sommeMolO = molAtomeONa + molAtomeONi;
        return sommeMolO;
    }

}