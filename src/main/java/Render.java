package main.java;
import java.awt.Graphics;
import java.util.ArrayList;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

import javax.imageio.ImageIO;

public class Render {

    private Jogo jogo;


    public Render(Jogo jogo){
        this.jogo = jogo;

    }
    public void render(Graphics g){

        switch (GameStates.gameState) {

            case MENU:

                jogo.getMenu().render(g);

                break;
            case PLAYING:

                jogo.getPlaying().render(g);

                break;
            case SETTINGS:

                jogo.getSettings().render(g);
                
                break;
        }
    }

}
