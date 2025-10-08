package scenes;

import main.java.Jogo;

import java.awt.Color;
import java.awt.Graphics;

public class Playing extends GameScene implements SceneMethods{

    public Playing(Jogo jogo) {
        super(jogo);

    }

    @Override
    public void render(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, 640, 640);
    }

}
