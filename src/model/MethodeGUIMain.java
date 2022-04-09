package model;

import javax.swing.JLabel;

import model.jeu.Aquarium;
import model.jeu.Argent;
import model.jeu.Inventaire;
import model.plantes.BlueBlue;
import model.plantes.JavaFern;
import model.plantes.ScarletRot;
import model.poissons.PoissonBetta;
import model.poissons.PoissonRouge;
import model.poissons.PoissonTetra;
import view.GUIMain;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

public class MethodeGUIMain {

    Aquarium aquarium;
    Inventaire inventaire;

    public static void checkRectanglesDeco(Rectangle rectangle, JLabel label, Icon icone, JLabel label2,
            String emplacement,
            boolean hasPlant, String hasPlantString, int indexInv, int indexAqua, String pla) {
        if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {

            if (hasPlant) {
                // System.out.println("emplacement déjà occupé");
            } else {
                setHasPlant(hasPlantString);
                setPlantName(indexAqua, pla);
                label.setIcon(icone);
                label2.setIcon(Inventaire.empty_inv);
                setEmpla(emplacement);
                setEmplaToPlant(emplacement, pla, indexInv, indexAqua);
            }

        }
    }

    /**
     * @param rectangle
     * @param label
     * @param icone
     *                  regarder si la souris est dans le rectangle lors du
     *                  lachement de la touche
     */
    public static void checkRectanglesPoi(Rectangle rectangle, JLabel label1, Icon icone, JLabel label2,
            String emplacement,
            boolean hasFish, String hasFishString, int index, String poi, String aqua) {
        if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {

            if (hasFish == true) {
                // System.out.println("emplacement déjà occupé");

            } else {
                setHasFish(hasFishString);
                label1.setIcon(icone);
                label2.setIcon(Inventaire.empty_inv);
                setEmpla(emplacement);
                setEmplaToFish(emplacement, poi, label1, index);
                // setAquaName(poi, aqua);

                // createPoissonRouge(emplacement, label1, index);
                // createPoissonBetta(emplacement, label1, index);
                // System.out.println("hasFish = " + hasFish);
            }

        }
    }

    public static void checkRectanglesPoiFilet(Rectangle rectangle, JLabel label1, Icon icone, // TODO changer pour un
                                                                                               // bouton
            boolean hasFish, String hasFishString, int index, String aqua) {
        if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {

            if (hasFish == true) {
                setHasFishFalse(hasFishString);
                label1.setIcon(icone);
                // PanelShop.checkCase(Inventaire.img_inv_poi_rouge, "poisson", "rouge");

                if (GUIMain.listePoissonsAqua.get(index).index == index) {
                    GUIMain.listePoissonsAqua.get(index).direction = "empty";
                    GUIMain.listePoissonsAqua.get(index).var = false;
                    GUIMain.listePoissonsInv.set(index, GUIMain.poisson_default);
                    checkFishType(aqua);
                }
            } else {
                System.out.println("à deja pas de poisson");
            }
        }
    }

    public static void checkRectanglesDecoCis(Rectangle rectangle, JLabel label1, Icon icone, // TODO changer pour un
                                                                                              // bouton
            boolean hasPlant, String hasPlantString, int index, String plant) {
        if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {

            if (hasPlant == true) {
                setHasPlantFalse(hasPlantString);
                label1.setIcon(icone);
                // PanelShop.checkCase(Inventaire.img_inv_poi_rouge, "poisson", "rouge");

                // if (GUIMain.listePlantesAqua.get(index).index == index) {
                GUIMain.listePlantesAqua.set(index, GUIMain.plante_default);
                // checkFishType(plant);
                // System.out.println(plant + " " + index);
                checkPlantType(plant);
                // }
            } else {
                System.out.println("à deja pas de poisson");
            }
        }
    }

    public void checkRectanglesShop(Rectangle rectangle, JLabel label1, String emplacement) {
        if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {
            label1.setIcon(Inventaire.empty_inv);
            setEmpla(emplacement);
        }
    }

    /**
     * create a method that creates a new PoissonTetra and make it appear on the
     * frame on panelAqua
     */

    public static void createPoissonTetra(String emplacement, JLabel label1, int index) {
        GUIMain.listePoissonsAqua.set(index, GUIMain.listePoissonsInv.get(getEmplaToInt(emplacement)));
        GUIMain.poisson_tetra = (PoissonTetra) GUIMain.listePoissonsAqua.get(index);
        GUIMain.poisson_tetra.setBounds(340, 324, 322, 156);
        GUIMain.poisson_tetra.index = setIndexPoi(index);
        GUIMain.tpoisson_tetra = new Thread(GUIMain.poisson_tetra);
        Argent.poi3 += 2;
        GUIMain.tpoisson_tetra.start();
        GUIMain.panelAqua.add(GUIMain.poisson_tetra);
        setAquaName(index, "tetra");
    }

