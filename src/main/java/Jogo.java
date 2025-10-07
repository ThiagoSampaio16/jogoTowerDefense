package main.java;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class Jogo extends JFrame implements Runnable {

    private TelaJogo telaJogo;
    
    private BufferedImage img;
    
    private final double FPS_SET = 120.0;
    private final double UPS_SET = 60.0;
    
    
    private int updates;
    private long lastTimeUPS;

    private Thread gamThread;

    public Jogo() {
        
        importImg();

        telaJogo = new TelaJogo(img);
        add(telaJogo);

        setTitle("Jogo Tower Defense");
        setSize(655, 679);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true); // <- mover para o final!
    }

    private void importImg() {
        try {
            // 1ª tentativa: dentro dos recursos do classpath
            InputStream is = getClass().getResourceAsStream("/Sprites_do_jogo_Larissa.png");
            if (is != null) {
                img = ImageIO.read(is);
                System.out.println("Imagem carregada do classpath!");
                return;
            }

            // 2ª tentativa: caminho direto (VS Code)
            File file = new File("src/main/resources/Sprites_do_jogo_Larissa.png");
            if (file.exists()) {
                img = ImageIO.read(file);
                System.out.println("Imagem carregada do arquivo local!");
            } else {
                System.out.println("Imagem não encontrada!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() {
        gamThread = new Thread(this);
        gamThread.start();
        //lastUpdate = System.nanoTime();
        //lastFrame = System.nanoTime();
        //lastTimeUPS = System.currentTimeMillis();
    }



    private void callUPS() {
        if (System.currentTimeMillis() - lastTimeUPS >= 1000) {
            System.out.println("UPS: "+updates);
            updates = 0;
            lastTimeUPS = System.currentTimeMillis();
        }
        
    }

    private void updateGame() {
        
        //System.out.println("Game Updated");
    }

    public static void main(String[] args) {
        Jogo jogo = new Jogo();
        jogo.start();
}

@Override
    public void run() {
        
        double timePerFrame= 1000000000.0 / FPS_SET;
        double timePerUpdate= 1000000000.0 / UPS_SET;
        
        long lastFrame= System.nanoTime();
        long lastUpdate= System.nanoTime();
        
        long lastTimeCheck = System.currentTimeMillis();
        
       
        int frames = 0;
        int updates = 0;
        

        while (true){
            if (System.nanoTime() - lastFrame >= timePerFrame) {
                    repaint();
                    lastFrame = System.nanoTime(); 
                    frames++;
                }
            

            if (System.nanoTime() - lastUpdate >= timePerUpdate) {
                updateGame();
                lastUpdate = System.nanoTime();
                updates++;
            }
            if (System.currentTimeMillis() - lastTimeCheck >= 1000) {
                System.out.println("FPS: "+frames+" | UPS: "+updates);
                frames = 0;
                updates = 0;
                lastTimeCheck = System.currentTimeMillis();
            } 
        }
    }
    }

