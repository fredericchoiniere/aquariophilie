// Itération 1: Jérémie Caron
// Itération 2: Frédéric Choinière

//Classe pour l'affichage des infos

package view.tabs;

import java.awt.*;
import java.text.DecimalFormat;
import javax.swing.*;
import model.GestionException;
import model.chimie.Molecules;
import model.environnement.Temps;
import view.GUIMain;

public class PanelInfo extends JPanel implements Runnable {

    // appel des attributs de la classe
    public static JLabel lblAction, lblN, lblH, lblO, lblAmmo, lblNit, lblNat, lblPH, lblGH, lblKH, lblScore,
            lblDechets, lblAbsDechets;

    float scoreEau = GUIMain.eau.getScoreEau();

    public static JProgressBar progressBar;

    String actionEnCours = GUIMain.actionEnCours;

    DecimalFormat df = new DecimalFormat("0.###E0");
    DecimalFormat dff = new DecimalFormat("#0.00");

    Molecules mol;

    public PanelInfo() { // Constructeur de la classe PanelInfo

        // création des labels et progressBar du paneel info
        mol = new Molecules();
        mol.ammoniaqueAtomesMol();
        mol.nitritesAtomesMol();
        mol.nitratesAtomesMol();

        setLayout(null); // layout du panel info

        lblAction = new JLabel("Action en cours: ");
        lblAction.setBounds(152, 98, 200, 20);
        add(lblAction);

        progressBar = new JProgressBar();
        progressBar.setString("Aucune action en cours");
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(46, 232, 158));
        progressBar.setValue(50);
        progressBar.setBounds(102, 130, 300, 20);
        add(progressBar);

        lblScore = new JLabel("Score: " + dff.format(GUIMain.eau.getScoreEau()));
        lblScore.setBounds(215, 230, 200, 20);
        add(lblScore);

        lblDechets = new JLabel("Déchets accumulés : " + GUIMain.eau.sommeDechets);
        lblDechets.setBounds(187, 275, 200, 20);
        add(lblDechets);

        lblAbsDechets = new JLabel("Potentiel d'absorbtion: " + GUIMain.eau.sommeAbsorptionDechets);
        lblAbsDechets.setBounds(182, 320, 200, 20);
        add(lblAbsDechets);

        lblN = new JLabel("N: " + mol.sommeMolN() + " mols d'azote");
        lblN.setBounds(60, 420, 200, 20);
        add(lblN);

        lblAmmo = new JLabel("NH3: " + mol.eau.getAmmoniaque() + " au jour " + mol.eau.jours);
        lblAmmo.setBounds(330, 420, 200, 20);
        add(lblAmmo);

        lblH = new JLabel("H: " + mol.molAtomeH + " mols d'hydrogène");
        lblH.setBounds(60, 480, 200, 20);
        add(lblH);

        lblNit = new JLabel("NO2: " + mol.nitritesMgLtoMol() + " mols");
        lblNit.setBounds(330, 480, 200, 20);
        add(lblNit);

        lblO = new JLabel("O: " + mol.sommeMolO() + " mols d'oxygène");
        lblO.setBounds(60, 540, 200, 20);
        add(lblO);

        lblNat = new JLabel("NO3: " + mol.nitratesMgLtoMol() + " mols");
        lblNat.setBounds(330, 540, 200, 20);
        add(lblNat);

        lblPH = new JLabel("PH: " + dff.format(GUIMain.eau.getPH()));
        lblPH.setBounds(60, 600, 200, 20);
        add(lblPH);

        lblGH = new JLabel("GH: " + dff.format(GUIMain.eau.getGH()));
        lblGH.setBounds(330, 600, 200, 20);
        add(lblGH);

