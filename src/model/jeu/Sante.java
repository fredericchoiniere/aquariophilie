// Iteration 3: Jérémie Caron
// TODO:Commenter la classe

package model.jeu;

import java.awt.*;
import javax.swing.*;

public class Sante {
    public static EmplacementSante emp1, emp2, emp3, emp4, emp5, emp6;
    final Dimension size_icone_sante = new Dimension(200, 20);

    public static boolean state1 = true, state2 = true, state3 = true, state4 = true, state5 = true, state6 = true;

    public Sante(JLabel label) {
        emp1 = new EmplacementSante();
        emp1.setBounds(20, 50, (int) size_icone_sante.getWidth(), (int) size_icone_sante.getHeight());
        emp1.setValue(100);
        emp1.setString("Santé du poisson 1");
        emp1.setStringPainted(true);
        emp1.setForeground(new Color(46, 232, 158));
        emp1.setVisible(false);
        label.add(emp1);

        emp2 = new EmplacementSante();
        emp2.setBounds(20, 120, (int) size_icone_sante.getWidth(), (int) size_icone_sante.getHeight());
        emp2.setValue(100);
        emp2.setString("Santé du poisson 2");
        emp2.setStringPainted(true);
        emp2.setForeground(new Color(46, 232, 158));
        emp2.setVisible(false);
        label.add(emp2);

        emp3 = new EmplacementSante();
        emp3.setBounds(20, 190, (int) size_icone_sante.getWidth(), (int) size_icone_sante.getHeight());
        emp3.setValue(100);
        emp3.setString("Santé du poisson 3");
        emp3.setStringPainted(true);
        emp3.setForeground(new Color(46, 232, 158));
        emp3.setVisible(false);
        label.add(emp3);

        emp4 = new EmplacementSante();
        emp4.setBounds(20, 260, (int) size_icone_sante.getWidth(), (int) size_icone_sante.getHeight());
        emp4.setValue(100);
        emp4.setString("Santé du poisson 4");
        emp4.setStringPainted(true);
        emp4.setForeground(new Color(46, 232, 158));
        emp4.setVisible(false);
        label.add(emp4);

        emp5 = new EmplacementSante();
        emp5.setBounds(20, 330, (int) size_icone_sante.getWidth(), (int) size_icone_sante.getHeight());
        emp5.setValue(100);
        emp5.setString("Santé du poisson 5");
        emp5.setStringPainted(true);
        emp5.setForeground(new Color(46, 232, 158));
        emp5.setVisible(false);
        label.add(emp5);

        emp6 = new EmplacementSante();
        emp6.setBounds(20, 400, (int) size_icone_sante.getWidth(), (int) size_icone_sante.getHeight());
        emp6.setValue(100);
        emp6.setString("Santé du poisson 6");
        emp6.setStringPainted(true);
        emp6.setForeground(new Color(46, 232, 158));
        emp6.setVisible(false);
        label.add(emp6);
    }

    
    /** 
     * @param etat1
     * @param etat2
     * @param etat3
     * @param etat4
     * @param etat5
     * @param etat6
     */
    public void setVisible(boolean etat1, boolean etat2, boolean etat3, boolean etat4, boolean etat5, boolean etat6) {
        emp1.setVisible(etat1);
        emp2.setVisible(etat2);
        emp3.setVisible(etat3);
        emp4.setVisible(etat4);
        emp5.setVisible(etat5);
        emp6.setVisible(etat6);
    }
}

// Слава Україні!