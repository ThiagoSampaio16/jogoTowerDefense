package inputs;

import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MyMouseListener implements MouseListener, MouseMotionListener {

    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) {
            System.out.println("Botão esquerdo do mouse clicado");
            
        }
        else if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) {
            System.out.println("Botão direito do mouse clicado");
            
        }
        
    }

    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        
    }

    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        
    }

}
