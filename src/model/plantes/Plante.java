//Jérémie Caron, Frédéric Choinière     itération 2

package model.plantes;

import javax.swing.JLabel;

public class Plante extends JLabel {

    // attributs de la classe
    public int index;
    public static int prix;
    public String empInv, empAqua, nom;

    public Plante() {
    }

    public static void updateToolTip(JLabel label, String type) {
        switch (type) {
            case "java":
                label.setToolTipText("<html><p>Type: <strong><span style=\"color: #339966;\">Java Fern</span></strong></p>" +
                "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #339966;\">450฿</span></span></p>" +
                "<p><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">5 <span style=\"color: #000000;\">mg/L de nitrates par jour</span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">6 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Contribution PH: <span style=\"color: #ff9900;\">moyenne</span></span></span></span></span></span></p></html>");
                break;
            case "blue":
                label.setToolTipText("<html><p>Type: <strong><span style=\"color: #339966;\">Blue blue</span></strong></p>" +
                "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #339966;\">200฿</span></span></p>" +
                "<p><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">3 <span style=\"color: #000000;\">mg/L de nitrates par jour</span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">10 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Contribution PH: <span style=\"color: #008000;\">faible</span></span></span></span></span></span></p></html>");
                break;
            case "scarlet":
                label.setToolTipText("<html><p>Type: <strong><span style=\"color: #339966;\">Scarlet rot</span></strong></p>" +
                "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #339966;\">1000฿</span></span></p>" +
                "<p><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">8 <span style=\"color: #000000;\">mg/L de nitrates par jour</span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">20 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Contribution PH: <span style=\"color: #993366;\">&eacute;lev&eacute;e</span></span></span></span></span></span></p></html>");
                break;
            case "erdtree":
                label.setToolTipText("<html><p>Type: <strong><span style=\"color: #339966;\">Erdtree</span></strong></p>" +
                "<p><span style=\"color: #000000;\">Prix: <span style=\"color: #339966;\">5000฿</span></span></p>" +
                "<p><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">10000 <span style=\"color: #000000;\">mg/L de nitrates par jour</span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Absorbe <span style=\"color: #339966;\">10000 <span style=\"color: #000000;\">d&eacute;chets par jour</span></span></span></span></span></p> " +
                "<p><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\"><span style=\"color: #339966;\"><span style=\"color: #000000;\">Contribution PH: <span style=\"color: #008000;\">faible</span></span></span></span></span></span></p></html>");
                break;
            default:
                break;
        }
    }
}

// Слава Україні!