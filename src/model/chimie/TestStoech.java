package model.chimie;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

// nitrification, en ppm ou mg/L --> 1ppm = 1mg/L
// 10gal = 37,85L
// changer couleur prog bar


public class TestStoech implements Runnable{
    
    final short MAXNITRATE = 50;
    int quantAmmoniaque = 50, quantNitrite = 0, quantNitrate = 0; // nitrate max 50mg/L
    JProgressBar barAmmoniaque, barNitrite, barNitrate;

    Thread threadStoech;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new JPanel();
        TestStoech stoech = new TestStoech();
        
    }



    public TestStoech(){

        barAmmoniaque = new JProgressBar();
        barNitrite = new JProgressBar();
        barNitrate = new JProgressBar();

        barNitrate.setMaximum(50);
        
        threadStoech = new Thread();
        threadStoech.start();

    }

    @Override
    public void run() {
        while(true){
            barAmmoniaque.setValue(quantAmmoniaque);
            if(quantAmmoniaque <= 33)
                barAmmoniaque.setForeground(Color.GREEN);
            else if(quantAmmoniaque > 33 && quantAmmoniaque <= 66)
                barAmmoniaque.setForeground(Color.YELLOW);
            else if(quantAmmoniaque > 66)
                barAmmoniaque.setForeground(Color.RED);
                

            barNitrite.setValue(quantNitrite);
            if(quantNitrite <= 33)
                barNitrite.setForeground(Color.GREEN);
            else if(quantNitrite > 33 && quantNitrite <= 66)
                barNitrite.setForeground(Color.YELLOW);
            else if(quantNitrite > 66)
                barNitrite.setForeground(Color.RED);


            barNitrate.setValue(quantNitrate);
            if(quantNitrate <= (MAXNITRATE/3))
                barNitrate.setForeground(Color.GREEN);
            else if(quantNitrate > (MAXNITRATE/3) && quantNitrate <= 2*(MAXNITRATE/3))
                barNitrate.setForeground(Color.YELLOW);
            else if(quantNitrate > 2*(MAXNITRATE/3))
                barNitrate.setForeground(Color.RED);
            

        }
        
    }





}
