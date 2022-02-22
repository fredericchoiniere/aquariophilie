package model.chimie;

public class Eau {
    public int scoreEau;
    public int ph = 7; //0 à 14 (dépend des poissons à élever) 
    public int kh = 8; //Dureté de l'eau 0 à 10? (8+ pour poissons d'eau douce en eau basique?)
    public int gh = 5; //0 à 30?
    public int nitrites = 0; //Doit etre 0, maximum 5mg par litre
    public int nitrates = 10; //
    public int ammoniac = 0;
    public int ammonium = 0;
    public int bacteries;
    public int chlore;
    public int temperature;
    public final double volumeEau = 37.85;

    public void changerEau(){
        
        scoreEau = 0;
        ph = 7;


    }
}
