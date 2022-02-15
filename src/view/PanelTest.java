package view;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class PanelTest extends JPanel {

    public PanelTest() {

        setSize(300, 300);
        setName("testeau");
        setVisible(true);

        JLabel label = new JLabel("Hagougaga");
        add(label);

    }
}