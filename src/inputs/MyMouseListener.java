package inputs;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import main.java.GameStates;
import main.java.Jogo;



public class MyMouseListener implements MouseListener, MouseMotionListener {

     private Jogo jogo;

    // Construtor que recebe Jogo
    public MyMouseListener(Jogo jogo) {
        this.jogo = jogo;
    }

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            switch (GameStates.gameState) {
                case MENU:
                    jogo.getMenu().mouseClicked(e.getX(), e.getY());
                    break;
                case PLAYING:
                    jogo.getPlaying().mouseClicked(e.getX(), e.getY());
                    break;
                case SETTINGS:
                    jogo.getSettings().mouseClicked(e.getX(), e.getY());
                    break;
                default:
                    break;
            }
            
        }
        else if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            System.out.println("Botão direito do mouse clicado");
            
        }
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        switch (GameStates.gameState) {
                case MENU:
                    jogo.getMenu().mousePressed(e.getX(),e.getY());
                    break;
                case PLAYING:
                    jogo.getPlaying().mousePressed(e.getX(),e.getY());
                    break;
                case SETTINGS:
                    jogo.getSettings().mousePressed(e.getX(),e.getY());
                    break;
                default:
                    break;
            }
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {

        switch (GameStates.gameState) {
                case MENU:
                    jogo.getMenu().mouseReleased(e.getX(),e.getY());
                    break;
                case PLAYING:
                    jogo.getPlaying().mouseReleased(e.getX(),e.getY());
                    break;
                case SETTINGS:
                    jogo.getSettings().mouseReleased(e.getX(),e.getY());
                    break;
                default:
                    break;
            }
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }

     @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        switch (GameStates.gameState) {
                case MENU:
                    jogo.getMenu().mouseDragged(e.getX(), e.getY());
                    break;
                case PLAYING:
                    jogo.getPlaying().mouseDragged(e.getX(), e.getY());
                    break;
                case SETTINGS:
                    jogo.getSettings().mouseDragged(e.getX(), e.getY());
                    break;
                default:
                    break;
            }
        
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        switch (GameStates.gameState) {
                case MENU:
                    jogo.getMenu().mouseMoved(e.getX(), e.getY());
                    break;
                case PLAYING:
                    jogo.getPlaying().mouseMoved(e.getX(), e.getY());
                    break;
                case SETTINGS:
                    jogo.getSettings().mouseMoved(e.getX(), e.getY());
                    break;
                default:
                    break;
            }
        
    }

    
}
