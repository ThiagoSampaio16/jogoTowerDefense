package main.java;

import javax.swing.JPanel;

import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class TelaJogo extends JPanel {

    private Random random;
    private BufferedImage img;

    public TelaJogo(BufferedImage img){
        this.img = img;
        random = new Random();


    }
    
    public void paintComponent(Graphics g){
        super.paintComponent(g);

        g.drawImage(img, 0, 0, null);
        /* for(int y = 0; y < 20; y++){
            for (int x = 0; x < 20; x++){

                g.setColor(getRndColor());
                g.fillRect(x*32, y*32, 32, 32);
            }
        } */
        

    }
    private Color getRndColor(){
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);

        return new Color(r, g, b);
    }

}