    public static void createPoissonBetta(String emplacement, JLabel label, int index) {
        GUIMain.listePoissonsAqua.set(index, GUIMain.listePoissonsInv.get(getEmplaToInt(emplacement)));
        GUIMain.poisson_betta = (PoissonBetta) GUIMain.listePoissonsAqua.get(index);
        GUIMain.poisson_betta.setBounds(340, 324, 322, 156);
        GUIMain.poisson_betta.index = setIndexPoi(index);
        GUIMain.tpoisson_betta = new Thread(GUIMain.poisson_betta);
        Argent.poi2 += 3;
        GUIMain.tpoisson_betta.start();
        GUIMain.panelAqua.add(GUIMain.poisson_betta);
        setAquaName(index, "betta");

    }

    public static void createPoissonRouge(String emplacement, JLabel label1, int index) { // passer de l'inventaire à
        // l'aquarium
        GUIMain.listePoissonsAqua.set(index, GUIMain.listePoissonsInv.get(getEmplaToInt(emplacement)));
        GUIMain.poisson_rouge = (PoissonRouge) GUIMain.listePoissonsAqua.get(index);
        GUIMain.poisson_rouge.setBounds(340, 324, 322, 156);
        GUIMain.poisson_rouge.index = setIndexPoi(index);
        GUIMain.tpoisson_rouge = new Thread(GUIMain.poisson_rouge);
        Argent.poi1 += 1;
        GUIMain.tpoisson_rouge.start();
        GUIMain.panelAqua.add(GUIMain.poisson_rouge);
        setAquaName(index, "rouge");
    }

    /**
     * set les labels des poissons visible
     */
    public void aquaVisibleTrue() {
        aquarium.aqua1.setVisible(true);
        aquarium.aqua2.setVisible(true);
        aquarium.aqua3.setVisible(true);
        aquarium.aqua4.setVisible(true);
        aquarium.aqua5.setVisible(true);
        aquarium.aqua6.setVisible(true);
        GUIMain.shop_label.setVisible(true);
    }

    /**
     * set les labels des poissons invisible
     */
    public void aquaVisibleFalse() {
        aquarium.aqua1.setVisible(false);
        aquarium.aqua2.setVisible(false);
        aquarium.aqua3.setVisible(false);
        aquarium.aqua4.setVisible(false);
        aquarium.aqua5.setVisible(false);
        aquarium.aqua6.setVisible(false);
        GUIMain.shop_label.setVisible(false);
    }

    public void empVisibleTrue() { // set les labels des emplacements visible
        aquarium.emp1.setVisible(true);
        aquarium.emp2.setVisible(true);
        aquarium.emp3.setVisible(true);

    }

    public void empVisibleFalse() { // set les labels des emplacements invisible
        aquarium.emp1.setVisible(false);
        aquarium.emp2.setVisible(false);
        aquarium.emp3.setVisible(false);
    }

    public static void setEmpla(String emplacement) { // set l'emplacement du poisson
        switch (emplacement) { // dans l'inventaire
            case "empla1":
                GUIMain.empla1 = "empty";
                // System.out.println("cul");
                break;
            case "empla2":
                GUIMain.empla2 = "empty";
                break;
            case "empla3":
                GUIMain.empla3 = "empty";
                break;
            case "empla4":
                GUIMain.empla4 = "empty";
                break;
            case "empla5":
                GUIMain.empla5 = "empty";
                break;
            case "empla6":
                GUIMain.empla6 = "empty";
                break;
            default:
                break;
        }
    }

    public static int getEmplaToInt(String emplacement) { // TODO: à revoir
        int index = 420;
        switch (emplacement) {
            case "empla1":
                index = 0;
                break;
            case "empla2":
                index = 1;
                break;
            case "empla3":
                index = 2;
                break;
            case "empla4":
                index = 3;
                break;
            case "empla5":
                index = 4;
                break;
            case "empla6":
                index = 5;
                break;
            default:
                break;
        }
        return index;
    }

    public static void setHasFish(String hasFish) { // set le poisson dans l'inventaire
        switch (hasFish) { // dans l'inventaire
            case "hasFish1":
                GUIMain.hasFish1 = true;
                break;
            case "hasFish2":
                GUIMain.hasFish2 = true;
                break;
            case "hasFish3":
                GUIMain.hasFish3 = true;
                break;
            case "hasFish4":
                GUIMain.hasFish4 = true;
                break;
            case "hasFish5":
                GUIMain.hasFish5 = true;
                break;
            case "hasFish6":
                GUIMain.hasFish6 = true;
                break;
            default:
                break;
        }
    }

