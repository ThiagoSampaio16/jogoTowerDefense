package scenes;

import java.awt.Graphics;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Random;
import java.util.Set;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;

import main.java.Jogo;
import ui.MyButton;
import static main.java.GameStates.*;

public class Menu extends GameScene implements SceneMethods{

    private BufferedImage img;
    private ArrayList<BufferedImage> sprites = new ArrayList<>();
    private Random random;

    private MyButton bPlaying, bEdit, bSettings, bQuit;

    public Menu(Jogo jogo) {
        super(jogo);
        random = new Random();
        importImg();
        loadSprites();
        initButtons();
    }

    private void initButtons() {

        int w = 150;
        int h = w/3;
        int x = 640/2 - w/2;
        int y = 150;
        int yOffset = 100;

        bPlaying = new MyButton("Play", x, y, w, h);
        bEdit = new MyButton("Edit", x, y + yOffset, w, h);
        bSettings = new MyButton("Settings", x, y + yOffset, w, h);
        bQuit = new MyButton("Quit", x, y + yOffset*2, w, h);
    }

    @Override
    public void render(Graphics g) {
            drawButtons(g);
    }

    private void drawButtons(Graphics g) {
        bPlaying.draw(g);
        bEdit.draw(g);
        bSettings.draw(g);  
        bQuit.draw(g);
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

    @Override
    public void mouseClicked(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) {
            SetGameState(PLAYING);
            
        }
        /*else if (bEdit.getBounds().contains(x, y)) {
            SetGameState(EDIT);
        }*/
        else if (bSettings.getBounds().contains(x, y)) {
            SetGameState(SETTINGS);
            
        }
        else if (bQuit.getBounds().contains(x, y)) {
            System.exit(0);
            
        }
            
        }
    

    @Override
    public void mouseMoved(int x, int y) {
        bPlaying.setMouseOver(false);
        bEdit.setMouseOver(false);
        bSettings.setMouseOver(false);
        bQuit.setMouseOver(false);
        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMouseOver(true);
        } else if (bEdit.getBounds().contains(x, y)) {
            bEdit.setMouseOver(true);
        } else if (bSettings.getBounds().contains(x, y)) {
            bSettings.setMouseOver(true);
        } else if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMouseOver(true);
        }
    }

    @Override
    public void mousePressed(int x, int y) {
        if (bPlaying.getBounds().contains(x, y)) {
            bPlaying.setMousePressed(true);
        } else if (bEdit.getBounds().contains(x, y)) {
            bEdit.setMousePressed(true);
        } else if (bSettings.getBounds().contains(x, y)) {
            bSettings.setMousePressed(true);
        } else if (bQuit.getBounds().contains(x, y)) {
            bQuit.setMousePressed(true);
        }
    }

    @Override
    public void mouseReleased(int x, int y) {
        resetButtons();

    }

    @Override
    public void mouseDragged(int x, int y){
        
    }

    public void resetButtons() {
        bPlaying.resetBooleans();
        bEdit.resetBooleans();
        bSettings.resetBooleans(); 
        bQuit.resetBooleans();

    }

    
}