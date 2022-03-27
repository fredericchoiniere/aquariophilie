//Jérémie Caron     itération 1
//Classe pour l'affichage des infos, pour itération 3

package view.tabs;

import java.awt.*;
import javax.swing.*;

public class PanelInfo extends JPanel { // extends JPanel pour créer un Jpanel

    // appel des attributs de la classe
    JTextArea textArea;
    JScrollPane scroll;

    public PanelInfo() { // créer un constructeur à la classe PanelInfo

        textArea = new JTextArea(20, 20);
        textArea.setEditable(false);
        textArea.setText("Peux être modifier dans PanelInfo.java");
        scroll = new JScrollPane(textArea);
        scroll.setPreferredSize(new Dimension(1000, 700));
        

        add(scroll); // ajout du panel à la classe
    }

    
}
