//Jérémie Caron     itération 1
//Frédéric Choinière     itération 2
//Classe pour l'affichage des infos

package view.tabs;

import java.awt.*;
import java.text.DecimalFormat;

import javax.swing.*;
import model.chimie.Molecules;
import model.environnement.Temps;
import view.GUIMain;

public class PanelInfo extends JPanel implements Runnable { // TODO: ajouter PH/GH/KH

    // appel des attributs de la classe
    JLabel lblAction, lblN, lblH, lblO, lblAmmo, lblNit, lblNat, lblPH, lblGH, lblKH;
    JProgressBar progressBar;

    String actionEnCours = GUIMain.actionEnCours;

    DecimalFormat df = new DecimalFormat("0.###E0");

    Molecules mol;

    public PanelInfo() { // créer un constructeur à la classe PanelInfo

        mol = new Molecules();
        mol.ammoniaqueAtomesMol();
        mol.nitritesAtomesMol();
        mol.nitratesAtomesMol();

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        lblAction = new JLabel("Action en cours: ");
        c.gridx = 0;
        c.gridy = 0;
        c.gridwidth = 3;
        c.gridheight = 1;
        c.weightx = 1;
        c.weighty = 0.5;
        c.anchor = GridBagConstraints.SOUTH;
        add(lblAction, c);

        progressBar = new JProgressBar(); // diviser 100 par x pour obtenir step en fonction des jours
        progressBar.setString("Aucune action en cours");
        progressBar.setStringPainted(true);
        progressBar.setForeground(new Color(46, 232, 158));
        progressBar.setValue(50);
        // progressBar.setSize(700, 50);
        c.gridy = 1;
        c.anchor = GridBagConstraints.NORTH;
        add(progressBar, c);

        lblN = new JLabel("N: " + mol.sommeMolN() + " mols d'azote");
        c.gridwidth = 1;
        c.gridy = 2;
        // c.anchor = GridBagConstraints.NORTHEAST;
        add(lblN, c);

        // lblAmmo = new JLabel("NH3: " + mol.ammoniaqueMgLtoMol() + " mols");
        lblAmmo = new JLabel("NH3: " + mol.eau.ammoniaque + " au jour " + mol.eau.jours);
        c.gridx = 2;
        // c.anchor = GridBagConstraints.NORTHWEST;
        add(lblAmmo, c);

        lblH = new JLabel("H: " + mol.molAtomeH + " mols d'hydrogène");
        c.gridx = 0;
        c.gridy = 3;
        // c.anchor = GridBagConstraints.NORTHEAST;
        add(lblH, c);

        lblNit = new JLabel("NO2: " + mol.nitritesMgLtoMol() + " mols");
        c.gridx = 2;
        // c.anchor = GridBagConstraints.NORTHWEST;
        add(lblNit, c);

        lblO = new JLabel("O: " + mol.sommeMolO() + " mols d'oxygène");
        c.gridx = 0;
        c.gridy = 4;
        // c.anchor = GridBagConstraints.NORTHEAST;
        add(lblO, c);

        lblNat = new JLabel("NO3: " + mol.nitratesMgLtoMol() + " mols");
        c.gridx = 2;
        // c.anchor = GridBagConstraints.NORTHWEST;
        add(lblNat, c);

    }

    public void setActionEnCours() {
        actionEnCours = GUIMain.actionEnCours;
        lblAction.setText("Action en cours: " + actionEnCours);
    }

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

    @Override
    public void run() {
        while (true) {
            try {

                mol.ammoniaqueAtomesMol();
                mol.nitritesAtomesMol();
                mol.nitratesAtomesMol();

                setActionEnCours();
                changerEtatBarre();

                lblN.setText("N: " + df.format(mol.sommeMolN()) + " mols d'azote");
                lblH.setText("H: " + df.format(mol.molAtomeH) + " mols d'hydrogène");
                lblO.setText("O: " + df.format(mol.sommeMolO()) + " mols d'oxygène");
                lblAmmo.setText("NH3: " + df.format(mol.ammoniaqueMgLtoMol()) + " mols");
                // lblAmmo.setText("NH3: " + mol.eau.ammoniaque + " au jour " + (mol.eau.jours -
                // 1));
                lblNit.setText("NO2: " + df.format(mol.nitritesMgLtoMol()) + " mols");
                lblNat.setText("NO3: " + df.format(mol.nitratesMgLtoMol()) + " mols");

                Thread.sleep(Temps.DUREE);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

}

/*
 * textArea = new JTextArea(20, 20);
 * textArea.setEditable(false);
 * textArea.setText("Peux être modifier dans PanelInfo.java");
 * scroll = new JScrollPane(textArea);
 * scroll.setPreferredSize(new Dimension(1000, 700));
 * 
 * 
 * add(scroll); // ajout du panel à la classe
 */