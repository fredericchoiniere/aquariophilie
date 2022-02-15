package model.outils;

import model.*;

public class Pipette extends Outils {

    public Pipette() { // Création de l'objet pipette
        super();
        adapterNom();

        // position de retour
        DraggableComponent.x = 860;
        DraggableComponent.y = 200;
    }

}