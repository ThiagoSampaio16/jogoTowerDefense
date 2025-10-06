package main.java;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;

public class Jogo extends JFrame{

    private TelaJogo telaJogo;

    private BufferedImage img;

    public Jogo(){

        importImg();

        setSize(655, 679);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        telaJogo = new TelaJogo(img);
        add(telaJogo);
    }
    private void importImg() {
    try {
        InputStream is = getClass().getResourceAsStream("/Sprites_do_jogo_Larissa.png");
        if (is != null) {
            img = ImageIO.read(is);
            return;
        }
        java.io.File file = new java.io.File("src/main/resources/Sprites_do_jogo_Larissa.png");
        if (file.exists()) {
            img = ImageIO.read(file);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }
    }

public static void main(String[] args) {
    Jogo jogo = new Jogo();

}
    
}
