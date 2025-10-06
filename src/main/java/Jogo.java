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

        setSize(640, 640);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        telaJogo = new TelaJogo();
        add(telaJogo);
    }
    private void importImg() {
    InputStream is = getClass().getResourceAsStream("/Sprites_do_jogo_Larissa.png");
    try {
        img = ImageIO.read(is);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
public static void main(String[] args) {
    Jogo jogo = new Jogo();

}
    
}
