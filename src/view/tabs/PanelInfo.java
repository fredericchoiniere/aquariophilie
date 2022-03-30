//Jérémie Caron     itération 1
//Frédéric Choinière     itération 2
//Classe pour l'affichage des infos

package view.tabs;

import java.awt.*;
import javax.swing.*;
import model.chimie.Molecules;
import model.environnement.Temps;

public class PanelInfo extends JPanel implements Runnable{ // TODO: formatter les nombres, ajouter PH/GH/KH, implémenter action en cours en "temps réel"

    // appel des attributs de la classe
    JLabel lblAction, lblN, lblH, lblO, lblAmmo, lblNit, lblNat, lblPH, lblGH, lblKH;
    JProgressBar progressBar;

    public boolean focus = true; // temp

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
        //progressBar.setSize(700, 50);
        c.gridy = 1;
        c.anchor = GridBagConstraints.NORTH;
        add(progressBar, c);

        lblN = new JLabel("N: " + mol.sommeMolN() + " mols d'azote");
        c.gridwidth = 1;
        c.gridy = 2;
        //c.anchor = GridBagConstraints.NORTHEAST;
        add(lblN, c);

        lblAmmo = new JLabel("NH3: " + mol.ammoniaqueMgLtoMol() + " mols");
        c.gridx = 2;
        //c.anchor = GridBagConstraints.NORTHWEST;
        add(lblAmmo, c);

        lblH = new JLabel("H: " + mol.molAtomeH + " mols d'hydrogène");
        c.gridx = 0;
        c.gridy = 3;
        //c.anchor = GridBagConstraints.NORTHEAST;
        add(lblH, c);

        lblNit = new JLabel("NO2: " + mol.nitritesMgLtoMol() + " mols");
        c.gridx = 2;
        //c.anchor = GridBagConstraints.NORTHWEST;
        add(lblNit, c);

        lblO = new JLabel("O: " + mol.sommeMolO() + " mols d'oxygène");
        c.gridx = 0;
        c.gridy = 4;
        //c.anchor = GridBagConstraints.NORTHEAST;
        add(lblO, c);

        lblNat = new JLabel("NO3: " + mol.nitratesMgLtoMol() + " mols");
        c.gridx = 2;
        //c.anchor = GridBagConstraints.NORTHWEST;
        add(lblNat, c);

    }

    @Override
    public void run() {
        while(focus){
            try {

                mol.ammoniaqueAtomesMol();
                mol.nitritesAtomesMol();
                mol.nitratesAtomesMol();

                lblN.setText("N: " + mol.sommeMolN() + " mols d'azote");
                lblH.setText("H: " + mol.molAtomeH + " mols d'hydrogène");
                lblO.setText("O: " + mol.sommeMolO() + " mols d'oxygène");
                lblAmmo.setText("NH3: " + mol.ammoniaqueMgLtoMol() + " mols");
                lblNit.setText("NO2: " + mol.nitritesMgLtoMol() + " mols");
                lblNat.setText("NO3: " + mol.nitratesMgLtoMol() + " mols");


                Thread.sleep(Temps.DUREE);
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }

    
}




/* textArea = new JTextArea(20, 20);
        textArea.setEditable(false);
        textArea.setText("Peux être modifier dans PanelInfo.java");
        scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(1000, 700));
        

        add(scroll); // ajout du panel à la classe */