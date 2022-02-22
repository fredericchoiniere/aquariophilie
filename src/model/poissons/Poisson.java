package model.poissons;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Poisson extends JPanel {

    private static final long serialVersionUID = 1L;
    private int cx = 0;
    private int cy = 130;
    private int cw = 20;
    private int ch = 20;
    private int xinc = 1;
    private int yinc = 1;


    public Poisson() {
        setLayout(new BorderLayout());
        JLabel label = new JLabel();
        label.setForeground(Color.RED);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);
        setBackground(Color.BLACK);
        setForeground(Color.RED);
        setOpaque(false); //pour voir délimitation du panel
    }

    public void animate() {
        new Timer(30, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Rectangle oldCircle = new Rectangle(cx - 1, cy - 1, cw + 2, ch + 2);
                cx += xinc;
                cy += yinc;
                if (cx >= getWidth() - cw || cx <= 0) {
                    xinc *= -1;
                }
                if (cy >= getHeight() - ch || cy <= 0) {
                    yinc *= -1;
                }
                repaint(oldCircle);
                repaint(cx - 1, cy - 1, cw + 2, ch + 2);
            }
        }).start();
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawOval(cx, cy, cw, ch);
    }
}