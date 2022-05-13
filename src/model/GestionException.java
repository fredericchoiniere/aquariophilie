// Jérémie Caron    itération 3

package model;

import javax.swing.JOptionPane;

public class GestionException {

    
    /** 
     * @param type
     */
    public static void GestionExceptionPoi(String type) {
        JOptionPane.showMessageDialog(null, "Le poisson de type: " + type
                + " a été placé hors de l'application. Il est donc revenu dans l'inventaire. Veuiller le déposer dans l'emplacement approprié.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    
    /** 
     * @param type
     */
    public static void GestionExceptionPla(String type) {
        JOptionPane.showMessageDialog(null, "La plante de type: " + type
                + ", a été placé hors de l'application. Il est donc revenu dans l'inventaire. Veuiller le déposer dans l'emplacement approprié.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void GestionExceptionObjet() {
        JOptionPane.showMessageDialog(null,
                "L'objet a été placé hors de l'application. Il est donc revenu dans l'application. Veuiller le déposer dans l'emplacement approprié.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void GestionExceptionRadio() {
        JOptionPane.showMessageDialog(null,
                "Le démarrage de la radio qui fournit le son à l'application a échoué. Veuiller le réinitialiser si vous voulez en profiter.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void GestionExceptionThreadTemps() {
        JOptionPane.showMessageDialog(null,
                "Le thread n'a pas pu se mettre en pause. Veuillez réinitialiser le programme si vous ne voulez pas qu'il consomme trop de ressources.",
                "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void GestionExceptionThread() {
        JOptionPane.showMessageDialog(null,
                "Erreur survenue dans le thread du panelInfo",
                "Erreur", JOptionPane.ERROR_MESSAGE);
    }

    public static void GestionExceptionRadio2() {
        JOptionPane.showMessageDialog(null,
                "Erreur survenue avec la mise en pause ou le démarrage de la radio",
                "Erreur", JOptionPane.ERROR_MESSAGE);
    }

}

// Слава Україні!