//Jérémie Caron, Frédéric Choinière    itération 2

package model;

import model.jeu.*;
import model.plantes.*;
import model.poissons.*;
import view.GUIMain;

import java.awt.*;
import javax.swing.*;

public class MethodeGUIMain {

    // call des attributs de la classe
    Aquarium aquarium;
    Inventaire inventaire;
    static Boolean hasPlants = false;

    /**
     * @param rectangle
     * @param label
     * @param icone
     * @param label2
     * @param emplacement
     * @param hasPlant
     * @param hasPlantString
     * @param indexInv
     * @param indexAqua
     * @param pla
     *                       méthode pour regarder quoi faire quand l'on dépose une
     *                       plante dans l'aquarium
     */
    public static void checkRectanglesDeco(Rectangle rectangle, JLabel label, Icon icone, JLabel label2,
            String emplacement, boolean hasPlant, String hasPlantString, int indexInv, int indexAqua, String pla) {
        try {
            if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                    && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                    && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                    && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {
                if (!hasPlant) {
                    setHasPlant(hasPlantString);
                    setPlantName(indexAqua, pla);
                    label.setIcon(icone);
                    label2.setIcon(Inventaire.empty_inv);
                    setEmpla(emplacement);
                    setEmplaToPlant(emplacement, pla, indexInv, indexAqua);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veuillez rester à l'intérieur de l'application", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param rectangle
     * @param label
     * @param icone
     *                  méthode pour regarder quoi faire quand l'on dépose un
     *                  poisson dans l'aquarium
     */
    public static void checkRectanglesPoi(Rectangle rectangle, JLabel label1, Icon icone, JLabel label2,
            String emplacement, boolean hasFish, String hasFishString, int index, String poi, String aqua) {
        try {
            if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                    && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                    && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                    && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {
                if (!hasFish) {
                    try {
                        setHasFish(hasFishString);
                        label1.setIcon(icone);
                        label2.setIcon(Inventaire.empty_inv);
                        setEmpla(emplacement);
                        setEmplaToFish(emplacement, poi, label1, index);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veuillez rester à l'intérieur de l'application", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param rectangle
     * @param label1
     * @param icone
     * @param hasFish
     * @param hasFishString
     * @param index
     * @param aqua
     *                      méthode pour regarder quoi faire quand l'on dépose le
     *                      filet dans l'aquarium
     */
    public static void checkRectanglesPoiFilet(Rectangle rectangle, JLabel label1, Icon icone,
            boolean hasFish, String hasFishString, int index, String aqua) {
        try {
            if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                    && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                    && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                    && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {
                if (hasFish) {
                    setHasFishFalse(hasFishString);
                    label1.setIcon(icone);
                    GUIMain.listePoissonsAqua.get(index).direction = "empty";
                    GUIMain.listePoissonsAqua.get(index).var = false;
                    GUIMain.listePoissonsAqua.set(index, GUIMain.poisson_default);
                    checkFishType(aqua);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veuillez rester à l'intérieur de l'application", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param rectangle
     * @param label1
     * @param icone
     * @param hasPlant
     * @param hasPlantString
     * @param index
     * @param plant
     *                       méthode pour regarder quoi faire quand l'on dépose le
     *                       ciseau dans l'aquarium
     */
    public static void checkRectanglesDecoCis(Rectangle rectangle, JLabel label1, Icon icone,
            boolean hasPlant, String hasPlantString, int index, String plant) {
        try {
            if (GUIMain.panelAqua.getMousePosition().getX() >= rectangle.getMinX()
                    && GUIMain.panelAqua.getMousePosition().getX() <= rectangle.getMaxX()
                    && GUIMain.panelAqua.getMousePosition().getY() >= rectangle.getMinY()
                    && GUIMain.panelAqua.getMousePosition().getY() <= rectangle.getMaxY()) {
                if (hasPlant) {
                    setHasPlantFalse(hasPlantString);
                    label1.setIcon(icone);
                    GUIMain.listePlantesAqua.set(index, GUIMain.plante_default);
                    checkPlantType(plant);
                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Veuillez rester à l'intérieur de l'application", "Erreur", JOptionPane.ERROR_MESSAGE);
        }
    }

    /**
     * @param emplacement
     * @param label
     * @param index
     *                    méthode pour créer un poisson tetra
     */
    public static void createPoissonTetra(String emplacement, JLabel label1, int index) {
        GUIMain.listePoissonsAqua.set(index, GUIMain.listePoissonsInv.get(getEmplaToInt(emplacement)));
        GUIMain.poisson_tetra = (PoissonTetra) GUIMain.listePoissonsAqua.get(index);
        GUIMain.poisson_tetra.setBounds(340, 324, 322, 156);
        GUIMain.poisson_tetra.index = setIndexPoi(index);
        GUIMain.tpoisson_tetra = new Thread(GUIMain.poisson_tetra);
        Argent.poi3 += 2;
        GUIMain.eau.potentielDechets += PoissonTetra.dechets;
        GUIMain.tpoisson_tetra.start();
        GUIMain.panelAqua.add(GUIMain.poisson_tetra);
        setAquaName(index, "tetra");
    }

    /**
     * @param emplacement
     * @param label
     * @param index
     *                    méthode pour créer un poisson betta
     */
    public static void createPoissonBetta(String emplacement, JLabel label, int index) {
        GUIMain.listePoissonsAqua.set(index, GUIMain.listePoissonsInv.get(getEmplaToInt(emplacement)));
        GUIMain.poisson_betta = (PoissonBetta) GUIMain.listePoissonsAqua.get(index);
        GUIMain.poisson_betta.setBounds(340, 324, 322, 156);
        GUIMain.poisson_betta.index = setIndexPoi(index);
        GUIMain.tpoisson_betta = new Thread(GUIMain.poisson_betta);
        Argent.poi2 += 3;
        GUIMain.eau.potentielDechets += PoissonBetta.dechets;
        GUIMain.tpoisson_betta.start();
        GUIMain.panelAqua.add(GUIMain.poisson_betta);
        setAquaName(index, "betta");
    }

    /**
     * @param emplacement
     * @param label1
     * @param index
     *                    méthode pour créer un poisson rouge
     */
    public static void createPoissonRouge(String emplacement, JLabel label1, int index) {
        GUIMain.listePoissonsAqua.set(index, GUIMain.listePoissonsInv.get(getEmplaToInt(emplacement)));
        GUIMain.poisson_rouge = (PoissonRouge) GUIMain.listePoissonsAqua.get(index);
        GUIMain.poisson_rouge.setBounds(340, 324, 322, 156);
        GUIMain.poisson_rouge.index = setIndexPoi(index);
        GUIMain.tpoisson_rouge = new Thread(GUIMain.poisson_rouge);
        Argent.poi1 += 1;
        GUIMain.eau.potentielDechets += PoissonRouge.dechets;
        GUIMain.tpoisson_rouge.start();
        GUIMain.panelAqua.add(GUIMain.poisson_rouge);
        setAquaName(index, "rouge");
    }

    /**
     * méthode pour rendre les emplacements à poisson visible
     */
    public void aquaVisibleTrue() {
        aquarium.aqua1.setVisible(true);
        aquarium.aqua2.setVisible(true);
        aquarium.aqua3.setVisible(true);
        aquarium.aqua4.setVisible(true);
        aquarium.aqua5.setVisible(true);
        aquarium.aqua6.setVisible(true);
    }

    /**
     * méthode pour rendre les emplacements à poisson invisible
     */
    public void aquaVisibleFalse() {
        aquarium.aqua1.setVisible(false);
        aquarium.aqua2.setVisible(false);
        aquarium.aqua3.setVisible(false);
        aquarium.aqua4.setVisible(false);
        aquarium.aqua5.setVisible(false);
        aquarium.aqua6.setVisible(false);
    }

    /**
     * méthode pour rendre les emplacements à plante visible
     */
    public void empVisibleTrue() {
        aquarium.emp1.setVisible(true);
        aquarium.emp2.setVisible(true);
        aquarium.emp3.setVisible(true);
    }

    /**
     * méthode pour rendre les emplacements à plante invisible
     */
    public void empVisibleFalse() {
        aquarium.emp1.setVisible(false);
        aquarium.emp2.setVisible(false);
        aquarium.emp3.setVisible(false);
    }

    /**
     * @param emplacement
     *                    méthode pour remettre l'emplacement en empty
     */
    public static void setEmpla(String emplacement) { // set l'emplacement du poisson
        switch (emplacement) { // dans l'inventaire
            case "empla1":
                GUIMain.empla1 = "empty";
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

    /**
     * @param emplacement
     * @return index
     *         méthode pour retourner un index selon l'emplacement
     */
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

    /**
     * @param hasFish
     *                méthode pour rendre l'emplacement rempli
     */
    public static void setHasFish(String hasFish) {
        switch (hasFish) {
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

    /**
     * @param hasPlant
     *                 méthode pour rendre l'emplacement rempli
     */
    public static void setHasPlant(String hasPlant) {
        switch (hasPlant) {
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

    /**
     * @param hasFish
     *                méthode pour rendre l'emplacement vide
     */
    public static void setHasFishFalse(String hasFish) {
        switch (hasFish) {
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

    /**
     * @param hasPlant
     *                 méthode pour rendre l'emplacement vide
     */
    public static void setHasPlantFalse(String hasPlant) {
        switch (hasPlant) {
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

    /**
     * @param index1
     * @return index
     *         méthode pour retourner un int en index
     */
    public static int setIndexPoi(int index1) {
        int index = 69;
        switch (index1) {
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

    /**
     * @param emplacement
     * @param poi
     * @param label1
     * @param index
     *                    méthode pour créer le poisson selon le type rentrer
     */
    public static void setEmplaToFish(String emplacement, String poi, JLabel label1, int index) {
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

    /**
     * @param emplacement
     * @param poi
     * @param indexInv
     * @param indexAqua
     *                    méthode pour créer la plante selon le type rentrer
     */
    public static void setEmplaToPlant(String emplacement, String poi, int indexInv, int indexAqua) {
        switch (poi) {
            case "blue":
                GUIMain.listePlantesAqua.set(indexAqua, GUIMain.listePlantesInv.get(indexInv));
                Argent.emp1 += 2;
                GUIMain.eau.sommeAbsorptionNitrates += BlueBlue.absorptionNitrates;
                GUIMain.eau.sommeAbsorptionDechets += BlueBlue.absorptionDechets;
                GUIMain.eau.sommeContributionPH += BlueBlue.contributionPH;
                break;
            case "java":
                GUIMain.listePlantesAqua.set(indexAqua, GUIMain.listePlantesInv.get(indexInv));
                Argent.emp2 += 5;
                GUIMain.eau.sommeAbsorptionNitrates += JavaFern.absorptionNitrates;
                GUIMain.eau.sommeAbsorptionDechets += JavaFern.absorptionDechets;
                GUIMain.eau.sommeContributionPH += JavaFern.contributionPH;
                break;
            case "scarlet":
                GUIMain.listePlantesAqua.set(indexAqua, GUIMain.listePlantesInv.get(indexInv));
                Argent.emp3 += 10;
                GUIMain.eau.sommeAbsorptionNitrates += ScarletRot.absorptionNitrates;
                GUIMain.eau.sommeAbsorptionDechets += ScarletRot.absorptionDechets;
                GUIMain.eau.sommeContributionPH += ScarletRot.contributionPH;
                break;
            default:
                break;
        }
    }

    /**
     * @param aqua
     *             méthode pour lorsque l'on enlève le poisson
     */
    public static void checkFishType(String aqua) {
        switch (aqua) {
            case "rouge":
                Argent.poi1 -= 1;
                Argent.argent += PoissonRouge.prix / 2;
                GUIMain.eau.potentielDechets -= PoissonRouge.dechets;
                break;
            case "betta":
                Argent.poi2 -= 3;
                Argent.argent += PoissonBetta.prix / 2;
                GUIMain.eau.potentielDechets -= PoissonBetta.dechets;
                break;
            case "tetra":
                Argent.poi3 -= 2;
                Argent.argent += PoissonTetra.prix / 2;
                GUIMain.eau.potentielDechets -= PoissonTetra.dechets;
                break;
            default:
                break;
        }
    }

    /**
     * @param plant
     *              méthode pour lorsque l'on enlève la plante
     */
    public static void checkPlantType(String plante) {
        switch (plante) {
            case "blue":
                Argent.emp1 -= 2;
                Argent.argent += BlueBlue.prix / 2;
                GUIMain.eau.sommeAbsorptionNitrates -= BlueBlue.absorptionNitrates;
                GUIMain.eau.sommeAbsorptionDechets -= BlueBlue.absorptionDechets;
                GUIMain.eau.sommeContributionPH -= BlueBlue.contributionPH;
                break;
            case "java":
                Argent.emp2 -= 5;
                Argent.argent += JavaFern.prix / 2;
                GUIMain.eau.sommeAbsorptionNitrates -= JavaFern.absorptionNitrates;
                GUIMain.eau.sommeAbsorptionDechets -= JavaFern.absorptionDechets;
                GUIMain.eau.sommeContributionPH -= JavaFern.contributionPH;
                break;
            case "scarlet":
                Argent.emp3 -= 10;
                Argent.argent += ScarletRot.prix / 2;
                GUIMain.eau.sommeAbsorptionNitrates -= ScarletRot.absorptionNitrates;
                GUIMain.eau.sommeAbsorptionDechets -= ScarletRot.absorptionDechets;
                GUIMain.eau.sommeContributionPH -= ScarletRot.contributionPH;
                break;
            default:
                break;
        }
    }

    /**
     * @param index
     * @param aqua
     *              méthode pour set le nom du poisson selon l'index
     */
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

    /**
     * @param index
     * @param plant
     *              méthode pour set le nom de la plante selon l'index
     */
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

    /**
     * @return Boolean
     *         méthode pour retourner si il y a une plante
     */
    public static Boolean hasPlants() {
        if (!GUIMain.hasPlant1 && !GUIMain.hasPlant2 && !GUIMain.hasPlant3) {
            hasPlants = false;
        } else
            hasPlants = true;
        return hasPlants;
    }

    /** 
     * @return Rectangle
     *      Retourne les dimensions du rectangle Eau
     */
    public static Rectangle getEauDimensions(){
        return GUIMain.rectEau;
    }

    /** 
     * @param y
     * @param height
     *          Redéfinit les dimensions du rectangle Eau en fonction des paramètres spécifiés 
     *          Rafraîchit l'affichage de l'eau
     */
    public static void setEauDimensions(int y, int height){
        GUIMain.rectEau.setBounds((int)GUIMain.rectEau.getX(), y, (int)GUIMain.rectEau.getWidth(), height);
        GUIMain.panelAqua.repaint();
    }

}
