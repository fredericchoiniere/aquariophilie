package model.outils;

import model.*;

public class Pipette extends Outils {

    public Pipette() { //Création de l'objet pipette
        super();
        adapterNom();

        // position de retour
        DraggableComponent.x = 835;
        DraggableComponent.y = 110;
    }

}
