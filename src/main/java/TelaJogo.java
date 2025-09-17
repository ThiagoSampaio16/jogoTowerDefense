package main.java;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics;

public class TelaJogo extends JPanel {

    public TelaJogo(){



    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.setColor(Color.RED);
        g.fillRect(50, 50, 100, 100);
        

    }


}
