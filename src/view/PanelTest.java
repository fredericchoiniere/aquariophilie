// Frédéric Choinière, Jérémie Caron   itération 1
// Justin Plouffe itération 2

package view;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import model.chimie.CycleAzote;
import model.chimie.Molecules;
//import model.environnement.Temps;

public class PanelTest extends JPanel implements ActionListener {

    CycleAzote cycle;
    //JButton btnActu, btnCycle;
    //public JLabel lblJour;
    public JLabel lblAmmo;
    public JLabel lblNitrites;
    public JLabel lblNitrates;
    public JLabel lblPH;
    public JLabel lblGH;
    public JLabel lblKH;
    public JLabel lblScoreEau;

    JLabel lblOKAmmo;
    JLabel lblOKNitrites;
    JLabel lblOKNitrates;
    JLabel lblOKPH;
    JLabel lblOKGH;
    JLabel lblOKKH;
    Thread cycle1;
    boolean isFocused;
    Molecules mol = new Molecules();

    public PanelTest() {

        setSize(700, 500);
        setOpaque(false);
        setName("testeau");
        setVisible(true);
        setCursor(Toolkit.getDefaultToolkit().createCustomCursor(
                new ImageIcon("res/icone_souris/pipe_vide.png").getImage(),
                new Point(0, 0), "custom cursor"));

        JLayeredPane layersPT = new JLayeredPane(); // layers panel test

        JLabel lblPT_BG = new JLabel(); // label panel test back ground

        lblPH = new JLabel("0.00");
        lblGH = new JLabel("0.00");
        lblKH = new JLabel("0.00");
        lblAmmo = new JLabel("0.00");
        lblNitrites = new JLabel("0.00");
        lblNitrates = new JLabel("0.00");

        JLabel lblSoluPH = new JLabel(); // label solution ph
        JLabel lblSoluGH = new JLabel();
        JLabel lblSoluKH = new JLabel();
        JLabel lblSoluAmmoniaque = new JLabel();
        JLabel lblSoluNitrites = new JLabel();
        JLabel lblSoluNitrates = new JLabel();

        JLabel lblOKPH = new JLabel();
        JLabel lblOKGH = new JLabel();
        JLabel lblOKKH = new JLabel();
        JLabel lblOKAmmo = new JLabel();
        JLabel lblOKNitrites = new JLabel();
        JLabel lblOKNitrates = new JLabel();

        layersPT.setBounds(0, 0, 700, 500);
        add(layersPT);

        setLayout(null);

        // Label pour l'image du background du panel test
        lblPT_BG.setIcon(new ImageIcon("res/outils/gradation_solutions/panel_test_bg.png"));
        Dimension size_icon_lblPT_BG = lblPT_BG.getPreferredSize(); // prend la dimension de l'image
        lblPT_BG.setBounds(0, 0, size_icon_lblPT_BG.width, size_icon_lblPT_BG.height);

        // Label pour l'image de la solution qui mesure le PH
        lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/eau.png"));
        Dimension size_icon_lblSoluPH = lblSoluPH.getPreferredSize(); // prend la dimension de l'image
        lblSoluPH.setBounds(66, 181, size_icon_lblSoluPH.width, size_icon_lblSoluPH.height);

        // Label pour l'image de la solution qui mesure le GH
        lblSoluGH.setIcon(new ImageIcon("res/outils/gradation_solutions/eau.png"));
        Dimension size_icon_lblSoluGH = lblSoluGH.getPreferredSize(); // prend la dimension de l'image
        lblSoluGH.setBounds(171, 181, size_icon_lblSoluGH.width, size_icon_lblSoluGH.height);

        // Label pour l'image de la solution qui mesure le KH
        lblSoluKH.setIcon(new ImageIcon("res/outils/gradation_solutions/eau.png"));
        Dimension size_icon_lblSoluKH = lblSoluKH.getPreferredSize(); // prend la dimension de l'image
        lblSoluKH.setBounds(276, 181, size_icon_lblSoluKH.width, size_icon_lblSoluKH.height);

        // Label pour l'image de la solution qui mesure l'ammoniaque
        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/eau.png"));
        Dimension size_icon_lblSoluAmmoniaque = lblSoluAmmoniaque.getPreferredSize(); // prend la dimension de l'image
        lblSoluAmmoniaque.setBounds(381, 181, size_icon_lblSoluAmmoniaque.width, size_icon_lblSoluAmmoniaque.height);

        // Label pour l'image de la solution qui mesure les nitrites
        lblSoluNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/eau.png"));
        Dimension size_icon_lblSoluNitrites = lblSoluNitrites.getPreferredSize(); // prend la dimension de l'image
        lblSoluNitrites.setBounds(486, 181, size_icon_lblSoluNitrites.width, size_icon_lblSoluNitrites.height);

        // Label pour l'image de la solution qui mesure les nitrates
        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/eau.png"));
        Dimension size_icon_lblSoluNitrates = lblSoluNitrates.getPreferredSize(); // prend la dimension de l'image
        lblSoluNitrates.setBounds(591, 181, size_icon_lblSoluNitrates.width, size_icon_lblSoluNitrates.height);

        // Label pour l'image de l'état de tolérance pour le PH
        lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
        Dimension size_icon_lblOKPH = lblOKPH.getPreferredSize(); // prend la dimension de l'image
        lblOKPH.setBounds(66, 25, size_icon_lblOKPH.width, size_icon_lblOKPH.height);

        // Label pour l'image de l'état de tolérance pour le GH
        lblOKGH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
        Dimension size_icon_lblOKGH = lblOKGH.getPreferredSize(); // prend la dimension de l'image
        lblOKGH.setBounds(171, 25, size_icon_lblOKGH.width, size_icon_lblOKGH.height);

        // Label pour l'image de l'état de tolérance pour le KH
        lblOKKH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
        Dimension size_icon_lblOKKH = lblOKKH.getPreferredSize(); // prend la dimension de l'image
        lblOKKH.setBounds(276, 25, size_icon_lblOKKH.width, size_icon_lblOKKH.height);

        // Label pour l'image de l'état de tolérance pour l'ammoniaque
        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
        Dimension size_icon_lblOKAmmo = lblOKAmmo.getPreferredSize(); // prend la dimension de l'image
        lblOKAmmo.setBounds(381, 25, size_icon_lblOKAmmo.width, size_icon_lblOKAmmo.height);

        // Label pour l'image de l'état de tolérance pour les nitrites
        lblOKNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
        Dimension size_icon_lblOKNitrites = lblOKNitrites.getPreferredSize(); // prend la dimension de l'image
        lblOKNitrites.setBounds(486, 25, size_icon_lblOKNitrites.width, size_icon_lblOKNitrites.height);

        // Label pour l'image de l'état de tolérance pour lest nitrates
        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
        Dimension size_icon_lblOKNitrates = lblOKNitrates.getPreferredSize(); // prend la dimension de l'image
        lblOKNitrates.setBounds(591, 25, size_icon_lblOKNitrates.width, size_icon_lblOKNitrates.height);

        // Établissement des priorités de layers
        layersPT.setLayer(lblPT_BG, 0);
        layersPT.setLayer(lblSoluPH, 1);
        layersPT.setLayer(lblSoluGH, 1);
        layersPT.setLayer(lblSoluKH, 1);
        layersPT.setLayer(lblSoluAmmoniaque, 1);
        layersPT.setLayer(lblSoluNitrites, 1);
        layersPT.setLayer(lblSoluNitrates, 1);
        layersPT.setLayer(lblOKPH, 1);
        layersPT.setLayer(lblOKGH, 1);
        layersPT.setLayer(lblOKKH, 1);
        layersPT.setLayer(lblOKAmmo, 1);
        layersPT.setLayer(lblOKNitrites, 1);
        layersPT.setLayer(lblOKNitrates, 1);

        // Ajouts des éléments au JLayeredPane
        layersPT.add(lblPT_BG);
        layersPT.add(lblSoluPH);
        layersPT.add(lblSoluGH);
        layersPT.add(lblSoluKH);
        layersPT.add(lblSoluAmmoniaque);
        layersPT.add(lblSoluNitrites);
        layersPT.add(lblSoluNitrates);
        layersPT.add(lblOKPH);
        layersPT.add(lblOKGH);
        layersPT.add(lblOKKH);
        layersPT.add(lblOKAmmo);
        layersPT.add(lblOKNitrites);
        layersPT.add(lblOKNitrates);

        // {}
        // -----------------------------------------------------------------------------------------------------------------------
        // Comportement lorsqu'on clic sur la solution PH
        lblSoluPH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (GUIMain.pipette.getEstRemplie()) {

                    GUIMain.pipette.enleverUneGoutte();
                    

                    switch (GUIMain.eau.getPHint()) {
                        case 0: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/0.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 1: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/1.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 2: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/2.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 3: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/3.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 4: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/4.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 5: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/5.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 6: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/6.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                        }
                            break;
                        case 7: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/7.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                        }
                            break;
                        case 8: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/8.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                        }
                            break;
                        case 9: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/9.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 10: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/10.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 11: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/11.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 12: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/12.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 13: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/13.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        case 14: {
                            lblSoluPH.setIcon(new ImageIcon("res/outils/gradation_solutions/ph/14.png"));
                            lblOKPH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                        }
                            break;
                        default:
                            break;
                    }
                }
            }
        });

        // {}
        lblSoluGH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (GUIMain.pipette.getEstRemplie()) {
                    GUIMain.pipette.enleverUneGoutte();
                    
                    if (GUIMain.eau.getGH() >= 0 && GUIMain.eau.getGH() < 5) {
                        lblSoluGH.setIcon(new ImageIcon("res/outils/gradation_solutions/gh/0.png"));
                        lblOKGH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    }
                    else if (GUIMain.eau.getGH() >= 5 && GUIMain.eau.getGH() < 10) {
                        lblSoluGH.setIcon(new ImageIcon("res/outils/gradation_solutions/gh/1.png"));
                        lblOKGH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    }
                    else if (GUIMain.eau.getGH() >= 10 && GUIMain.eau.getGH() < 15) {
                        lblSoluGH.setIcon(new ImageIcon("res/outils/gradation_solutions/gh/2.png"));
                        lblOKGH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getGH() >= 15 && GUIMain.eau.getGH() < 25) {
                        lblSoluGH.setIcon(new ImageIcon("res/outils/gradation_solutions/gh/3.png"));
                        lblOKGH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getGH() >= 25) {
                        lblSoluGH.setIcon(new ImageIcon("res/outils/gradation_solutions/gh/4.png"));
                        lblOKGH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    }
                }
            }
        });

        lblSoluKH.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (GUIMain.pipette.getEstRemplie()) {
                    GUIMain.pipette.enleverUneGoutte();
                    

                    if (GUIMain.eau.getKH() >= 0 && GUIMain.eau.getKH() < 2) {
                        lblSoluKH.setIcon(new ImageIcon("res/outils/gradation_solutions/kh/0.png"));
                        lblOKKH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getKH() >= 2 && GUIMain.eau.getKH() < 4) {
                        lblSoluKH.setIcon(new ImageIcon("res/outils/gradation_solutions/kh/1.png"));
                        lblOKKH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getKH() >= 4 && GUIMain.eau.getKH() < 6) {
                        lblSoluKH.setIcon(new ImageIcon("res/outils/gradation_solutions/kh/2.png"));
                        lblOKKH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getKH() >= 6 && GUIMain.eau.getKH() < 8) {
                        lblSoluKH.setIcon(new ImageIcon("res/outils/gradation_solutions/kh/3.png"));
                        lblOKKH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getKH() >= 8 && GUIMain.eau.getKH() < 10) {
                        lblSoluKH.setIcon(new ImageIcon("res/outils/gradation_solutions/kh/4.png"));
                        lblOKKH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getKH() >= 10) {
                        lblSoluKH.setIcon(new ImageIcon("res/outils/gradation_solutions/kh/5.png"));
                        lblOKKH.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    }
                }
            }
        });

        lblSoluAmmoniaque.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                if (GUIMain.pipette.getEstRemplie()) {

                    GUIMain.pipette.enleverUneGoutte();

                    if (GUIMain.eau.getAmmoniaque() >= 0 && GUIMain.eau.getAmmoniaque() < 0.25) {
                        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/ammoniaque/0.png"));
                        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getAmmoniaque() >= 0.25 && GUIMain.eau.getAmmoniaque() < 0.5) {
                        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/ammoniaque/1.png"));
                        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getAmmoniaque() >= 0.5 && GUIMain.eau.getAmmoniaque() < 1) {
                        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/ammoniaque/2.png"));
                        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getAmmoniaque() >= 1 && GUIMain.eau.getAmmoniaque() < 2) {
                        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/ammoniaque/3.png"));
                        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getAmmoniaque() >= 2 && GUIMain.eau.getAmmoniaque() < 4) {
                        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/ammoniaque/4.png"));
                        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getAmmoniaque() >= 4 && GUIMain.eau.getAmmoniaque() < 8) {
                        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/ammoniaque/5.png"));
                        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getAmmoniaque() >= 8) {
                        lblSoluAmmoniaque.setIcon(new ImageIcon("res/outils/gradation_solutions/ammoniaque/6.png"));
                        lblOKAmmo.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    }
                }
            }
        });

        lblSoluNitrites.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (GUIMain.pipette.getEstRemplie()) {

                    GUIMain.pipette.enleverUneGoutte();

                    if (GUIMain.eau.getNitrites() >= 0 && GUIMain.eau.getNitrites() < 0.25) {
                        lblSoluNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrites/0.png"));
                        lblOKNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getNitrites() >= 0.25 && GUIMain.eau.getNitrites() < 0.5) {
                        lblSoluNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrites/1.png"));
                        lblOKNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getNitrites() >= 0.5 && GUIMain.eau.getNitrites() < 1) {
                        lblSoluNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrites/2.png"));
                        lblOKNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getNitrites() >= 1 && GUIMain.eau.getNitrites() < 2) {
                        lblSoluNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrites/3.png"));
                        lblOKNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getNitrites() >= 2 && GUIMain.eau.getNitrites() < 5) {
                        lblSoluNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrites/4.png"));
                        lblOKNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getNitrites() >= 5) {
                        lblSoluNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrites/5.png"));
                        lblOKNitrites.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    }
                }
            }
        });

        lblSoluNitrates.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (GUIMain.pipette.getEstRemplie()) {

                    GUIMain.pipette.enleverUneGoutte();

                    if (GUIMain.eau.getNitrates() >= 0 && GUIMain.eau.getNitrates() < 5) {
                        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrates/0.png"));
                        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getNitrates() >= 5 && GUIMain.eau.getNitrates() < 10) {
                        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrates/1.png"));
                        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getNitrates() >= 10 && GUIMain.eau.getNitrates() < 20) {
                        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrates/2.png"));
                        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getNitrates() >= 20 && GUIMain.eau.getNitrates() < 40) {
                        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrates/3.png"));
                        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/tolerance.png"));
                    } else if (GUIMain.eau.getNitrates() >= 40 && GUIMain.eau.getNitrates() < 80) {
                        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrates/4.png"));
                        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getNitrates() >= 80 && GUIMain.eau.getNitrates() < 160) {
                        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrates/5.png"));
                        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    } else if (GUIMain.eau.getNitrates() >= 160) {
                        lblSoluNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/nitrates/6.png"));
                        lblOKNitrates.setIcon(new ImageIcon("res/outils/gradation_solutions/etat/non_tolerance.png"));
                    }
                }
            }
        });

        cycle = GUIMain.cycleInitial;
        cycle1 = new Thread(cycle);

        //Label qui affiche la valeur du ph
        lblPH.setText(GUIMain.eau.toString(GUIMain.eau.getPH()));
        lblPH.setBounds(76, 80, 25, 20);
        layersPT.setLayer(lblPH, 2);
        layersPT.add(lblPH);

        //Label qui affiche la valeur du gh
        lblGH.setText(GUIMain.eau.toString(GUIMain.eau.getGH()));
        lblGH.setBounds(181, 80, 25, 20);
        layersPT.setLayer(lblGH, 2);
        layersPT.add(lblGH);

        //Label qui affiche la valeur du kh
        lblKH.setText(GUIMain.eau.toString(GUIMain.eau.getKH()));
        lblKH.setBounds(286, 80, 25, 20);
        layersPT.setLayer(lblKH, 2);
        layersPT.add(lblKH);

        //Label qui affiche la valeur de l'ammoniaque
        lblAmmo.setText(GUIMain.eau.toString(GUIMain.eau.getAmmoniaque()));
        lblAmmo.setBounds(391, 80, 25, 20);
        layersPT.setLayer(lblAmmo, 2);
        layersPT.add(lblAmmo);

        //Label qui affiche la valeur des nitrites
        lblNitrites.setText(GUIMain.eau.toString(GUIMain.eau.getNitrites()));
        lblNitrites.setBounds(496, 80, 25, 20);
        layersPT.setLayer(lblNitrites, 2);
        layersPT.add(lblNitrites);

        //Label qui affiche la valeur des nitrates
        lblNitrates.setText(GUIMain.eau.toString(GUIMain.eau.getNitrates()));
        lblNitrates.setBounds(601, 80, 25, 20);
        layersPT.setLayer(lblNitrates, 2);
        layersPT.add(lblNitrates);
    
        lblScoreEau = new JLabel();
        lblScoreEau.setVisible(true);
        lblScoreEau.setText(GUIMain.eau.toString(GUIMain.eau.getScoreEau()));
        lblScoreEau.setBounds(0, 0, 25, 20);
        layersPT.setLayer(lblScoreEau, 2);
        layersPT.add(lblScoreEau);

    }

    /**
     * @param e
     *          Actionlistener
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        
    }

    /**
     * Méthode run de la classe PanelTest
     * Incomplète pour l'instant
     
    @Override
    public void run() {
        while (true) {
            
            if (!Temps.isPaused) {
                
                    
            } else { // permet de ne pas utiliser 23% du processeur si le temps est en pause
                try {
                    Thread.sleep(Temps.DUREE);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

        }
    }*/
}
