//Jérémie Caron     itération 1
//Frédéric Choinière     itération 2
//Classe pour l'affichage des infos

package view.tabs;

import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;

import model.GestionException;
import model.chimie.Molecules;
import model.environnement.Temps;
import view.GUIMain;

public class PanelInfo extends JPanel implements Runnable { // TODO: ajouter PH/GH/KH, ajouter compatibilité plusieurs cycles,
                                                            // ajouter infos déchets et absorption

    // appel des attributs de la classe
    public static JLabel lblAction, lblN, lblH, lblO, lblAmmo, lblNit, lblNat, lblPH, lblGH, lblKH, lblScore, lblDechets, lblAbsDechets;

    float scoreEau = GUIMain.eau.getScoreEau();

    public static JProgressBar progressBar;

    String actionEnCours = GUIMain.actionEnCours;

    DecimalFormat df = new DecimalFormat("0.###E0");

    Molecules mol;

    public PanelInfo() { // Constructeur de la classe PanelInfo

        mol = new Molecules();
        mol.ammoniaqueAtomesMol();
        mol.nitritesAtomesMol();
        mol.nitratesAtomesMol();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lblAction = new JLabel("Action en cours: ");
        c.gridx = 1;
        c.gridy = 0;
        c.gridwidth = 1;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.SOUTH;
        add(lblAction, c);

        progressBar = new JProgressBar();
        progressBar.setString("Aucune action en cours");
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(46, 232, 158));
        progressBar.setValue(50);
        c.gridy = 1;
        c.anchor = GridBagConstraints.NORTH;
        add(progressBar, c);

        lblScore = new JLabel("Score: " + GUIMain.eau.getScoreEau());
        c.gridwidth = 1;
        c.gridx = 1;
        c.gridy = 2;
        add(lblScore, c);

        lblDechets = new JLabel("Déchets accumulés : " + GUIMain.eau.sommeDechets);
        c.gridy = 3;
        add(lblDechets, c);

        lblAbsDechets = new JLabel("Potentiel d'absorbtion: " + GUIMain.eau.sommeAbsorptionDechets);
        c.gridy = 4;
        add(lblAbsDechets, c);

        lblN = new JLabel("N: " + mol.sommeMolN() + " mols d'azote");
        c.gridx = 0;
        c.gridy = 5;
        c.anchor = GridBagConstraints.EAST;
        add(lblN, c);

        lblAmmo = new JLabel("NH3: " + mol.eau.getAmmoniaque() + " au jour " + mol.eau.jours);
        c.gridx = 2;
        c.anchor = GridBagConstraints.WEST;
        add(lblAmmo, c);

        lblH = new JLabel("H: " + mol.molAtomeH + " mols d'hydrogène");
        c.gridx = 0;
        c.gridy = 6;
        c.anchor = GridBagConstraints.EAST;
        add(lblH, c);

        lblNit = new JLabel("NO2: " + mol.nitritesMgLtoMol() + " mols");
        c.gridx = 2;
        c.anchor = GridBagConstraints.WEST;
        add(lblNit, c);

        lblO = new JLabel("O: " + mol.sommeMolO() + " mols d'oxygène");
        c.gridx = 0;
        c.gridy = 7;
        c.anchor = GridBagConstraints.EAST;
        add(lblO, c);

        lblNat = new JLabel("NO3: " + mol.nitratesMgLtoMol() + " mols");
        c.gridx = 2;
        c.anchor = GridBagConstraints.WEST;
        add(lblNat, c);

    }

    /**
     *      Affiche l'action en cours
     */
    public void setActionEnCours() {
        actionEnCours = GUIMain.actionEnCours;
        lblAction.setText("Action en cours: " + actionEnCours);
    }

    /**
     *      Contrôle l'affichage de la barre d'état et de l'action en cours
     */
    public void changerEtatBarre() {
        switch (actionEnCours) {
            case "Cycle ammoniaque":
                progressBar.setString("La concentration d'ammoniaque augmente");
                progressBar.setMaximum(18);
                progressBar.setValue((int)(mol.eau.jours));
                break;
            case "Cycle nitrites":
                progressBar.setString("NH3 + O2 → NO2 + 3H");
                progressBar.setMinimum(14);
                progressBar.setMaximum(35);
                progressBar.setValue((int)(mol.eau.jours));
                break;
            case "Cycle nitrates":
                if (mol.molNitrites == 0.0) {
                    progressBar.setString("Les bactéries Nitrobacter relâchent des nitrates");
                } else {
                    progressBar.setString("NO2 + H2O → NO3 + 2H");
                }
                progressBar.setValue(progressBar.getMaximum());
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
     *          Méthode run de la classe PanelInfo
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

                lblScore.setText("Score: " + GUIMain.eau.getScoreEau());
                lblDechets.setText("Déchets accumulés : " + GUIMain.eau.sommeDechets);
                lblAbsDechets.setText("Potentiel d'absorbtion: " + GUIMain.eau.sommeAbsorptionDechets);

                if(mol.sommeMolN() != 0)
                    lblN.setText("N: " + df.format(mol.sommeMolN()) + " mols d'azote");
                else
                    lblN.setText("N: " + mol.sommeMolN() + " mols d'azote");

                if(mol.molAtomeH != 0)
                    lblH.setText("H: " + df.format(mol.molAtomeH) + " mols d'hydrogène");
                else 
                    lblH.setText("H: " + mol.molAtomeH + " mols d'hydrogène");

                if(mol.sommeMolO() != 0)
                    lblO.setText("O: " + df.format(mol.sommeMolO()) + " mols d'oxygène");
                else
                    lblO.setText("O: " + mol.sommeMolO() + " mols d'oxygène");

                if(mol.ammoniaqueMgLtoMol() != 0)
                    lblAmmo.setText("NH3: " + df.format(mol.ammoniaqueMgLtoMol()) + " mols");
                else
                    lblAmmo.setText("NH3: " + mol.ammoniaqueMgLtoMol() + " mols");

                if(mol.nitritesMgLtoMol() != 0)
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