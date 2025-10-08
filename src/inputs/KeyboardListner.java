package inputs;


import java.awt.event.KeyListener;

import main.java.GameStates;   
import static main.java.GameStates.*;

public class KeyboardListner implements KeyListener {

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {

        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_A) {
            GameStates.gameState = MENU;
            
        }

        else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_S) {
            GameStates.gameState = PLAYING;
            
        }
        else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_D) {
            GameStates.gameState = SETTINGS;
            
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        
    }

}