    public static void setHasPlant(String hasPlant) {
        switch (hasPlant) { // dans l'inventaire
            case "hasPlant1":
                GUIMain.hasPlant1 = true;
                break;
            case "hasPlant2":
                GUIMain.hasPlant2 = true;
                break;
            case "hasPlant3":
                GUIMain.hasPlant3 = true;
                break;
            default:
                break;
        }
    }

    public static void setHasFishFalse(String hasFish) { // set le poisson dans l'inventaire
        switch (hasFish) { // dans l'inventaire
            case "hasFish1":
                GUIMain.hasFish1 = false;
                break;
            case "hasFish2":
                GUIMain.hasFish2 = false;
                break;
            case "hasFish3":
                GUIMain.hasFish3 = false;
                break;
            case "hasFish4":
                GUIMain.hasFish4 = false;
                break;
            case "hasFish5":
                GUIMain.hasFish5 = false;
                break;
            case "hasFish6":
                GUIMain.hasFish6 = false;
                break;
            default:
                break;
        }
    }

    public static void setHasPlantFalse(String hasPlant) { // set le poisson dans l'inventaire
        switch (hasPlant) { // dans l'inventaire
            case "hasPlant1":
                GUIMain.hasPlant1 = false;
                break;
            case "hasPlant2":
                GUIMain.hasPlant2 = false;
                break;
            case "hasPlant3":
                GUIMain.hasPlant3 = false;
                break;
            default:
                break;
        }
    }

    public static int setIndexPoi(int index1) { // set le poisson dans l'inventaire
        int index = 69;
        switch (index1) { // dans l'inventaire
            case 0:
                index = 0;
                break;
            case 1:
                index = 1;
                break;
            case 2:
                index = 2;
                break;
            case 3:
                index = 3;
                break;
            case 4:
                index = 4;
                break;
            case 5:
                index = 5;
                break;
            default:
                break;
        }
        return index;
    }

    public static void setEmplaToFish(String emplacement, String poi, JLabel label1, int index) { // TODO: à revoir
        // impérativement

        switch (poi) {
            case "rouge":
                createPoissonRouge(emplacement, label1, index);
                break;
            case "betta":
                createPoissonBetta(emplacement, label1, index);
                break;
            case "tetra":
                createPoissonTetra(emplacement, label1, index);
                break;
            default:
                break;
        }
    }

    public static void setEmplaToPlant(String emplacement, String poi, int indexInv, int indexAqua) { // TODO: à revoir
        // impérativement

        switch (poi) {
            case "blue":
                GUIMain.listePlantesAqua.set(indexAqua, GUIMain.listePlantesInv.get(indexInv));
                // System.out.println("blue");
                Argent.emp1 += 2;
                break;
            case "java":
                GUIMain.listePlantesAqua.set(indexAqua, GUIMain.listePlantesInv.get(indexInv));
                // System.out.println("java");
                Argent.emp2 += 5;
                break;
            case "scarlet":
                GUIMain.listePlantesAqua.set(indexAqua, GUIMain.listePlantesInv.get(indexInv));
                // System.out.println("scarlet");
                Argent.emp3 += 10;
                break;
            default:
                break;
        }
    }

    public static void checkFishType(String aqua) {
        switch (aqua) {
            case "rouge":
                Argent.poi1 -= 1;
                Argent.argent += PoissonRouge.prix / 2;
                break;
            case "betta":
                Argent.poi2 -= 3;
                Argent.argent += PoissonBetta.prix / 2;
                break;
            case "tetra":
                Argent.poi3 -= 2;
                Argent.argent += PoissonTetra.prix / 2;
                break;
            default:
                break;
        }
    }

    public static void checkPlantType(String plant) {
        switch (plant) {
            case "blue":
                Argent.emp1 -= 2;
                Argent.argent += BlueBlue.prix / 2;
                break;
            case "java":
                Argent.emp2 -= 5;
                Argent.argent += JavaFern.prix / 2;
                break;

            case "scarlet":
                Argent.emp3 -= 10;
                Argent.argent += ScarletRot.prix / 2;
                break;
            default:
                break;
        }
    }

    public static void setAquaName(int index, String aqua) {
        switch (index) {
            case 0:
                GUIMain.aqua1 = aqua;
                break;
            case 1:
                GUIMain.aqua2 = aqua;
                break;
            case 2:
                GUIMain.aqua3 = aqua;
                break;
            case 3:
                GUIMain.aqua4 = aqua;
                break;
            case 4:
                GUIMain.aqua5 = aqua;
                break;
            case 5:
                GUIMain.aqua6 = aqua;
                break;

            default:
                break;
        }
    }

    public static void setPlantName(int index, String plant) {
        switch (index) {
            case 0:
                GUIMain.aquaPla1 = plant;
                break;
            case 1:
                GUIMain.aquaPla2 = plant;
                break;
            case 2:
                GUIMain.aquaPla3 = plant;
                break;
            default:
                break;
        }
    }
}
