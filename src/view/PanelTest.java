// Frédéric Choinière, Jérémie Caron   itération 1
// Classe pour afficher temporairement la stoechiométrie


package view;

// TODO: CLASSE DE TEST TEMPORAIRE

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import model.chimie.CycleAzote;

public class PanelTest extends JPanel implements ActionListener {

    CycleAzote cycle;
    JButton button1, button2;
    JLabel lbl1, lbl2, lbl3;
    Thread cycle1;
    boolean isFocused;

    public PanelTest() {

        setSize(700, 500);
        setName("testeau");
        setVisible(true);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("res/icone_souris/pipe_vide.png").getImage(),
                new Point(0, 0), "custom cursor"));

        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        cycle = new CycleAzote();
        cycle1 = new Thread(cycle);

        button1 = new JButton("(Ré)Afficher cycles");
        c.gridx = 0;
        c.gridy = 0;
        c.gridheight = 1;
        c.gridwidth = 1;
        c.weightx = 0.5;
        c.weighty = 0.5;
        button1.addActionListener(this);
        add(button1, c);

        button2 = new JButton("Ajouter nouveau cycle");
        button2.addActionListener(this);
        c.gridx = 1;
        add(button2, c);

        lbl1 = new JLabel("Jour " + cycle.jours);
        c.gridx = 0;
        c.gridy = 1;
        add(lbl1, c);

        lbl2 = new JLabel(
                "Somme ammoniaque: " + cycle.eau.sommeAmmoniaque() + "\nListe NH3: " + cycle.eau.listeAmmoniaque);
        c.gridy = 2;
        c.gridwidth = 2;
        add(lbl2, c);

        lbl3 = new JLabel("Somme nitrites: " + cycle.eau.sommeNitrites() + "\nListe NO2-: " + cycle.eau.listeNitrites);
        c.gridy = 3;
        add(lbl3, c);

        cycle1.start();
    }

    /**
     * @param e
     *          Actionlistener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == button1) {
            lbl1.setText("Jour " + cycle.jours);
            lbl2.setText("Somme ammoniaque: " + cycle.eau.sommeAmmoniaque() + "     Liste NH3: "
                    + cycle.eau.listeAmmoniaque);
            lbl3.setText(
                    "Somme nitrites: " + cycle.eau.sommeNitrites() + "     Liste NO2-: " + cycle.eau.listeNitrites);
        }
        if (e.getSource() == button2) {
            cycle.eau.listeAmmoniaque.add((float) 0);
            new Thread(new CycleAzote()).start();
        }
    }
}