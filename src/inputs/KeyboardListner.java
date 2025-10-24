package inputs;

import java.awt.event.KeyListener;

import main.java.GameStates;
import main.java.Jogo;
import static main.java.GameStates.*;


public class KeyboardListner implements KeyListener {
    private Jogo jogo;

    public void KeyboardListener(Jogo jogo) {
		this.jogo = jogo;

	}

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        
    }

}