        lblKH = new JLabel("KH: " + dff.format(GUIMain.eau.getKH()));
        lblKH.setBounds(195, 600, 200, 20);
        add(lblKH);
    }

    /**
     * Affiche l'action en cours
     */
    public void setActionEnCours() {
        actionEnCours = GUIMain.actionEnCours;
        lblAction.setText("Action en cours: " + actionEnCours);
    }

    /**
     * Contrôle l'affichage de la barre d'état et de l'action en cours
     */
    public void changerEtatBarre() {
        switch (actionEnCours) {
            case "Cycle ammoniaque":
                progressBar.setString("La concentration d'ammoniaque augmente");
                progressBar.setMaximum(18);
                progressBar.setValue((int) (mol.eau.jours + 1));
                break;
            case "Cycle nitrites":
                progressBar.setString("NH3 + O2 → NO2 + 3H");
                progressBar.setMinimum(14);
                progressBar.setMaximum(35);
                progressBar.setValue((int) (mol.eau.jours + 1));
                break;
            case "Cycle nitrates":
                if (mol.molNitrites == 0.0) {
                    progressBar.setString("Les bactéries Nitrobacter relâchent des nitrates");
                    progressBar.setValue(progressBar.getMaximum());
                } else {
                    progressBar.setString("NO2 + H2O → NO3 + 2H");
                    progressBar.setValue((int) (mol.eau.jours));
                }
                break;
            default:
                progressBar.setString("Aucune action en cours");
                progressBar.setValue(progressBar.getMinimum());
                break;
        }
    }

    /**
     * @param Graphics
     *                 méthode pour paint le background du panel
     */
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2D = (Graphics2D) g;
        Image background = Toolkit.getDefaultToolkit().getImage("res/background/background_details.png");
        g2D.drawImage(background, 0, 0, this);
    }

    /**
     * Méthode run de la classe PanelInfo
     */
    @Override
    public void run() {
        while (true) {
            try {
                mol.ammoniaqueAtomesMol();
                mol.nitritesAtomesMol();
                mol.nitratesAtomesMol();

                setActionEnCours();
                changerEtatBarre();

                lblScore.setText("Score: " + dff.format(GUIMain.eau.getScoreEau()));
                lblDechets.setText("Déchets accumulés : " + GUIMain.eau.sommeDechets);
                lblAbsDechets.setText("Potentiel d'absorbtion: " + GUIMain.eau.sommeAbsorptionDechets);

                lblGH.setText("GH: " + dff.format(GUIMain.eau.getGH()));
                lblPH.setText("PH: " + dff.format(GUIMain.eau.getPH()));
                lblKH.setText("KH: " + dff.format(GUIMain.eau.getKH()));

                if (mol.sommeMolN() != 0)
                    lblN.setText("N: " + df.format(mol.sommeMolN()) + " mols d'azote");
                else
                    lblN.setText("N: " + mol.sommeMolN() + " mols d'azote");

                if (mol.molAtomeH != 0)
                    lblH.setText("H: " + df.format(mol.molAtomeH) + " mols d'hydrogène");
                else
                    lblH.setText("H: " + mol.molAtomeH + " mols d'hydrogène");

                if (mol.sommeMolO() != 0)
                    lblO.setText("O: " + df.format(mol.sommeMolO()) + " mols d'oxygène");
                else
                    lblO.setText("O: " + mol.sommeMolO() + " mols d'oxygène");

                if (mol.ammoniaqueMgLtoMol() != 0)
                    lblAmmo.setText("NH3: " + df.format(mol.ammoniaqueMgLtoMol()) + " mols");
                else
                    lblAmmo.setText("NH3: " + mol.ammoniaqueMgLtoMol() + " mols");

                if (mol.nitritesMgLtoMol() != 0)
                    lblNit.setText("NO2: " + df.format(mol.nitritesMgLtoMol()) + " mols");
                else
                    lblNit.setText("NO2: " + mol.nitritesMgLtoMol() + " mols");

                if (mol.nitratesMgLtoMol() != 0)
                    lblNat.setText("NO3: " + df.format(mol.nitratesMgLtoMol()) + " mols");
                else
                    lblNat.setText("NO3: " + mol.nitratesMgLtoMol() + " mols");

                Thread.sleep(Temps.DUREE);
            } catch (InterruptedException e) {
                GestionException.GestionExceptionThread();
            }
        }
    }
}

// Слава Україні!