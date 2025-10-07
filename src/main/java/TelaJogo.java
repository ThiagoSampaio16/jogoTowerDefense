package main.java;

import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class TelaJogo extends JPanel {

    private Random random;
    private BufferedImage img;

    private long lastTime = System.currentTimeMillis();
    private int frames = 0;

    
    private ArrayList<BufferedImage> sprites = new ArrayList<>();

    public TelaJogo(BufferedImage img) {
        this.img = img;
        loadSprites();  
        random = new Random();
        
    }
    
    private void loadSprites() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 20; x++) {
                g.drawImage(sprites.get(getRndInt()), x * 32, y * 32, null);
            }
        }
        frames++;
        if (System.currentTimeMillis() - lastTime >= 1000) {
            System.out.println("FPS: "+frames);
            frames = 0;
            lastTime = System.currentTimeMillis();
            
        }
        
    }

    

    private int getRndInt() {
        return random.nextInt(100);
    }

    private Color getRndColor() {
        int r = random.nextInt(256);
        int g = random.nextInt(256);
        int b = random.nextInt(256);
        return new Color(r, g, b);
    }
}
