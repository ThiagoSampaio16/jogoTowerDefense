package inputs;


import java.awt.event.KeyListener;

public class KeyboardListner implements KeyListener {

    @Override
    public void keyTyped(java.awt.event.KeyEvent e) {
        
    }

    @Override
    public void keyPressed(java.awt.event.KeyEvent e) {

        if (e.getKeyCode() == java.awt.event.KeyEvent.VK_A) {
            System.out.println("A foi pressionada");
            
        }

        else if (e.getKeyCode() == java.awt.event.KeyEvent.VK_B) {
            System.out.println("B foi pressionada");
            
        }
    }

    @Override
    public void keyReleased(java.awt.event.KeyEvent e) {
        
    }

}
