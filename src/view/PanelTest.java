package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTest extends JPanel {

    public PanelTest() {

        setSize(700, 500);
        setName("testeau");
        setVisible(true);

        JLabel label = new JLabel("Hagougaga");
        add(label);

    }
}