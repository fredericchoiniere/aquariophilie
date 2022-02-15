package view;

import javax.swing.*;
import java.awt.event.*;

public class PanelTest extends JPanel  implements FocusListener {

    public PanelTest() {

        addFocusListener(this);
        setSize(700, 500);
        setName("testeau");
        setVisible(true);

        JLabel label = new JLabel("Hagougaga");
        add(label);

    }

    @Override
    public void focusGained(FocusEvent e) {
        System.out.println("gained");
        
    }

    @Override
    public void focusLost(FocusEvent e) {
        System.out.println("lost");
        
    }
}