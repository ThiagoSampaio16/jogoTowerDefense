package main.java;
import java.awt.Graphics;

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
            case EDIT:
                jogo.getEditor().render(g);
                break;
            default:
                break;
        }
    }

}
