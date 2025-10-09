package scenes;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.java.Jogo;
import ui.MyButton;

public class Menu extends GameScene implements SceneMethods{

    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;

    private MyButton bPlaying, bSettings, bQuit;

    public Menu(Jogo jogo) {
        super(jogo);
        random = new Random();
        importImg();
        loadSprites();
        initButtons();
    }

    private void initButtons() {
        bPlaying = new MyButton("Play", 300, 150, 200, 50);
    }

    @Override
    public void render(Graphics g) {
            drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
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

    private void loadSprites() {
        for (int y = 0; y < 10; y++) {
            for (int x = 0; x < 10; x++) {
                sprites.add(img.getSubimage(x * 32, y * 32, 32, 32));
            }
        }
    }


    private int getRndInt() {
        return random.nextInt(100);
    }
}
